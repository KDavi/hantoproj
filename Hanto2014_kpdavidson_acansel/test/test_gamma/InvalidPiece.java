package test_gamma;

import static org.junit.Assert.*;
import hanto.common.HantoException;
import hanto.common.HantoGame;
import hanto.common.HantoGameID;
import hanto.common.HantoPieceType;
import hanto.common.MoveResult;
import hanto.student_kpdavidson_acansel_.HantoGameFactory;
import hanto.student_kpdavidson_acansel_.common.BasicCoordinate;

import org.junit.Test;

import common.HantoTestGame;
import common.HantoTestGameFactory;

public class InvalidPiece {

	@Test
	public void test() {
		HantoGame game = HantoGameFactory.getInstance().makeHantoGame(HantoGameID.GAMMA_HANTO);
		
		try {
			MoveResult result = game.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0, 0));
			assertEquals(MoveResult.OK, result);
			result = game.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0, 1));
			assertEquals(MoveResult.OK, result);
			result = game.makeMove(HantoPieceType.CRAB, null, new BasicCoordinate(1, 0));
			fail("should not reach here");
			
		} catch (HantoException e) {
			assertEquals(e.getMessage(), "Invalid Piece");
		}
		
	}

}
