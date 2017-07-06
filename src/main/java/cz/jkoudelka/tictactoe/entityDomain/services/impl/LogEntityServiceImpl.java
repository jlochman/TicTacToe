package cz.jkoudelka.tictactoe.entityDomain.services.impl;

import java.util.Date;

import cz.jkoudelka.tictactoe.DAO.GenericEntityDAO;
import cz.jkoudelka.tictactoe.app.DAOLocator;
import cz.jkoudelka.tictactoe.entityDomain.LogEntity;
import cz.jkoudelka.tictactoe.entityDomain.enums.LogLevel;
import cz.jkoudelka.tictactoe.entityDomain.services.LogEntityService;

/**
 * Implementace servicy nad {@link LogEntity}.
 * 
 * @author jlochman
 *
 */
public class LogEntityServiceImpl implements LogEntityService {

	@Override
	public GenericEntityDAO<LogEntity> getDAO() {
		return DAOLocator.getInstance().getLogDAO();
	}

	@Override
	public void log(String msg, LogLevel level) {
		LogEntity log = new LogEntity();
		log.setMsg(msg);
		log.setLogLevel(level);
		log.setLoggedDate(new Date());
		persist(log);
	}

}
