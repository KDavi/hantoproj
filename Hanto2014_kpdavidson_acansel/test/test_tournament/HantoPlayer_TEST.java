package test_tournament;

import hanto.common.HantoGameID;
import hanto.common.HantoPlayerColor;
import hanto.student_kpdavidson_acansel_.tournament.HantoGameForAI_Factory;
import hanto.student_kpdavidson_acansel_.tournament.HantoPlayer;

public class HantoPlayer_TEST extends HantoPlayer {

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
		
		game = new EpsilonHantoForAI_TEST(movesFirst);
	}
}
