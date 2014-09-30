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

public class SurrenderAndMove {

	@Test
	public void blueWins() {
		HantoTestGame game = HantoTestGameFactory.getInstance().makeHantoTestGame(HantoGameID.DELTA_HANTO);

		try {
			MoveResult result = game.makeMove(HantoPieceType.SPARROW, null, new BasicCoordinate(0, 0));
			assertEquals(MoveResult.OK, result);
			result = game.makeMove(null, null, null);
			assertEquals(MoveResult.BLUE_WINS, result);
			result = game.makeMove(HantoPieceType.SPARROW, new BasicCoordinate(0, 0), new BasicCoordinate(0, 2));
			fail("Expecting exception");

		} catch (HantoException e) {
			assertEquals(e.getMessage(), "game is already over");
		}
	}

	@Test
	public void redWins() {
		HantoTestGame game = HantoTestGameFactory.getInstance().makeHantoTestGame(HantoGameID.DELTA_HANTO);

		try {
			MoveResult result = game.makeMove(null, null, null);
			assertEquals(MoveResult.RED_WINS, result);
			result = game.makeMove(HantoPieceType.SPARROW, new BasicCoordinate(0, 0), new BasicCoordinate(0, 2));
			fail("Expecting exception");

		} catch (HantoException e) {
			assertEquals(e.getMessage(), "game is already over");
		}
	}
}
