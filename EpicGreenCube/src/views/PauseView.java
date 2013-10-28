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
		KeyboardInputHandler.reset();
	}

	public void run() {
		if (KeyboardInputHandler.keys[KeyEvent.VK_P] || KeyboardInputHandler.keys[KeyEvent.VK_ESCAPE]){
			this.panel.setView(GameView.class.getName());
		}
		try {
			Thread.sleep(30);
		} catch (Exception e) {
		}
	}

	public void stop() {

	}

	public void render(Graphics g) {
		g.drawImage(this.background, 0, 0, null);
	}

}
