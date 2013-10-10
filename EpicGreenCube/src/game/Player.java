package game;

import gui.GameSprites;
import handlers.KeyboardInputHandler;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 * The damn player, that can move, die and... die again.
 * @author valentin
 * @version 1
 */
public class Player extends MovingEntity {
	
	public final static double SPEED = 2.;

	public Player(double spawnX, double spawnY) {
		super(spawnX, spawnY, GameSprites.playerSprite());
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * check the keyboard to adjust speed
	 */
	public void checkKeyboard() {
		// we check if one or more keys are pressed
		if (KeyboardInputHandler.keys[KeyEvent.VK_UP]) {
			// To the top !
			this.speedY = - Player.SPEED;
		} else if (KeyboardInputHandler.keys[KeyEvent.VK_DOWN]) {
			// nah, go to the bottom
			this.speedY =Player.SPEED;
		}
		
		// now we check right and left
		if (KeyboardInputHandler.keys[KeyEvent.VK_LEFT]) {
			// always the left first !
			this.speedX = - Player.SPEED;
		} else if (KeyboardInputHandler.keys[KeyEvent.VK_RIGHT]) {
			// and now the right
			this.speedX =Player.SPEED;
		}
	}

	@Override
	public void update(Updater u) {
		// First of all, we check the keyboard to change the speeds
		checkKeyboard();

		// we update position
		this.posX += this.speedX;
		this.posY += this.speedY;

	}

}
