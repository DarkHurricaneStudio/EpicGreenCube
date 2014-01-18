package applet;

import gui.MainPanel;

import javax.swing.JApplet;
import javax.swing.JFrame;

import views.BeginView;

public class MainApplet extends JApplet {

	// Fields
		/**
		 * Main panel of the frame
		 */
		public MainPanel mainPanel;
		
	public void init() {
		System.setSecurityManager(null);
		
		
		this.mainPanel = new MainPanel();
		this.setContentPane(this.mainPanel);
		//this.setVisible(true);
	}
	
	public void start() {
		this.mainPanel.setView(BeginView.class.getName());
	}
	
	public void stop() {
		
	}

}
