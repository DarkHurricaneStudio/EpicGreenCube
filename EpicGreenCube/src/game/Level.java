package game;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;



/**
 * The level class, representing... a level
 * @author valentin
 * @version 1
 */
public class Level {
	
	//fields
	private Exit exit;
	private ArrayList<MovingEntity> enemies; // all enemies : circles and triangles
	private BufferedImage background; // the background of the level
	private ArrayList<String> messages; // some messages to display ?
	private double spawnX;
	private double spawnY;
	
	/**
	 * Load and create a Level from a ZIP with only a number as param
	 * @param zipName the name of the ZIP file
	 * @param id the ID of the level
	 */
	public Level(BufferedImage image, ArrayList<String> textFile) {
		// we load the image representing the level
		this.background = image;
		this.messages = new ArrayList<String>();
		// and we do the same for the text file
		loadTextLevel(textFile);
	}
	
	/**
	 * Transform the text file into usable content
	 * @param textFile an arrayList of string representing the file
	 */
	private void loadTextLevel(ArrayList<String> textFile) {
		// for all lines( each String represents a line
		for (int i = 0; i < textFile.size();i++) {
			// we check what type of parameter we have
			//each parameter are separated by ":"
			String[] parameters = textFile.get(i).split("\\|");
			// what type of first parameter is it ?
			switch (parameters[0]) {
				case "Spawn":
					// a spawn ? We define the position of the spawn
					this.spawnX = Double.parseDouble(parameters[1]);
					this.spawnY = Double.parseDouble(parameters[2]);
					break;
					
				case "Triangle":
					// a triangle ? Add it to the enemies
					this.enemies.add(new Triangle(Double.parseDouble(parameters[1]),Double.parseDouble(parameters[2])));
					break;
					
				case "Circle":
					// add the circle
					// TODO : the waypoint
					ArrayList<Point> path = new ArrayList<Point>();
					this.enemies.add(new Circle(Double.parseDouble(parameters[1]),Double.parseDouble(parameters[2]),path));
					break;
					
				case "Exit":
					// we add the exit
					this.exit = new Exit(Double.parseDouble(parameters[1]),Double.parseDouble(parameters[2]));
					break;
					
				case "Sentence":
					// we had the sentence
					this.messages.add(parameters[1]);
					break;
					
				default:
					//something doesn't start with the previous String ? There is a problem somewhere !
					System.out.println("Error with a beginning of a new line : "+parameters[0]);
					break;
			}
			
			
		}
		
	}
	
	/**
	 * get the background
	 * @return the background as a bufferedImage
	 */
	public BufferedImage getBackground() {
		return this.background;
	}
	
	/**
	 * get the list of all enemies
	 * @return an ArrayList of enemies
	 */
	public ArrayList<MovingEntity> getEnemies() {
		return this.enemies;
	}
	
	public Exit getExit() {
		return this.exit;
	}

	public double getSpawnX() {
		return this.spawnX;
	}
	
	public double getSpawnY() {
		return this.spawnY;
	}
	


}
