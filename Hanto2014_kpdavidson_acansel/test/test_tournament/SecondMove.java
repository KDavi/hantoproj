package test_tournament;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import hanto.common.HantoGameID;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;
import hanto.student_kpdavidson_acansel_.common.BasicCoordinate;
import hanto.student_kpdavidson_acansel_.tournament.HantoPlayer;
import hanto.tournament.HantoGamePlayer;
import hanto.tournament.HantoMoveRecord;

import org.junit.Test;

public class SecondMove {

	@Test
	public void BLUE() {
		HantoGamePlayer player = new HantoPlayer();
		
		player.startGame(HantoGameID.EPSILON_HANTO, HantoPlayerColor.BLUE, false);
		HantoMoveRecord result = player.makeMove(new HantoMoveRecord(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0, 0)));
		
		List<BasicCoordinate> surroundings = new ArrayList<BasicCoordinate>(); 
		surroundings.add(new BasicCoordinate(0, 1));
		surroundings.add(new BasicCoordinate(1, 0));
		surroundings.add(new BasicCoordinate(1, -1));
		surroundings.add(new BasicCoordinate(0, -1));
		surroundings.add(new BasicCoordinate(-1, 0));
		surroundings.add(new BasicCoordinate(-1, 1));
		
		assertEquals(result.getFrom(), null);
		
		boolean found = false;
		for(BasicCoordinate c : surroundings) {
			if(result.getTo().getX() == c.getX() && result.getTo().getY() == c.getY()) {
				found = true;
				break;
			}
		}
		
		assertTrue(found);
	}

	@Test
	public void RED() {
		HantoGamePlayer player = new HantoPlayer();
		
		player.startGame(HantoGameID.EPSILON_HANTO, HantoPlayerColor.RED, false);
		HantoMoveRecord result = player.makeMove(new HantoMoveRecord(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0, 0)));
		
		List<BasicCoordinate> surroundings = new ArrayList<BasicCoordinate>(); 
		surroundings.add(new BasicCoordinate(0, 1));
		surroundings.add(new BasicCoordinate(1, 0));
		surroundings.add(new BasicCoordinate(1, -1));
		surroundings.add(new BasicCoordinate(0, -1));
		surroundings.add(new BasicCoordinate(-1, 0));
		surroundings.add(new BasicCoordinate(-1, 1));
		
		assertEquals(result.getFrom(), null);
		
		boolean found = false;
		for(BasicCoordinate c : surroundings) {
			if(result.getTo().getX() == c.getX() && result.getTo().getY() == c.getY()) {
				found = true;
				break;
			}
		}
		
		assertTrue(found);
	}
	
	@Test
	public void SURRENDER() {
		HantoGamePlayer player = new HantoPlayer_TEST();
		
		player.startGame(HantoGameID.EPSILON_HANTO, HantoPlayerColor.RED, false);
		HantoMoveRecord result = player.makeMove(new HantoMoveRecord(HantoPieceType.BUTTERFLY, null, new BasicCoordinate(0, 0)));
		
		assertEquals(result.getFrom(), null);
		assertEquals(result.getTo(), null);
		assertEquals(result.getPiece(), null);
	}
}
