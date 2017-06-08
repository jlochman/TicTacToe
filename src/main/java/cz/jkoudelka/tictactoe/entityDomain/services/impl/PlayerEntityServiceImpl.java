package cz.jkoudelka.tictactoe.entityDomain.services.impl;

import cz.jkoudelka.tictactoe.DAO.GenericEntityDAO;
import cz.jkoudelka.tictactoe.app.DAOLocator;
import cz.jkoudelka.tictactoe.entityDomain.PlayerEntity;
import cz.jkoudelka.tictactoe.entityDomain.services.PlayerEntityService;

public class PlayerEntityServiceImpl implements PlayerEntityService {

	@Override
	public GenericEntityDAO<PlayerEntity> getDAO() {
		return DAOLocator.getInstance().getPlayerDAO();
	}

}
