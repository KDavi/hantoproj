package test_gamma;

import static org.junit.Assert.*;
import hanto.common.*;
import hanto.student_kpdavidson_acansel_.common.BasicCoordinate;

import org.junit.Test;

import common.*;
import common.HantoTestGame.PieceLocationPair;

import org.junit.Test;

public class TestWinning {

	@Test
	public void test() {
HantoTestGame game = HantoTestGameFactory.getInstance().makeHantoTestGame(HantoGameID.GAMMA_HANTO, HantoPlayerColor.BLUE);
		/*
		try {
			PieceLocationPair pair6 = new PieceLocationPair(HantoPlayerColor.BLUE, HantoPieceType.BUTTERFLY, new BasicCoordinate(0,0));
			PieceLocationPair pair1 = new PieceLocationPair(HantoPlayerColor.RED, HantoPieceType.BUTTERFLY, new BasicCoordinate(0,1));
			PieceLocationPair pair2 = new PieceLocationPair(HantoPlayerColor.RED, HantoPieceType.SPARROW, new BasicCoordinate(1,0));
			PieceLocationPair pair3 = new PieceLocationPair(HantoPlayerColor.RED, HantoPieceType.SPARROW, new BasicCoordinate(1,-1));
			PieceLocationPair pair4 = new PieceLocationPair(HantoPlayerColor.RED, HantoPieceType.SPARROW, new BasicCoordinate(0,-1));
			PieceLocationPair pair5 = new PieceLocationPair(HantoPlayerColor.RED, HantoPieceType.SPARROW, new BasicCoordinate(-1,0));
			PieceLocationPair[] pieces = {pair1, pair2, pair3, pair4, pair5, pair6};
			game.initializeBoard(pieces);
			game.setPlayerMoving(HantoPlayerColor.RED);
			game.setTurnNumber(5);
			MoveResult result = game.makeMove(HantoPieceType.SPARROW, null, new BasicCoordinate(-1, 1));
			assertEquals(result, MoveResult.RED_WINS);
			
		} catch (HantoException e) {
			e.printStackTrace();
			fail("Should never reach here");
		}
		*/
	}

}
