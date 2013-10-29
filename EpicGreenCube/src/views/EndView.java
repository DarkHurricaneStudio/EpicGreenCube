package views;

import gui.MainPanel;

import java.awt.image.BufferedImage;
import java.io.File;

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
	private final static String path = "res/end.png";

	// Constructors
	/**
	 * Create the view and load the background. If it can't be load, the game stops.
	 */
	public EndView(MainPanel panel) {
		super(panel);
		try {
			this.background = ImageIO.read(new File(EndView.path));
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

	}

	public void stop() {

	}

	public void render() {
		this.render.getGraphics().drawImage(this.background, 0, 0, null);
	}
}
