package gameoflife;

import java.awt.Dimension;
import java.awt.Toolkit;

final public class Config implements IConfig {

	private Dimension		screenSize			= Toolkit.getDefaultToolkit().getScreenSize();
	private int				size				= 120;
	private int				framerate			= 60;
	private boolean			colors				= true;
	private double			restartCondition	= 0;
	private int				bottom				= (int) (getScreenSize().getHeight());
	private int				rightWall			= (int) getScreenSize().getWidth();
	private int				dims				= Math.min(getRightWall(), getBottom()) / getSize();
	private static IConfig	instance;

	/**
	 * Constructor
	 */
	private Config() {
		instance = this;
	}

	public static IConfig getInstance() {
		if (instance == null) {
			return new Config();
		}
		return instance;
	}

	/**
	 * @return the size
	 */
	@Override
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	@Override
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return the framerate
	 */
	@Override
	public int getFramerate() {
		return framerate;
	}

	/**
	 * @param framerate the framerate to set
	 */
	@Override
	public void setFramerate(int framerate) {
		this.framerate = framerate;
	}

	/**
	 * @return the colors
	 */
	@Override
	public boolean isColors() {
		return colors;
	}

	/**
	 * @param colors the colors to set
	 */
	@Override
	public void setColors(boolean colors) {
		this.colors = colors;
	}

	/**
	 * @return the restartCondition
	 */
	@Override
	public double getRestartCondition() {
		return restartCondition;
	}

	/**
	 * @param restartCondition the
	 *                         restartCondition
	 *                         to set
	 */
	@Override
	public void setRestartCondition(double restartCondition) {
		this.restartCondition = restartCondition;
	}

	/**
	 * @return the bottom
	 */
	@Override
	public int getBottom() {
		return bottom;
	}

	/**
	 * @param bottom the bottom to set
	 */
	@Override
	public void setBottom(int bottom) {
		this.bottom = bottom;
	}

	/**
	 * @return the rightWall
	 */
	@Override
	public int getRightWall() {
		return rightWall;
	}

	/**
	 * @param rightWall the rightWall to set
	 */
	@Override
	public void setRightWall(int rightWall) {
		this.rightWall = rightWall;
	}

	/**
	 * @return the dims
	 */
	@Override
	public int getDims() {
		return dims;
	}

	/**
	 * @param dims the dims to set
	 */
	@Override
	public void setDims(int dims) {
		this.dims = dims;
	}

	/**
	 * @return the screenSize
	 */
	@Override
	public Dimension getScreenSize() {
		return screenSize;
	}

	/**
	 * @param screenSize the screenSize to
	 *                   set
	 */
	@Override
	public void setScreenSize(Dimension screenSize) {
		this.screenSize = screenSize;
	}

}