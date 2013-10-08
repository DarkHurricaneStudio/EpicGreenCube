package game;

import java.awt.image.BufferedImage;

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
	private final double spawnX;
	private final double spawnY;
	
	// Sprite
	protected BufferedImage sprite;
	
	/**
	 * The constructor for the abstract class Entity
	 * @param spawnX the position in the X-axis for the entity (used as spawn)
	 * @param spawnY the position in the Y-axis for the entity (used as spawn)
	 * @param sprite the BufferedImage used to display this Entity
	 * 
	 * TODO : check if the position are in the screen/level ?
	 */
	public Entity( double spawnX, double spawnY, BufferedImage sprite) {
		// we define the spawn and the first position (that is the spawn)
		this.spawnX = spawnX;
		this.spawnY = spawnY;
		this.posX = spawnX;
		this.posY = spawnY;
		
		// and we also define the sprite
		this.sprite = sprite;
	}
	
	
	/**
	 * place the Entity at its spawn
	 */
	public void reset(){
		this.posX = this.spawnX;
		this.posY = this.spawnY;
	}
	
	/**
	 * ABSTRACT - update the Entity
	 */
	public abstract void update();
	
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

	/**
	 * get the sprite of the Entity
	 * @return the associated sprite (a BufferedImage)
	 */
	public BufferedImage getSprite() {
		return this.sprite;
	}
	
	/**
	 * get the height of the sprite associated to this Entity
	 * @return the height of the sprite associated
	 */
	public int getHeight() {
		return this.sprite.getHeight();
	}
	
	/**
	 * get the width of the sprite associated to this Entity
	 * @return the width of the sprite associated
	 */
	public int getWidth() {
		return this.sprite.getWidth();
	}
	
	
}