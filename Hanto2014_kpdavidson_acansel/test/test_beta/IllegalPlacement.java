package test_beta;

import static org.junit.Assert.*;
import hanto.HantoGameFactory;
import hanto.common.*;
import hanto.student_kpdavidson_acansel_.beta.*;

import org.junit.Test;

public class IllegalPlacement {

	@Test
	public void test() {
		HantoGameFactory factory = HantoGameFactory.getInstance();
		HantoGame betagame = factory.makeHantoGame(HantoGameID.BETA_HANTO);
		
		try {
			betagame.makeMove(HantoPieceType.BUTTERFLY, null, new BetaCoordinate(1,1));
			fail("should never be reached");
		} catch (HantoException e) {
			assertEquals(e.getMessage(), "Illegal Destination");
		}
	}
	
	@Test
	public void test2() {
		HantoGameFactory factory = HantoGameFactory.getInstance();
		HantoGame betagame = factory.makeHantoGame(HantoGameID.BETA_HANTO);
		
		try {
			betagame.makeMove(HantoPieceType.BUTTERFLY, null, new BetaCoordinate(0,0));
			betagame.makeMove(HantoPieceType.BUTTERFLY, null, new BetaCoordinate(0,2));
			fail("should never be reached");
		} catch (HantoException e) {
			assertEquals(e.getMessage(), "Illegal Destination");
		}
	}

}
