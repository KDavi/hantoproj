package test_alpha;

import static org.junit.Assert.*;
import hanto.common.*;
import hanto.student_kpdavidson_acansel_.HantoGameFactory;
import hanto.student_kpdavidson_acansel_.alpha.*;
import hanto.student_kpdavidson_acansel_.common.BasicCoordinate;

import org.junit.Test;

public class GetPieceAt {

	@Test
	public void test() {
		HantoGameFactory fact = HantoGameFactory.getInstance();
		HantoGame game = fact.makeHantoGame(HantoGameID.ALPHA_HANTO);
		HantoPiece ret = game.getPieceAt(new BasicCoordinate(0, 0));
		assertEquals(ret.getColor(), HantoPlayerColor.BLUE);
		assertEquals(ret.getType(), HantoPieceType.BUTTERFLY);
		
		try {
			game.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0, 0));
		} catch (HantoException e) {
			fail("no");
		}
		
		ret = game.getPieceAt(new BasicCoordinate(0, 1));
		assertEquals(ret.getColor(), HantoPlayerColor.RED);
		assertEquals(ret.getType(), HantoPieceType.BUTTERFLY);
	}

}
