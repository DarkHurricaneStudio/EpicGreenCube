package sounds;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javazoom.spi.mpeg.sampled.file.MpegAudioFileReader;
import quentinc.audio.AudioManager;
import quentinc.audio.Sample;
import sounds.waitingLists.LoopingWaitingList;
import sounds.waitingLists.MultiSoundWaitingList;
import sounds.waitingLists.WaitingList;

public class GameAudioManager extends AudioManager {

	// Fields
	private HashMap<Integer, WaitingList> lists;
	public final static int BACKGROUND_LIST = 0;
	public final static int SFX_LIST = 1;

	private HashMap<Integer, Sample> samples;
	public final static int BACK_SAMPLE = 0;
	public final static int DIE_SAMPLE = 1;

	private static ArrayList<Request> requests = new ArrayList<>();

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
		this.lists.put(GameAudioManager.BACKGROUND_LIST, new LoopingWaitingList());
		this.lists.put(GameAudioManager.SFX_LIST, new MultiSoundWaitingList());
	}

	public void initializeSamples() {
		try {
			MpegAudioFileReader reader = new MpegAudioFileReader();
			this.samples.put(GameAudioManager.BACK_SAMPLE, this.loadSample(reader.getAudioInputStream(new File(System.getProperty("user.dir")+"\\res\\back.mp3"))));
			
			this.samples.put(GameAudioManager.DIE_SAMPLE, this.loadSample(new File(System.getProperty("user.dir")+"\\res\\death.wav")));
		} catch (UnsupportedAudioFileException e) {
			System.out.println("Error, unsupported audio file !");
			e.printStackTrace();
			System.exit(2);
		} catch (IOException e) {
			System.out.println("Error while reading the sound file");
			e.printStackTrace();
			System.exit(2);
		}
	}

	public void updateSounds() {
		// Requests
		for (int i=0;i<GameAudioManager.requests.size();i++){
			int sampleID = GameAudioManager.requests.get(i).getSampleID();
			int listID = GameAudioManager.requests.get(i).getListID();
			
			this.lists.get(listID).addSample(this.samples.get(sampleID));
		}
		GameAudioManager.requests.clear();
		
		// Lists' update
		for (int i = 0; i < this.lists.size(); i++) {
			this.lists.get(i).update(this);
		}
		
		// Should be call (quentinc say it bitch)
		this.update3D();
	}

	public static void request(int sampleID, int listID) {
		GameAudioManager.requests.add(new Request(sampleID, listID));
	}
}

class Request {

	private int sampleID, listID;

	public Request(int sampleID, int listID) {
		this.listID = listID;
		this.sampleID = sampleID;
	}

	public int getSampleID() {
		return this.sampleID;
	}

	public int getListID() {
		return this.listID;
	}

}