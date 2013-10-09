package view;

import gui.MainPanel;

import java.awt.image.BufferedImage;

/**
 * Abstract class which represents a view. A view is a displayable part of the game like a menu or the game.
 * @author Robrock
 */
public abstract class View {

	// Fields
	
	// Constructors
	
	// Methods
	/**
	 * Return the render of the view
	 * @return Render of the view
	 */
	public abstract BufferedImage render();
}