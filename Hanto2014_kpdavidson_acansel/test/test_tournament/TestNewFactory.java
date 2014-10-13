package test_tournament;

import static org.junit.Assert.*;
import hanto.common.HantoGameID;
import hanto.common.HantoPlayerColor;
import hanto.student_kpdavidson_acansel_.tournament.HantoGameForAI_Factory;

import org.junit.Test;

public class TestNewFactory {

	@Test
	public void test() {
		HantoGameForAI_Factory.getInstance().makeHantoGame(HantoGameID.EPSILON_HANTO);
		HantoGameForAI_Factory.getInstance().makeHantoGame(HantoGameID.EPSILON_HANTO, HantoPlayerColor.RED);
		HantoGameForAI_Factory.getInstance().makeHantoGame(HantoGameID.EPSILON_HANTO, HantoPlayerColor.BLUE);
	}

}
