package handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputHandler implements KeyListener {

	// Fields
	public static boolean[] keys = new boolean[512];
	
	// Methods
	public static void reset(){
		for (int i=0;i<keys.length;i++){
			keys[i] = false;
		}
	}
	
	// Methods from KeyListener
	public void keyPressed(KeyEvent e) {
		KeyboardInputHandler.keys[e.getExtendedKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		KeyboardInputHandler.keys[e.getExtendedKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {
		
	}

	
}
