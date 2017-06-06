package cz.jkoudelka.tictactoe.entityDomain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

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
