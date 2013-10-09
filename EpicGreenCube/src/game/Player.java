package game;

import java.awt.image.BufferedImage;

/**
 * The damn player, that can move, die and... die again.
 * @author valentin
 * @version 1
 */
public class Player extends MovingEntity {

	public Player(double spawnX, double spawnY) {
		super(spawnX, spawnY, createSprite());
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * create a square in the BufferedImage
	 * @return the BufferedImage to use for this Player entity
	 */
	private static BufferedImage createSprite() {
		return null;
	}

	@Override
	public void update(Updater u) {
		// TODO : what to do ?

		// we update position
		this.posX += this.speedX;
		this.posY += this.speedY;

	}

}
