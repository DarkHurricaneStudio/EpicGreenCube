package views;

import gui.Main;
import gui.MainPanel;
import handlers.KeyboardInputHandler;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * View at the beginning of the game.
 * 
 * @author Robrock
 */
public class BeginView extends View {

	// Fields
	/**
	 * Background of the view
	 */
	private BufferedImage background;

	/**
	 * Path of the background
	 */
	private final static String path = "res/menu.png";

	/**
	 * Frame Per Seconds
	 */
	private final static int FPS = 100;

	/**
	 * Value use for FPS limit
	 */
	private long beforeTime;

	// Constructors
	/**
	 * Create the view and load the background. If it can't be load, the game stops.
	 */
	public BeginView(MainPanel panel) {
		super(panel);
		try {
			this.background = ImageIO.read(new File(BeginView.path));
		} catch (Exception e) {
			System.out.println("The file " + BeginView.path + " cannot be open !");
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	// Methods
	public void start() {

	}

	public void run() {
		beforeTime = System.currentTimeMillis();

		// Paint the background
		this.paintScreen();

		// Wait for the player to push enter
		if (KeyboardInputHandler.keys[KeyEvent.VK_ENTER]) {
			this.panel.setView(GameView.class.getName());
		}

		while (System.currentTimeMillis() - beforeTime < 1000 / BeginView.FPS) {
		}
	}

	public void stop() {

	}

	public BufferedImage render() {
		BufferedImage res = new BufferedImage(Main.WIDTH, Main.HEIGHT, BufferedImage.TYPE_INT_ARGB);
		Graphics g = res.getGraphics();

		g.drawImage(this.background, 0, 0, null);

		return res;
	}
}