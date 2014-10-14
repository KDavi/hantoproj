/**
 * File Comment
 */
package hanto.student_kpdavidson_acansel_.common;

import hanto.common.HantoCoordinate;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author Kyle & Adam
 *
 */
public abstract class Continuity {

	protected Map<String, BasicHantoPiece> gameboard;
	protected BasicCoordinate startlocation;
	protected BasicCoordinate destination;
	
	
	//serves as a list that is global to the method gather_pieces
	protected List<String> continuityList;
	

	/**
	 * Sets variables for continuity class
	 * @param gameboard the gameboard in its current state
	 * @param startlocation location the piece is currently at
	 * @param destination location the piece is going to
	 */
	protected Continuity(Map<String, BasicHantoPiece> gameboard,
			HantoCoordinate startlocation, HantoCoordinate destination) {
		this.gameboard = gameboard;
		this.startlocation = new BasicCoordinate(startlocation);
		this.destination = new BasicCoordinate(destination);
	}

	/**
	 * @param location the location of the piece being checked
	 * @return the number of pieces adjacent to the piece being checked
	 */
	protected int num_adjacent(HantoCoordinate location) {
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
	protected boolean check_continuity(BasicCoordinate current) {
		continuityList = new ArrayList<String>();
		Map<String, BasicHantoPiece> boardstatus = new HashMap<String, BasicHantoPiece>(gameboard);
		boardstatus.remove(startlocation.getkey());
		boardstatus.put(current.getkey(), new BasicHantoPiece(HantoPieceType.SPARROW, HantoPlayerColor.RED));
		
		// the temporary boardstatus map now looks like it would assuming the move step was made
		gather_pieces(current, boardstatus);
		
		// check if the pieces gathered by gather_pieces are all the pieces on the real board
		Set<String> setFromBoard = new HashSet<String>(gameboard.keySet());
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
	protected void gather_pieces(BasicCoordinate current, Map<String, BasicHantoPiece> boardstatus) {
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
