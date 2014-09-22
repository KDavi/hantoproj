/**
 * File comment
 */
package hanto.student_kpdavidson_acansel_.beta;

import hanto.common.*;
import hanto.student_kpdavidson_acansel_.common.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Kyle & Adam
 *
 */
public class BetaHantoGame implements HantoGame {

	private int turncount; //max = 12 (6 turns)
	private HantoPlayerColor turn; // who's turn it is
	private Map<String, BasicHantoPiece> gameboard;
	private BasicCoordinate bluefly; // location of blue butterfly
	private BasicCoordinate redfly;  // location of red butterfly
	private List<HantoPieceType> legalPieces; // a list of legal pieces
	private int blueSparrowCount; // how many blue sparrows exist
	private int redSparrowCount; // how many red sparrows exist
	
	/**
	 * Constructor
	 * @param turn who goes first
	 */
	public BetaHantoGame(HantoPlayerColor turn) {
		this.turn = turn;
		turncount = 1;
		gameboard = new HashMap<String, BasicHantoPiece>();
		bluefly = null;
		redfly = null;
		legalPieces = new ArrayList<HantoPieceType>();
		legalPieces.add(HantoPieceType.BUTTERFLY);
		legalPieces.add(HantoPieceType.SPARROW);
		blueSparrowCount = 0;
		redSparrowCount = 0;
	}

	/**
	 * This method executes a move in the game. It is called for every move that must be
	 * made.
	 * 
	 * @param pieceType
	 *            the piece type that is being moved
	 * @param from
	 *            the coordinate where the piece begins. If the coordinate is null, then
	 *            the piece begins off the board (that is, it is placed on the board in
	 *            this move).
	 * @param to
	 *            the coordinated where the piece is after the move has been made.
	 * @return the result of the move
	 * @throws HantoException
	 *             if there are any problems in making the move (such as specifying a
	 *             coordinate that does not have the appropriate piece, or the color of
	 *             the piece is not the color of the player who is moving.
	 */
	@Override
	public MoveResult makeMove(HantoPieceType pieceType, HantoCoordinate from,
			HantoCoordinate to) throws HantoException {
		
		MoveResult result = MoveResult.OK;
		
		// will throw an exception if there is a problem
		ismovelegal(pieceType, from, to);
		
		// makes the move
		move(pieceType, from, to);
		
		// end the turn
		turncount++;
		if(turn.equals(HantoPlayerColor.BLUE)) {
			turn = HantoPlayerColor.RED;
		}
		else {
			turn = HantoPlayerColor.BLUE;
		}
		
		// check for game over situation
		result = checkGameOver();
		
		return result;
	}

	/**
	 * @param where the coordinate to query
	 * @return the piece at the specified coordinate or null if there is no 
	 * 	piece at that position
	 */
	@Override
	public HantoPiece getPieceAt(HantoCoordinate where) {
		String key = Integer.toString(where.getX()) + Integer.toString(where.getY());
		HantoPiece piece = gameboard.get(key);
		return piece;
	}

	@Override
	public String getPrintableBoard() {
		return "not supported";
	}

	/**
	 * @param location the location of the piece being checked
	 * @return the number of pieces adjacent to the piece being checked
	 */
	private int num_adjacent(HantoCoordinate location) {
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
	private void ismovelegal(HantoPieceType pieceType, HantoCoordinate from,
			HantoCoordinate to) throws HantoException {
		
		boolean outofpieceflag = false;
		boolean mustplacebutterfly = false;
		
		if(!legalPieces.contains(pieceType)) {
			throw new HantoException("Invalid Piece");
		}
		
		if(from != null) {
			throw new HantoException("Cannot Move Pieces");
		}
		
		if(getPieceAt(to) != null) {
			throw new HantoException("Spot already taken");
		}
		
		if(turncount == 1) {
			if(to.getX() != 0 || to.getY() != 0) {
				throw new HantoException("Illegal Destination");
			}
		}
		
		if(num_adjacent(to) == 0 && turncount != 1) {
			throw new HantoException("Illegal Destination");
		}
		
		if(turn.equals(HantoPlayerColor.BLUE)) {
			if(pieceType.equals(HantoPieceType.BUTTERFLY) && bluefly != null) {
				outofpieceflag = true;
			}
			else if(pieceType.equals(HantoPieceType.SPARROW) && blueSparrowCount == 5) {
				outofpieceflag = true;
			}
		}
		else if(turn.equals(HantoPlayerColor.RED)) {
			if(pieceType.equals(HantoPieceType.BUTTERFLY) && redfly != null) {
				outofpieceflag = true;
			}
			else if(pieceType.equals(HantoPieceType.SPARROW) && redSparrowCount == 5) {
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
	
	/** Performs the moving of a piece
	 * @param pieceType the type of piece being moved
	 * @param from old location of the piece
	 * @param to new location of the piece
	 */
	private void move(HantoPieceType pieceType, HantoCoordinate from,
			HantoCoordinate to) {
		
		BasicHantoPiece piece = new BasicHantoPiece(pieceType, turn);
		String key = Integer.toString(to.getX()) + Integer.toString(to.getY());
		
		if(piece.getType().equals(HantoPieceType.BUTTERFLY)) {
			if(turn.equals(HantoPlayerColor.RED)) {
				redfly = new BasicCoordinate(to.getX(), to.getY());
			}
			else if(turn.equals(HantoPlayerColor.BLUE)) {
				bluefly = new BasicCoordinate(to.getX(), to.getY());
			}
		}
		else if(piece.getType().equals(HantoPieceType.SPARROW)) {
			if(turn.equals(HantoPlayerColor.RED)) {
				redSparrowCount++;
			}
			else if(turn.equals(HantoPlayerColor.BLUE)) {
				blueSparrowCount++;
			}
		}
		
		gameboard.put(key, piece);
	}
	
	/**
	 * Checks gameover conditions at the end of a turn
	 * @return a move result based on the current state, OK, red/blue wins, draw
	 */
	private MoveResult checkGameOver() {
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
		if(blueflysurrounded && redflysurrounded) result = MoveResult.DRAW;
		else if(blueflysurrounded) result = MoveResult.RED_WINS;
		else if(redflysurrounded) result = MoveResult.BLUE_WINS;
		
		// if no endgame check for draw due to time
		if(turncount == 13 && result.equals(MoveResult.OK)) {
			result = MoveResult.DRAW;
		}
		return result;
	}
}
