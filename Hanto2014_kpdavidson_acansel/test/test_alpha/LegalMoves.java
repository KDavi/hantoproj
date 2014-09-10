package test_alpha;

import static org.junit.Assert.*;
import hanto.common.*;
import hanto.student_kpdavidson_acansel_.alpha.*;

import org.junit.Test;

public class LegalMoves {

	@Test
	public void goodMove() {
		HantoGame game = new AlphaHantoGame();
		MoveResult result = null;
		
		try {
			result = game.makeMove(HantoPieceType.BUTTERFLY, null, new AlphaCoordinate(0,0));
			assertEquals(result, MoveResult.OK);
		} catch (HantoException e) {
			fail("Both moves are legal");
		}
	}
	
	@Test
	public void badMove() {
		HantoGame game = new AlphaHantoGame();
		
		try {
			game.makeMove(HantoPieceType.BUTTERFLY, null, new AlphaCoordinate(0,1));
			// should not go past here without exception
			fail("Illegal move did not cause exception");
		} catch (HantoException e) {
			assertTrue(true);
		}
	}

}
