package cz.jkoudelka.tictactoe.observer.events;

import cz.jkoudelka.tictactoe.entityDomain.GameEntity;
import cz.jkoudelka.tictactoe.entityDomain.enums.GameResult;
import cz.jkoudelka.tictactoe.observer.Event;

public class GameEndedEvent extends Event {

	private GameEntity gameEntity;
	private GameResult gameResult;

	public GameEndedEvent(GameEntity gameEntity, GameResult gameResult) {
		this.gameEntity = gameEntity;
		this.gameResult = gameResult;
	}

	public GameEntity getGameEntity() {
		return gameEntity;
	}

	public void setGameEntity(GameEntity gameEntity) {
		this.gameEntity = gameEntity;
	}

	public GameResult getGameResult() {
		return gameResult;
	}

	public void setGameResult(GameResult gameResult) {
		this.gameResult = gameResult;
	}

}
