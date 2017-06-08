package cz.jkoudelka.tictactoe.observer.events;

import cz.jkoudelka.tictactoe.entityDomain.GameEntity;

public class GameSelectedEvent {

	private GameEntity gameEntity;

	public GameSelectedEvent(GameEntity gameEntity) {
		this.gameEntity = gameEntity;
	}

	public GameEntity getGameEntity() {
		return gameEntity;
	}

	public void setGameEntity(GameEntity gameEntity) {
		this.gameEntity = gameEntity;
	}

}
