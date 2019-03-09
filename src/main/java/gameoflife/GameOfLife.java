package gameoflife;

import java.util.Random;

import processing.core.PApplet;

public class GameOfLife extends processing.template.Gui {
	public static int count = 0;

	static Random r = new Random();
	public static int speed;
	public static int tmpCount;
	public static Cell[][] tmpGen = new Cell[Config.SIZE][Config.SIZE];

	public static Cell[][] gen() {
		final Cell[][] Gen = new Cell[Config.SIZE][Config.SIZE];
		{
			for (int i = 0; i < Config.SIZE; i++) {
				for (int j = 0; j < Config.SIZE; j++) {
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

	Civilization civ = new Civilization(GameOfLife.gen());

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
			Config.colors = !Config.colors;
		}
		if (this.keyPressed && this.key == 'r') {
			this.civ.setGen(GameOfLife.gen());
		}
		if (this.keyPressed && this.key == 's') {
			for (int i = 0; i < Config.SIZE; i++) {
				for (int j = 0; j < Config.SIZE; j++) {
					GameOfLife.tmpGen[i][j] = new Cell();
					GameOfLife.tmpGen[i][j].setAlive(this.civ.getGen()[i][j].isAlive());
				}
			}
			GameOfLife.tmpCount = GameOfLife.count;
		}
		if (this.keyPressed && this.key == 'l') {
			for (int i = 0; i < Config.SIZE; i++) {
				for (int j = 0; j < Config.SIZE; j++) {
					this.civ.getGen()[i][j].setAlive(GameOfLife.tmpGen[i][j].isAlive());
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
		for (int i = 0; i < Config.SIZE; i++) {
			for (int j = 0; j < Config.SIZE; j++) {
				if (civ.getGen()[i][j].isAlive()) {
					if (Config.colors) {
						if (tmpCiv[i][j].isAlive()) {
							this.fill(255, 255, 255);
						} else {
							this.fill(255, 0, 0);
						}
					} else {
						this.fill(255, 255, 255);
					}
				} else {
					if (Config.colors) {
						if (tmpCiv[i][j].isAlive()) {
							this.fill(0, 255, 0);
						} else {
							this.fill(0, 0, 0);
						}
					} else {
						this.fill(0, 0, 0);
					}
				}
				this.rect(Config.dims * i, Config.dims * j, Config.dims, Config.dims);
			}
		}
	}

	@Override
	public void setup() {
		this.frameRate(Config.framerate);
//		background(255);
//		frameRate(60);
//		getSurface().setResizable(true);
//		getSurface().setSize(10 * Config.SIZE, 5 * Config.SIZE);
//		getSurface().setLocation(displayWidth - width >> 1,
//				displayHeight - height >> 1);

	}
}