package test_delta;

import hanto.common.HantoCoordinate;
import hanto.common.HantoException;
import hanto.common.HantoPiece;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;
import hanto.common.MoveResult;
import hanto.student_kpdavidson_acansel_.common.BasicCoordinate;
import hanto.student_kpdavidson_acansel_.common.BasicHantoPiece;
import hanto.student_kpdavidson_acansel_.delta.DeltaHantoGame;
import common.HantoTestGame;
import common.HantoTestGame.PieceLocationPair;

public class DeltaHantoTestGame extends DeltaHantoGame implements HantoTestGame {

	public DeltaHantoTestGame(HantoPlayerColor turn) {
		super(turn);
	}

	@Override
	public void initializeBoard(PieceLocationPair[] initialPieces) {
		gameboard.clear();
		for(PieceLocationPair pair : initialPieces) {
			BasicHantoPiece piece = new BasicHantoPiece(pair.pieceType, pair.player);
			BasicCoordinate location = new BasicCoordinate(pair.location);
			gameboard.put(location.getkey(), piece);
			
			if(piece.getType().equals(HantoPieceType.BUTTERFLY)) {
				if(piece.getColor().equals(HantoPlayerColor.RED)) {
					redfly = location;
				}
				else if(piece.getColor().equals(HantoPlayerColor.BLUE)) {
					bluefly = location;
				}
			}
			else if(piece.getType().equals(HantoPieceType.SPARROW)) {
				if(piece.getColor().equals(HantoPlayerColor.RED)) {
					redSparrowCount--;
				}
				else if(piece.getColor().equals(HantoPlayerColor.BLUE)) {
					blueSparrowCount--;
				}
			}
			else if(piece.getType().equals(HantoPieceType.CRAB)) {
				if(piece.getColor().equals(HantoPlayerColor.RED)) {
					redCrabCount--;
				}
				else if(piece.getColor().equals(HantoPlayerColor.BLUE)) {
					blueCrabCount--;
				}
			}
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
			if(!player.equals(whoStarted)) {
				turncount++;
			}
			else {
				turncount--;
			}
		}
		turn = player;
	}

}
