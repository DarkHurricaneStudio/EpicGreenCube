package game;

import java.awt.image.BufferedImage;


/**
 * an ameliorated Entity that can follow the player
 * @author valentin
 * @version 1
 */
public class Triangle extends MovingEntity {

	/**
	 * create a new Triangle, a moving entity that can follow the player
	 * @param spawnX the X-axis position to spawn the entity
	 * @param spawnY the Y-axis position to spawn the entity
	 */
	public Triangle(double spawnX, double spawnY) {
		super(spawnX, spawnY, createSprite());
	}

	/**
	 * create a triangle in the BufferedImage
	 * @return the BufferedImage to use for this Triangle entity
	 */
	private static BufferedImage createSprite() {
		return null;
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
		turnToPoint(p.getPosX(),p.getPosY());
		}

}
