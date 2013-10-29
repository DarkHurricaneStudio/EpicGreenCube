package sprites;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * All methods return a BufferedImage for each Entity
 * @author valentin/Robrock
 * @version 1
 */

public class GameSprites {
	
	public final static int PLAYER_WIDTH = 16;
	public final static int PLAYER_HEIGHT = 16;
	public final static int CIRCLE_WIDTH = 16;
	public final static int CIRCLE_HEIGHT = 16;
	public final static int TRIANGLE_WIDTH = 16;
	public final static int TRIANGLE_HEIGHT = 16;
	public final static int EXIT_WIDTH = 16;
	public final static int EXIT_HEIGHT = 16;

	/**
	 * Create the sprite for the creation of the player
	 * @return the player's sprite
	 */
	public static BufferedImage playerSprite() {
		BufferedImage res = new BufferedImage(GameSprites.PLAYER_WIDTH, GameSprites.PLAYER_HEIGHT, BufferedImage.TYPE_INT_ARGB);
		Graphics g = res.getGraphics();

		g.setColor(Color.green);
		g.fillRect(0, 0, GameSprites.PLAYER_WIDTH , GameSprites.PLAYER_HEIGHT );
		g.setColor(Color.black);
		g.drawRect(0, 0, GameSprites.PLAYER_WIDTH - 1, GameSprites.PLAYER_HEIGHT - 1);

		return res;
	}
	
	/**
	 * Create a sprite for the circles
	 * @return the circle's sprite
	 */
	public static BufferedImage circleSprite() {
		BufferedImage res = new BufferedImage(GameSprites.CIRCLE_WIDTH,GameSprites.CIRCLE_HEIGHT,BufferedImage.TYPE_INT_ARGB);
		Graphics g = res.getGraphics();
		
		g.setColor(Color.red);
		g.fillOval(0, 0, GameSprites.CIRCLE_WIDTH-1, GameSprites.CIRCLE_HEIGHT-1);
		g.setColor(Color.black);
		g.drawOval(0, 0, GameSprites.CIRCLE_WIDTH-1, GameSprites.CIRCLE_HEIGHT-1);
		
		return res;
	}
	
	/**
	 * Create a sprite used as the sprite for the creation of a triangle
	 * @return the triangle's sprite
	 */
	public static BufferedImage triangleSprite() {
		BufferedImage res = new BufferedImage(GameSprites.TRIANGLE_WIDTH,GameSprites.TRIANGLE_HEIGHT,BufferedImage.TYPE_INT_ARGB);
		Graphics g = res.getGraphics();
		
		
		int[] posX = new int[3];
		int[] posY = new int[3];
		
		int tmp = (int) ((Math.sqrt(3)/2)*TRIANGLE_HEIGHT);
		
		posX[0] = 0;
		posY[0] = GameSprites.TRIANGLE_HEIGHT/2;
				
		posX[1] = tmp;
		posY[1] = 0;
		
		posX[2] = tmp;
		posY[2] = GameSprites.TRIANGLE_HEIGHT;
		
		g.setColor(Color.magenta);
		g.fillPolygon(posX, posY, 3);
		g.setColor(Color.black);
		g.drawPolygon(posX, posY, 3);
		
		return res;
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
		BufferedImage res = new BufferedImage(GameSprites.EXIT_WIDTH, GameSprites.EXIT_HEIGHT, BufferedImage.TYPE_INT_ARGB);
		Graphics g = res.getGraphics();

		g.setColor(Color.cyan);
		g.fillRect(0, 0, GameSprites.EXIT_HEIGHT, GameSprites.EXIT_HEIGHT);
		g.setColor(Color.black);
		g.drawRect(0, 0, GameSprites.EXIT_WIDTH -1, GameSprites.EXIT_HEIGHT -1);

		return res;
	}
}
