package cz.jkoudelka.tictactoe.observer.events;

import cz.jkoudelka.tictactoe.entityDomain.GameEntity;
import cz.jkoudelka.tictactoe.observer.Event;

/**
 * Obecny event, do ktereho se predava {@link GameEntity}
 * 
 * @author jlochman
 *
 */
public class GameEntityEvent extends Event {

	private GameEntity gameEntity;

	public GameEntityEvent(GameEntity gameEntity) {
		this.gameEntity = gameEntity;
	}

	public GameEntity getGameEntity() {
		return gameEntity;
	}

	public void setGameEntity(GameEntity gameEntity) {
		this.gameEntity = gameEntity;
	}

}
