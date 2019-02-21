package gameoflife;

import java.util.*;

import gameoflife.Cell;
import gameoflife.Civilization;
import gameoflife.Config;

public class GameOfLife extends processing.template.Gui{
	 public GameOfLife() {};
	 public static int count = 0;
	 public static int speed;
	 public static int tmpCount;
	 public static Cell[][] tmpGen=new Cell[Config.SIZE][Config.SIZE]; 
	 /*
	 public static void main(String[] args) {
		 PApplet.main(new String[] { "--present","gameoflife.GameOfLife"});
	 }
	 */
	 
	 public static void main(String[] args) {
		 GameOfLife gol=new GameOfLife();
		 gol.run("gameoflife.GameOfLife");
	 }
	 
	 @Override
	 public void settings(){ 
		 fullScreen();
		 //size(1200,1200);
	 } 
	 
	 @Override
	 public void setup(){
		 frameRate(Config.framerate);
	 }
	 static Random r = new Random();
	 public static Cell[][] gen(){
		 Cell[][] Gen=new Cell[Config.SIZE][Config.SIZE];
		 {
			 for (int i=0;i<Config.SIZE;i++) {
				 for (int j=0;j<Config.SIZE;j++) {
					 Gen[i][j]=new Cell();
					 Gen[i][j].setAlive(r.nextBoolean());
				 }
			 }
		 }
		 return(Gen);
	 }
	 Civilization civ = new Civilization(gen());
	 
	 @Override
	 public void draw(){
		 
		 	background(0);

			present(civ);
			civ.setGen(civ.nextGen());
			

		 	textSize(30);
			fill(255,255,255,255);
			text("Options:", 2200, 100);
			text("r :  	restart (random)", 2200, 150);
			text("s :   save state", 2200, 180);
			text("l :   reload state", 2200, 210);
			text("+ :   speed up", 2200, 240);
			text("- :   slow down", 2200, 270);
			text("c :   colors", 2200, 300);
			text("q :   quit", 2200, 360);
			
			count=count+1;
			text(str(count)+"th generation",2200,540);
			
			if (keyPressed && key=='c') {
                Config.colors = !Config.colors;
			}
			if (keyPressed && key=='r') {
				civ.setGen(gen());
			}
			if (keyPressed && key=='s') {
				for (int i =0; i<Config.SIZE;i++) {
					for (int j=0;j<Config.SIZE;j++) {
						tmpGen[i][j]=new Cell();
						tmpGen[i][j].setAlive(civ.getGen()[i][j].isAlive());
					}
				}
				tmpCount=count;
			}
			if (keyPressed && key=='l') {
				for (int i =0; i<Config.SIZE;i++) {
					for (int j=0;j<Config.SIZE;j++) {
						civ.getGen()[i][j].setAlive(tmpGen[i][j].isAlive());
					}
				}
				count=tmpCount;
			}
			if (keyPressed && key=='+') { 
				if (speed>0) { 
					try {Thread.sleep(200);} 
					catch (InterruptedException e) {e.printStackTrace();} 
					speed=speed-50;}
				}
			if (keyPressed && key=='-') {
				try {Thread.sleep(200);} 
				catch (InterruptedException e) {e.printStackTrace();} 
				speed=speed+50;}
			if (keyPressed && key=='q') { exit();			}
			try { Thread.sleep(speed);} catch (InterruptedException e) {e.printStackTrace();}
	 }
	 public void present(Civilization civ) {
		 Cell[][] tmpCiv=civ.nextGen();
		 for (int i=0;i<Config.SIZE;i++) {
			 for (int j=0;j<Config.SIZE;j++) {
				 if (civ.getGen()[i][j].isAlive()) {
					 if (Config.colors) {
						 if (tmpCiv[i][j].isAlive()) {
							 fill(255,255,255);
						 }
						 else {
							 fill(255,0,0);
						 }
					 }
					 else {fill(255,255,255);}
				 }
				 else {
					 if (Config.colors) {
						 if (tmpCiv[i][j].isAlive()) {
							 fill(0,255,0);
						 }
						 else {
							 fill(0,0,0);
						 }
					 }
					 else {fill(0,0,0);}
				 }
				 rect(Config.dims*i,Config.dims*j,Config.dims,Config.dims);
			 }
		 }
	 } 
}