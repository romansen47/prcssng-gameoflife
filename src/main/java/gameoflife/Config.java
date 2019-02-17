package gameoflife;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Config {
	 static int framerate									= 60;
	 static int speed                           			= 1;       			// the faster the less smooth
	 static double RestartCondition            				= 0;       // 0.0000001*AmountOfBalls;
	 public static int SIZE										= 120;
	 static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	 static int RightWall=(int)screenSize.getWidth();
	 static int Bottom=(int)(screenSize.getHeight());
	 static int dims										=(int)(Math.min(RightWall,Bottom)/SIZE);
	 static boolean colors									= true;
}