package cz.jkoudelka.tictactoe.entityDomain.services.impl;

import java.util.Date;

import cz.jkoudelka.tictactoe.DAO.GenericEntityDAO;
import cz.jkoudelka.tictactoe.app.DAOLocator;
import cz.jkoudelka.tictactoe.entityDomain.LogEntity;
import cz.jkoudelka.tictactoe.entityDomain.enums.LogLevel;
import cz.jkoudelka.tictactoe.entityDomain.services.LogEntityService;

public class LogEntityServiceImpl implements LogEntityService {

	@Override
	public GenericEntityDAO<LogEntity> getDAO() {
		return DAOLocator.getInstance().getLogDAO();
	}

	@Override
	public void info(String msg) {
		log(msg, LogLevel.INFO);
	}

	@Override
	public void warn(String msg) {
		log(msg, LogLevel.WARN);
	}

	@Override
	public void error(String msg) {
		log(msg, LogLevel.ERROR);
	}

	private void log(String msg, LogLevel level) {
		LogEntity log = new LogEntity();
		log.setMsg(msg);
		log.setLogLevel(level);
		log.setLoggedDate(new Date());
		persist(log);
	}

}
