package cz.jkoudelka.tictactoe.observer.events;

import cz.jkoudelka.tictactoe.entityDomain.PlayerEntity;

public class PlayerCreatedEvent extends PlayerEntityEvent {

	public PlayerCreatedEvent(PlayerEntity playerEntity) {
		super(playerEntity);
	}

}
