package cz.jkoudelka.tictactoe.entityDomain.services.impl;

import cz.jkoudelka.tictactoe.DAO.GenericEntityDAO;
import cz.jkoudelka.tictactoe.app.ServiceLocator;
import cz.jkoudelka.tictactoe.entityDomain.LogEntity;
import cz.jkoudelka.tictactoe.entityDomain.services.LogEntityService;

public class LogEntityServiceImpl implements LogEntityService {

	@Override
	public GenericEntityDAO<LogEntity> getDAO() {
		return ServiceLocator.getInstance().getDaos().getLogDAO();
	}

}
