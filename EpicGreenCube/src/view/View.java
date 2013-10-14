package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/**
 * Abstract class which represents a view. A view is a displayable part of the game like a menu or the game.
 * @author Robrock
 */
public abstract class View {

	// Fields
	/**
	 * Panel containing the view
	 */
	protected JPanel panel;
	
	/**
	 * True if the panel is currently active
	 */
	protected boolean active = false;
	
	// Constructors
	public View(JPanel panel){
		this.panel = panel;
	}
	
	// Methods
	/**
	 * Return the render of the view
	 * @return Render of the view
	 */
	public abstract BufferedImage render();
	
	/**
	 * Active rendering on the field panel
	 */
	public void paintScreen(){
		Graphics g = this.panel.getGraphics();
		if (g != null){
			g.drawImage(this.render(),0,0,null);
		}
		else {
			System.out.println("Graphics error");
		}
	}
	
	/**
	 * Instructions todo when the view is active 
	 */
	public abstract void run();
	
	/**
	 * Set a view active or not
	 * @param b State of the view
	 */
	public void setActive(boolean b){
		this.active = b;
		
		if (this.active){
			this.run();
		}
	}
}
