/**
 * file comment
 */
package hanto.student_kpdavidson_acansel_.tournament;

import hanto.common.HantoGame;
import hanto.common.HantoGameID;
import hanto.common.HantoPlayerColor;

/**
 * This is a singleton class that provides a factory to create an instance of any version
 * of a Hanto game with additional methods to support AI.
 * 
 *  -structure taken from Professor provided factories
 * 
 * @author Kyle & Adam
 * @version Feb 5, 2013
 */
public class HantoGameForAI_Factory {
	private static final HantoGameForAI_Factory INSTANCE = new HantoGameForAI_Factory();

	/**
	 * Default private descriptor.
	 */
	private HantoGameForAI_Factory()
	{
		// Empty, but the private constructor is necessary for the singleton.
	}

	/**
	 * @return the instance
	 */
	public static HantoGameForAI_Factory getInstance()
	{
		return INSTANCE;
	}

	/**
	 * Create the specified Hanto game version with the Blue player moving
	 * first.
	 * @param gameId the version desired.
	 * @return the game instance
	 */
	public HantoGame makeHantoGame(HantoGameID gameId)
	{
		return makeHantoGame(gameId, HantoPlayerColor.BLUE);
	}

	/**
	 * Factory method that returns the appropriately configured Hanto game.
	 * @param gameId the version desired.
	 * @param movesFirst the player color that moves first
	 * @return the game instance
	 */
	public HantoGameForAI makeHantoGame(HantoGameID gameId, HantoPlayerColor movesFirst) {
		HantoGameForAI game = null;
		switch (gameId) {
		case EPSILON_HANTO:
			game = new EpsilonHantoForAI(movesFirst);
			break;
		default:
			//never
			break;
		}
		return game;
	}
}
