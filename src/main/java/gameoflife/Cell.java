package gameoflife;

public class Cell {
	public boolean alive;
	public String color;
	public Cell() {}
	public Cell(boolean al) {
		this.color="None";
		this.alive=al;
	}
}