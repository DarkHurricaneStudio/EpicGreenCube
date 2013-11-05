package sounds.waitingLists;

import quentinc.audio.AudioManager;

public class LoopingWaitingList extends WaitingList {

	// Fields
	
	// Constructors
	public LoopingWaitingList(){
		super();
	}
	
	// Methods
	public void update(AudioManager am){
		if (am.getPositionInFrames() < am.getDurationInFrames()-1){
			return;
		}
		else {
			try {
				am.play(this.list.get(this.getIndex()));
			}
			catch (Exception e){
				
			}
		}
	}
}
