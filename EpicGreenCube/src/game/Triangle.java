package game;

import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


import sprites.GameSprites;

/**
 * an ameliorated Entity that can follow the player
 * 
 * @author valentin
 * @version 1
 */
public class Triangle extends MovingEntity {

	//fields
	public final static double SPEED = 1.5;
	private ArrayList<Node> waypoints;
	

	
	
	/**
	 * create a new Triangle, a moving entity that can follow the player
	 * 
	 * @param spawnX
	 *            the X-axis position to spawn the entity
	 * @param spawnY
	 *            the Y-axis position to spawn the entity
	 */
	public Triangle(double spawnX, double spawnY) {
		super(spawnX, spawnY);
		this.width = GameSprites.TRIANGLE_WIDTH;
		this.height = GameSprites.TRIANGLE_HEIGHT;
		this.waypoints = new ArrayList<Node>();

	}

	@Override
	public void update(Updater u) {
		// TODO : what to do ?
		this.turnToDirection();
		//we transform the speed with the real values
		this.speedX *= Triangle.SPEED;
		this.speedY *= Triangle.SPEED;

		// we check if we hit wall
		horizontalWallCollision(u.getActualLevel().getBackground());
		verticalWallCollision(u.getActualLevel().getBackground());
	}

	public void turnToDirection() {
		turnToPoint(waypoints.get(0).getX(),waypoints.get(0).getY());
	}
	
	public AffineTransformOp rotateSprite() {
		// we turn the sprite to the good position
		// we create an affine transformation
		AffineTransform rotation = new AffineTransform();
		// we translate it to the center
		rotation.translate(getWidth()/2+1, getHeight()/2+1);
		// we compute the right angle
		double angle;
		if (speedX != 0){
			angle = Math.atan2(-(speedY/Triangle.SPEED),-(speedX/Triangle.SPEED));
		} else {
			angle = 0;
		}

		

		// now we rotate it
		rotation.rotate(angle);
		// we get back to the good translation
		rotation.translate(-getWidth()/2-1, -getHeight()/2-1);
		
		// we create the operation for the rotation
		AffineTransformOp rotationOp = new AffineTransformOp(rotation, AffineTransformOp.TYPE_BILINEAR);
		
		return rotationOp;

	}

	public boolean horizontalWallCollision(BufferedImage back) {
		// new system
		// We check if there is a collision at the corner of the triangle
		// we have to compute the position
		for (int i = 0; i <=360; i=i+5) {
			double ptX = this.posX + getWidth()/2 + 2*this.speedX + Math.cos(2*i*Math.PI/360)*(this.getWidth()/2);
			double ptY = this.posY + getHeight()/2 + Math.sin(2*i*Math.PI/360)*(this.getHeight()/2);
			
			// we check only if the corner is on the screen (to prevent exception
			if (ptX >= 0 && ptX <= back.getWidth() && ptY >= 0 && ptY <= back.getHeight()) {
				int color  = back.getRGB((int) ptX, (int) ptY);
				if (color == (new Color(0,0,0).getRGB())) {
					// a wall ? we don't move
					return true;
				}
			}
		}

		// no wall ? We can move !
		this.posX += this.speedX;

		return false;
	}
	
	public boolean verticalWallCollision(BufferedImage back) {
		// new system
		// We check if there is a collision at the corner of the triangle
		// we have to compute the position
		for (int i = 0; i <=360; i=i+5) {
			double ptX = this.posX + getWidth()/2 + Math.cos(2*i*Math.PI/360)*(this.getWidth()/2);
			double ptY = this.posY + getHeight()/2  + 2*this.speedY+ Math.sin(2*i*Math.PI/360)*(this.getHeight()/2);

			// we check only if the corner is on the screen (to prevent exception
			if (ptX >= 0 && ptX <= back.getWidth() && ptY >= 0 && ptY <= back.getHeight()) {
				int color  = back.getRGB((int) ptX, (int) ptY);
				if (color == (new Color(0,0,0).getRGB())) {
					// a wall ? we don't move
					return true;
				}
			}
		}

		// no wall ? We can move !
		this.posY += this.speedY;

		return false;
	}
	
	public void updateAI(Updater u) {
		// we search the nearest Node to the triangle
		double distance = 99999; // we set a very far distance to check the nearest
		for (Node n:u.getActualLevel().getWaypoints()) {
			if (n.distanceTo(this) <= distance) {
				distance = n.distanceTo(this);
				this.waypoints.add(0, n);
			}
		}
		// now we check the next ndoes to join
		Dijkstra(u.getPlayer().getPosX(),u.getPlayer().getPosY());
	}
	
	public void Dijkstra(double goalX, double goalY) {
		//TODO
	}

}
