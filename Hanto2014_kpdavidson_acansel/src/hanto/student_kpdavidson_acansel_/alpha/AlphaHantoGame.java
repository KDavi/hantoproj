package hanto.student_kpdavidson_acansel_.alpha;

import hanto.common.HantoCoordinate;
import hanto.common.HantoException;
import hanto.common.HantoGame;
import hanto.common.HantoPiece;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;
import hanto.common.MoveResult;

public class AlphaHantoGame implements HantoGame {
	
	HantoPlayerColor currentTurn;

	public AlphaHantoGame() {
		this.currentTurn = HantoPlayerColor.BLUE;
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
		MoveResult result = null;
		
		if(currentTurn.equals(HantoPlayerColor.BLUE)) {
			if(pieceType.equals(HantoPieceType.BUTTERFLY) &&
					from == null && to.getX() == 0 && to.getY() == 0) {
				result = MoveResult.OK;
				currentTurn = HantoPlayerColor.RED;
			}
			else {
				throw new HantoException("Illegal first move");
			}
		}
		else if(currentTurn.equals(HantoPlayerColor.RED)) {
			if(pieceType.equals(HantoPieceType.BUTTERFLY) &&
					from == null && isAdjacent(new AlphaCoordinate(0,0), to)) {
				result = MoveResult.DRAW;
			}
		}
		
		return result;
	}

	/**
	 * @param where the coordinate to query
	 * @return the piece at the specified coordinate or null if there is no 
	 * 	piece at that position
	 */
	@Override
	public HantoPiece getPieceAt(HantoCoordinate where) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return a printable representation of the board.
	 */
	@Override
	public String getPrintableBoard() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param from
	 *            the coordinate where the piece begins. If the coordinate is null, then
	 *            the piece begins off the board (that is, it is placed on the board in
	 *            this move).
	 * @param to
	 *            the coordinated where the piece is after the move has been made.
	 * @return true if (X1,Y1) is adjacent to (X2, Y2)
	 */
	private boolean isAdjacent(HantoCoordinate from, HantoCoordinate to) {
		boolean result = false;
		
		if(from.getX() == to.getX() && (from.getY() + 1) == to.getY()) {
			result = true;
		}
		else if((from.getX() + 1) == to.getX() && from.getY() == to.getY()) {
			result = true;
		}
		else if((from.getX() + 1) == to.getX() && (from.getY() - 1) == to.getY()) {
			result = true;
		}
		else if(from.getX() == to.getX() && (from.getY() - 1) == to.getY()) {
			result = true;
		}
		else if((from.getX() - 1) == to.getX() && from.getY() == to.getY()) {
			result = true;
		}
		else if((from.getX() - 1) == to.getX() && (from.getY() + 1) == to.getY()) {
			result = true;
		}
		
		return result;
	}
}
