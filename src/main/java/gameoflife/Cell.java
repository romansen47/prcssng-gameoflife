package gameoflife;

public class Cell {
	private boolean alive;
	private String color;

	public Cell() {
	}

	public Cell(boolean al) {
		this.color = "None";
		this.alive = al;
	}

	public String getColor() {
		return this.color;
	}

	public boolean isAlive() {
		return this.alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public void setColor(String color) {
		this.color = color;
	}
}