package cz.jkoudelka.tictactoe.observer.events;

import cz.jkoudelka.tictactoe.entityDomain.PlayerEntity;

/**
 * Event volan, pri vytvoreni noveho hrace
 * 
 * @author jlochman
 *
 */
public class PlayerCreatedEvent extends PlayerEntityEvent {

	public PlayerCreatedEvent(PlayerEntity playerEntity) {
		super(playerEntity);
	}

}
