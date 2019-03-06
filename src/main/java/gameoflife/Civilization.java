package gameoflife;

public class Civilization {

	private Cell[][] gen;

	public Civilization(Cell[][] generation) {
		this.setGen(generation);
	}

	public Cell[][] nextGen() {
		Cell[][] tmpGen = new Cell[Config.SIZE][Config.SIZE];
		int count;
		for (int i = 0; i < Config.SIZE; i++) {
			for (int j = 0; j < Config.SIZE; j++) {
				tmpGen[i][j] = new Cell();
				count = 0;
				if (this.getGen()[(i - 1 + Config.SIZE) % Config.SIZE][(j - 1 + Config.SIZE) % Config.SIZE].isAlive()) {
					count = count + 1;
				}
				if (this.getGen()[(i - 1 + Config.SIZE) % Config.SIZE][(j + Config.SIZE) % Config.SIZE].isAlive()) {
					count = count + 1;
				}
				if (this.getGen()[(i - 1 + Config.SIZE) % Config.SIZE][(j + 1 + Config.SIZE) % Config.SIZE].isAlive()) {
					count = count + 1;
				}
				if (this.getGen()[(i + Config.SIZE) % Config.SIZE][(j - 1 + Config.SIZE) % Config.SIZE].isAlive()) {
					count = count + 1;
				}
				if (this.getGen()[(i + Config.SIZE) % Config.SIZE][(j + 1 + Config.SIZE) % Config.SIZE].isAlive()) {
					count = count + 1;
				}
				if (this.getGen()[(i + 1 + Config.SIZE) % Config.SIZE][(j - 1 + Config.SIZE) % Config.SIZE].isAlive()) {
					count = count + 1;
				}
				if (this.getGen()[(i + 1 + Config.SIZE) % Config.SIZE][(j + Config.SIZE) % Config.SIZE].isAlive()) {
					count = count + 1;
				}
				if (this.getGen()[(i + 1 + Config.SIZE) % Config.SIZE][(j + 1 + Config.SIZE) % Config.SIZE].isAlive()) {
					count = count + 1;
				}
				if (this.getGen()[i][j].isAlive()) {
					tmpGen[i][j].setAlive(count <= 3 && count >= 2);
				} else {
					tmpGen[i][j].setAlive(count == 3);
				}
			}
		}
		return (tmpGen);
	}

	public Cell[][] getGen() {
		return gen;
	}

	public void setGen(Cell[][] gen) {
		this.gen = gen;
	}
}