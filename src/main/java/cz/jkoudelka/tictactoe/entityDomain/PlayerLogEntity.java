package cz.jkoudelka.tictactoe.entityDomain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * Tabulka s logy pro daneho hrace. Obshuje {@link #player} coz je vazna N:1 na
 * konretni {@link PlayerEntity}.
 * 
 * @author jlochman
 *
 */
@Entity
public class PlayerLogEntity extends PersistenceLogObject {

	@ManyToOne(fetch = FetchType.LAZY)
	private PlayerEntity player;

	public PlayerEntity getPlayer() {
		return player;
	}

	public void setPlayer(PlayerEntity player) {
		this.player = player;
	}

}
