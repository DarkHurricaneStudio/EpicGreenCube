package sprites;

import game.Circle;
import game.Exit;
import game.Player;
import game.Triangle;
import game.Updater;

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
	
	public void render(Updater u) {
		// we display all
		//TODO
		//display the background level
		//TODO.drawImage(u.getActualLevel().getBackground(),0,0);
		//display the player
		//TODO.drawImage(this.sprites.get("Player",u.getPlayer().getPosX(),u.getPlayer.getPosY());
	}

}
