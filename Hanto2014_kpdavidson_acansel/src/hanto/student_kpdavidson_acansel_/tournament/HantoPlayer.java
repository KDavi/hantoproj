/**
 * file comment
 */
package hanto.student_kpdavidson_acansel_.tournament;




import hanto.common.HantoGameID;
import hanto.common.HantoPlayerColor;
import hanto.tournament.HantoGamePlayer;
import hanto.tournament.HantoMoveRecord;

/**
 * 
 * @author Kyle & Adam
 *
 */
public class HantoPlayer implements HantoGamePlayer {

	HantoGameForAI game;

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

	@Override
	public HantoMoveRecord makeMove(HantoMoveRecord opponentsMove) {
		// TODO Auto-generated method stub
		return null;
	}
}
