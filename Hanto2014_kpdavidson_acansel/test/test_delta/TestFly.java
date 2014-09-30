package test_delta;

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

public class TestFly {

	@Test
	public void goodfly() {
		HantoGame game = HantoGameFactory.getInstance().makeHantoGame(HantoGameID.DELTA_HANTO);

		try {
			MoveResult result = game.makeMove(HantoPieceType.SPARROW, null, new BasicCoordinate(0, 0));
			assertEquals(MoveResult.OK, result);
			result = game.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0, 1));
			assertEquals(MoveResult.OK, result);
			result = game.makeMove(HantoPieceType.SPARROW, new BasicCoordinate(0, 0), new BasicCoordinate(0, 2));
			assertEquals(MoveResult.OK, result);

		} catch (HantoException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void badfly() {
		HantoTestGame game = HantoTestGameFactory.getInstance().makeHantoTestGame(HantoGameID.DELTA_HANTO);

		try {
			MoveResult result = game.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0, 0)); //blue
			assertEquals(MoveResult.OK, result);
			result = game.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0, 1)); //red
			assertEquals(MoveResult.OK, result);
			result = game.makeMove(HantoPieceType.SPARROW, null, new BasicCoordinate(0, -1)); //blue
			assertEquals(MoveResult.OK, result);
			result = game.makeMove(HantoPieceType.SPARROW, null, new BasicCoordinate(0, 2)); //red
			assertEquals(MoveResult.OK, result);
			result = game.makeMove(HantoPieceType.SPARROW, null, new BasicCoordinate(0, -2)); //blue
			assertEquals(MoveResult.OK, result);
			result = game.makeMove(HantoPieceType.SPARROW, null, new BasicCoordinate(0, 3)); //red
			assertEquals(MoveResult.OK, result);
			
			result = game.makeMove(HantoPieceType.SPARROW, new BasicCoordinate(0, -1), new BasicCoordinate(0, 4));
			fail("should have gotten exception");

		} catch (HantoException e) {
			assertEquals(e.getMessage(), "invalid move");
		}
	}
}
