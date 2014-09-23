/**
 * file comment
 */
package hanto.student_kpdavidson_acansel_.common;

import hanto.common.HantoCoordinate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Kyle & Adam
 *
 */
public class HantoWalkValidator {

	private int maxsteps;
	private HashMap<String, BasicHantoPiece> gameboard;
	BasicCoordinate startlocation;
	BasicCoordinate destination;
	
	/**
	 * 
	 * @param maxsteps the maximum number of steps that can be taken
	 * @param gameboard the current state of the gameboard
	 * @param startlocation the location the piece is starting at
	 * @param destination the location the piece is trying to get to
	 */
	public HantoWalkValidator(int maxsteps,
			HashMap<String, BasicHantoPiece> gameboard,
			HantoCoordinate startlocation, HantoCoordinate destination) {
		super();
		this.maxsteps = maxsteps;
		this.gameboard = gameboard;
		this.destination = new BasicCoordinate(destination.getX(), destination.getY());
		this.startlocation = new BasicCoordinate(startlocation.getX(), startlocation.getY());
	}
	
	/**
	 * Calls the validation routine
	 * @return boolean indicating whether the desired spot can be reached or not
	 */
	public boolean validate() {
		return runvalidate(new ArrayList<String>(), 0, startlocation);
	}
	
	/**
	 * Uses an "attempt every possible path approach" to reach the desired destination
	 * @param checkedlocations a list of locations already checked
	 * @param stepnumber the number of steps already taken
	 * @param current the current spot being checked
	 * @return
	 */
	private boolean runvalidate(ArrayList<String> checkedlocations, int stepnumber, BasicCoordinate current) {
		boolean result = false;
		checkedlocations.add(current.getkey());
		
		// clone list of checked locations
		ArrayList<String> listcopy1 = new ArrayList<String>();
		ArrayList<String> listcopy2 = new ArrayList<String>();
		ArrayList<String> listcopy3 = new ArrayList<String>();
		ArrayList<String> listcopy4 = new ArrayList<String>();
		ArrayList<String> listcopy5 = new ArrayList<String>();
		ArrayList<String> listcopy6 = new ArrayList<String>();
		for(String tmp : checkedlocations) {
			listcopy1.add(tmp);
			listcopy2.add(tmp);
			listcopy3.add(tmp);
			listcopy4.add(tmp);
			listcopy5.add(tmp);
			listcopy6.add(tmp);
		}
		
		// get surrounding space's locations
		BasicCoordinate above = new BasicCoordinate(current.getX(), current.getY() + 1);
		boolean above_result = false;
		BasicCoordinate right_top = new BasicCoordinate(current.getX() + 1, current.getY());
		boolean right_top_result = false;
		BasicCoordinate right_bottom = new BasicCoordinate(current.getX() + 1, current.getY() - 1);
		boolean right_bottom_result = false;
		BasicCoordinate below = new BasicCoordinate(current.getX(), current.getY() - 1);
		boolean below_result = false;
		BasicCoordinate left_bottom = new BasicCoordinate(current.getX() - 1, current.getY());
		boolean left_bottom_result = false;
		BasicCoordinate left_top = new BasicCoordinate(current.getX() - 1, current.getY() + 1);
		boolean left_top_result = false;
		
		if(destination.getkey().equals(current.getkey())) {
			result = true;
		}
		else if (stepnumber == maxsteps) {
			result = false;
		}
		else {
			// attempt to move up
			if(!checkedlocations.contains(above.getkey()) && //has not already checked
					gameboard.get(above.getkey()) == null && //spot not taken
					(gameboard.get(right_top.getkey()) == null || gameboard.get(left_top.getkey()) == null)) { //walk specific
				above_result = runvalidate(listcopy1, stepnumber + 1, above);
			}
			// attempt to move up and right
			if(!checkedlocations.contains(right_top.getkey()) && //has not already checked
					gameboard.get(right_top.getkey()) == null && //spot not taken
					(gameboard.get(above.getkey()) == null || gameboard.get(right_bottom.getkey()) == null)) { //walk specific
				right_top_result = runvalidate(listcopy2, stepnumber + 1, right_top);
			}
			// attempt to move down and right
			if(!checkedlocations.contains(right_bottom.getkey()) && //has not already checked
					gameboard.get(right_bottom.getkey()) == null && //spot not taken
					(gameboard.get(right_top.getkey()) == null || gameboard.get(below.getkey()) == null)) { //walk specific
				right_bottom_result = runvalidate(listcopy3, stepnumber + 1, right_bottom);
			}
			// attempt to move down
			if(!checkedlocations.contains(below.getkey()) && //has not already checked
					gameboard.get(below.getkey()) == null && //spot not taken
					(gameboard.get(right_bottom.getkey()) == null || gameboard.get(left_bottom.getkey()) == null)) { //walk specific
				below_result = runvalidate(listcopy4, stepnumber + 1, below);
			}
			// attempt to move left and down
			if(!checkedlocations.contains(left_bottom.getkey()) && //has not already checked
					gameboard.get(left_bottom.getkey()) == null && //spot not taken
					(gameboard.get(below.getkey()) == null || gameboard.get(left_top.getkey()) == null)) { //walk specific
				left_bottom_result = runvalidate(listcopy5, stepnumber + 1, left_bottom);
			}
			// attempt to move left and up
			if(!checkedlocations.contains(left_top.getkey()) && //has not already checked
					gameboard.get(left_top.getkey()) == null && //spot not taken
					(gameboard.get(left_bottom.getkey()) == null || gameboard.get(above.getkey()) == null)) { //walk specific
				left_top_result = runvalidate(listcopy6, stepnumber + 1, left_top);
			}
			
			//check if any moves found the desired spot
			result = (above_result || right_top_result || right_bottom_result || 
					below_result || left_bottom_result || left_top_result);
		}
		
		return result;
	}
}
