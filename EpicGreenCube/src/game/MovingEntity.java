package game;

import java.awt.image.BufferedImage;

/**
 * an ameliorated Entity that can move
 * @author valentin
 * @version 1
 */
public abstract class MovingEntity extends Entity {

	//fields
	private double speedX; // the entity's speed on the X-axis
	private double speedY; // the entity's speed on the Y-axis
	
	
	/**
	 * The constructor for the abstract class MovingEntity
	 * @param spawnX the position in the X-axis for the entity (used as spawn)
	 * @param spawnY the position in the Y-axis for the entity (used as spawn)
	 * @param sprite the BufferedImage used to display this Entity
	 */
	public MovingEntity(double spawnX, double spawnY, BufferedImage sprite) {
		super(spawnX, spawnY, sprite);
	}
	
	/**
	 * set the X speed of the MovingEntity
	 * @param newSpeed the new speed on the X-axis
	 */
	public void setSpeedX(double newSpeed) {
		this.speedX = newSpeed;
	}
	
	/**
	 * set the Y speed of the MovingEntity
	 * @param newSpeed the new speed on the Y-axis
	 */
	public void setSpeedY(double newSpeed) {
		this.speedY = newSpeed;
	}
	
	/**
	 * get the X speed of the MovingEntity
	 * @return the speed on the X-axis
	 */
	public double getSpeedX() {
		return this.speedX;
	}

	/**
	 * get the Y speed of the MovingEntity
	 * @return the speed on the Y-axis
	 */
	public double getSpeedY() {
		return this.speedY;
	}


}
