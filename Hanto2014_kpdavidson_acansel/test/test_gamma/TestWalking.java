package test_gamma;

import static org.junit.Assert.*;
import hanto.common.*;
import hanto.student_kpdavidson_acansel_.common.BasicCoordinate;

import org.junit.Test;

import common.*;

public class TestWalking {

	@Test
	public void test() {
		HantoTestGame game = HantoTestGameFactory.getInstance().makeHantoTestGame(HantoGameID.GAMMA_HANTO);
		
		try {
			MoveResult result = game.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0, 0));
			assertEquals(MoveResult.OK, result);
			result = game.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0, 1));
			assertEquals(MoveResult.OK, result);
			result = game.makeMove(HantoPieceType.BUTTERFLY, new BasicCoordinate(0, 0), new BasicCoordinate(1, 0));
			assertEquals(MoveResult.OK, result);
			
		} catch (HantoException e) {
			fail(e.getMessage());
		}
		
	}
	
	@Test
	public void testfail() {
		HantoTestGame game = HantoTestGameFactory.getInstance().makeHantoTestGame(HantoGameID.GAMMA_HANTO);
		
		try {
			MoveResult result = game.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0, 0));
			assertEquals(MoveResult.OK, result);
			result = game.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0, 1));
			assertEquals(MoveResult.OK, result);
			result = game.makeMove(HantoPieceType.BUTTERFLY, new BasicCoordinate(0, 0), new BasicCoordinate(0, 2));
			fail("should never reach here");
			
		} catch (HantoException e) {
			assertEquals(e.getMessage(), "invalid walk");
		}
		
	}

}
