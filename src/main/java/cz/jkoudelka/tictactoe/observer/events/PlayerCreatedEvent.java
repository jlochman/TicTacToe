package cz.jkoudelka.tictactoe.observer.events;

import cz.jkoudelka.tictactoe.entityDomain.PlayerEntity;
import cz.jkoudelka.tictactoe.observer.Event;

public class PlayerCreatedEvent extends Event {

	private PlayerEntity player;

	public PlayerCreatedEvent(PlayerEntity player) {
		this.player = player;
	}

	public PlayerEntity getPlayer() {
		return player;
	}

	public void setPlayer(PlayerEntity player) {
		this.player = player;
	}

}
