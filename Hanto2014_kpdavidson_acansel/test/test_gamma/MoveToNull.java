package test_gamma;

import static org.junit.Assert.*;
import hanto.common.HantoException;
import hanto.common.HantoGameID;
import hanto.common.HantoPieceType;
import hanto.common.MoveResult;
import hanto.student_kpdavidson_acansel_.common.BasicCoordinate;

import org.junit.Test;

import common.HantoTestGame;
import common.HantoTestGameFactory;

public class MoveToNull {

	@Test
	public void test() {
		HantoTestGame game = HantoTestGameFactory.getInstance().makeHantoTestGame(HantoGameID.GAMMA_HANTO);
		
		try {
			MoveResult result = game.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0, 0));
			assertEquals(MoveResult.OK, result);
			result = game.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0, 1));
			assertEquals(MoveResult.OK, result);
			result = game.makeMove(HantoPieceType.BUTTERFLY, new BasicCoordinate(0, 0), null);
			fail("should not reach here");
			
		} catch (HantoException e) {
			assertEquals(e.getMessage(), "Cannot Move Pieces to null");
		}
		
	}

}
