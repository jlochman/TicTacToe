package cz.jkoudelka.tictactoe.entityDomain.services.impl;

import cz.jkoudelka.tictactoe.DAO.GenericEntityDAO;
import cz.jkoudelka.tictactoe.app.ServiceLocator;
import cz.jkoudelka.tictactoe.entityDomain.GameLogEntity;
import cz.jkoudelka.tictactoe.entityDomain.services.GameLogEntityService;

public class GameLogEntityServiceImpl implements GameLogEntityService {

	@Override
	public GenericEntityDAO<GameLogEntity> getDAO() {
		return ServiceLocator.getInstance().getDaos().getGameLogDAO();
	}

}
