package test_beta;

import static org.junit.Assert.*;
import hanto.HantoGameFactory;
import hanto.common.*;
import hanto.student_kpdavidson_acansel_.beta.*;

import org.junit.Test;

public class Non_Null_From_Move {

	@Test
	public void test() {
		HantoGameFactory factory = HantoGameFactory.getInstance();
		HantoGame betagame = factory.makeHantoGame(HantoGameID.BETA_HANTO);
		
		try {
			betagame.makeMove(HantoPieceType.BUTTERFLY, new BetaCoordinate(2,3), new BetaCoordinate(0,0));
			fail("should never be reached");
		} catch (HantoException e) {
			assertEquals(e.getMessage(), "Cannot Move Pieces");
		}
	}

}
