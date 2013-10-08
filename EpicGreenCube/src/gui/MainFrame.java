package gui;

import javax.swing.JFrame;

/**
 * Main frame of the game.
 * @author Robrock
 */
public class MainFrame extends JFrame {

	// Fields
	/**
	 * Main panel of the frame
	 */
	private MainPanel mainPanel;
	
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
		
		this.mainPanel.requestFocus();
	}
	
	// Methods
}
