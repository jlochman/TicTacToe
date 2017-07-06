package cz.jkoudelka.tictactoe.observer.events;

import cz.jkoudelka.tictactoe.entityDomain.PlayerEntity;
import cz.jkoudelka.tictactoe.observer.Event;

public class PlayerEntityEvent extends Event {

	private PlayerEntity playerEntity;

	public PlayerEntityEvent(PlayerEntity playerEntity) {
		this.playerEntity = playerEntity;
	}

	public PlayerEntity getPlayerEntity() {
		return playerEntity;
	}

	public void setPlayerEntity(PlayerEntity playerEntity) {
		this.playerEntity = playerEntity;
	}

}
