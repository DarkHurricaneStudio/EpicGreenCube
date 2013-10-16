package gui;

import handlers.KeyboardInputHandler;

import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.util.HashMap;

import javax.swing.JPanel;

import views.BeginView;
import views.EndView;
import views.GameView;
import views.PauseView;
import views.View;

/**
 * Main panel of the game. It contains all the views.
 * 
 * @author Robrock
 */
public class MainPanel extends JPanel {

	// Fields
	/**
	 * All the views displayable in the panel
	 */
	private HashMap<String, View> views;

	/**
	 * Current view displayed
	 */
	private View currentView;

	/**
	 * KeyListener of the application
	 */
	private KeyListener keyListener; 

	// Constructors
	/**
	 * Initialize the panel and create the views
	 */
	public MainPanel() {
		this.setPreferredSize(new Dimension(Main.WIDTH, Main.HEIGHT));
		this.createViews();

		this.keyListener = new KeyboardInputHandler();
		this.addKeyListener(this.keyListener);
	}

	// Methods
	/**
	 * Create all the views and set the first view
	 */
	private void createViews() {
		this.views = new HashMap<>();
		this.views.put(BeginView.class.getName(), new BeginView(this));
		this.views.put(EndView.class.getName(), new EndView(this));
		this.views.put(GameView.class.getName(), new GameView(this));
		this.views.put(PauseView.class.getName(), new PauseView(this));
	}

	/**
	 * Change the view and active it
	 * 
	 * @param s
	 *            ID of the view. View.class.getName()
	 */
	public void setView(String s) {
		if (this.currentView != null){
			this.currentView.setActive(false);
		}
		this.currentView = this.views.get(s);
		this.currentView.setActive(true);
		KeyboardInputHandler.reset();
	}
}
