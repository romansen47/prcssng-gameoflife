package gameoflife;

import java.awt.Dimension;

interface IConfig {

	/**
	 * @return the size
	 */
	int getSize();

	/**
	 * @param size the size to set
	 */
	void setSize(int size);

	/**
	 * @return the framerate
	 */
	int getFramerate();

	/**
	 * @param framerate the framerate to set
	 */
	void setFramerate(int framerate);

	/**
	 * @return the colors
	 */
	boolean isColors();

	/**
	 * @param colors the colors to set
	 */
	void setColors(boolean colors);

	/**
	 * @return the restartCondition
	 */
	double getRestartCondition();

	/**
	 * @param restartCondition the
	 *                         restartCondition
	 *                         to set
	 */
	void setRestartCondition(double restartCondition);

	/**
	 * @return the bottom
	 */
	int getBottom();

	/**
	 * @param bottom the bottom to set
	 */
	void setBottom(int bottom);

	/**
	 * @return the rightWall
	 */
	int getRightWall();

	/**
	 * @param rightWall the rightWall to set
	 */
	void setRightWall(int rightWall);

	/**
	 * @return the dims
	 */
	int getDims();

	/**
	 * @param dims the dims to set
	 */
	void setDims(int dims);

	/**
	 * @return the screenSize
	 */
	Dimension getScreenSize();

	/**
	 * @param screenSize the screenSize to
	 *                   set
	 */
	void setScreenSize(Dimension screenSize);

}
