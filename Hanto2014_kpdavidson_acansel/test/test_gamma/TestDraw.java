package test_gamma;

import static org.junit.Assert.*;
import hanto.common.HantoException;
import hanto.common.HantoGameID;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;
import hanto.common.MoveResult;
import hanto.student_kpdavidson_acansel_.common.BasicCoordinate;

import org.junit.Test;

import common.HantoTestGame;
import common.HantoTestGameFactory;
import common.HantoTestGame.PieceLocationPair;

public class TestDraw {

	@Test
	public void test() {
		HantoTestGame game = HantoTestGameFactory.getInstance().makeHantoTestGame(HantoGameID.GAMMA_HANTO, HantoPlayerColor.BLUE);

		try {
			PieceLocationPair pair6 = new PieceLocationPair(HantoPlayerColor.BLUE, HantoPieceType.BUTTERFLY, new BasicCoordinate(0,0));
			PieceLocationPair pair1 = new PieceLocationPair(HantoPlayerColor.RED, HantoPieceType.BUTTERFLY, new BasicCoordinate(0,1));
			PieceLocationPair pair2 = new PieceLocationPair(HantoPlayerColor.RED, HantoPieceType.SPARROW, new BasicCoordinate(1,0));
			PieceLocationPair pair3 = new PieceLocationPair(HantoPlayerColor.RED, HantoPieceType.SPARROW, new BasicCoordinate(1,-1));
			PieceLocationPair pair4 = new PieceLocationPair(HantoPlayerColor.RED, HantoPieceType.SPARROW, new BasicCoordinate(0,-1));
			PieceLocationPair pair5 = new PieceLocationPair(HantoPlayerColor.RED, HantoPieceType.SPARROW, new BasicCoordinate(-1,0));
			PieceLocationPair pair7 = new PieceLocationPair(HantoPlayerColor.RED, HantoPieceType.SPARROW, new BasicCoordinate(-2,1));
			PieceLocationPair[] pieces = {pair1, pair2, pair3, pair4, pair5, pair6, pair7};
			game.initializeBoard(pieces);
			game.setPlayerMoving(HantoPlayerColor.RED);
			game.setTurnNumber(20);
			MoveResult result = game.makeMove(HantoPieceType.SPARROW, new BasicCoordinate(-2,1), new BasicCoordinate(-2, 0));
			assertEquals(result, MoveResult.DRAW);

		} catch (HantoException e) {
			fail(e.getMessage());
		}

	}

}
