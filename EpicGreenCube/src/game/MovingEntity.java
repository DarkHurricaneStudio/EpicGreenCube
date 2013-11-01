package game;

import java.awt.Color;
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
		

		
		// we compute the new speedX and speedY to go to the new goal
		// this is just the calculus of a cosinus ;)
		double newSpeedX = (pointX - this.posX) / Math.sqrt((pointX-this.posX)*(pointX-this.posX)+(pointY-this.posY)*(pointY-this.posY));
		// same for the Y-axis speed
		double newSpeedY = (pointY - this.posY) / Math.sqrt((pointX-this.posX)*(pointX-this.posX)+(pointY-this.posY)*(pointY-this.posY));
		
		
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
		return null;
	}

	public boolean horizontalWallCollision(BufferedImage back) {
		// to know if the player can move, we test every pixel for the next position (except the one where the player is, of course)
		int direction = (int) (this.speedX/Math.abs(this.speedX)); // -1 for left, 1 for right)

		double startPos = this.posX;
		if (direction == 1)
			startPos +=this.width;

		for (int i = -1; i <= Math.abs(this.speedX);i++) {
			for (int j = (int) this.posY;j< (this.posY+this.height) ;j++) {
				
				// we test if the position is in the cache (if not, there will be a bad, bad bug
				if (startPos+i*direction >= 0 && startPos+i*direction <= back.getWidth() && j >= 0 && j <= back.getHeight()) {
					
					// we test this pixel.
					int color = back.getRGB((int) startPos+i*direction,j);
					// there is a collision ? bad
					if (color == (new Color(0,0,0).getRGB())) {
						// so this position cannot be joined, we get back to the previous line
						this.posX += (i-1)*direction;

						// and we have a collision, so we stop the speed
						this.speedX = 0;
						// and we stop the test
						return true;
					}
				}
			}

			
		}
		// we finish all the tests, we don't hit anything, it's good !
		// so let's move
			this.posX += this.speedX;
		return false;	
			
	}
	
	public boolean verticalWallCollision(BufferedImage back) {
		// we do the same for the Y-axis
		int direction = (int) (this.speedY/Math.abs(this.speedY)); // -1 for top, 1 for bottom)
		double startPos = this.posY;
		if (direction == 1)
			startPos +=this.height;

		for (int i = -1; i <= Math.abs(this.speedY);i++) {
			for (int j = (int) this.posX; j<= (this.posX+this.width);j++) {

				// we check each pixel. if there is a collision, we do the same thing for the X-axis
				if (j >= 0 && j <= back.getWidth() && startPos+i*direction >= 0 && startPos+i*direction <= back.getHeight()) {

					// we test this pixel.
					int color = back.getRGB(j,(int) startPos+i*direction);
					// there is a collision ? bad
					if (color == (new Color(0,0,0).getRGB())) {
						// so this position cannot be joined, we get back to the previous line
						this.posY += (i-1)*direction;

						// and we have a collision, so we stop the speed
						this.speedY = 0;
						// and we stop the test
						return true;
					}
				}
			}
		}
		// we finish all the tests, we don't hit anything, it's good !
		// so let's move
		this.posY += this.speedY;
		return false;
	}
}
