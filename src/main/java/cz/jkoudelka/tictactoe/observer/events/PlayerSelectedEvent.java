package cz.jkoudelka.tictactoe.observer.events;

import cz.jkoudelka.tictactoe.entityDomain.PlayerEntity;

/**
 * Event volan, pokud je vybran hrac
 * 
 * @author jlochman
 *
 */
public class PlayerSelectedEvent extends PlayerEntityEvent {

	public PlayerSelectedEvent(PlayerEntity playerEntity) {
		super(playerEntity);
	}

}
