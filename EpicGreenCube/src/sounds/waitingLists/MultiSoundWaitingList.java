package sounds.waitingLists;

import quentinc.audio.AudioManager;

public class MultiSoundWaitingList extends WaitingList {

	// Fields
	
	// Constructors
	public MultiSoundWaitingList(){
		super();
	}
	
	// Methods
	public void update(AudioManager am){
		for (int i=0;i<this.list.size();i++){
			am.play(this.list.get(i));
		}
		this.list.clear();
	}
}
