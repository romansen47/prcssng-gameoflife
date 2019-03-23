package gameoflife;

public class Civilization {

	final IConfig config = Config.getInstance();
	private Cell[][] gen;

	public Civilization(Cell[][] generation) {
		setGen(generation);
	}

	public Cell[][] getGen() {
		return gen;
	}

	public Cell[][] nextGen() {
		final Cell[][] tmpGen = new Cell[config.getSize()][config.getSize()];
		int count;
		for (int i = 0; i < config.getSize(); i++) {
			for (int j = 0; j < config.getSize(); j++) {
				tmpGen[i][j] = new Cell();
				count = 0;
				if (getGen()[(i - 1 + config.getSize()) % config.getSize()][(j - 1 + config.getSize())
						% config.getSize()].isAlive()) {
					count = count + 1;
				}
				if (getGen()[(i - 1 + config.getSize()) % config.getSize()][(j + config.getSize()) % config.getSize()]
						.isAlive()) {
					count = count + 1;
				}
				if (getGen()[(i - 1 + config.getSize()) % config.getSize()][(j + 1 + config.getSize())
						% config.getSize()].isAlive()) {
					count = count + 1;
				}
				if (getGen()[(i + config.getSize()) % config.getSize()][(j - 1 + config.getSize()) % config.getSize()]
						.isAlive()) {
					count = count + 1;
				}
				if (getGen()[(i + config.getSize()) % config.getSize()][(j + 1 + config.getSize()) % config.getSize()]
						.isAlive()) {
					count = count + 1;
				}
				if (getGen()[(i + 1 + config.getSize()) % config.getSize()][(j - 1 + config.getSize())
						% config.getSize()].isAlive()) {
					count = count + 1;
				}
				if (getGen()[(i + 1 + config.getSize()) % config.getSize()][(j + config.getSize()) % config.getSize()]
						.isAlive()) {
					count = count + 1;
				}
				if (getGen()[(i + 1 + config.getSize()) % config.getSize()][(j + 1 + config.getSize())
						% config.getSize()].isAlive()) {
					count = count + 1;
				}
				if (getGen()[i][j].isAlive()) {
					tmpGen[i][j].setAlive(count <= 3 && count >= 2);
				} else {
					tmpGen[i][j].setAlive(count == 3);
				}
			}
		}
		return (tmpGen);
	}

	public void setGen(Cell[][] gen) {
		this.gen = gen;
	}
}