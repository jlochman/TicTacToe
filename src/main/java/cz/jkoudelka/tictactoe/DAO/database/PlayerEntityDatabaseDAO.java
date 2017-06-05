package cz.jkoudelka.tictactoe.DAO.database;

import cz.jkoudelka.tictactoe.DAO.PlayerEntityDAO;
import cz.jkoudelka.tictactoe.entityDomain.PlayerEntity;

public class PlayerEntityDatabaseDAO implements GenericEntityDatabaseDAO<PlayerEntity>, PlayerEntityDAO {

	@Override
	public Class<PlayerEntity> getEntityClass() {
		return PlayerEntity.class;
	}

}
