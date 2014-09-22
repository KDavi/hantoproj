package test_beta;

import static org.junit.Assert.*;
import hanto.HantoGameFactory;
import hanto.common.*;
import hanto.student_kpdavidson_acansel_.beta.*;
import hanto.student_kpdavidson_acansel_.common.BasicCoordinate;

import org.junit.Test;

public class Non_Null_From_Move {

	@Test
	public void test() {
		HantoGameFactory factory = HantoGameFactory.getInstance();
		HantoGame betagame = factory.makeHantoGame(HantoGameID.BETA_HANTO);
		
		try {
			betagame.makeMove(HantoPieceType.BUTTERFLY, new BasicCoordinate(2,3), new BasicCoordinate(0,0));
			fail("should never be reached");
		} catch (HantoException e) {
			assertEquals(e.getMessage(), "Cannot Move Pieces");
		}
	}

}
