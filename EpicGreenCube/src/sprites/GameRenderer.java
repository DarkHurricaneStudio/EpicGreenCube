package sprites;

import game.Circle;
import game.Exit;
import game.Fragment;
import game.Player;
import game.Triangle;
import game.Updater;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import org.newdawn.slick.util.ResourceLoader;

/**
 * The rendering of the game
 * 
 * @author valentin/Robrock version 1
 * 
 */
public class GameRenderer {

	// Fields
	HashMap<String, BufferedImage> sprites;
	private final static String fontPath = "res/PrStart.ttf";
	private static Font font;
	
	// Constructors
	public GameRenderer() {

		// we create the hashmap of all the sprites used in the game
		this.sprites = new HashMap<String, BufferedImage>();

		// we had all sprites
		this.sprites.put(Player.class.getName(), GameSprites.playerSprite());
		this.sprites.put(Exit.class.getName(), GameSprites.exitSprite());
		this.sprites.put(Triangle.class.getName(), GameSprites.triangleSprite());
		this.sprites.put(Circle.class.getName(), GameSprites.circleSprite());
		// we create different sizes of fragments
		for (int i = 2;i<8;i++) {
			this.sprites.put(Fragment.class.getName()+i, GameSprites.fragmentSprite(i));
		}

		// we load the custom font
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {
			GameRenderer.font = Font.createFont(Font.TRUETYPE_FONT,ResourceLoader.getResourceAsStream(fontPath)).deriveFont(10f);
			ge.registerFont(GameRenderer.font);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	// Methods
	public void render(Graphics g, Updater u) {
		// TODO :
		// level number
		// death number
		// funny sentence

		// we display all
		// display the background level
		g.drawImage(u.getActualLevel().getBackground(), 0, 0, null);
		if (u.getActualLevel().getEnemies().size() != 0) {

			for (int i = 0; i < u.getActualLevel().getEnemies().size(); i++) {

				// we create a transitional sprite
				BufferedImage sprite = new BufferedImage(u.getActualLevel().getEnemies().get(i).getWidth()+2, u.getActualLevel().getEnemies().get(i).getHeight()+2, BufferedImage.TYPE_INT_ARGB);

				// if the enemy is a triangle, we have to rotate it
				if (u.getActualLevel().getEnemies().get(i).getClass().getName() == Triangle.class.getName()) {
					sprite = u.getActualLevel().getEnemies().get(i).rotateSprite().filter(this.sprites.get(u.getActualLevel().getEnemies().get(i).getClass().getName()), null);
					//draw the speed vector
					//g.setColor(new Color(255,0,0));
					//g.drawLine((int) (u.getActualLevel().getEnemies().get(i).getPosX()+u.getActualLevel().getEnemies().get(i).getWidth()/2), (int) (u.getActualLevel().getEnemies().get(i).getPosY()+u.getActualLevel().getEnemies().get(i).getHeight()/2),(int) (u.getActualLevel().getEnemies().get(i).getPosX()+u.getActualLevel().getEnemies().get(i).getWidth()/2+20*u.getActualLevel().getEnemies().get(i).getSpeedX()),(int) (u.getActualLevel().getEnemies().get(i).getPosY()+u.getActualLevel().getEnemies().get(i).getHeight()/2+20*u.getActualLevel().getEnemies().get(i).getSpeedY()));
				} else {
					sprite = this.sprites.get(u.getActualLevel().getEnemies().get(i).getClass().getName());
				}
				g.drawImage(sprite, (int) u.getActualLevel().getEnemies().get(i).getPosX(), (int) u.getActualLevel().getEnemies().get(i).getPosY(), null);
			}

		}
		// display the goal
		g.drawImage(this.sprites.get(Exit.class.getName()), (int) u.getActualLevel().getExit().getPosX(), (int) u.getActualLevel().getExit().getPosY(), null);

		// display the player
		g.drawImage(this.sprites.get(Player.class.getName()), (int) u.getPlayer().getPosX(), (int) u.getPlayer().getPosY(), null);
		
		// we display the fragments
		if (u.getFragments().size() != 0) {
			for (int i = 0;i<u.getFragments().size();i++) {
				g.drawImage(this.sprites.get(Fragment.class.getName()+u.getFragments().get(i).getSize()),(int)u.getFragments().get(i).getPosX(),(int) u.getFragments().get(i).getPosY(),null);
			}
		}
		
		
		
		g.setFont(GameRenderer.font);
		g.setColor(Color.WHITE);
		// display the level
		g.drawString("Level "+(u.getActualLevelID()+1),318,28);
		
		// display the deaths
		g.drawString("Deaths  : "+u.getDeathNumber(),10,360);
		
		// display the sentence		
		g.drawString(u.getActualLevel().getNextSentence(),10,385);
	}

}
