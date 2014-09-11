package test_beta;

import static org.junit.Assert.*;
import hanto.HantoGameFactory;
import hanto.common.*;
import hanto.student_kpdavidson_acansel_.beta.*;

import org.junit.Test;

public class Fourth_Turn_No_Butterfly {

	@Test
	public void test() {
		HantoGameFactory factory = HantoGameFactory.getInstance();
		HantoGame betagame = factory.makeHantoGame(HantoGameID.BETA_HANTO);
		
		try {
			// turn 1
			betagame.makeMove(HantoPieceType.SPARROW, null, new BetaCoordinate(0,0)); //Blue
			betagame.makeMove(HantoPieceType.SPARROW, null, new BetaCoordinate(0,0)); //Red
			// turn 2
			betagame.makeMove(HantoPieceType.SPARROW, null, new BetaCoordinate(0,0)); //Blue
			betagame.makeMove(HantoPieceType.SPARROW, null, new BetaCoordinate(0,0)); //Red
			// turn 3
			betagame.makeMove(HantoPieceType.SPARROW, null, new BetaCoordinate(0,0)); //Blue
			betagame.makeMove(HantoPieceType.SPARROW, null, new BetaCoordinate(0,0)); //Red
			// turn 4
			betagame.makeMove(HantoPieceType.SPARROW, null, new BetaCoordinate(0,0)); //Blue
			
			fail("should never be reached");
		} catch (HantoException e) {
			assertEquals(e.getMessage(), "Must Place Butterfly");
		}
	}

}
