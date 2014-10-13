package test_tournament;

import static org.junit.Assert.*;
import hanto.common.HantoGameID;
import hanto.common.HantoPlayerColor;
import hanto.student_kpdavidson_acansel_.tournament.HantoPlayer;
import hanto.tournament.HantoGamePlayer;
import hanto.tournament.HantoMoveRecord;

import org.junit.Test;

public class FirstMove {

	@Test
	public void test() {
		HantoGamePlayer player = new HantoPlayer();
		
		player.startGame(HantoGameID.EPSILON_HANTO, HantoPlayerColor.RED, true);
		HantoMoveRecord result = player.makeMove(null);
		
		assertEquals(result.getFrom(), null);
		assertEquals(result.getTo().getX(), 0);
		assertEquals(result.getTo().getY(), 0);
	}

}
