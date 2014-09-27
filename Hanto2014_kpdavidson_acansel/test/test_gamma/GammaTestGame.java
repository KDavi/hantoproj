package test_gamma;

import hanto.common.HantoCoordinate;
import hanto.common.HantoException;
import hanto.common.HantoPiece;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;
import hanto.common.MoveResult;
import hanto.student_kpdavidson_acansel_.common.BasicCoordinate;
import hanto.student_kpdavidson_acansel_.common.BasicHantoPiece;
import hanto.student_kpdavidson_acansel_.gamma.GammaHantoGame;
import common.HantoTestGame;

public class GammaTestGame extends GammaHantoGame implements HantoTestGame {

	public GammaTestGame(HantoPlayerColor turn) {
		super(turn);
	}

	@Override
	public void initializeBoard(PieceLocationPair[] initialPieces) {
		for(PieceLocationPair pair : initialPieces) {
			BasicHantoPiece piece = new BasicHantoPiece(pair.pieceType, pair.player);
			BasicCoordinate location = new BasicCoordinate(pair.location);
			gameboard.put(location.getkey(), piece);
		}
	}

	@Override
	public void setTurnNumber(int turnNumber) {
		if(turn.equals(whoStarted)) {
			turncount = ((turnNumber * 2) - 1);
		}
		else {
			turncount = (turnNumber * 2);
		}

	}

	@Override
	public void setPlayerMoving(HantoPlayerColor player) {
		if(!turn.equals(player)) {
			if(player.equals(whoStarted)) {
				turncount--;
			}
			else {
				turncount++;
			}
		}
	}

}
