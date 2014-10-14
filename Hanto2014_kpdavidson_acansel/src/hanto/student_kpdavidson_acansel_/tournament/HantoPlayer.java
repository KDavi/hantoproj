/**
 * file comment
 */
package hanto.student_kpdavidson_acansel_.tournament;




import java.util.List;

import hanto.common.HantoException;
import hanto.common.HantoGameID;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;
import hanto.student_kpdavidson_acansel_.common.BasicCoordinate;
import hanto.tournament.HantoGamePlayer;
import hanto.tournament.HantoMoveRecord;

/**
 * 
 * @author Kyle & Adam
 *
 */
public class HantoPlayer implements HantoGamePlayer {

	protected HantoGameForAI game;

	@Override
	public void startGame(HantoGameID version, HantoPlayerColor myColor,
			boolean doIMoveFirst) {
		HantoPlayerColor movesFirst = null;
		if(doIMoveFirst) {
			movesFirst = myColor;
		}
		else {
			if(HantoPlayerColor.RED.equals(myColor)) {
				movesFirst = HantoPlayerColor.BLUE;
			}
			else {
				movesFirst = HantoPlayerColor.RED;
			}
		}
		
		game = HantoGameForAI_Factory.getInstance().makeHantoGame(version, movesFirst);
	}

	/**
	 * Makes a move by getting a list of all possible moves that can be run in the game without 
	 * causing an exception then choosing the first one that was added. This prioritizes placing pieces 
	 * over moving ones already on the board.
	 */
	@Override
	public HantoMoveRecord makeMove(HantoMoveRecord opponentsMove) {
		HantoMoveRecord ourmove = null;
		if(opponentsMove == null) {
			try {
				game.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0, 0));
				ourmove = new HantoMoveRecord(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0, 0));
			} catch (HantoException e) {
				e.printStackTrace();
			}
		}
		else {
			//make opponents move
			try {
				game.makeMove(opponentsMove.getPiece(), opponentsMove.getFrom(), opponentsMove.getTo());
			} catch (HantoException e) {
				e.printStackTrace();
			}
			
			//make our move
			List<HantoMoveRecord> possibles = game.moveCanBeMade();
			
			if(possibles.isEmpty()) {
				ourmove = new HantoMoveRecord(null, null, null);
			}
			else {
				ourmove = possibles.get(0);
				try {
					game.makeMove(possibles.get(0).getPiece(), possibles.get(0).getFrom(), possibles.get(0).getTo());
				} catch (HantoException e) {
					e.printStackTrace();
				}
			}
		}
		return ourmove;
	}
}
