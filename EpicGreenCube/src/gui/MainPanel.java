package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.HashMap;

import javax.swing.JPanel;

import view.BeginView;
import view.EndView;
import view.GameView;
import view.PauseView;
import view.View;

/**
 * Main panel of the game. It contains all the views. 
 * @author Robrock
 */
public class MainPanel extends JPanel {

	// Fields
	/**
	 * All the views displayable in the panel
	 */
	private HashMap<String,View> views;
	
	/**
	 * Current view displayed
	 */
	private View currentView;
	
	// Constructors
	/**
	 * Initialize the panel and create the views
	 */
	public MainPanel(){
		this.setPreferredSize(new Dimension(Main.WIDTH,Main.HEIGHT));
		
		this.createViews();

		
	}
	
	// Methods
	/**
	 * Create all the views and set the first view
	 */
	private void createViews(){
		this.views = new HashMap<>();
		this.views.put(BeginView.class.getName(),new BeginView());
		this.views.put(EndView.class.getName(),new EndView());
		this.views.put(GameView.class.getName(),new GameView());
		this.views.put(PauseView.class.getName(),new PauseView());
		
		this.currentView = this.views.get(BeginView.class.getName());
	}
	
	public void paint(Graphics g){
		g.drawImage(this.currentView.render(), 0, 0, null);
	}
}
