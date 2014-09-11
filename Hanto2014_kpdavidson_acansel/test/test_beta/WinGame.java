package test_beta;

import static org.junit.Assert.*;
import hanto.HantoGameFactory;
import hanto.common.*;
import hanto.student_kpdavidson_acansel_.beta.*;

import org.junit.Test;

public class WinGame {

	@Test
	public void test() {
		HantoGameFactory factory = HantoGameFactory.getInstance();
		HantoGame betagame = factory.makeHantoGame(HantoGameID.BETA_HANTO);
		MoveResult result = null;
		
		try {
			// turn 1
			result = betagame.makeMove(HantoPieceType.BUTTERFLY, null, new BetaCoordinate(0,0)); //Blue
			assertEquals(result, MoveResult.OK);
			result = betagame.makeMove(HantoPieceType.BUTTERFLY, null, new BetaCoordinate(1,0)); //Red
			assertEquals(result, MoveResult.OK);
			// turn 2
			result = betagame.makeMove(HantoPieceType.SPARROW, null, new BetaCoordinate(2,0)); //Blue
			assertEquals(result, MoveResult.OK);
			result = betagame.makeMove(HantoPieceType.SPARROW, null, new BetaCoordinate(1,-1)); //Red
			assertEquals(result, MoveResult.OK);
			// turn 3
			result = betagame.makeMove(HantoPieceType.SPARROW, null, new BetaCoordinate(3,0)); //Blue
			assertEquals(result, MoveResult.OK);
			result = betagame.makeMove(HantoPieceType.SPARROW, null, new BetaCoordinate(0,-1)); //Red
			assertEquals(result, MoveResult.OK);
			// turn 4
			result = betagame.makeMove(HantoPieceType.SPARROW, null, new BetaCoordinate(4,0)); //Blue
			assertEquals(result, MoveResult.OK);
			result = betagame.makeMove(HantoPieceType.SPARROW, null, new BetaCoordinate(-1,0)); //Red
			assertEquals(result, MoveResult.OK);
			// turn 5
			result = betagame.makeMove(HantoPieceType.SPARROW, null, new BetaCoordinate(5,0)); //Blue
			assertEquals(result, MoveResult.OK);
			result = betagame.makeMove(HantoPieceType.SPARROW, null, new BetaCoordinate(-1,1)); //Red
			assertEquals(result, MoveResult.OK);
			// turn 6
			result = betagame.makeMove(HantoPieceType.SPARROW, null, new BetaCoordinate(6,0)); //Blue
			assertEquals(result, MoveResult.OK);
			result = betagame.makeMove(HantoPieceType.SPARROW, null, new BetaCoordinate(0,1)); //Red
			assertEquals(result, MoveResult.RED_WINS);
			
		} catch (HantoException e) {
			fail("should end in draw with no problems");
		}
	}

}
