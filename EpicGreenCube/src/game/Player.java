package game;

import gui.GameSprites;

import java.awt.image.BufferedImage;

/**
 * The damn player, that can move, die and... die again.
 * @author valentin
 * @version 1
 */
public class Player extends MovingEntity {
	
	public final double SPEED = 2.;

	public Player(double spawnX, double spawnY) {
		super(spawnX, spawnY, GameSprites.playerSprite());
		// TODO Auto-generated constructor stub
	}
	


	@Override
	public void update(Updater u) {
		// TODO : what to do ?

		// we update position
		this.posX += this.speedX;
		this.posY += this.speedY;

	}

}
