package gameoflife;

import java.util.Random;

import processing.core.PApplet;

public class GameOfLife extends processing.template.Gui {

	final IConfig config = Config.getInstance();
	public static int count = 0;
	static Random r = new Random();
	public static int speed;
	public static int tmpCount;
	public Cell[][] tmpGen = new Cell[config.getSize()][config.getSize()];

	public Cell[][] gen() {
		final Cell[][] Gen = new Cell[config.getSize()][config.getSize()];
		{
			for (int i = 0; i < config.getSize(); i++) {
				for (int j = 0; j < config.getSize(); j++) {
					Gen[i][j] = new Cell();
					Gen[i][j].setAlive(GameOfLife.r.nextBoolean());
				}
			}
		}
		return (Gen);
	}

	public static void main(String[] args) {
		final GameOfLife gol = new GameOfLife();
		gol.run("gameoflife.GameOfLife");
	}

	Civilization civ = new Civilization(gen());

	public GameOfLife() {
	}

	@Override
	public void draw() {

		this.background(0);

		this.present(this.civ);
		this.civ.setGen(this.civ.nextGen());

		this.textSize(30);
		this.fill(255, 255, 255, 255);
		this.text("Options:", 2200, 100);
		this.text("r :  	restart (random)", 2200, 150);
		this.text("s :   save state", 2200, 180);
		this.text("l :   reload state", 2200, 210);
		this.text("+ :   speed up", 2200, 240);
		this.text("- :   slow down", 2200, 270);
		this.text("c :   colors", 2200, 300);
		this.text("q :   quit", 2200, 360);

		GameOfLife.count = GameOfLife.count + 1;
		this.text(PApplet.str(GameOfLife.count) + "th generation", 2200, 540);

		if (this.keyPressed && this.key == 'c') {
			config.setColors(!config.isColors());
		}
		if (this.keyPressed && this.key == 'r') {
			this.civ.setGen(gen());
		}
		if (this.keyPressed && this.key == 's') {
			for (int i = 0; i < config.getSize(); i++) {
				for (int j = 0; j < config.getSize(); j++) {
					tmpGen[i][j] = new Cell();
					tmpGen[i][j].setAlive(this.civ.getGen()[i][j].isAlive());
				}
			}
			GameOfLife.tmpCount = GameOfLife.count;
		}
		if (this.keyPressed && this.key == 'l') {
			for (int i = 0; i < config.getSize(); i++) {
				for (int j = 0; j < config.getSize(); j++) {
					this.civ.getGen()[i][j].setAlive(tmpGen[i][j].isAlive());
				}
			}
			GameOfLife.count = GameOfLife.tmpCount;
		}
		if (this.keyPressed && this.key == '+') {
			if (GameOfLife.speed > 0) {
				try {
					Thread.sleep(200);
				} catch (final InterruptedException e) {
					e.printStackTrace();
				}
				GameOfLife.speed = GameOfLife.speed - 50;
			}
		}
		if (this.keyPressed && this.key == '-') {
			try {
				Thread.sleep(200);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
			GameOfLife.speed = GameOfLife.speed + 50;
		}
		if (this.keyPressed && this.key == 'q') {
			this.exit();
		}
		try {
			Thread.sleep(GameOfLife.speed);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void present(Civilization civ) {
		final Cell[][] tmpCiv = civ.nextGen();
		for (int i = 0; i < config.getSize(); i++) {
			for (int j = 0; j < config.getSize(); j++) {
				if (civ.getGen()[i][j].isAlive()) {
					if (config.isColors()) {
						if (tmpCiv[i][j].isAlive()) {
							this.fill(255, 255, 255);
						} else {
							this.fill(255, 0, 0);
						}
					} else {
						this.fill(255, 255, 255);
					}
				} else {
					if (config.isColors()) {
						if (tmpCiv[i][j].isAlive()) {
							this.fill(0, 255, 0);
						} else {
							this.fill(0, 0, 0);
						}
					} else {
						this.fill(0, 0, 0);
					}
				}
				this.rect(config.getDims() * i, config.getDims() * j, config.getDims(), config.getDims());
			}
		}
	}

	@Override
	public void setup() {
		this.frameRate(config.getFramerate());
//		background(255);
//		frameRate(60);
//		getSurface().setResizable(true);
//		getSurface().setSize(10 * config.SIZE, 5 * config.SIZE);
//		getSurface().setLocation(displayWidth - width >> 1,
//				displayHeight - height >> 1);

	}
}