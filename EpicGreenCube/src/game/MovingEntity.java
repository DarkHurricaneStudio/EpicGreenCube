package game;

import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

/**
 * an ameliorated Entity that can move
 * @author valentin
 * @version 1
 */
public abstract class MovingEntity extends Entity {

	//fields
	protected double speedX; // the entity's speed on the X-axis
	protected double speedY; // the entity's speed on the Y-axis
	
	
	/**
	 * The constructor for the abstract class MovingEntity
	 * @param spawnX the position in the X-axis for the entity (used as spawn)
	 * @param spawnY the position in the Y-axis for the entity (used as spawn)
	 * @param sprite the BufferedImage used to display this Entity
	 */
	public MovingEntity(double spawnX, double spawnY) {
		super(spawnX, spawnY);
	}
	
	/**
	 * change the speed on the X-axis and the Y-axis to move to a specific point
	 * @param pointX the X position of the point to move to
	 * @param pointY the Y position of the point to move to
	 */
	public void turnToPoint(double pointX, double pointY) {
		
		// we set the point
		Point pt = new Point();
		pt.setLocation(pointX,pointY);
		
		// we compute the new speedX and speedY to go to the new goal
		// this is just the calculus of a cosinus ;)
		double newSpeedX = (pointX - this.posX) / pt.distanceSq(this.posX, this.posY);
		// same for the Y-axis speed
		double newSpeedY = -(pointY - this.posY) / pt.distanceSq(this.posX, this.posY);
		
		// and we set these are the real speeds
		this.speedX = newSpeedX;
		this.speedY = newSpeedY;
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

	public AffineTransformOp rotateSprite() {
		AffineTransform rotation = new AffineTransform();
		AffineTransformOp rotationOp = new AffineTransformOp(rotation, AffineTransformOp.TYPE_BILINEAR);
		return rotationOp;
	}


}
