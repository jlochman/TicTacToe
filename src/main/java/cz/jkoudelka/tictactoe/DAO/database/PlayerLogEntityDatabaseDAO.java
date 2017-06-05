package cz.jkoudelka.tictactoe.DAO.database;

import cz.jkoudelka.tictactoe.DAO.PlayerLogEntityDAO;
import cz.jkoudelka.tictactoe.entityDomain.PlayerLogEntity;

public class PlayerLogEntityDatabaseDAO implements GenericEntityDatabaseDAO<PlayerLogEntity>, PlayerLogEntityDAO {

	@Override
	public Class<PlayerLogEntity> getEntityClass() {
		return PlayerLogEntity.class;
	}

}
