package game;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import FourFileLevel.FFL_Loader;

/**
 * The level class, representing... a level
 * @author valentin
 * @version 1
 */
public class Level {
	
	//fields
	private ArrayList<MovingEntity> enemies; // all enemies : circles and triangles
	private BufferedImage background; // the background of the level
	private ArrayList<String> messages; // some messages to display ?
	
	/**
	 * Load and create a Level from a ZIP with only a number as param
	 * @param zipName the name of the ZIP file
	 * @param id the ID of the level
	 */
	public Level(BufferedImage image, ArrayList<String> textFile) {
		// we load the image representing the level
		this.background = image;
		// and we do the same for the text file
		loadTextLevel(textFile);
		
	}
	
	/**
	 * Transform the text file into usable content
	 * @param textFile an arrayList of string representing the file
	 */
	private void loadTextLevel(ArrayList<String> textFile) {
		// TODO Auto-generated method stub
		
	}
	


}
