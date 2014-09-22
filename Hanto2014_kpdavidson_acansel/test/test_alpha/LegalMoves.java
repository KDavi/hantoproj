package test_alpha;

import static org.junit.Assert.*;
import hanto.common.*;
import hanto.student_kpdavidson_acansel_.HantoGameFactory;
import hanto.student_kpdavidson_acansel_.alpha.*;
import hanto.student_kpdavidson_acansel_.common.BasicCoordinate;

import org.junit.Test;

public class LegalMoves {

	@Test
	public void goodMove() {
		HantoGameFactory fact = HantoGameFactory.getInstance();
		HantoGame game = fact.makeHantoGame(HantoGameID.ALPHA_HANTO);
		MoveResult result = null;
		
		try {
			result = game.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0,0));
			assertEquals(result, MoveResult.OK);
		} catch (HantoException e) {
			fail("Both moves are legal");
		}
	}
	
	@Test
	public void badMove() {
		HantoGameFactory fact = HantoGameFactory.getInstance();
		HantoGame game = fact.makeHantoGame(HantoGameID.ALPHA_HANTO);
		
		try {
			game.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0,1));
			// should not go past here without exception
			fail("Illegal move did not cause exception");
		} catch (HantoException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void badMove2() {
		HantoGameFactory fact = HantoGameFactory.getInstance();
		HantoGame game = fact.makeHantoGame(HantoGameID.ALPHA_HANTO);
		
		try {
			game.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0,0));
			game.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0,2));
			// should not go past here without exception
			fail("Illegal move did not cause exception");
		} catch (HantoException e) {
			assertTrue(true);
		}
	}

}
