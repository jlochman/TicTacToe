package cz.jkoudelka.tictactoe.observer.events;

import cz.jkoudelka.tictactoe.entityDomain.GameEntity;

/**
 * Event, ktery je volan, pokud uzivatel vybral nejakou hru.
 * 
 * @author jlochman
 *
 */
public class GameSelectedEvent extends GameEntityEvent {

	public GameSelectedEvent(GameEntity gameEntity) {
		super(gameEntity);
	}

}
