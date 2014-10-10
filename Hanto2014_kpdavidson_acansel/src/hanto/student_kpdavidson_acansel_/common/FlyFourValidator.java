/**
 * file comment
 */
package hanto.student_kpdavidson_acansel_.common;

import hanto.common.HantoCoordinate;

import java.util.Map;

/**
 * 
 * @author Kyle & Adam
 *
 */
public class FlyFourValidator extends HantoFlyValidator implements Validator_interface {

	/**
	 * 
	 * @param maxsteps the maximum number of steps that can be taken
	 * @param gameboard the current state of the gameboard
	 * @param startlocation the location the piece is starting at
	 * @param destination the location the piece is trying to get to
	 */
	public FlyFourValidator(Map<String, BasicHantoPiece> gameboard,
			HantoCoordinate startlocation, HantoCoordinate destination) {
		super(gameboard, startlocation, destination);
	}

	/**
	 * Calls the validation routine\n
	 * Distance calculation provided by\n
	 * Keekerdc.com/2011/03/hexagon-grids-coordinate-systems-and-distance-calculations/
	 * @return boolean indicating whether the desired spot can be reached or not
	 */
	public boolean validate() {
		boolean result = check_continuity(destination);
		
		//create 3 dimensional grids
		ThreeDimCoord start = new ThreeDimCoord(startlocation);
		ThreeDimCoord dest = new ThreeDimCoord(destination);
		
		int distance = Math.max(dest.getX() - start.getX(), dest.getY() - start.getY());
		distance = Math.max(distance, dest.getZ() - start.getZ());
		
		if(!(distance < 5)) {
			result = false;
		}
		
		return result;
	}
}
