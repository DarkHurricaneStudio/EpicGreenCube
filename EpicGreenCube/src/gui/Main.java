package gui;

import handlers.KeyboardInputHandler;

/**
 * Main class containing the main method
 * @author Robrock
 */
public class Main {

	// Fields
	/*
	 * Width and height of the application
	 */
	public final static int WIDTH = 720;
	public final static int HEIGHT = 405;
	
	// Main Method
	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
		mf.go();
	}
}
