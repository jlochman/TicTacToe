package cz.jkoudelka.tictactoe.observer.events;

import cz.jkoudelka.tictactoe.entityDomain.GameEntity;
import cz.jkoudelka.tictactoe.entityDomain.enums.GameResult;

/**
 * Event volan, pokud je hra ukoncena.
 * 
 * @author jlochman
 *
 */
public class GameEndedEvent extends GameEntityEvent {

	private GameResult gameResult;

	public GameEndedEvent(GameEntity gameEntity, GameResult gameResult) {
		super(gameEntity);
		this.gameResult = gameResult;
	}

	public GameResult getGameResult() {
		return gameResult;
	}

	public void setGameResult(GameResult gameResult) {
		this.gameResult = gameResult;
	}

}
