package game;



import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * the Circle class, an enemy moving through a path
 * @author valentin
 * @version 1
 */
public class Circle extends MovingEntity {

	//fields
	
	// the path
	private Vector<Point> waypoints; // a list of points
	private int goal; // the goal is the position of the next point in the path
	
	
	/**
	 * the constructor of the Circle, an Entity that can move through a path
	 * @param spawnX
	 * @param spawnY
	 */
	public Circle(double spawnX, double spawnY, Vector<Point> path) {
		
		super(spawnX, spawnY, null);
		
		//We define the real sprite
		// TODO : set a sprite
		BufferedImage sprite = null;
		this.setSprite(sprite);
		
		// we define the path
		this.waypoints = path;
		this.goal = 0;
	}

	@Override
	public void update() {
		// we check if the circle is in its goal
		// it's comparable to see if the distance from the center of the circle to the goal is lower than the ray
		if (this.waypoints.get(this.goal).distanceSq((this.posX+this.getWidth()/2.0),(this.posY+this.getHeight()/2.0)) <= this.getHeight()/2.0) {
			// we go to the new goal !
			this.goal++;
			turnToGoal();
		}
		
		//we update the position
		this.posX += speedX;
		this.posY += speedY;

	}
	
	public void turnToGoal() {
		// we turn it to the next goal
		turnToPoint(this.waypoints.get(this.goal).getX(),this.waypoints.get(this.goal).getY());
	}

}
