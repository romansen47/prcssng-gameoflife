package gameoflife;

import java.awt.Dimension;
import java.awt.Toolkit;

final public class Config {

	static int framerate = 60;
	static int speed = 1; // the faster the less smooth
	static double RestartCondition = 0; // 0.0000001*AmountOfBalls;
	public static int SIZE = 120;
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	static int RightWall = (int) Config.screenSize.getWidth();
	static int Bottom = (int) (Config.screenSize.getHeight());
	static int dims = Math.min(Config.RightWall, Config.Bottom) / Config.SIZE;
	static boolean colors = true;

}