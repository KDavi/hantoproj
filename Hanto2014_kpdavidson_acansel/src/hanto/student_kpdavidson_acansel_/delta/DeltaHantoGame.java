/**
 * file comment
 */
package hanto.student_kpdavidson_acansel_.delta;

import java.util.Map;

import hanto.common.HantoCoordinate;
import hanto.common.HantoException;
import hanto.common.HantoGame;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;
import hanto.common.MoveResult;
import hanto.student_kpdavidson_acansel_.common.BasicCoordinate;
import hanto.student_kpdavidson_acansel_.common.BasicHanto;
import hanto.student_kpdavidson_acansel_.common.BasicHantoPiece;
import hanto.student_kpdavidson_acansel_.common.HantoFlyValidator;
import hanto.student_kpdavidson_acansel_.common.HantoWalkValidator;
import hanto.student_kpdavidson_acansel_.common.Validator_interface;

/**
 * 
 * @author Kyle & Adam
 *
 */
public class DeltaHantoGame extends BasicHanto implements HantoGame {

	private boolean gameIsOver;
	
	public DeltaHantoGame(HantoPlayerColor turn) {
		super(turn);
		legalPieces.add(HantoPieceType.BUTTERFLY);
		legalPieces.add(HantoPieceType.SPARROW);
		legalPieces.add(HantoPieceType.CRAB);
		blueSparrowCount = 4;
		redSparrowCount = 4;
		blueCrabCount = 4;
		redCrabCount = 4;
		gameIsOver = false;
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
		
		if(gameIsOver) {
			throw new HantoException("game is already over");
		}
		
		MoveResult result = checkresign(pieceType, from, to);
		
		if(pieceType == null && from == null && to == null) {
			if(turn.equals(HantoPlayerColor.BLUE)) {
				result = MoveResult.RED_WINS;
			}
			else {
				result = MoveResult.BLUE_WINS;
			}
			gameIsOver = true;
		}
		
		if(result.equals(MoveResult.OK)) {
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
		}
		
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
		
		// Delta specific checks
		
		// cannot place next to opposite color
		if(from == null && turncount > 2) {
			if(!super.nextToOppositeColor(to, turn)) {
				throw new HantoException("Piece placed next to opposite color");
			}
		}
		
		//test attempted walk or fly
		if(from != null) {
			Validator_interface validator = getValidator(1, gameboard, from, to, pieceType);
			if(!validator.validate()) {
				throw new HantoException("invalid move");
			}
		}
	}
	
	/** Performs the moving of a piece
	 * @param pieceType the type of piece being moved
	 * @param from old location of the piece
	 * @param to new location of the piece
	 */
	protected void move(HantoPieceType pieceType, HantoCoordinate from,
			HantoCoordinate to) {
		super.move(pieceType, from, to);
		
		if(from != null) {
			gameboard.remove(new BasicCoordinate(from).getkey());
		}
	}
	
	/**
	 * Checks gameover conditions at the end of a turn
	 * @return a move result based on the current state, OK, red/blue wins, draw
	 */
	@Override
	protected MoveResult checkGameOver() {
		MoveResult result = super.checkGameOver();
		
		if(!result.equals(MoveResult.OK)) {
			gameIsOver = true;
		}
		
		return result;
	}

	private Validator_interface getValidator(int maxsteps,
			Map<String, BasicHantoPiece> board,
			HantoCoordinate startlocation, HantoCoordinate destination, HantoPieceType type) {
		
		Validator_interface ret = null;
		
		if(type.equals(HantoPieceType.BUTTERFLY)) {
			ret = new HantoWalkValidator(maxsteps, board, startlocation, destination);
		}
		else if(type.equals(HantoPieceType.CRAB)) {
			ret = new HantoWalkValidator(maxsteps, board, startlocation, destination);
		}
		else if(type.equals(HantoPieceType.SPARROW)) {
			ret = new HantoFlyValidator(board, startlocation, destination);
		}
		
		return ret;
	}
		
	/**
	 * Checks if a player is resigning
	 * @param pieceType null if resigning
	 * @param from null if resigning
	 * @param to null if resigning
	 * @return Move Result indicating status of the game
	 */
	private MoveResult checkresign(HantoPieceType pieceType, HantoCoordinate from,
			HantoCoordinate to) {
		MoveResult result = MoveResult.OK;
		
		if(pieceType == null && from == null && to == null) {
			if(turn.equals(HantoPlayerColor.BLUE)) {
				result = MoveResult.RED_WINS;
			}
			else {
				result = MoveResult.BLUE_WINS;
			}
			gameIsOver = true;
		}
		return result;
	}
}
