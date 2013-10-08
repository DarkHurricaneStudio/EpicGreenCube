package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

/**
 * Main panel of the game. It contains all the views. 
 * @author Robrock
 */
public class MainPanel extends JPanel {

	// Fields
	
	// Constructors
	/**
	 * Initialize the panel and create the views
	 */
	public MainPanel(){
		this.setPreferredSize(new Dimension(Main.WIDTH,Main.HEIGHT));
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("Bro");
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	// Methods
	public void paint(Graphics g){
	}
}
