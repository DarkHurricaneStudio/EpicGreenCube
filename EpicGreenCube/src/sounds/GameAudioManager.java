package sounds;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import quentinc.audio.AudioManager;
import quentinc.audio.Sample;
import sounds.waitingLists.WaitingList;

public class GameAudioManager extends AudioManager {

	// Fields
	private HashMap<Integer, WaitingList> lists;

	private HashMap<Integer, Sample> samples;
	public final static int BACK_SAMPLE = 0;
	public final static int DIE_SAMPLE = 1;

	// Constructors
	/**
	 * Needed to throws the exception
	 * 
	 * @throws LineUnavailableException
	 */
	public GameAudioManager() throws LineUnavailableException {
		super();
		this.lists = new HashMap<>();
		this.samples = new HashMap<>();
		this.initializeLists();
		this.initializeSamples();
	}

	// Methods
	public void initializeLists() {
		
	}

	public void initializeSamples() {
		try {
			
			File file = new File("res/back.mp3");
			AudioInputStream in = AudioSystem.getAudioInputStream(file);
			AudioInputStream din = null;
			AudioFormat baseFormat = in.getFormat();
			AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16, baseFormat.getChannels(), baseFormat.getChannels(),baseFormat.getSampleRate(),false);
			din = AudioSystem.getAudioInputStream(decodedFormat,in);
			
			this.samples.put(GameAudioManager.BACK_SAMPLE, this.loadSample(new File("res/back.mp3")));
			
			
			this.samples.put(GameAudioManager.DIE_SAMPLE, this.loadSample(new File("res/die.wav")));
		} catch (UnsupportedAudioFileException e) {
			System.out.println("Error, unsupported audio file !");
			System.exit(2);
		}
		catch (IOException e){
			System.out.println("Error while reading the sound file");
			System.exit(2);
		}
	}
}
