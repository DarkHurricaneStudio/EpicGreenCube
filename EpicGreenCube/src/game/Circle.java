package game;




import java.awt.Point;
import java.util.ArrayList;


/**
 * the Circle class, an enemy moving through a path
 * @author valentin
 * @version 1
 */
public class Circle extends MovingEntity {

	//fields
	
	// the path
	private ArrayList<Point> waypoints; // a list of points
	private int goal; // the goal is the position of the next point in the path
	
	
	/**
	 * Create a new Circle
	 * @param spawnX
	 * @param spawnY
	 * @param path
	 */
	public Circle(double spawnX, double spawnY, ArrayList<Point> path) {
		
		super(spawnX, spawnY);
		
		
		// we define the path
		this.waypoints = path;
		// we don't have a path ?
		if (path == null) {
			// we create our own path with only one point, the spawn
			this.waypoints = new ArrayList<Point>();
			Point spawn = new Point();
			spawn.setLocation(spawnX,spawnY);
			this.waypoints.add(spawn);
		}
		this.goal = 0;
	}


	@Override
	public void update(Updater u) {
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
	
	/**
	 * change the speed on X and Y axis to move to the next goal
	 */
	public void turnToGoal() {
		// we turn it to the next goal
		turnToPoint(this.waypoints.get(this.goal).getX(),this.waypoints.get(this.goal).getY());
	}

}
