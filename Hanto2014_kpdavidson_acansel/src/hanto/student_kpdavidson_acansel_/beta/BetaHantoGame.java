/**
 * File comment
 */
package hanto.student_kpdavidson_acansel_.beta;

import hanto.common.*;
import hanto.student_kpdavidson_acansel_.common.*;

/**
 * 
 * @author Kyle & Adam
 *
 */
public class BetaHantoGame extends BasicHanto implements HantoGame {

	
	
	/**
	 * Constructor
	 * @param turn who goes first
	 */
	public BetaHantoGame(HantoPlayerColor turn) {
		super(turn);
		legalPieces.add(HantoPieceType.BUTTERFLY);
		legalPieces.add(HantoPieceType.SPARROW);
		blueSparrowCount = 5;
		redSparrowCount = 5;
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
	
	/** Checks if a move is legal or not
	 * @param pieceType the type of piece being moved
	 * @param from location the piece is moving from (null = off board)
	 * @param to location the piece is moving to
	 * @throws HantoException if the move is illegal a hanto exception is thrown
	 */
	@Override
	protected void ismovelegal(HantoPieceType pieceType, HantoCoordinate from,
			HantoCoordinate to) throws HantoException {
		// basic checks
		super.ismovelegal(pieceType, from, to);
		
		// Beta specific checks
		if(from != null) {
			throw new HantoException("Cannot Move Pieces");
		}
	}
	
	/**
	 * Checks gameover conditions at the end of a turn
	 * @return a move result based on the current state, OK, red/blue wins, draw
	 */
	@Override
	protected MoveResult checkGameOver() {
		MoveResult result = super.checkGameOver();
		
		// if no endgame check for draw due to time
		if(turncount == 13 && result.equals(MoveResult.OK)) {
			result = MoveResult.DRAW;
		}
		return result;
	}
}
