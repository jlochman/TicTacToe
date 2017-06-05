package cz.jkoudelka.tictactoe.DAO.database;

import cz.jkoudelka.tictactoe.DAO.LogEntityDAO;
import cz.jkoudelka.tictactoe.entityDomain.LogEntity;

public class LogEntityDatabaseDAO implements GenericEntityDatabaseDAO<LogEntity>, LogEntityDAO {

	@Override
	public Class<LogEntity> getEntityClass() {
		return LogEntity.class;
	}

}
