package sounds.waitingLists;

import java.util.ArrayList;

import quentinc.audio.AudioManager;
import quentinc.audio.Sample;

public abstract class WaitingList {

	// Fields
	protected ArrayList<Sample> list;
	private int currentIndex;
	
	// Constructors
	public WaitingList(){
		this.list = new ArrayList<>();
		this.currentIndex = 0;
	}
	
	// Methods
	public void addSample(Sample s) {
		this.list.add(s);
	}
	
	public int getIndex(){
		int res;
		if (this.currentIndex < this.list.size()){
			res = this.currentIndex;
			this.currentIndex++;
		}
		else {
			this.currentIndex = 0;
			res = this.currentIndex;
		}
		return res;
	}
	public abstract void update(AudioManager am);
}
