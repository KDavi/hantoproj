/**
 * file comment
 */
package hanto.student_kpdavidson_acansel_.beta;

import hanto.common.HantoCoordinate;

/**
 * 
 * @author Kyle & Adam
 *
 */
public class BetaCoordinate implements HantoCoordinate {

	int x, y;
	
	/**
	 * Constructor
	 * @param x x coordinate
	 * @param y y coordinate
	 */
	public BetaCoordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

}
