package cz.jkoudelka.tictactoe.DAO.database;

import cz.jkoudelka.tictactoe.DAO.GameLogEntityDAO;
import cz.jkoudelka.tictactoe.entityDomain.GameLogEntity;

public class GameLogEntityDatabaseDAO implements GenericEntityDatabaseDAO<GameLogEntity>, GameLogEntityDAO {

	@Override
	public Class<GameLogEntity> getEntityClass() {
		return GameLogEntity.class;
	}

}
