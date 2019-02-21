package gameoflife;

public class Cell {
	private boolean alive;
	private String color;
	public Cell() {}
	public Cell(boolean al) {
		this.color="None";
		this.alive=al;
	}
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}