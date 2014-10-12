package test_epsilon;

import static org.junit.Assert.*;
import hanto.common.HantoException;
import hanto.common.HantoGame;
import hanto.common.HantoGameID;
import hanto.common.HantoPieceType;
import hanto.common.MoveResult;
import hanto.student_kpdavidson_acansel_.HantoGameFactory;
import hanto.student_kpdavidson_acansel_.common.BasicCoordinate;

import org.junit.Test;

public class Movement {

	@Test
	public void test1() {
		HantoGame game = HantoGameFactory.getInstance().makeHantoGame(HantoGameID.EPSILON_HANTO);

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
	public void test2() {
		HantoGame game = HantoGameFactory.getInstance().makeHantoGame(HantoGameID.EPSILON_HANTO);

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
	
	@Test
	public void test3() {
		HantoGame game = HantoGameFactory.getInstance().makeHantoGame(HantoGameID.EPSILON_HANTO);

		try {
			MoveResult result = game.makeMove(HantoPieceType.HORSE, null, new BasicCoordinate(0, 0));
			assertEquals(MoveResult.OK, result);
			result = game.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0, 1));
			assertEquals(MoveResult.OK, result);
			result = game.makeMove(HantoPieceType.HORSE, new BasicCoordinate(0, 0), new BasicCoordinate(0, 2));
			assertEquals(MoveResult.OK, result);

		} catch (HantoException e) {
			fail(e.getMessage());
		}
	}

}
