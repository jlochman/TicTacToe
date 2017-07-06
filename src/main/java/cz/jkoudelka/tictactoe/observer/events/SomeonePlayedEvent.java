package cz.jkoudelka.tictactoe.observer.events;

import cz.jkoudelka.tictactoe.entityDomain.GameEntity;

/**
 * Event volan, pokud nekdo (player nebo CPU) zahral
 * 
 * @author jlochman
 *
 */
public class SomeonePlayedEvent extends GameEntityEvent {

	public SomeonePlayedEvent(GameEntity gameEntity) {
		super(gameEntity);
	}

}
