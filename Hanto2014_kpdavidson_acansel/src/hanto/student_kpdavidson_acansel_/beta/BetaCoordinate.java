package hanto.student_kpdavidson_acansel_.beta;

import hanto.common.HantoCoordinate;

public class BetaCoordinate implements HantoCoordinate {

	int x, y;
	
	public BetaCoordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

}
