package cz.jkoudelka.tictactoe.observer.events;

import cz.jkoudelka.tictactoe.entityDomain.GameEntity;
import cz.jkoudelka.tictactoe.observer.Event;

public class GameSelectedEvent extends Event {

	private GameEntity game;

	public GameSelectedEvent(GameEntity game) {
		this.game = game;
	}

	public GameEntity getGame() {
		return game;
	}

	public void setGame(GameEntity game) {
		this.game = game;
	}

}
