package views;

import gui.Main;
import gui.MainPanel;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

/**
 * Abstract class which represents a view. A view is a displayable part of the game like a menu or the game.
 * 
 * @author Robrock
 */
public abstract class View {

	// Fields
	/**
	 * Panel containing the view
	 */
	protected MainPanel panel;

	/**
	 * Render of the view
	 */
	protected BufferedImage render;
	
	/**
	 * True if the panel is currently active
	 */
	protected boolean active = false;

	// Constructors
	public View(MainPanel panel) {
		this.panel = panel;
		this.render = new BufferedImage(Main.WIDTH, Main.HEIGHT, BufferedImage.TYPE_INT_ARGB);
	}

	// Methods
	/**
	 * Print the render on a bufferedImage
	 * @return Render of the view
	 */
	protected abstract void render();

	/**
	 * Active rendering on the field panel
	 */
	protected void paintScreen() {
		Graphics g = this.panel.getGraphics();
		if (g != null) {
			g.drawImage(this.render, 0, 0, null);
			Toolkit.getDefaultToolkit().sync(); // Useful for Linux (Killer Game Programming In Java)
		} else {
			System.out.println("Graphics error");
		}
	}

	/**
	 * Set a view active or not	
	 * @param b	State of the view
	 */
	public void setActive(boolean b) {
		this.active = b;
		this.go();
	}

	/**
	 * Start the instructions of the view
	 */
	public void go() {
		this.start();
		while (this.active) {
			this.run();
		}
		this.stop();
	}

	/**
	 * Instructions todo when the view is active.
	 */
	protected abstract void run();

	/**
	 * Instructions todo when the view become active
	 */
	protected abstract void start();

	/**
	 * Instructions todo when the view become inactive
	 */
	protected abstract void stop();
}
