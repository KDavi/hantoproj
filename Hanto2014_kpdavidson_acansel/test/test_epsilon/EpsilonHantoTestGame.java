package test_epsilon;

import hanto.common.HantoCoordinate;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;
import hanto.student_kpdavidson_acansel_.common.BasicCoordinate;
import hanto.student_kpdavidson_acansel_.common.BasicHantoPiece;
import hanto.student_kpdavidson_acansel_.epsilon.EpsilonHantoGame;

import common.HantoTestGame;
import common.HantoTestGame.PieceLocationPair;

public class EpsilonHantoTestGame extends EpsilonHantoGame implements
		HantoTestGame {

	public EpsilonHantoTestGame(HantoPlayerColor turn) {
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
			else if(piece.getType().equals(HantoPieceType.HORSE)) {
				if(piece.getColor().equals(HantoPlayerColor.RED)) {
					redHorseCount--;
				}
				else if(piece.getColor().equals(HantoPlayerColor.BLUE)) {
					blueHorseCount--;
				}
			}
			
			
			BasicCoordinate basicto = new BasicCoordinate(location);
			
			possiblespaces.remove(basicto);
			if(getPieceAt(new BasicCoordinate(basicto.getX(), basicto.getY() + 1)) == null) {
				if(!possiblespaces.contains(new BasicCoordinate(basicto.getX(), basicto.getY() + 1))) {
					possiblespaces.add(new BasicCoordinate(basicto.getX(), basicto.getY() + 1));
				}
			}
			if(getPieceAt(new BasicCoordinate(basicto.getX() + 1, basicto.getY())) == null) {
				if(!possiblespaces.contains(new BasicCoordinate(basicto.getX() + 1, basicto.getY()))) {
					possiblespaces.add(new BasicCoordinate(basicto.getX() + 1, basicto.getY()));
				}
			}
			if(getPieceAt(new BasicCoordinate(basicto.getX() + 1, basicto.getY() - 1)) == null) {
				if(!possiblespaces.contains(new BasicCoordinate(basicto.getX() + 1, basicto.getY() - 1))) {
					possiblespaces.add(new BasicCoordinate(basicto.getX() + 1, basicto.getY() - 1));
				}
			}
			if(getPieceAt(new BasicCoordinate(basicto.getX(), basicto.getY() - 1)) == null) {
				if(!possiblespaces.contains(new BasicCoordinate(basicto.getX(), basicto.getY() - 1))) {
					possiblespaces.add(new BasicCoordinate(basicto.getX(), basicto.getY() - 1));
				}
			}
			if(getPieceAt(new BasicCoordinate(basicto.getX() - 1, basicto.getY())) == null) {
				if(!possiblespaces.contains(new BasicCoordinate(basicto.getX() - 1, basicto.getY()))) {
					possiblespaces.add(new BasicCoordinate(basicto.getX() - 1, basicto.getY()));
				}
			}
			if(getPieceAt(new BasicCoordinate(basicto.getX() - 1, basicto.getY() + 1)) == null) {
				if(!possiblespaces.contains(new BasicCoordinate(basicto.getX() - 1, basicto.getY() + 1))) {
					possiblespaces.add(new BasicCoordinate(basicto.getX() - 1, basicto.getY() + 1));
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

	public void zeropieces() {
		blueSparrowCount = 0;
		redSparrowCount = 0;
		blueCrabCount = 0;
		redCrabCount = 0;
		blueHorseCount = 0;
		redHorseCount = 0;
	}
	public void zerosparrows() {
		blueSparrowCount = 0;
		redSparrowCount = 0;
	}
	public void zerocrabs() {
		blueCrabCount = 0;
		redCrabCount = 0;
	}
	public void zerohorses() {
		blueHorseCount = 0;
		redHorseCount = 0;
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
