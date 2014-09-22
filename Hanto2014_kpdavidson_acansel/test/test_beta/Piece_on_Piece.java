package test_beta;

import static org.junit.Assert.*;
import hanto.common.*;
import hanto.student_kpdavidson_acansel_.HantoGameFactory;
import hanto.student_kpdavidson_acansel_.beta.*;
import hanto.student_kpdavidson_acansel_.common.BasicCoordinate;

import org.junit.Test;

public class Piece_on_Piece {

	@Test
	public void test() {
		HantoGameFactory factory = HantoGameFactory.getInstance();
		HantoGame betagame = factory.makeHantoGame(HantoGameID.BETA_HANTO);
		
		try {
			betagame.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0,0)); //Blue
			betagame.makeMove(HantoPieceType.SPARROW, null, new BasicCoordinate(0,0));   //Red
			fail("should never be reached");
		} catch (HantoException e) {
			assertEquals("Spot already taken", e.getMessage());
		}
	}

}
