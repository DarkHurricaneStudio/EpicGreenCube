package game;

import java.awt.image.BufferedImage;

public class Player extends MovingEntity {

	public Player(double spawnX, double spawnY, BufferedImage sprite) {
		super(spawnX, spawnY, sprite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO : what to do ?

		// we update position
		this.posX += this.speedX;
		this.posY += this.speedY;

	}

}
