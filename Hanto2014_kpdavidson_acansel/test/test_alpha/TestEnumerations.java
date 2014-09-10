package test_alpha;

import static org.junit.Assert.*;
import hanto.common.*;
import hanto.student_kpdavidson_acansel_.alpha.*;

import org.junit.Test;

public class TestEnumerations {

	// Attempt to access all enumerations without errors
	@Test
	public void test() {
		HantoGameID id = HantoGameID.ALPHA_HANTO;
		id = HantoGameID.BETA_HANTO;
		id = HantoGameID.DELTA_HANTO;
		id = HantoGameID.EPSILON_HANTO;
		id = HantoGameID.GAMMA_HANTO;
		id = HantoGameID.IOTA_HANTO;
		id = HantoGameID.THETA_HANTO;
		id = HantoGameID.ZETA_HANTO;
		
		HantoPieceType type = HantoPieceType.BUTTERFLY;
		type.getPrintableName();
		type.getSymbol();
		type.toString();
		type = HantoPieceType.CRAB;
		type.getPrintableName();
		type.getSymbol();
		type.toString();
		type = HantoPieceType.CRANE;
		type.getPrintableName();
		type.getSymbol();
		type.toString();
		type = HantoPieceType.DOVE;
		type.getPrintableName();
		type.getSymbol();
		type.toString();
		type = HantoPieceType.HORSE;
		type.getPrintableName();
		type.getSymbol();
		type.toString();
		type = HantoPieceType.SPARROW;
		type.getPrintableName();
		type.getSymbol();
		type.toString();
		
		HantoPlayerColor color = HantoPlayerColor.RED;
		color = HantoPlayerColor.BLUE;
		
		MoveResult res = MoveResult.OK;
		res = MoveResult.BLUE_WINS;
		res = MoveResult.DRAW;
		res = MoveResult.RED_WINS;
		
		assertTrue(true);
	}

	//test other type of hanto exception
	@Test
	public void test2() {
		HantoCoordinate cord = null;
		
		try {
			cord.getX();
		}catch(Exception e) {
			try {
				throw new HantoException("message", e);
			} catch (HantoException e1) {
				assertTrue(true);
			}
		}
	}
}
