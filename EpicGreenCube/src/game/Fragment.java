package game;


import gui.Main;


/**
 * A fragment of the player created at his death
 * @author valentin
 * @version 1
 */
public class Fragment extends MovingEntity {

	public Fragment(double spawnX, double spawnY, int size) {
		super(spawnX, spawnY);
		// we create random speed
		this.speedX = 2 * Player.SPEED * (Math.random()) - Player.SPEED ;
		this.speedY = 2 * Player.SPEED * (Math.random()) - Player.SPEED ;
		// but we can't have a fragment with no movement. we have to move all the fragments
		if (speedX == 0 && speedY == 0) {
			this.speedX = 1;
			this.speedY = 1;
		}
		
		this.height = size;
		this.width = size;
			
	}

	@Override
	public void update(Updater u) {
		// we just move the fragment
		this.posX += this.speedX;
		this.posY += this.speedY;
		
	}
	
	/**
	 * Return true if the fragment is out of screen, false if not
	 * @return true if out of screen
	 */
	public boolean isOutOfScreen() {
		if (this.posX < - this.getWidth() || this.posX > Main.WIDTH || this.posY < - this.getHeight() || this.posY > Main.HEIGHT) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getSize() {
		return this.width;
	}

}
