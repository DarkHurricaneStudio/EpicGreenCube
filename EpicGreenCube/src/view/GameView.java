package view;

import game.Updater;

import java.awt.image.BufferedImage;

import javax.swing.JPanel;

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
	public GameView(JPanel panel) {
		super(panel);
		this.updater = new Updater();
	}

	// Methods
	public void run() {

	}

	public BufferedImage render() {
		return null;
	}

}
