package test_tournament;

import java.util.ArrayList;
import java.util.List;

import hanto.common.HantoPlayerColor;
import hanto.student_kpdavidson_acansel_.tournament.EpsilonHantoForAI;
import hanto.tournament.HantoMoveRecord;

public class EpsilonHantoForAI_TEST extends EpsilonHantoForAI {

	public EpsilonHantoForAI_TEST(HantoPlayerColor turn) {
		super(turn);
	}

	public List<HantoMoveRecord> moveCanBeMade() {
		List<HantoMoveRecord> newlist = new ArrayList<HantoMoveRecord>();
		return newlist;
	}
}
