package game;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import sprites.GameSprites;

/**
 * an ameliorated Entity that can follow the player
 * 
 * @author valentin
 * @version 1
 */
public class Triangle extends MovingEntity {

	/**
	 * create a new Triangle, a moving entity that can follow the player
	 * 
	 * @param spawnX
	 *            the X-axis position to spawn the entity
	 * @param spawnY
	 *            the Y-axis position to spawn the entity
	 */
	public Triangle(double spawnX, double spawnY) {
		super(spawnX, spawnY);
	}

	@Override
	public void update(Updater u) {
		// TODO : what to do ?
		this.turnToPlayer(u.getPlayer());

		// we update position
		this.posX += this.speedX;
		this.posY += this.speedY;
	}

	public void turnToPlayer(Player p) {
		turnToPoint(p.getPosX(), p.getPosY());
	}
	
	public AffineTransformOp rotateSprite() {
		// we turn the sprite to the good position
		// we create an affine transformation
		AffineTransform rotation = new AffineTransform();
		// we translate it to the center
		rotation.translate(getWidth()/2, getHeight()/2);
		// we compute the right angle
		double angle = Math.atan2(speedX, speedY);
		// now we rotate it
		rotation.rotate(angle);
		// we get back to the good translation
		rotation.translate(getWidth()/2, -getHeight()/2);
		
		// we create the operation for the rotation
		AffineTransformOp rotationOp = new AffineTransformOp(rotation, AffineTransformOp.TYPE_BILINEAR);
		
		return rotationOp;
		
	}

}
