package hanto.student_kpdavidson_acansel_.alpha;

import hanto.common.HantoCoordinate;

public class AlphaCoordinate implements HantoCoordinate {

	private int X;
	private int Y;
	
	public AlphaCoordinate(int x, int y) {
		this.X = x;
		this.Y = y;
	}

	@Override
	public int getX() {
		return X;
	}

	@Override
	public int getY() {
		return Y;
	}

}
