package views;

import game.Updater;
import gui.MainPanel;

import java.awt.image.BufferedImage;

/**
 * Main view, containing the game. It can display it and update it via an updater.
 * 
 * @author Robrock
 */
public class GameView extends View {

	// Fields
	/**
	 * Updater of the game. Control all the game datas.
	 */
	private Updater updater;

	
	/**
	 * 
	 */
	private long beforeTime, timeDiff, afterTime, sleepTime,overSleepTime;
	
	/**
	 * Time (in ns) per frame
	 */
	private int period = 1000000000 / GameView.FPS;
	
	/**
	 * 
	 */
	private int noDelays;
	
	/**
	 * 
	 */
	private final static int FPS = 60;
	
	/**
	 * 
	 */
	private final static int NO_DELAYS_PER_YIELD = 10;
	
	// Constructors
	/**
	 * Create the view and the updater.
	 */
	public GameView(MainPanel panel) {
		super(panel);
		this.updater = new Updater();
		this.noDelays = 0;
	}

	// Methods
	public void start() {
		// Needed for the first loop
		beforeTime = System.nanoTime();
	}

	public void run() {
		//this.gameUpdate(); // Game state is updated
		//this.gameRender(); // Render to a buffer
		// this.paintScreen(); // Draw buffer to screen
		
		// NanoTime after the update/render
		afterTime = System.nanoTime();
		
		// Time (in ns) using to update/render
		timeDiff = afterTime - beforeTime;
		
		// Time to sleep, period minus time used
		sleepTime = (period - timeDiff) - overSleepTime;

		if (sleepTime > 0) { // Some time left in this cycle
			try {
				// Sleep sleepTime (convert in ms)
				Thread.sleep(sleepTime / 1000000L);
			} catch (InterruptedException e) {
				// If there's a sleep error
				System.out.println("Bro error");
				overSleepTime = (System.nanoTime() - afterTime) - sleepTime;
			}
		} else { // sleepTime <= 0; frame took longer than the period
			System.out.println("Bro SUPER error");
			
			overSleepTime = 0L;

			if (++noDelays >= GameView.NO_DELAYS_PER_YIELD) {
				Thread.yield(); // Give another thread 	a chance to run
				noDelays = 0;
			}
		}
		beforeTime = System.nanoTime();
	}

	public void stop() {

	}

	public BufferedImage render() {
		return null;
	}

}
