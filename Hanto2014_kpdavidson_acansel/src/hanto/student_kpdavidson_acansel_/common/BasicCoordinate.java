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
public class BasicCoordinate implements HantoCoordinate {

int x, y;
	
	/**
	 * Constructor
	 * @param x x coordinate
	 * @param y y coordinate
	 */
	public BasicCoordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Constructor
	 * @param cord A hanto Coordinate
	 */
	public BasicCoordinate(HantoCoordinate cord) {
		x = cord.getX();
		y = cord.getY();
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}
	
	/**
	 * Produces a key for hashmap use
	 * @return the key string
	 */
	public String getkey() {
		return Integer.toString(x) + "BREAK" +  Integer.toString(y);
	}

}
