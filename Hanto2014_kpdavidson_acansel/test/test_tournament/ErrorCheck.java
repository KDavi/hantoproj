package test_tournament;

import static org.junit.Assert.*;
import hanto.common.HantoGameID;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;
import hanto.student_kpdavidson_acansel_.common.BasicCoordinate;
import hanto.student_kpdavidson_acansel_.tournament.HantoPlayer;
import hanto.tournament.HantoGamePlayer;
import hanto.tournament.HantoMoveRecord;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ErrorCheck {

	@Test
	public void BLUE() {
		HantoGamePlayer blue = new HantoPlayer();
		
		blue.startGame(HantoGameID.EPSILON_HANTO, HantoPlayerColor.BLUE, true);
		
		HantoMoveRecord result = blue.makeMove(null);
		result = new HantoMoveRecord(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0,1));
		result = blue.makeMove(result);
		
	}

}
