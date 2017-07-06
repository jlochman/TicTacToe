package cz.jkoudelka.tictactoe.observer.events;

import cz.jkoudelka.tictactoe.entityDomain.PlayerEntity;

public class PlayerSelectedEvent extends PlayerEntityEvent {

	public PlayerSelectedEvent(PlayerEntity playerEntity) {
		super(playerEntity);
	}

}
