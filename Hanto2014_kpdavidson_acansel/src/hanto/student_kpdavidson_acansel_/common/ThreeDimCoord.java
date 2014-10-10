/**
 * File comment
 */
package hanto.student_kpdavidson_acansel_.common;

import hanto.common.HantoCoordinate;

/**
 * 
 * @author Kyle & Adam
 *
 */
public class ThreeDimCoord implements HantoCoordinate {

	int x;
	int y;
	int z; //z, x, and y sum together to be 0
	
	
	/**
	 * Creates a three dimensional coordinate from an x and y
	 * @param x x value
	 * @param y y value
	 */
	public ThreeDimCoord(int x, int y) {
		this.x = x;
		this.y = y;
		z = (-1 * x) + (-1 * y);
	}
	
	/**
	 * Creates a three dimensional coordinate from a hanto coordinate
	 * @param coord the coordinate being converted
	 */
	public ThreeDimCoord(HantoCoordinate coord) {
		x = coord.getX();
		y = coord.getY();
		z = (-1 * x) + (-1 * y);
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}
	
	public int getZ() {
		return z;
	}

}
