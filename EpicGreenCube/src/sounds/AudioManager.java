package sounds;

import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

public class AudioManager {

	public static Audio backgroundMusic;
	
	public static Audio deathSound;
	
	public static void init(){
		try {
			AudioManager.backgroundMusic = AudioLoader.getAudio("OGG", ResourceLoader.getResourceAsStream("res/back.ogg"));
			AudioManager.deathSound = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("res/death.wav"));
		} catch (Exception e){
			System.out.println("Erreur lors du chargement des sons !");
		}
	}
}
