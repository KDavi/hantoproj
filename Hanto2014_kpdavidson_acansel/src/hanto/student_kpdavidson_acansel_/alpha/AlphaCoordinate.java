/**
 * File comment
 */
package hanto.student_kpdavidson_acansel_.alpha;

import hanto.common.HantoCoordinate;

/**
 * 
 * @author Kyle & Adam
 *
 */
public class AlphaCoordinate implements HantoCoordinate {

	private int X;
	private int Y;
	
	/**
	 * Constructor
	 * @param x x coordinate
	 * @param y y coordinate
	 */
	public AlphaCoordinate(int x, int y) {
		X = x;
		Y = y;
	}

	@Override
	public int getX() {
		return X;
	}

	@Override
	public int getY() {
		return Y;
	}

}
