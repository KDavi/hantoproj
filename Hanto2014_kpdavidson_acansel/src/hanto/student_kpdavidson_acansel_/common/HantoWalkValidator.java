/**
 * file comment
 */
package hanto.student_kpdavidson_acansel_.common;

import hanto.common.HantoCoordinate;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author Kyle & Adam
 *
 */
public class HantoWalkValidator {

	private int maxsteps;
	private Map<String, BasicHantoPiece> gameboard;
	BasicCoordinate startlocation;
	BasicCoordinate destination;
	
	private ArrayList<String> continuityList; //serves as a list that is global to the method gather_pieces
	
	/**
	 * 
	 * @param maxsteps the maximum number of steps that can be taken
	 * @param gameboard the current state of the gameboard
	 * @param startlocation the location the piece is starting at
	 * @param destination the location the piece is trying to get to
	 */
	public HantoWalkValidator(int maxsteps,
			Map<String, BasicHantoPiece> gameboard,
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
		boolean result = runvalidate(new ArrayList<String>(), 0, startlocation);
		
		return result;
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
		
		if (num_adjacent(current) == 0) {
			result = false;
		}
		else if(!check_continuity(current)) {
			result = false;
		}
		else if(destination.getkey().equals(current.getkey())) {
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
	
	/**
	 * @param location the location of the piece being checked
	 * @return the number of pieces adjacent to the piece being checked
	 */
	private int num_adjacent(HantoCoordinate location) {
		int count = 0;
		
		if(gameboard.get(new BasicCoordinate(location.getX(), location.getY() + 1).getkey()) != null) {
			count++;
		}
		if(gameboard.get(new BasicCoordinate(location.getX() + 1, location.getY()).getkey()) != null) {
			count++;
		}
		if(gameboard.get(new BasicCoordinate(location.getX() + 1, location.getY() - 1).getkey()) != null) {
			count++;
		}
		if(gameboard.get(new BasicCoordinate(location.getX(), location.getY() - 1).getkey()) != null) {
			count++;
		}
		if(gameboard.get(new BasicCoordinate(location.getX() - 1, location.getY()).getkey()) != null) {
			count++;
		}
		if(gameboard.get(new BasicCoordinate(location.getX() - 1, location.getY() + 1).getkey()) != null) {
			count++;
		}
		
		return count;
	}
	
	/**
	 * Assume that a walk step from this.startlocation to current has been made, 
	 * check that all pieces can be reached from an current
	 * @param current the current position of the piece walking
	 * @return boolean indicating if the board still has piecewise continuity
	 */
	private boolean check_continuity(BasicCoordinate current) {
		continuityList = new ArrayList<String>();
		Map<String, BasicHantoPiece> boardstatus = new HashMap<String, BasicHantoPiece>(gameboard);
		boardstatus.remove(startlocation.getkey());
		boardstatus.put(current.getkey(), new BasicHantoPiece(HantoPieceType.SPARROW, HantoPlayerColor.RED));
		
		// the temporary boardstatus map now looks like it would assuming the move step was made
		gather_pieces(current, boardstatus);
		
		// check if the pieces gathered by gather_pieces are all the pieces on the real board
		Set<String> setFromBoard = gameboard.keySet();
		setFromBoard.remove(startlocation.getkey()); //remove startlocations key, that piece has moved
		
		boolean result = true;
		for(String piece : setFromBoard) {
			if(!continuityList.contains(piece)) {
				result = false;
			}
		}
		
		return result;
	}
	
	/**
	 * Gathers all pieces that can be reached from position "current" into 
	 * a continuityList
	 * @param current the beginning location
	 * @param boardstatus a map representing a gameboard
	 */
	private void gather_pieces(BasicCoordinate current, Map<String, BasicHantoPiece> boardstatus) {
		continuityList.add(current.getkey());
		
		BasicCoordinate surrounding1 = new BasicCoordinate(current.getX(), current.getY() + 1);
		BasicCoordinate surrounding2 = new BasicCoordinate(current.getX() + 1, current.getY());
		BasicCoordinate surrounding3 = new BasicCoordinate(current.getX() + 1, current.getY() - 1);
		BasicCoordinate surrounding4 = new BasicCoordinate(current.getX(), current.getY() - 1);
		BasicCoordinate surrounding5 = new BasicCoordinate(current.getX() - 1, current.getY());
		BasicCoordinate surrounding6 = new BasicCoordinate(current.getX() - 1, current.getY() + 1);
		
		if(boardstatus.get(surrounding1.getkey()) != null) {
			if(!continuityList.contains(surrounding1.getkey())) {
				gather_pieces(surrounding1, boardstatus);
			}
		}
		if(boardstatus.get(surrounding2.getkey()) != null) {
			if(!continuityList.contains(surrounding2.getkey())) {
				gather_pieces(surrounding2, boardstatus);
			}
		}
		if(boardstatus.get(surrounding3.getkey()) != null) {
			if(!continuityList.contains(surrounding3.getkey())) {
				gather_pieces(surrounding3, boardstatus);
			}
		}
		if(boardstatus.get(surrounding4.getkey()) != null) {
			if(!continuityList.contains(surrounding4.getkey())) {
				gather_pieces(surrounding4, boardstatus);
			}
		}
		if(boardstatus.get(surrounding5.getkey()) != null) {
			if(!continuityList.contains(surrounding5.getkey())) {
				gather_pieces(surrounding5, boardstatus);
			}
		}
		if(boardstatus.get(surrounding6.getkey()) != null) {
			if(!continuityList.contains(surrounding6.getkey())) {
				gather_pieces(surrounding6, boardstatus);
			}
		}
	}
}
