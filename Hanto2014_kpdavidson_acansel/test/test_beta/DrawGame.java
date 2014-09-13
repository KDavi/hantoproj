package test_beta;

import static org.junit.Assert.*;
import hanto.HantoGameFactory;
import hanto.common.*;
import hanto.student_kpdavidson_acansel_.beta.*;

import org.junit.Test;

public class DrawGame {

	@Test
	public void test() {
		HantoGameFactory factory = HantoGameFactory.getInstance();
		HantoGame betagame = factory.makeHantoGame(HantoGameID.BETA_HANTO);
		MoveResult result = null;
		
		try {
			// turn 1
			result = betagame.makeMove(HantoPieceType.SPARROW, null, new BetaCoordinate(0,0)); //Blue
			assertEquals(result, MoveResult.OK);
			result = betagame.makeMove(HantoPieceType.SPARROW, null, new BetaCoordinate(1,0)); //Red
			assertEquals(result, MoveResult.OK);
			// turn 2
			result = betagame.makeMove(HantoPieceType.SPARROW, null, new BetaCoordinate(2,0)); //Blue
			assertEquals(result, MoveResult.OK);
			result = betagame.makeMove(HantoPieceType.SPARROW, null, new BetaCoordinate(3,0)); //Red
			assertEquals(result, MoveResult.OK);
			// turn 3
			result = betagame.makeMove(HantoPieceType.SPARROW, null, new BetaCoordinate(4,0)); //Blue
			assertEquals(result, MoveResult.OK);
			result = betagame.makeMove(HantoPieceType.SPARROW, null, new BetaCoordinate(5,0)); //Red
			assertEquals(result, MoveResult.OK);
			// turn 4
			result = betagame.makeMove(HantoPieceType.BUTTERFLY, null, new BetaCoordinate(6,0)); //Blue
			assertEquals(result, MoveResult.OK);
			result = betagame.makeMove(HantoPieceType.BUTTERFLY, null, new BetaCoordinate(7,0)); //Red
			assertEquals(result, MoveResult.OK);
			// turn 5
			result = betagame.makeMove(HantoPieceType.SPARROW, null, new BetaCoordinate(8,0)); //Blue
			assertEquals(result, MoveResult.OK);
			result = betagame.makeMove(HantoPieceType.SPARROW, null, new BetaCoordinate(9,0)); //Red
			assertEquals(result, MoveResult.OK);
			// turn 6
			result = betagame.makeMove(HantoPieceType.SPARROW, null, new BetaCoordinate(10,0)); //Blue
			assertEquals(result, MoveResult.OK);
			result = betagame.makeMove(HantoPieceType.SPARROW, null, new BetaCoordinate(11,0)); //Red
			assertEquals(result, MoveResult.DRAW);
			
		} catch (HantoException e) {
			fail(e.getMessage());
		}
	}

}
