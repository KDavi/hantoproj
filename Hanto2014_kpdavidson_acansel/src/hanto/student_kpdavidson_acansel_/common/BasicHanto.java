/**
 * file comment
 */
package hanto.student_kpdavidson_acansel_.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hanto.common.HantoCoordinate;
import hanto.common.HantoException;
import hanto.common.HantoGame;
import hanto.common.HantoPiece;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;
import hanto.common.MoveResult;

/**
 * 
 * @author Kyle & Adam
 *
 */
public abstract class BasicHanto implements HantoGame {

	protected HantoPlayerColor whoStarted; //who went first
	protected HantoPlayerColor turn; // who's turn it is
	protected Map<String, BasicHantoPiece> gameboard;
	protected BasicCoordinate bluefly; // location of blue butterfly
	protected BasicCoordinate redfly;  // location of red butterfly
	protected List<HantoPieceType> legalPieces; // a list of legal pieces
	protected int turncount;
	
	//piece inventory, how many of that piece can exist
	protected int blueSparrowCount;
	protected int redSparrowCount;
	protected int blueCrabCount;
	protected int redCrabCount;
	protected int blueHorseCount;
	protected int redHorseCount;
	
	
	/**
	 * Constructor
	 * @param turn who goes first
	 */
	protected BasicHanto(HantoPlayerColor turn) {
		whoStarted = turn;
		this.turn = turn;
		gameboard = new HashMap<String, BasicHantoPiece>();
		bluefly = null;
		redfly = null;
		turncount = 1;
		legalPieces = new ArrayList<HantoPieceType>();
	}
	
	@Override
	public MoveResult makeMove(HantoPieceType pieceType, HantoCoordinate from, 
			HantoCoordinate to) throws HantoException {
		ismovelegal(pieceType, from, to);
		return null;
	}

	/**
	 * @param where the coordinate to query
	 * @return the piece at the specified coordinate or null if there is no 
	 * 	piece at that position
	 */
	@Override
	public HantoPiece getPieceAt(HantoCoordinate where) {
		String key = new BasicCoordinate(where).getkey();
		HantoPiece piece = gameboard.get(key);
		return piece;
	}

	@Override
	public String getPrintableBoard() {
		return "not supported";
	}

	/** Performs the moving of a piece
	 * @param pieceType the type of piece being moved
	 * @param from old location of the piece
	 * @param to new location of the piece
	 */
	protected void move(HantoPieceType pieceType, HantoCoordinate from,
			HantoCoordinate to) {
		
		BasicHantoPiece piece = new BasicHantoPiece(pieceType, turn);
		String key = new BasicCoordinate(to).getkey();
		gameboard.put(key, piece);
		
		if(piece.getType().equals(HantoPieceType.BUTTERFLY)) {
			if(turn.equals(HantoPlayerColor.RED)) {
				redfly = new BasicCoordinate(to);
			}
			else if(turn.equals(HantoPlayerColor.BLUE)) {
				bluefly = new BasicCoordinate(to);
			}
		}
		else if(pieceType.equals(HantoPieceType.SPARROW) && from == null) {
			if(turn.equals(HantoPlayerColor.RED)) {
				redSparrowCount--;
			}
			else if(turn.equals(HantoPlayerColor.BLUE)) {
				blueSparrowCount--;
			}
		}
		else if(pieceType.equals(HantoPieceType.CRAB) && from == null) {
			if(turn.equals(HantoPlayerColor.RED)) {
				redCrabCount--;
			}
			else if(turn.equals(HantoPlayerColor.BLUE)) {
				blueCrabCount--;
			}
		}
		else if(pieceType.equals(HantoPieceType.HORSE) && from == null) {
			if(turn.equals(HantoPlayerColor.RED)) {
				redHorseCount--;
			}
			else if(turn.equals(HantoPlayerColor.BLUE)) {
				blueHorseCount--;
			}
		}
	}
	
	/**
	 * @param location the location of the piece being checked
	 * @return the number of pieces adjacent to the piece being checked
	 */
	protected int num_adjacent(HantoCoordinate location) {
		int count = 0;
		
		if(getPieceAt(new BasicCoordinate(location.getX(), location.getY() + 1)) != null) {
			count++;
		}
		if(getPieceAt(new BasicCoordinate(location.getX() + 1, location.getY())) != null) {
			count++;
		}
		if(getPieceAt(new BasicCoordinate(location.getX() + 1, location.getY() - 1)) != null) {
			count++;
		}
		if(getPieceAt(new BasicCoordinate(location.getX(), location.getY() - 1)) != null) {
			count++;
		}
		if(getPieceAt(new BasicCoordinate(location.getX() - 1, location.getY())) != null) {
			count++;
		}
		if(getPieceAt(new BasicCoordinate(location.getX() - 1, location.getY() + 1)) != null) {
			count++;
		}
		
		return count;
	}
	
	/** Checks if a move is legal or not
	 * @param pieceType the type of piece being moved
	 * @param from location the piece is moving from (null = off board)
	 * @param to location the piece is moving to
	 * @throws HantoException if the move is illegal a hanto exception is thrown
	 */
	protected void ismovelegal(HantoPieceType pieceType, HantoCoordinate from,
			HantoCoordinate to) throws HantoException {
		
		boolean outofbutterfly = false;
		boolean outofpieceflag = false;
		boolean mustplacebutterfly = false;
		
		if(!legalPieces.contains(pieceType)) {
			throw new HantoException("Invalid Piece");
		}
		
		if(to == null) {
			throw new HantoException("Cannot Move Pieces to null");
		}
		
		if(turncount == 1) {
			if(to.getX() != 0 || to.getY() != 0) {
				throw new HantoException("Illegal Destination");
			}
		}
		
		if(getPieceAt(to) != null) {
			throw new HantoException("Spot already taken");
		}
		
		if(from != null) {
			if(getPieceAt(from) == null) {
				throw new HantoException("There is nothing at from");
			}
			else {
				if(!getPieceAt(from).getType().equals(pieceType)) {
					throw new HantoException("Moving wrong piece type");
				}
			}
		}
		
		if(num_adjacent(to) == 0 && turncount != 1) {
			throw new HantoException("Illegal Destination");
		}
		
		if(turn.equals(HantoPlayerColor.BLUE)) {
			if(pieceType.equals(HantoPieceType.BUTTERFLY) && bluefly != null && from == null) {
				outofbutterfly = true;
			}
		}
		else if(turn.equals(HantoPlayerColor.RED)) {
			if(pieceType.equals(HantoPieceType.BUTTERFLY) && redfly != null && from == null) {
				outofbutterfly = true;
			}
		}
		if(outofbutterfly) {
			throw new HantoException("Out of that piece");
		}
		
		if(turn.equals(HantoPlayerColor.BLUE)) {
			if(pieceType.equals(HantoPieceType.SPARROW) && blueSparrowCount == 0 && from == null) {
				outofpieceflag = true;
			}
			else if(pieceType.equals(HantoPieceType.CRAB) && blueCrabCount == 0 && from == null) {
				outofpieceflag = true;
			}
			else if(pieceType.equals(HantoPieceType.HORSE) && blueHorseCount == 0 && from == null) {
				outofpieceflag = true;
			}
		}
		else if(turn.equals(HantoPlayerColor.RED)) {
			if(pieceType.equals(HantoPieceType.SPARROW) && redSparrowCount == 0 && from == null) {
				outofpieceflag = true;
			}
			else if(pieceType.equals(HantoPieceType.CRAB) && redCrabCount == 0 && from == null) {
				outofpieceflag = true;
			}
			else if(pieceType.equals(HantoPieceType.HORSE) && redHorseCount == 0 && from == null) {
				outofpieceflag = true;
			}
		}
		if(outofpieceflag) {
			throw new HantoException("Out of that piece");
		}
		
		if(turncount == 7 || turncount == 8) {
			if(turn.equals(HantoPlayerColor.BLUE) && bluefly == null) {
				if(!pieceType.equals(HantoPieceType.BUTTERFLY)) {
					mustplacebutterfly = true;
				}
			}
			else if(turn.equals(HantoPlayerColor.RED) && redfly == null) {
				if(!pieceType.equals(HantoPieceType.BUTTERFLY)) {
					mustplacebutterfly = true;
				}
			}
		}
		if(mustplacebutterfly) {
			throw new HantoException("Must Place Butterfly");
		}
	}
	
	/**
	 * Checks gameover conditions at the end of a turn
	 * @return a move result based on the current state, OK, red/blue wins, draw
	 */
	protected MoveResult checkGameOver() {
		MoveResult result = MoveResult.OK;
		boolean blueflysurrounded = false;
		boolean redflysurrounded = false;
		
		// check surrounded butterflys
		if(bluefly != null) {
			if(num_adjacent(bluefly) == 6) {
				blueflysurrounded = true;
			}
		}
		if(redfly != null) {
			if(num_adjacent(redfly) == 6) {
				redflysurrounded = true;
			}
		}
		
		// check for early endgame
		if(blueflysurrounded && redflysurrounded) {
			result = MoveResult.DRAW;
		}
		else if(blueflysurrounded) {
			result = MoveResult.RED_WINS;
		}
		else if(redflysurrounded) {
			result = MoveResult.BLUE_WINS;
		}
		
		return result;
	}
	
	/** Checks if a given color at a location is next to a piece of the opposite color
	 * @param location the location being checked
	 * @param color the color to be checked
	 * @return the number of pieces adjacent to the piece being checked
	 */
	protected boolean nextToOppositeColor(HantoCoordinate location, HantoPlayerColor color) {
		boolean result = true;
		
		BasicCoordinate one = new BasicCoordinate(location.getX(), location.getY() + 1);
		BasicCoordinate two = new BasicCoordinate(location.getX() + 1, location.getY());
		BasicCoordinate three = new BasicCoordinate(location.getX() + 1, location.getY() - 1);
		BasicCoordinate four = new BasicCoordinate(location.getX(), location.getY() - 1);
		BasicCoordinate five = new BasicCoordinate(location.getX() - 1, location.getY());
		BasicCoordinate six = new BasicCoordinate(location.getX() - 1, location.getY() + 1);
		
		if(getPieceAt(one) != null) {
			if(getPieceAt(one).getColor() != color) {
				result = false;
			}
		}
		if(getPieceAt(two) != null) {
			if(getPieceAt(two).getColor() != color) {
				result = false;
			}
		}
		if(getPieceAt(three) != null) {
			if(getPieceAt(three).getColor() != color) {
				result = false;
			}
		}
		if(getPieceAt(four) != null) {
			if(getPieceAt(four).getColor() != color) {
				result = false;
			}
		}
		if(getPieceAt(five) != null) {
			if(getPieceAt(five).getColor() != color) {
				result = false;
			}
		}
		if(getPieceAt(six) != null) {
			if(getPieceAt(six).getColor() != color) {
				result = false;
			}
		}
		
		return result;
	}
}
