package views;

import gui.MainPanel;
import handlers.KeyboardInputHandler;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class EndView extends View {

	// Fields
	/**
	 * Background of the view
	 */
	private BufferedImage background;

	/**
	 * Path of the background
	 */
	//private final static String path = "/res/end.png";
	private final static String path = "res/end.png";
	
	/**
	 * Frame Per Seconds
	 */
	private final static int FPS = 60;

	/**
	 * Value use for FPS limit
	 */
	private long beforeTime;

	// Constructors
	/**
	 * Create the view and load the background. If it can't be load, the game stops.
	 */
	public EndView(MainPanel panel) {
		super(panel);
		try {
			/* Jar version
			InputStream tmp = this.getClass().getResourceAsStream(path);
			this.background = ImageIO.read(tmp);
			*/
			this.background = ImageIO.read(new File(path));
		} catch (Exception e) {
			System.out.println("The file " + EndView.path + " cannot be open !");
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
		this.render();
		this.paintScreen();
		// Wait for the player to push enter
		if (KeyboardInputHandler.keys[KeyEvent.VK_ENTER]) {
			System.exit(0);
		}

		while (System.currentTimeMillis() - beforeTime < 1000 / EndView.FPS) {
		}
	}

	public void stop() {

	}

	public void render() {
		this.render.getGraphics().drawImage(this.background, 0, 0, null);
	}
}
