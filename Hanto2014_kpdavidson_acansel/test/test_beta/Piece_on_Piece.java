package test_beta;

import static org.junit.Assert.*;
import hanto.HantoGameFactory;
import hanto.common.*;
import hanto.student_kpdavidson_acansel_.beta.*;

import org.junit.Test;

public class Piece_on_Piece {

	@Test
	public void test() {
		HantoGameFactory factory = HantoGameFactory.getInstance();
		HantoGame betagame = factory.makeHantoGame(HantoGameID.BETA_HANTO);
		
		try {
			betagame.makeMove(HantoPieceType.BUTTERFLY, null, new BetaCoordinate(0,0)); //Blue
			betagame.makeMove(HantoPieceType.SPARROW, null, new BetaCoordinate(0,0));   //Red
			fail("should never be reached");
		} catch (HantoException e) {
			assertEquals(e.getMessage(), "Spot already taken");
		}
	}

}
