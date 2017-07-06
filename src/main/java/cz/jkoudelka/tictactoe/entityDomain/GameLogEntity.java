package cz.jkoudelka.tictactoe.entityDomain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * Tato entita obsahuje logy vazane na konkretni entitu hry. Paremter
 * {@link #game} obsahuje vazby N:1 na konkretni entitu {@link GameEntity}.
 * 
 * @author jlochman
 *
 */
@Entity
public class GameLogEntity extends PersistenceLogObject {

	@ManyToOne(fetch = FetchType.LAZY)
	private GameEntity game;

	public GameEntity getGame() {
		return game;
	}

	public void setGame(GameEntity game) {
		this.game = game;
	}

}
