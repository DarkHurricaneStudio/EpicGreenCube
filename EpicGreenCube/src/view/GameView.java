package view;

import game.Updater;
import gui.MainPanel;

import java.awt.image.BufferedImage;

/**
 * Main view, containing the game. It can display it and update it via an updater.
 * 
 * @author Robrock
 */
public class GameView extends View {

	// Fields
	/**
	 * Updater of the game. Control all the game datas.
	 */
	private Updater updater;

	// Constructors
	/**
	 * Create the view and the updater.
	 */
	public GameView(MainPanel panel) {
		super(panel);
		this.updater = new Updater();
	}

	// Methods
	public void run() {
		while (this.active){
			System.out.println("Bro");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
		}
	}

	public BufferedImage render() {
		return null;
	}

}
