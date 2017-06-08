package cz.jkoudelka.tictactoe.entityDomain.services.impl;

import cz.jkoudelka.tictactoe.DAO.GenericEntityDAO;
import cz.jkoudelka.tictactoe.app.DAOLocator;
import cz.jkoudelka.tictactoe.entityDomain.LogEntity;
import cz.jkoudelka.tictactoe.entityDomain.services.LogEntityService;

public class LogEntityServiceImpl implements LogEntityService {

	@Override
	public GenericEntityDAO<LogEntity> getDAO() {
		return DAOLocator.getInstance().getLogDAO();
	}

}
