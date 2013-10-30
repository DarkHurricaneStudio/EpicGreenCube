package game;

import handlers.KeyboardInputHandler;

import java.awt.event.KeyEvent;

import sprites.GameSprites;

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
		super(spawnX, spawnY);
		this.width = GameSprites.PLAYER_WIDTH;
		this.height = GameSprites.PLAYER_HEIGHT;
	}
	

	@Override
	public void update(Updater u) {
		// First of all, we check the keyboard to change the speeds
		checkKeyboard();
		
		// we check if we hit the exit
		if(reachedTheGoal(u.getActualLevel().getExit())) {
			u.changeLevel(u.getActualLevelID()+1);
		}
		for (int i = 0;i<u.getActualLevel().getEnemies().size();i++) {
			if (hitEntity(u.getActualLevel().getEnemies().get(i)))
				u.die();	
		}

		// we check if we hit a wall
		if (verticalWallCollision(u.getActualLevel().getBackground()) ||horizontalWallCollision(u.getActualLevel().getBackground()))
			u.die();

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
		} else {
			this.speedY = 0;
		}
		
		// now we check right and left
		if (KeyboardInputHandler.keys[KeyEvent.VK_LEFT]) {
			// always the left first !
			this.speedX = - Player.SPEED;
		} else if (KeyboardInputHandler.keys[KeyEvent.VK_RIGHT]) {
			// and now the right
			this.speedX =Player.SPEED;
		} else {
			this.speedX = 0;
		}
	}
	
	/**
	 * test if the player hits an Entity
	 * @param e the entity to test
	 * @return true if there is collision
	 */
	public boolean hitEntity (Entity e) {
		// We use the approximation that the entity and the player are circles.
		// for the entity, this is quite right because the circles are circle (hell yeah)
		// and triangles always face the player, so, there will always be the same distance between it and the player
		if (Math.sqrt((this.posX+this.getWidth()/2-e.getPosX()-e.getWidth()/2)*(this.posX+this.getWidth()/2-e.getPosX()-e.getWidth()/2) + (this.posY+this.getHeight()/2-e.getPosY()-e.getHeight()/2)*(this.posY+this.getHeight()/2-e.getPosY()-e.getHeight()/2)) <= (this.getWidth()/2 + e.getWidth()/2)) {
			return true;
		} else {
			return false;
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
		return hitEntity(goal);
	}

}
