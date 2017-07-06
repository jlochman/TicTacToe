package cz.jkoudelka.tictactoe.observer.events;

import cz.jkoudelka.tictactoe.entityDomain.GameEntity;

/**
 * Event volany, pokud je vytvorena nova entita hry.
 * 
 * @author jlochman
 *
 */
public class GameCreatedEvent extends GameEntityEvent {

	public GameCreatedEvent(GameEntity gameEntity) {
		super(gameEntity);
	}

}
