package cz.jkoudelka.tictactoe.DAO.database;

import cz.jkoudelka.tictactoe.DAO.GameEntityDAO;
import cz.jkoudelka.tictactoe.entityDomain.GameEntity;

public class GameEntityDatabaseDAO implements GenericEntityDatabaseDAO<GameEntity>, GameEntityDAO {

	@Override
	public Class<GameEntity> getEntityClass() {
		return GameEntity.class;
	}

}
