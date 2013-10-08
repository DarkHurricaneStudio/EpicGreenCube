package game;

import java.awt.image.BufferedImage;

/**
 * the Circle class, an enemy moving through a path
 * @author valentin
 * @version 1
 */
public class Circle extends MovingEntity {

	public Circle(double spawnX, double spawnY) {
		
		super(spawnX, spawnY, null);
		
		//We define the real sprite
		// TODO : set a sprite
		BufferedImage sprite = null;
		this.setSprite(sprite);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
