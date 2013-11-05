package game;

import gui.Main;

/**
 * the most basic part of any entity of the game
 * @author valentin
 * @version 1
 */
public abstract class Entity {
	
	//fields
	
	// position
	protected double posX;
	protected double posY;
	
	// spawn position
	// we use these fields when the player die. It's better than reloading all the level
	protected double spawnX;
	protected double spawnY;
	
	protected int width;
	protected int height;
	

	
	/**
	 * The constructor for the abstract class Entity
	 * @param spawnX the position in the X-axis for the entity (used as spawn)
	 * @param spawnY the position in the Y-axis for the entity (used as spawn)
	 *
	 */
	public Entity( double spawnX, double spawnY) {
		// we define the spawn and the first position (that is the spawn)
		if (spawnX >= 0 && spawnX <= Main.WIDTH && spawnY >= 0 && spawnY <= Main.HEIGHT) {
			this.spawnX = spawnX;
			this.spawnY = spawnY;
			this.posX = spawnX;
			this.posY = spawnY;
		} else {
			System.out.println("An Entity was created out of the level ! We skip this creation");
		}
		

	}
	
	
	/**
	 * place the Entity at its spawn
	 */
	public void reset(){
		this.posX = this.spawnX;
		this.posY = this.spawnY;
	}
	
	/**
	 * teleport this entity to a new location
	 * @param newX the new X position
	 * @param newY the new Y position
	 */
	public void teleport(double newX, double newY) {
		this.posX = newX;
		this.posY = newY;
	}
	
	/**
	 * ABSTRACT - update the Entity
	 * @param u the Updater
	 */
	public abstract void update(Updater u) throws IndexOutOfBoundsException;
	
	public void setPosX(double x) {
		this.posX = x;
	}
	
	public void setPosY(double y) {
		this.posY = y;
	}
	
	/**
	 * get the X-axis position of the Entity
	 * @return the X-axis position
	 */
	public double getPosX() {
		return this.posX;
	}

	/**
	 * get the X-axis position of the Entity
	 * @return the Y-axis position
	 */
	public double getPosY() {
		return this.posY;
	}

	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
}