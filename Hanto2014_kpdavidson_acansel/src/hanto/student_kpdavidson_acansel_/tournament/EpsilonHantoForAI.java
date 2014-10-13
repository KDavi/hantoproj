/**
 * file comment
 */
package hanto.student_kpdavidson_acansel_.tournament;

import java.util.List;

import hanto.common.HantoPlayerColor;
import hanto.student_kpdavidson_acansel_.epsilon.EpsilonHantoGame;
import hanto.tournament.HantoMoveRecord;

/**
 * 
 * @author Kyle & Adam
 *
 */
public class EpsilonHantoForAI extends EpsilonHantoGame implements HantoGameForAI {

	public EpsilonHantoForAI(HantoPlayerColor turn) {
		super(turn);
	}

	public List<HantoMoveRecord> moveCanBeMade() {
		return super.moveCanBeMade();
	}
}
