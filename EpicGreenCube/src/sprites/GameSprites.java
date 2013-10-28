package sprites;

import java.awt.image.BufferedImage;

/**
 * All methods return a BufferedImage for each Entity
 * @author valentin
 * @version 1
 */

public class GameSprites {
	
	public final static int PLAYER_WIDTH = 0;
	public final static int PLAYER_HEIGHT = 0;
	public final static int CIRCLE_WIDTH = 0;
	public final static int CIRCLE_HEIGHT = 0;
	public final static int TRIANGLE_WIDTH = 0;
	public final static int TRIANGLE_HEIGHT = 0;
	public final static int EXIT_WIDTH = 0;
	public final static int EXIT_HEIGHT = 0;

	/**
	 * Create the sprite for the creation of the player
	 * @return the player's sprite
	 */
	public static BufferedImage playerSprite() {
		return null;
	}
	
	/**
	 * Create a sprite for the circles
	 * @return the circle's sprite
	 */
	public static BufferedImage circleSprite() {
		return null;
	}
	
	/**
	 * Create a sprite used as the sprite for the creation of a triangle
	 * @return the triangle's sprite
	 */
	public static BufferedImage triangleSprite() {
		return null;
	}
	
	/**
	 * Create a sprite used as the sprite for player's fragments at his death
	 * @param size the size of the sprite/square
	 * @return
	 */
	public static BufferedImage fragmentSprite(int size) {
		return null;
	}
	
	/**
	 * Create the sprite for the creation of the exit/goal
	 * @return the exit's sprite
	 */
	public static BufferedImage exitSprite() {
		return null;
	}
}
