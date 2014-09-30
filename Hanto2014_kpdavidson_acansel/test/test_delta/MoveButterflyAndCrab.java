package test_delta;

import static org.junit.Assert.*;
import hanto.common.HantoException;
import hanto.common.HantoGameID;
import hanto.common.HantoPieceType;
import hanto.common.MoveResult;
import hanto.student_kpdavidson_acansel_.common.BasicCoordinate;

import org.junit.Test;

import common.HantoTestGame;
import common.HantoTestGameFactory;

public class MoveButterflyAndCrab {

	@Test
	public void butterfly() {
		HantoTestGame game = HantoTestGameFactory.getInstance().makeHantoTestGame(HantoGameID.DELTA_HANTO);

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
	public void crab() {
		HantoTestGame game = HantoTestGameFactory.getInstance().makeHantoTestGame(HantoGameID.DELTA_HANTO);

		try {
			MoveResult result = game.makeMove(HantoPieceType.CRAB, null, new BasicCoordinate(0, 0));
			assertEquals(MoveResult.OK, result);
			result = game.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0, 1));
			assertEquals(MoveResult.OK, result);
			result = game.makeMove(HantoPieceType.CRAB, new BasicCoordinate(0, 0), new BasicCoordinate(1, 0));
			assertEquals(MoveResult.OK, result);

		} catch (HantoException e) {
			fail(e.getMessage());
		}
	}
}
