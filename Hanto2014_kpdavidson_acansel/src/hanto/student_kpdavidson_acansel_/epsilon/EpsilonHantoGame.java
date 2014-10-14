/**
 * file comment
 */
package hanto.student_kpdavidson_acansel_.epsilon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import hanto.common.HantoCoordinate;
import hanto.common.HantoException;
import hanto.common.HantoGame;
import hanto.common.HantoPiece;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;
import hanto.common.HantoPrematureResignationException;
import hanto.common.MoveResult;
import hanto.student_kpdavidson_acansel_.common.BasicCoordinate;
import hanto.student_kpdavidson_acansel_.common.BasicHanto;
import hanto.student_kpdavidson_acansel_.common.BasicHantoPiece;
import hanto.student_kpdavidson_acansel_.common.FlyFourValidator;
import hanto.student_kpdavidson_acansel_.common.HantoWalkValidator;
import hanto.student_kpdavidson_acansel_.common.JumpValidator;
import hanto.student_kpdavidson_acansel_.common.Validator_interface;
import hanto.tournament.HantoMoveRecord;

/**
 * 
 * @author Kyle & Adam
 *
 */
public class EpsilonHantoGame extends BasicHanto implements HantoGame {
	
	protected boolean gameIsOver;
	protected List<String> possiblespaces; //list of spaces that can possibly be moved to
	
	public EpsilonHantoGame(HantoPlayerColor turn) {
		super(turn);
		legalPieces.add(HantoPieceType.BUTTERFLY);
		legalPieces.add(HantoPieceType.SPARROW);
		legalPieces.add(HantoPieceType.CRAB);
		legalPieces.add(HantoPieceType.HORSE);
		blueSparrowCount = 2;
		redSparrowCount = 2;
		blueCrabCount = 6;
		redCrabCount = 6;
		blueHorseCount = 4;
		redHorseCount = 4;
		gameIsOver = false;
		possiblespaces = new ArrayList<String>();
		possiblespaces.add(new BasicCoordinate(0, 0).getkey());
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
			HantoCoordinate to) throws HantoException, HantoPrematureResignationException {
		
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
		
		// Epsilon specific checks
		
		// cannot place next to opposite color
		if(from == null && turncount > 2) {
			if(!super.nextToOppositeColor(to, turn)) {
				throw new HantoException("Piece placed next to opposite color");
			}
		}
		
		//test attempted walk or fly or jump
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
		
		BasicCoordinate basicto = new BasicCoordinate(to);
		
		// manage gameboard and list of possible move spaces
		if(from != null) {
			BasicCoordinate basicfrom = new BasicCoordinate(from);
			gameboard.remove(new BasicCoordinate(from).getkey());
			if(!possiblespaces.contains(basicfrom.getkey())) {
				possiblespaces.add(basicfrom.getkey());
			}
		}
		possiblespaces.remove(basicto.getkey());
		if(getPieceAt(new BasicCoordinate(to.getX(), to.getY() + 1)) == null) {
			if(!possiblespaces.contains(new BasicCoordinate(to.getX(), to.getY() + 1).getkey())) {
				possiblespaces.add(new BasicCoordinate(to.getX(), to.getY() + 1).getkey());
			}
		}
		if(getPieceAt(new BasicCoordinate(to.getX() + 1, to.getY())) == null) {
			if(!possiblespaces.contains(new BasicCoordinate(to.getX() + 1, to.getY()).getkey())) {
				possiblespaces.add(new BasicCoordinate(to.getX() + 1, to.getY()).getkey());
			}
		}
		if(getPieceAt(new BasicCoordinate(to.getX() + 1, to.getY() - 1)) == null) {
			if(!possiblespaces.contains(new BasicCoordinate(to.getX() + 1, to.getY() - 1).getkey())) {
				possiblespaces.add(new BasicCoordinate(to.getX() + 1, to.getY() - 1).getkey());
			}
		}
		if(getPieceAt(new BasicCoordinate(to.getX(), to.getY() - 1)) == null) {
			if(!possiblespaces.contains(new BasicCoordinate(to.getX(), to.getY() - 1).getkey())) {
				possiblespaces.add(new BasicCoordinate(to.getX(), to.getY() - 1).getkey());
			}
		}
		if(getPieceAt(new BasicCoordinate(to.getX() - 1, to.getY())) == null) {
			if(!possiblespaces.contains(new BasicCoordinate(to.getX() - 1, to.getY()).getkey())) {
				possiblespaces.add(new BasicCoordinate(to.getX() - 1, to.getY()).getkey());
			}
		}
		if(getPieceAt(new BasicCoordinate(to.getX() - 1, to.getY() + 1)) == null) {
			if(!possiblespaces.contains(new BasicCoordinate(to.getX() - 1, to.getY() + 1).getkey())) {
				possiblespaces.add(new BasicCoordinate(to.getX() - 1, to.getY() + 1).getkey());
			}
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

	/**
	 * 
	 * @param maxsteps maximum number of steps
	 * @param board the current gameboard
	 * @param startlocation the location the piece is at
	 * @param destination the location the piece is going
	 * @param type the type of piece
	 * @return a validator that will tell you if a move is ok or not
	 */
	protected Validator_interface getValidator(int maxsteps,
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
			ret = new FlyFourValidator(board, startlocation, destination);
		}
		else if(type.equals(HantoPieceType.HORSE)) {
			ret = new JumpValidator(board, startlocation, destination);
		}
		
		return ret;
	}
		
	/**
	 * Checks if a player is resigning
	 * @param pieceType null if resigning
	 * @param from null if resigning
	 * @param to null if resigning
	 * @return Move Result indicating status of the game
	 * @throws HantoPrematureResignationException if you resign to early
	 */
	protected MoveResult checkresign(HantoPieceType pieceType, HantoCoordinate from,
			HantoCoordinate to) throws HantoPrematureResignationException {
		MoveResult result = MoveResult.OK;
		
		if(pieceType == null && from == null && to == null) {
			if(turn.equals(HantoPlayerColor.BLUE)) {
				result = MoveResult.RED_WINS;
			}
			else {
				result = MoveResult.BLUE_WINS;
			}
			gameIsOver = true;
			
			//check if any moves could have been made
			if(!moveCanBeMade().isEmpty()) {
				throw new HantoPrematureResignationException();
			}
		}
		
		return result;
	}

	/**
	 * Checks if a move can be made
	 * @return List of all possible moves in the form of HantoMoveRecords
	 */
	protected List<HantoMoveRecord> moveCanBeMade() {
		List<HantoMoveRecord> result = new LinkedList<HantoMoveRecord>();

		//check possible placements of pieces off the board
		HantoPieceType type = null;
		if(turn.equals(HantoPlayerColor.RED)) {
			if(redfly == null) {
				type = HantoPieceType.BUTTERFLY;
			}
			else if(redSparrowCount > 0) {
				type = HantoPieceType.SPARROW;
			}
			else if(redHorseCount > 0) {
				type = HantoPieceType.HORSE;
			}
			else if(redCrabCount > 0) {
				type = HantoPieceType.CRAB;
			}
		}
		else {
			if(bluefly == null) {
				type = HantoPieceType.BUTTERFLY;
			}
			else if(blueSparrowCount > 0) {
				type = HantoPieceType.SPARROW;
			}
			else if(blueHorseCount > 0) {
				type = HantoPieceType.HORSE;
			}
			else if(blueCrabCount > 0) {
				type = HantoPieceType.CRAB;
			}
		}
		if(type != null) {
			for(String str : possiblespaces) {
				try {
					BasicCoordinate to = reversekey(str);
					ismovelegal(type, null, to);
					result.add(new HantoMoveRecord(type, null, to));
				}catch(HantoException e) {
					String exception = e.getMessage();
					exception.length(); //required by CodePro
				}
			}
		}

		//check possible moves of pieces already on board
		Set<String> tmp = new HashSet<String>(gameboard.keySet());
		String[] piecelocations = tmp.toArray(new String[tmp.size()]);
		for(String piecelocation : piecelocations) {
			BasicCoordinate from = reversekey(piecelocation);
			HantoPiece piece = getPieceAt(from);
			if(piece.getColor().equals(turn)) {
				for(String str : possiblespaces) {
					try {
						BasicCoordinate to = reversekey(str);
						ismovelegal(piece.getType(), from, to);
						result.add(new HantoMoveRecord(piece.getType(), from, to));
						break;

					}catch(HantoException e) {
						String exception = e.getMessage();
						exception.length(); //required by CodePro
					}
				}
			}
		}

		return result;
	}
	
	/**
	 * Reverses a key string into a coordinate object
	 * @param key the key being reversed
	 * @return The Coordinate form of the key
	 */
	protected BasicCoordinate reversekey(String key) {
		String[] XandY = key.split("BREAK");
		
		return (new BasicCoordinate(Integer.parseInt(XandY[0]), Integer.parseInt(XandY[1])));
	}
}
