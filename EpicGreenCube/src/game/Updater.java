package game;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import zipFileLevel.ZFL_Loader;

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
		this.levels = new ArrayList<>();
		
		// we create the levels
		this.levels = new ArrayList<Level>();
		// we create the player
		this.player = new Player(0,0);
		
		// we load all the levels
		loadLevels();
		
		// we define the first level
		changeLevel(0);

		// we create the array of fragments
		this.fragments = new ArrayList<Fragment>();
		
	}
	
	public void loadLevels() {
		
		// the zip where are stored the levels
		String zip = "res/levels.zip";
		// the number of levels
		int numberOfLevels = 3;
		
		//the list of backgrounds
		ArrayList<String> images = new ArrayList<String>();
		//the list of file texts
		ArrayList<String> textnames = new ArrayList<String>();
		
		// we write the name of the wanted files
		for (int i = 0; i < numberOfLevels; i++) {
			images.add("back"+i+".png");
			textnames.add("lvl"+i+".txt");
		}
		
		// Drop the FILES ! (dubstep style)
		ArrayList<BufferedImage> backs = ZFL_Loader.loadMultipleImages(zip, images);
		ArrayList<ArrayList<String>> texts = ZFL_Loader.loadMultipleTexts(zip, textnames, "UTF-8");
		// for each, we create a level object
		for (int i = 0; i < numberOfLevels;i++) {
			this.levels.add(new Level(backs.get(i),texts.get(i)));
		}
		
	}
	
	public void changeLevel(int newLvl) {
		this.actualLevel = newLvl;
		this.player.setPosX(this.levels.get(this.actualLevel).getSpawnX());
		this.player.setPosY(this.levels.get(this.actualLevel).getSpawnY());
	}

	/**
	 * add one more death
	 */
	public void addDeath() {
		this.deathCounter++;
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

	public void update() {
		// We update the player
		this.player.update(this);
		// and the entities
		for (int i = 0;i<this.levels.get(this.actualLevel).getEnemies().size();i++) {
			this.levels.get(this.actualLevel).getEnemies().get(i).update(this);
		}
		
	}

	public void die(){
		this.deathCounter++;
		this.player.teleport(this.getActualLevel().getSpawnX(),this.getActualLevel().getSpawnX());
		ArrayList<MovingEntity> entities = this.getActualLevel().getEnemies();
		for (MovingEntity me:entities){
			me.reset();
		}
	}
}
