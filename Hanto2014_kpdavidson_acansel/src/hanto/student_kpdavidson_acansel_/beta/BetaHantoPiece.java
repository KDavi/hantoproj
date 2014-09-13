/**
 * file comment
 */
package hanto.student_kpdavidson_acansel_.beta;

import hanto.common.HantoPiece;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;

/**
 * 
 * @author Kyle & Adam
 *
 */
public class BetaHantoPiece implements HantoPiece {

	HantoPieceType type;
	HantoPlayerColor color;
	
	/**
	 * Constructor
	 * @param type type of piece
	 * @param color color of player owning piece
	 */
	public BetaHantoPiece(HantoPieceType type, HantoPlayerColor color) {
		this.type = type;
		this.color = color;
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
