package test_gamma;

import static org.junit.Assert.*;

import java.util.HashMap;

import hanto.common.HantoGameID;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;
import hanto.student_kpdavidson_acansel_.common.BasicCoordinate;
import hanto.student_kpdavidson_acansel_.common.BasicHantoPiece;
import hanto.student_kpdavidson_acansel_.common.HantoWalkValidator;

import org.junit.Test;

import common.HantoTestGame;
import common.HantoTestGameFactory;

/**
 * Tests the walking algorithm for correctness
 * @author Kyle & Adam
 *
 */
public class TestWalkingAlgorithm {

	@Test
	public void Truetest() {
		HashMap<String, BasicHantoPiece> board = new HashMap<String, BasicHantoPiece>();
		BasicCoordinate start = new BasicCoordinate(0, 0);
		BasicCoordinate destination = new BasicCoordinate(0, 2);
		
		HantoWalkValidator validate = new HantoWalkValidator(2, board, start, destination);
		boolean result = validate.validate();
		
		assertTrue(result);
	}

	@Test
	public void Falsetest_noStepsLeft() {
		HashMap<String, BasicHantoPiece> board = new HashMap<String, BasicHantoPiece>();
		BasicCoordinate start = new BasicCoordinate(0, 0);
		BasicCoordinate destination = new BasicCoordinate(0, 2);
		
		HantoWalkValidator validate = new HantoWalkValidator(1, board, start, destination);
		boolean result = validate.validate();
		
		assertFalse(result);
	}
	
	@Test
	public void Falsetest_path_blocked() {
		HashMap<String, BasicHantoPiece> board = new HashMap<String, BasicHantoPiece>();
		BasicCoordinate start = new BasicCoordinate(0, 0);
		BasicCoordinate destination = new BasicCoordinate(0, 2);
		
		board.put(new BasicCoordinate(-1,1).getkey(), new BasicHantoPiece(HantoPieceType.BUTTERFLY, HantoPlayerColor.RED));
		board.put(new BasicCoordinate(1,0).getkey(), new BasicHantoPiece(HantoPieceType.BUTTERFLY, HantoPlayerColor.BLUE));
		
		HantoWalkValidator validate = new HantoWalkValidator(2, board, start, destination);
		boolean result = validate.validate();
		
		assertFalse(result);
	}
}
