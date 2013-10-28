package sprites;

import game.Circle;
import game.Exit;
import game.Player;
import game.Triangle;
import game.Updater;
import gui.Main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;


public class GameRenderer {
	
	//fields
	HashMap<String, BufferedImage>sprites;
	
	public GameRenderer() {
		
		// we create the hashmap of all the sprites used in the game
		this.sprites = new HashMap<String, BufferedImage>();
		
		// we had all sprites
		this.sprites.put(Player.class.getName(), GameSprites.playerSprite());
		this.sprites.put(Exit.class.getName(), GameSprites.exitSprite());
		this.sprites.put(Triangle.class.getName(), GameSprites.triangleSprite());
		this.sprites.put(Circle.class.getName(), GameSprites.circleSprite());
		
	}
	
	public BufferedImage render(Updater u) {
		// TODO :
		// level number
		// death number
		// funny sentence
		
		
		BufferedImage screen = new BufferedImage(Main.WIDTH,Main.HEIGHT,BufferedImage.TYPE_INT_RGB);
		Graphics g = screen.getGraphics();
		
		// we display all
		//display the background level
		g.drawImage(u.getActualLevel().getBackground(),0,0,null);
		//display the player
		g.drawImage(this.sprites.get("Player"),(int) u.getPlayer().getPosX(),(int) u.getPlayer().getPosY(),null);
		// display the enemies
		for (int i = 0; i < u.getActualLevel().getEnemies().size();i++) {
			
			// we create a transitional sprite
			BufferedImage sprite = this.sprites.get(u.getActualLevel().getEnemies().get(i).getClass().getName());
			
			// if the enemy is a triangle, we have to rotate it
			if (u.getActualLevel().getEnemies().get(i).getClass().getName() == Triangle.class.getName())
				u.getActualLevel().getEnemies().get(i).rotateSprite().filter(sprite,null);
				
			g.drawImage(sprite,(int) u.getActualLevel().getEnemies().get(i).getPosX(), (int) u.getActualLevel().getEnemies().get(i).getPosY(), null);
		}
		//display the goal
		g.drawImage(this.sprites.get("Exit"),(int) u.getActualLevel().getExit().getPosX(),(int) u.getActualLevel().getExit().getPosY(),null);
		
		// we return the screen
		return screen;
		
	}

}
