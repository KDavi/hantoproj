/**
 * file comment
 */
package hanto.student_kpdavidson_acansel_.tournament;

import java.util.List;

import hanto.common.HantoCoordinate;
import hanto.common.HantoGame;
import hanto.common.HantoPiece;
import hanto.tournament.HantoMoveRecord;

/**
 * 
 * @author Kyle & Adam
 *
 */
public interface HantoGameForAI extends HantoGame {

	/**
	 * @return a linked list of all possible moves for the player whos turn it is,
	 *  moves that place a piece on the board from the hand are added first.
	 */
	List<HantoMoveRecord> moveCanBeMade();
	
	HantoPiece getPieceAt(HantoCoordinate where);
}
