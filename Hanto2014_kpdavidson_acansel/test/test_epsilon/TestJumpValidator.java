package test_epsilon;

import static org.junit.Assert.*;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;
import hanto.student_kpdavidson_acansel_.common.BasicCoordinate;
import hanto.student_kpdavidson_acansel_.common.BasicHantoPiece;
import hanto.student_kpdavidson_acansel_.common.HantoWalkValidator;
import hanto.student_kpdavidson_acansel_.common.JumpValidator;
import hanto.student_kpdavidson_acansel_.common.Validator_interface;

import java.util.HashMap;

import org.junit.Test;

public class TestJumpValidator {

	@Test
	public void Falsetest_nopiece() {
		HashMap<String, BasicHantoPiece> board = new HashMap<String, BasicHantoPiece>();
		board.put(new BasicCoordinate(0,0).getkey(), new BasicHantoPiece(HantoPieceType.HORSE, HantoPlayerColor.BLUE));
		BasicCoordinate start = new BasicCoordinate(0, 0);
		BasicCoordinate destination = new BasicCoordinate(0, 2);
		
		Validator_interface validate = new JumpValidator(board, start, destination);
		boolean result = validate.validate();
		
		assertFalse(result);
	}

	@Test
	public void Falsetest_toShort() {
		HashMap<String, BasicHantoPiece> board = new HashMap<String, BasicHantoPiece>();
		board.put(new BasicCoordinate(0,0).getkey(), new BasicHantoPiece(HantoPieceType.HORSE, HantoPlayerColor.BLUE));
		BasicCoordinate start = new BasicCoordinate(0, 0);
		BasicCoordinate destination = new BasicCoordinate(0, 1);
		
		Validator_interface validate = new JumpValidator(board, start, destination);
		boolean result = validate.validate();
		
		assertFalse(result);
	}
	
	@Test
	public void Falsetest_invalidplace() {
		HashMap<String, BasicHantoPiece> board = new HashMap<String, BasicHantoPiece>();
		board.put(new BasicCoordinate(0,0).getkey(), new BasicHantoPiece(HantoPieceType.HORSE, HantoPlayerColor.BLUE));
		BasicCoordinate start = new BasicCoordinate(0, 0);
		BasicCoordinate destination = new BasicCoordinate(1, 1);
		
		Validator_interface validate = new JumpValidator(board, start, destination);
		boolean result = validate.validate();
		
		assertFalse(result);
	}
	
	@Test
	public void Falsetest_invalidplace2() {
		HashMap<String, BasicHantoPiece> board = new HashMap<String, BasicHantoPiece>();
		board.put(new BasicCoordinate(0,0).getkey(), new BasicHantoPiece(HantoPieceType.HORSE, HantoPlayerColor.BLUE));
		BasicCoordinate start = new BasicCoordinate(0, 0);
		BasicCoordinate destination = new BasicCoordinate(-1, -1);
		
		Validator_interface validate = new JumpValidator(board, start, destination);
		boolean result = validate.validate();
		
		assertFalse(result);
	}
	
	@Test
	public void Falsetest_invalidplace3() {
		HashMap<String, BasicHantoPiece> board = new HashMap<String, BasicHantoPiece>();
		board.put(new BasicCoordinate(0,0).getkey(), new BasicHantoPiece(HantoPieceType.HORSE, HantoPlayerColor.BLUE));
		BasicCoordinate start = new BasicCoordinate(0, 0);
		BasicCoordinate destination = new BasicCoordinate(3, -2);
		
		Validator_interface validate = new JumpValidator(board, start, destination);
		boolean result = validate.validate();
		
		assertFalse(result);
	}
}
