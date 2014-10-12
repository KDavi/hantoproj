package test_epsilon;

import static org.junit.Assert.*;
import hanto.common.HantoException;
import hanto.common.HantoGame;
import hanto.common.HantoGameID;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;
import hanto.common.MoveResult;
import hanto.student_kpdavidson_acansel_.HantoGameFactory;
import hanto.student_kpdavidson_acansel_.common.BasicCoordinate;

import org.junit.Test;

import common.HantoTestGame;
import common.HantoTestGameFactory;
import common.HantoTestGame.PieceLocationPair;

public class PrematureRes {

	@Test
	public void test1() {
		HantoGame game = HantoGameFactory.getInstance().makeHantoGame(HantoGameID.EPSILON_HANTO);
		
		try {
			MoveResult result = game.makeMove(null, null, null);
			fail("Premature resignation did not cause an exception");
			
		} catch (HantoException e) {
			assertEquals(e.getMessage(), "You resigned when you have a valid move available.");
		}
		
	}

	@Test
	public void test2() {
		// HANTOTESTGAME does not allow enough control
		EpsilonHantoTestGame game = new EpsilonHantoTestGame(HantoPlayerColor.BLUE);
		
		try {
			PieceLocationPair pair6 = new PieceLocationPair(HantoPlayerColor.RED, HantoPieceType.BUTTERFLY, new BasicCoordinate(0,0));
			PieceLocationPair pair1 = new PieceLocationPair(HantoPlayerColor.RED, HantoPieceType.SPARROW, new BasicCoordinate(0,1));
			PieceLocationPair pair2 = new PieceLocationPair(HantoPlayerColor.RED, HantoPieceType.SPARROW, new BasicCoordinate(0,-1));
			PieceLocationPair[] pieces = {pair1, pair2, pair6};
			game.initializeBoard(pieces);
			game.setPlayerMoving(HantoPlayerColor.RED);
			game.setTurnNumber(20);
			game.zeropieces();
			MoveResult result = game.makeMove(null, null, null);
			fail("Premature resignation did not cause an exception");
			
		} catch (HantoException e) {
			assertEquals(e.getMessage(), "You resigned when you have a valid move available.");
		}
		
	}
	
	@Test
	public void test3() {
		// HANTOTESTGAME does not allow enough control
		EpsilonHantoTestGame game = new EpsilonHantoTestGame(HantoPlayerColor.BLUE);
		
		try {
			PieceLocationPair pair6 = new PieceLocationPair(HantoPlayerColor.RED, HantoPieceType.SPARROW, new BasicCoordinate(0,0));
			PieceLocationPair pair1 = new PieceLocationPair(HantoPlayerColor.BLUE, HantoPieceType.BUTTERFLY, new BasicCoordinate(0,1));
			PieceLocationPair pair2 = new PieceLocationPair(HantoPlayerColor.RED, HantoPieceType.SPARROW, new BasicCoordinate(0,-1));
			PieceLocationPair[] pieces = {pair1, pair2, pair6};
			game.initializeBoard(pieces);
			game.setPlayerMoving(HantoPlayerColor.RED);
			game.setTurnNumber(20);
			MoveResult result = game.makeMove(null, null, null);
			fail("Premature resignation did not cause an exception");
			
		} catch (HantoException e) {
			assertEquals(e.getMessage(), "You resigned when you have a valid move available.");
		}
		
	}
	
	@Test
	public void test4() {
		// HANTOTESTGAME does not allow enough control
		EpsilonHantoTestGame game = new EpsilonHantoTestGame(HantoPlayerColor.BLUE);
		
		try {
			PieceLocationPair pair6 = new PieceLocationPair(HantoPlayerColor.RED, HantoPieceType.BUTTERFLY, new BasicCoordinate(0,0));
			PieceLocationPair pair1 = new PieceLocationPair(HantoPlayerColor.BLUE, HantoPieceType.BUTTERFLY, new BasicCoordinate(0,1));
			PieceLocationPair pair2 = new PieceLocationPair(HantoPlayerColor.RED, HantoPieceType.SPARROW, new BasicCoordinate(0,-1));
			PieceLocationPair[] pieces = {pair1, pair2, pair6};
			game.initializeBoard(pieces);
			game.setPlayerMoving(HantoPlayerColor.RED);
			game.setTurnNumber(20);
			MoveResult result = game.makeMove(null, null, null);
			fail("Premature resignation did not cause an exception");
			
		} catch (HantoException e) {
			assertEquals(e.getMessage(), "You resigned when you have a valid move available.");
		}
		
	}
	
	@Test
	public void test5() {
		// HANTOTESTGAME does not allow enough control
		EpsilonHantoTestGame game = new EpsilonHantoTestGame(HantoPlayerColor.BLUE);
		
		try {
			PieceLocationPair pair6 = new PieceLocationPair(HantoPlayerColor.RED, HantoPieceType.BUTTERFLY, new BasicCoordinate(0,0));
			PieceLocationPair pair1 = new PieceLocationPair(HantoPlayerColor.BLUE, HantoPieceType.BUTTERFLY, new BasicCoordinate(0,1));
			PieceLocationPair pair2 = new PieceLocationPair(HantoPlayerColor.RED, HantoPieceType.SPARROW, new BasicCoordinate(0,-1));
			PieceLocationPair[] pieces = {pair1, pair2, pair6};
			game.initializeBoard(pieces);
			game.setPlayerMoving(HantoPlayerColor.RED);
			game.setTurnNumber(20);
			game.zerosparrows();
			MoveResult result = game.makeMove(null, null, null);
			fail("Premature resignation did not cause an exception");
			
		} catch (HantoException e) {
			assertEquals(e.getMessage(), "You resigned when you have a valid move available.");
		}
		
	}
	
	@Test
	public void test6() {
		// HANTOTESTGAME does not allow enough control
		EpsilonHantoTestGame game = new EpsilonHantoTestGame(HantoPlayerColor.BLUE);
		
		try {
			PieceLocationPair pair6 = new PieceLocationPair(HantoPlayerColor.RED, HantoPieceType.BUTTERFLY, new BasicCoordinate(0,0));
			PieceLocationPair pair1 = new PieceLocationPair(HantoPlayerColor.BLUE, HantoPieceType.BUTTERFLY, new BasicCoordinate(0,1));
			PieceLocationPair pair2 = new PieceLocationPair(HantoPlayerColor.RED, HantoPieceType.SPARROW, new BasicCoordinate(0,-1));
			PieceLocationPair[] pieces = {pair1, pair2, pair6};
			game.initializeBoard(pieces);
			game.setPlayerMoving(HantoPlayerColor.RED);
			game.setTurnNumber(20);
			game.zerosparrows();
			game.zerohorses();
			MoveResult result = game.makeMove(null, null, null);
			fail("Premature resignation did not cause an exception");
			
		} catch (HantoException e) {
			assertEquals(e.getMessage(), "You resigned when you have a valid move available.");
		}
		
	}
	
	@Test
	public void test7() {
		// HANTOTESTGAME does not allow enough control
		EpsilonHantoTestGame game = new EpsilonHantoTestGame(HantoPlayerColor.BLUE);
		
		try {
			PieceLocationPair pair6 = new PieceLocationPair(HantoPlayerColor.RED, HantoPieceType.BUTTERFLY, new BasicCoordinate(0,0));
			PieceLocationPair pair1 = new PieceLocationPair(HantoPlayerColor.BLUE, HantoPieceType.SPARROW, new BasicCoordinate(0,1));
			PieceLocationPair pair2 = new PieceLocationPair(HantoPlayerColor.RED, HantoPieceType.SPARROW, new BasicCoordinate(0,-1));
			PieceLocationPair[] pieces = {pair1, pair2, pair6};
			game.initializeBoard(pieces);
			game.setPlayerMoving(HantoPlayerColor.BLUE);
			game.setTurnNumber(20);
			MoveResult result = game.makeMove(null, null, null);
			fail("Premature resignation did not cause an exception");
			
		} catch (HantoException e) {
			assertEquals(e.getMessage(), "You resigned when you have a valid move available.");
		}
		
	}
	
	@Test
	public void test8() {
		// HANTOTESTGAME does not allow enough control
		EpsilonHantoTestGame game = new EpsilonHantoTestGame(HantoPlayerColor.BLUE);
		
		try {
			PieceLocationPair pair6 = new PieceLocationPair(HantoPlayerColor.RED, HantoPieceType.BUTTERFLY, new BasicCoordinate(0,0));
			PieceLocationPair pair1 = new PieceLocationPair(HantoPlayerColor.BLUE, HantoPieceType.BUTTERFLY, new BasicCoordinate(0,1));
			PieceLocationPair pair2 = new PieceLocationPair(HantoPlayerColor.RED, HantoPieceType.SPARROW, new BasicCoordinate(0,-1));
			PieceLocationPair[] pieces = {pair1, pair2, pair6};
			game.initializeBoard(pieces);
			game.setPlayerMoving(HantoPlayerColor.BLUE);
			game.setTurnNumber(20);
			MoveResult result = game.makeMove(null, null, null);
			fail("Premature resignation did not cause an exception");
			
		} catch (HantoException e) {
			assertEquals(e.getMessage(), "You resigned when you have a valid move available.");
		}
		
	}
	
	@Test
	public void test9() {
		// HANTOTESTGAME does not allow enough control
		EpsilonHantoTestGame game = new EpsilonHantoTestGame(HantoPlayerColor.BLUE);
		
		try {
			PieceLocationPair pair6 = new PieceLocationPair(HantoPlayerColor.RED, HantoPieceType.BUTTERFLY, new BasicCoordinate(0,0));
			PieceLocationPair pair1 = new PieceLocationPair(HantoPlayerColor.BLUE, HantoPieceType.BUTTERFLY, new BasicCoordinate(0,1));
			PieceLocationPair pair2 = new PieceLocationPair(HantoPlayerColor.RED, HantoPieceType.SPARROW, new BasicCoordinate(0,-1));
			PieceLocationPair[] pieces = {pair1, pair2, pair6};
			game.initializeBoard(pieces);
			game.setPlayerMoving(HantoPlayerColor.BLUE);
			game.setTurnNumber(20);
			game.zerosparrows();
			MoveResult result = game.makeMove(null, null, null);
			fail("Premature resignation did not cause an exception");
			
		} catch (HantoException e) {
			assertEquals(e.getMessage(), "You resigned when you have a valid move available.");
		}
		
	}
	
	@Test
	public void test10() {
		// HANTOTESTGAME does not allow enough control
		EpsilonHantoTestGame game = new EpsilonHantoTestGame(HantoPlayerColor.BLUE);
		
		try {
			PieceLocationPair pair6 = new PieceLocationPair(HantoPlayerColor.RED, HantoPieceType.BUTTERFLY, new BasicCoordinate(0,0));
			PieceLocationPair pair1 = new PieceLocationPair(HantoPlayerColor.BLUE, HantoPieceType.BUTTERFLY, new BasicCoordinate(0,1));
			PieceLocationPair pair2 = new PieceLocationPair(HantoPlayerColor.RED, HantoPieceType.SPARROW, new BasicCoordinate(0,-1));
			PieceLocationPair[] pieces = {pair1, pair2, pair6};
			game.initializeBoard(pieces);
			game.setPlayerMoving(HantoPlayerColor.BLUE);
			game.setTurnNumber(20);
			game.zerosparrows();
			game.zerohorses();
			MoveResult result = game.makeMove(null, null, null);
			fail("Premature resignation did not cause an exception");
			
		} catch (HantoException e) {
			assertEquals(e.getMessage(), "You resigned when you have a valid move available.");
		}
		
	}
}
