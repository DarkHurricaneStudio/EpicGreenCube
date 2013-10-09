package game;

public class Updater {

	//fields
	private Player player;
	//private Vector<Level> levels; // list of all levels
	private int deathNumber; // how many times the player died
	private int actualLevel; // the ID of the level wich the player is in
	

	/**
	 * TODO
	 */
	public Updater() {
		
	}

	/**
	 * add one more death
	 */
	public void addDeath() {
		this.deathNumber++;
	}

	/**
	 * set a new level
	 * @param actualLevel the actualLevel to set
	 */
	public void setActualLevel(int actualLevel) {
		this.actualLevel = actualLevel;
	}
	
	/**
	 * get the number of death since the beginning of the session
	 * @return the deathNumber
	 */
	public int getDeathNumber() {
		return deathNumber;
	}
	


	/**
	 * get the ID of the actual level being played
	 * @return the actualLevel
	 */
	public int getActualLevel() {
		return actualLevel;
	}

}
