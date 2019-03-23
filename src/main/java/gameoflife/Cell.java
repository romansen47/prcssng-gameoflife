package gameoflife;

public class Cell {
	private boolean	alive;
	private String	color;

	public Cell() {
	}

	public Cell(boolean al) {
		color	= "None";
		alive	= al;
	}

	public String getColor() {
		return color;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public void setColor(String color) {
		this.color = color;
	}
}