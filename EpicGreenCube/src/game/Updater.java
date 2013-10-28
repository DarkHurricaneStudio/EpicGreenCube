package game;

import java.util.ArrayList;

/**
 * The most important class, the Updater. It's the core of the game
 * @author valentin
 * @version 1
 *  TODO : 	- load levels
 *  		- kill the player (mwahahah)
 *  		- some others stuff
 */
public class Updater {

	//fields
	private Player player;
	//private ArrayList<Level> levels; // list of all levels
	private int deathCounter; // how many times the player died
	private int actualLevel; // the ID of the level witch the player is in
	private ArrayList<Fragment> fragments; // list of all fragments actually displayed
	private ArrayList<Level> levels; // the list of levels
	


	public Updater() {
		
		// TODO : some stuff
		
		// we create a player. It will be useful, isn't it ?
		//this.player = new Player(0,0);
		// we create the array of fragments
		this.fragments = new ArrayList<Fragment>();
		
	}

	/**
	 * add one more death
	 */
	public void addDeath() {
		this.deathCounter++;
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
		return deathCounter;
	}
	


	/**
	 * get the ID of the actual level being played
	 * @return the actualLevel
	 */
	public int getActualLevelID() {
		return actualLevel;
	}
	
	/**
	 * get the ID of the actual level being played
	 * @return the actualLevel
	 */
	public Level getActualLevel() {
		return this.levels.get(this.actualLevel);
	}
	
	/**
	 * get the player object
	 * @return the player
	 */
	public Player getPlayer() {
		return this.player;
	}

}
