/**
 * File comment
 */
package hanto.student_kpdavidson_acansel_.alpha;

import hanto.common.HantoPiece;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;

/**
 * 
 * @author Kyle & Adam
 *
 */
public class AlphaHantoPiece implements HantoPiece {

	HantoPlayerColor color;
	HantoPieceType type;
	
	/**
	 * Constructor
	 * @param color piece color
	 * @param type piece type
	 */
	public AlphaHantoPiece(HantoPlayerColor color, HantoPieceType type) {
		this.color = color;
		this.type = type;
	}

	@Override
	public HantoPlayerColor getColor() {
		return color;
	}

	@Override
	public HantoPieceType getType() {
		return type;
	}

}
