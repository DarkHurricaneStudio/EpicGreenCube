package views;

import gui.Main;
import gui.MainPanel;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * View when the game is in pause mode
 * 
 * @author Robrock
 */
public class PauseView extends View {

	// Fields
	/**
	 * Background of the pause menu
	 */
	private BufferedImage background;

	/**
	 * Path of the background image
	 */
	private final static String path = "res/pause.png";

	// Constructors
	/**
	 * Create the view and load the background. If it can't be load, the game stops.
	 */
	public PauseView(MainPanel panel) {
		super(panel);
		try {
			this.background = ImageIO.read(new File(PauseView.path));
		} catch (Exception e) {
			System.out.println("The file " + PauseView.path + " cannot be open !");
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	// Methods
	public void start() {

	}

	public void run() {

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
