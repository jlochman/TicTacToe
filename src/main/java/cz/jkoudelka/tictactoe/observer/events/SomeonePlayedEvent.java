package cz.jkoudelka.tictactoe.observer.events;

import cz.jkoudelka.tictactoe.entityDomain.GameEntity;
import cz.jkoudelka.tictactoe.observer.Event;

public class SomeonePlayedEvent extends Event {

	private GameEntity gameEntity;

	public SomeonePlayedEvent(GameEntity gameEntity) {
		this.gameEntity = gameEntity;
	}

	public GameEntity getGameEntity() {
		return gameEntity;
	}

	public void setGameEntity(GameEntity gameEntity) {
		this.gameEntity = gameEntity;
	}

}
