package cz.jkoudelka.tictactoe.observer.events;

import cz.jkoudelka.tictactoe.entityDomain.GameEntity;

public class GameSelectedEvent extends GameEntityEvent {

	public GameSelectedEvent(GameEntity gameEntity) {
		super(gameEntity);
	}

}
