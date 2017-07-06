package cz.jkoudelka.tictactoe.observer.events;

import cz.jkoudelka.tictactoe.entityDomain.GameEntity;

public class SomeonePlayedEvent extends GameEntityEvent {

	public SomeonePlayedEvent(GameEntity gameEntity) {
		super(gameEntity);
	}

}
