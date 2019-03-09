package gameoflife;

import java.awt.Dimension;
import java.awt.Toolkit;

final public class Config {

	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	public static int SIZE = 120;

	static int framerate = 60;

	static boolean colors = true;

	static double RestartCondition = 0; // 0.0000001*AmountOfBalls;

	static int speed = 1; // the faster the less smooth
	
	static int Bottom = (int) (Config.screenSize.getHeight());
	static int RightWall = (int) Config.screenSize.getWidth();
	static int dims = Math.min(Config.RightWall, Config.Bottom) / Config.SIZE;

}