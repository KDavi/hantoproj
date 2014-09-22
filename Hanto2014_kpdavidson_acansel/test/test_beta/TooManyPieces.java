package test_beta;

import static org.junit.Assert.*;
import hanto.HantoGameFactory;
import hanto.common.*;
import hanto.student_kpdavidson_acansel_.beta.*;
import hanto.student_kpdavidson_acansel_.common.BasicCoordinate;

import org.junit.Test;

public class TooManyPieces {

	@Test
	public void test() {
		HantoGameFactory factory = HantoGameFactory.getInstance();
		HantoGame betagame = factory.makeHantoGame(HantoGameID.BETA_HANTO);
		MoveResult result = null;
		
		try {
			// turn 1
			result = betagame.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0,0)); //Blue
			assertEquals(result, MoveResult.OK);
			result = betagame.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(1,0)); //Red
			assertEquals(result, MoveResult.OK);
			// turn 2
			betagame.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(2,0)); //Blue
			fail("should never get here");
		} catch (HantoException e) {
			assertEquals(e.getMessage(), "Out of that piece");
		}
	}

}
