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
public class HantoFlyValidator extends Continuity implements Validator_interface {
	
	/**
	 * 
	 * @param maxsteps the maximum number of steps that can be taken
	 * @param gameboard the current state of the gameboard
	 * @param startlocation the location the piece is starting at
	 * @param destination the location the piece is trying to get to
	 */
	public HantoFlyValidator(Map<String, BasicHantoPiece> gameboard,
			HantoCoordinate startlocation, HantoCoordinate destination) {
		super(gameboard, startlocation, destination);
	}
	
	/**
	 * Calls the validation routine
	 * @return boolean indicating whether the desired spot can be reached or not
	 */
	public boolean validate() {
		boolean result = check_continuity(destination);
		
		return result;
	}
}
