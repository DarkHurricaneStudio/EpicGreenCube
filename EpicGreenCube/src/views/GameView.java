package views;

import game.Updater;
import gui.MainPanel;
import handlers.KeyboardInputHandler;

import java.awt.event.KeyEvent;

import sprites.GameRenderer;

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
	 * Renderer of the games
	 */
	private GameRenderer renderer;
	
	/**
	 * 
	 */
	private long beforeTime,sleepTime;
	
	/**
	 * Time (in ns) per frame
	 */
	private final static int PERIOD = 1000000000 / GameView.FPS;
	
	/**
	 * Number of frames too long following the period
	 */
	private int noDelays;
	
	/**
	 * FPS goal
	 */
	private final static int FPS = 60;
	
	/**
	 * Number of errors before yielding
	 */
	private final static int NO_DELAYS_PER_YIELD = 10;
	
	/**
	 * Used for FPS counter
	 */
	private long beforeFPS,counterFPS;
	
	
	// Constructors
	/**
	 * Create the view and the updater.
	 */
	public GameView(MainPanel panel) {
		super(panel);
		this.updater = new Updater();
		this.renderer = new GameRenderer();
		
		this.noDelays = 0;
	}

	// Methods
	public void start() {
		KeyboardInputHandler.reset();
		
		// Needed for the first loop		
		beforeTime = System.nanoTime();	
		beforeFPS = System.nanoTime();
	}

	public void run() {
		// Pause system
		if (KeyboardInputHandler.keys[KeyEvent.VK_P] || KeyboardInputHandler.keys[KeyEvent.VK_ESCAPE]) {
			this.panel.setView(PauseView.class.getName());
		}
	
		long now = System.nanoTime();
		this.updater.update(); // Game is updated
		long updateNow = System.nanoTime();
		this.render(); // Save in a buffer
		long renderNow = System.nanoTime();
		this.paintScreen(); // Draw buffer to screen
		long paintNow = System.nanoTime();
		
		// Time to sleep, period minus time used
		sleepTime = (GameView.PERIOD - (System.nanoTime() - beforeTime));

		if (sleepTime > 0) { // Some time left in this cycle
			while (System.nanoTime() - beforeTime < GameView.PERIOD ) {}
		} else { // sleepTime <= 0; frame took longer than the period
			System.out.println("Too long");			

			if (++noDelays >= GameView.NO_DELAYS_PER_YIELD) {
				Thread.yield(); // Give another thread 	a chance to run
				noDelays = 0;
			}
		}
		
		System.out.println(updateNow-now);
		System.out.println(renderNow-updateNow);
		System.out.println(paintNow-renderNow);
		
		
		if (System.nanoTime() - beforeFPS < 1000000000){
			this.counterFPS++;
		}
		else {
			//System.out.println(this.counterFPS);
			this.counterFPS = 1;
			this.beforeFPS = System.nanoTime();
		}
		
		beforeTime = System.nanoTime();
	}

	public void stop() {

	}

	public void render() {
		this.renderer.render(this.render.getGraphics(),this.updater);
	}

}
