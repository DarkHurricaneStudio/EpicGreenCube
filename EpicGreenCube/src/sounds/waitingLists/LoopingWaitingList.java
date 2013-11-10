package sounds.waitingLists;

import quentinc.audio.AudioManager;

public class LoopingWaitingList extends WaitingList {

	// Fields
	private double sampleLength;
	private int currentIndex;
	private double startTime;
	
	// Constructors
	public LoopingWaitingList(){
		super();
	}
	
	// Methods
	public void update(AudioManager am){
		//System.out.println((System.nanoTime() - this.startTime)/1000000000+" / "+this.sampleLength);
		if ((System.nanoTime() - this.startTime)/1000000000 < this.sampleLength){
			return;
		}
		else {
			try {
				this.currentIndex = this.getIndex();
				this.sampleLength = this.list.get(this.currentIndex).getDuration();
				this.startTime = System.nanoTime();
				am.play(this.list.get(this.currentIndex));
			}
			catch (Exception e){
				
			}
		}
	}
}
