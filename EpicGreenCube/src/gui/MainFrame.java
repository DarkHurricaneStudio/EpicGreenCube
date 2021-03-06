package gui;

import javax.swing.JFrame;

import views.BeginView;

/**
 * Main frame of the game.
 * @author Robrock
 */
public class MainFrame extends JFrame {

	// Fields
	/**
	 * Main panel of the frame
	 */
	public MainPanel mainPanel;
	
	// Constructors
	/**
	 * Constructor of the main frame. Also create the main panel.
	 */
	public MainFrame(){
		super();
		
		this.mainPanel = new MainPanel();
		
		this.setTitle("Epic Green Cube");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(this.mainPanel);
		this.pack();
		this.setLocationRelativeTo(null);		
		this.setVisible(true);

	}
	
	// Methods
	public void go(){
		this.mainPanel.requestFocus();
		this.mainPanel.setView(BeginView.class.getName());
	}
}
