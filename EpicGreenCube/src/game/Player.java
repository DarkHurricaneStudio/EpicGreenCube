package game;

import gui.GameSprites;
import handlers.KeyboardInputHandler;

import java.awt.Point;
import java.awt.event.KeyEvent;

/**
 * The damn player, that can move, die and... die again.
 * @author valentin
 * @version 1
 */
public class Player extends MovingEntity {
	
	//fields
	
	//static fields
	public final static double SPEED = 2.; // maximum speed of the player
	
	

	public Player(double spawnX, double spawnY) {
		super(spawnX, spawnY, GameSprites.playerSprite());
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void update(Updater u) {
		// First of all, we check the keyboard to change the speeds
		checkKeyboard();

		// we update position
		this.posX += this.speedX;
		this.posY += this.speedY;

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
	
	
	/**
	 * test if the player reached the exit, by a circle approximation
	 * @param goal the Exit entity
	 * @return true if the player reached the exit
	 */
	public boolean reachedTheGoal(Entity goal) {
		// Both the player and the goal are squares with the same exact size.
		// we can, of course, test the collision by testing the fourth corner of the player
		// and see if it's in the goal.
		// but in my opinion, we can just test a distance between the two centers.
		// this solution doesn't work for the corners but it's more simple
		Point playerCenter = new Point();
		playerCenter.setLocation(this.posX + this.getWidth()/2, this.posY + this.getHeight()/2);
		if (playerCenter.distanceSq(goal.getPosX()+goal.getWidth()/2, goal.getPosY()+goal.getHeight()/2) <= (this.getWidth()/2 + goal.getWidth()/2)) {
			return true;
		} else {
			return false;
		}
	}

}
