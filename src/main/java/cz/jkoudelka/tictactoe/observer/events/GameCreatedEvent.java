package cz.jkoudelka.tictactoe.observer.events;

import cz.jkoudelka.tictactoe.entityDomain.GameEntity;

public class GameCreatedEvent extends GameEntityEvent {

	public GameCreatedEvent(GameEntity gameEntity) {
		super(gameEntity);
	}

}
