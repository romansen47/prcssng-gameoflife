package gameoflife;

import gameoflife.Cell;
import gameoflife.Config;

public class Civilization {
	public Cell[][] gen;
	public Civilization(Cell[][] generation) {
		this.gen=generation;
	}
	public Cell[][] nextGen() {
		Cell[][] tmpGen=new Cell[Config.SIZE][Config.SIZE];
		int count;
		for (int i=0;i<Config.SIZE;i++) {
			for (int j=0;j<Config.SIZE;j++) {
				tmpGen[i][j]=new Cell();
				count=0;
				if (this.gen[(i-1+Config.SIZE)%Config.SIZE][(j-1+Config.SIZE)%Config.SIZE].alive) {count=count+1;}
				if (this.gen[(i-1+Config.SIZE)%Config.SIZE][(j+Config.SIZE)%Config.SIZE].alive) {count=count+1;}
				if (this.gen[(i-1+Config.SIZE)%Config.SIZE][(j+1+Config.SIZE)%Config.SIZE].alive) {count=count+1;}
				if (this.gen[(i+Config.SIZE)%Config.SIZE][(j-1+Config.SIZE)%Config.SIZE].alive) {count=count+1;}
				if (this.gen[(i+Config.SIZE)%Config.SIZE][(j+1+Config.SIZE)%Config.SIZE].alive) {count=count+1;}
				if (this.gen[(i+1+Config.SIZE)%Config.SIZE][(j-1+Config.SIZE)%Config.SIZE].alive) {count=count+1;}
				if (this.gen[(i+1+Config.SIZE)%Config.SIZE][(j+Config.SIZE)%Config.SIZE].alive) {count=count+1;}
				if (this.gen[(i+1+Config.SIZE)%Config.SIZE][(j+1+Config.SIZE)%Config.SIZE].alive) {count=count+1;}
				if (this.gen[i][j].alive==true) {
                    tmpGen[i][j].alive = count <= 3 && count >= 2;
				}
				else {
                    tmpGen[i][j].alive = count == 3;
				}
			}
		}
		return(tmpGen);
	}
}