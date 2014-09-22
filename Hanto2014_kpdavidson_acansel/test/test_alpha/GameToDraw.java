package test_alpha;

import static org.junit.Assert.*;
import hanto.common.*;
import hanto.student_kpdavidson_acansel_.alpha.*;
import hanto.student_kpdavidson_acansel_.common.BasicCoordinate;

import org.junit.Test;

public class GameToDraw {

	@Test
	public void goodGame01() {
		HantoGame game = new AlphaHantoGame();
		MoveResult result = null;
		
		try {
			result = game.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0,0));
			assertEquals(result, MoveResult.OK);
			result = game.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0,1));
			assertEquals(result, MoveResult.DRAW);
		} catch (HantoException e) {
			fail("Both moves are legal");
		}
	}
	
	@Test
	public void goodGame10() {
		HantoGame game = new AlphaHantoGame();
		MoveResult result = null;
		
		try {
			result = game.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0,0));
			assertEquals(result, MoveResult.OK);
			result = game.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(1,0));
			assertEquals(result, MoveResult.DRAW);
		} catch (HantoException e) {
			fail("Both moves are legal");
		}
	}
	
	@Test
	public void goodGame1_1() {
		HantoGame game = new AlphaHantoGame();
		MoveResult result = null;
		
		try {
			result = game.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0,0));
			assertEquals(result, MoveResult.OK);
			result = game.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(1,-1));
			assertEquals(result, MoveResult.DRAW);
		} catch (HantoException e) {
			fail("Both moves are legal");
		}
	}

	@Test
	public void goodGame0_1() {
		HantoGame game = new AlphaHantoGame();
		MoveResult result = null;
		
		try {
			result = game.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0,0));
			assertEquals(result, MoveResult.OK);
			result = game.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0,-1));
			assertEquals(result, MoveResult.DRAW);
		} catch (HantoException e) {
			fail("Both moves are legal");
		}
	}
	
	@Test
	public void goodGame_10() {
		HantoGame game = new AlphaHantoGame();
		MoveResult result = null;
		
		try {
			result = game.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0,0));
			assertEquals(result, MoveResult.OK);
			result = game.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(-1,0));
			assertEquals(result, MoveResult.DRAW);
		} catch (HantoException e) {
			fail("Both moves are legal");
		}
	}
	
	@Test
	public void goodGame_11() {
		HantoGame game = new AlphaHantoGame();
		MoveResult result = null;
		
		try {
			result = game.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0,0));
			assertEquals(result, MoveResult.OK);
			result = game.makeMove(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(-1,1));
			assertEquals(result, MoveResult.DRAW);
		} catch (HantoException e) {
			fail("Both moves are legal");
		}
	}
}
