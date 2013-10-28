package game;



import sprites.GameSprites;

public class Exit extends Entity {

	public Exit(double spawnX, double spawnY) {
		super(spawnX, spawnY);
		this.width = GameSprites.EXIT_WIDTH;
		this.height = GameSprites.EXIT_HEIGHT;
	}

	@Override
	public void update(Updater u) {
		// TODO Auto-generated method stub

	}

}
