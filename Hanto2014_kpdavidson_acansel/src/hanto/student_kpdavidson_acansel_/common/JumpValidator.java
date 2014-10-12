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
public class JumpValidator extends Continuity implements Validator_interface {

	public JumpValidator(Map<String, BasicHantoPiece> gameboard,
			HantoCoordinate startlocation, HantoCoordinate destination) {
		super(gameboard, startlocation, destination);
	}

	@Override
	public boolean validate() {
		
		boolean result = check_continuity(destination);
		int xchange = 99999;
		int ychange = 99999;
		
		if(destination.getX() == startlocation.getX()) {
			xchange = 0;
		}
		if(destination.getY() == startlocation.getY()) {
			ychange = 0;
		}
		if(xchange == 0 && ychange == 0) {
			result = false;
		}
		
		if(result) {
			xchange = destination.getX() - startlocation.getX();
			ychange = destination.getY() - startlocation.getY();
			
			if(xchange !=0 && ychange != 0) {
				if(xchange > 0 && ychange > 0) {
					result = false;
				}
				else if(xchange < 0 && ychange < 0) {
					result = false;
				}
				else if(Math.abs(xchange) != Math.abs(ychange)) {
					result = false;
				}
			}
			
			if(xchange != 0) {
				if(Math.abs(xchange) == 1) {
					result = false;
				}
				xchange = (xchange / Math.abs(xchange));
			}
			if(ychange != 0) {
				if(Math.abs(ychange) == 1) {
					result = false;
				}
				ychange = (ychange / Math.abs(ychange));
			}
		}
		
		//x & y change now represents +1, -1, or 0
		int xlocation = startlocation.getX();
		int ylocation = startlocation.getY();
		
		while(result) {
			xlocation = xlocation + xchange;
			ylocation = ylocation + ychange;
			
			if(destination.getX() == xlocation && destination.getY() == ylocation) {
				break;
			}
			else {
				if(gameboard.get(new BasicCoordinate(xlocation, ylocation).getkey()) == null) {
					result = false;
				}
			}
		}
		
		return result;
	}

}
