package cz.jkoudelka.tictactoe.entityDomain.services.impl;

import cz.jkoudelka.tictactoe.DAO.GenericEntityDAO;
import cz.jkoudelka.tictactoe.app.ServiceLocator;
import cz.jkoudelka.tictactoe.entityDomain.GameEntity;
import cz.jkoudelka.tictactoe.entityDomain.services.GameEntityService;

public class GameEntityServiceImpl implements GameEntityService {

	@Override
	public GenericEntityDAO<GameEntity> getDAO() {
		return ServiceLocator.getInstance().getDaos().getGameDAO();
	}

}
