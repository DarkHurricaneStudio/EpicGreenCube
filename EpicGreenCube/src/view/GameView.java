package view;

import gui.MainPanel;

import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

/**
 * Main view, containing the game. It can display it and update it via an
 * updater.
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
	public GameView() {
		this.updater = new Updater();
	}

	// Methods

	public BufferedImage render() {
		return null;
	}
}
