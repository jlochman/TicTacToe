package cz.jkoudelka.tictactoe.entityDomain.services.impl;

import java.util.Date;

import cz.jkoudelka.tictactoe.DAO.GenericEntityDAO;
import cz.jkoudelka.tictactoe.app.DAOLocator;
import cz.jkoudelka.tictactoe.entityDomain.GameEntity;
import cz.jkoudelka.tictactoe.entityDomain.GameLogEntity;
import cz.jkoudelka.tictactoe.entityDomain.enums.LogLevel;
import cz.jkoudelka.tictactoe.entityDomain.services.GameLogEntityService;

public class GameLogEntityServiceImpl implements GameLogEntityService {

	@Override
	public GenericEntityDAO<GameLogEntity> getDAO() {
		return DAOLocator.getInstance().getGameLogDAO();
	}

	@Override
	public void info(GameEntity game, String msg) {
		log(game, msg, LogLevel.INFO);
	}

	@Override
	public void warn(GameEntity game, String msg) {
		log(game, msg, LogLevel.WARN);

	}

	@Override
	public void error(GameEntity game, String msg) {
		log(game, msg, LogLevel.ERROR);
	}

	private void log(GameEntity game, String msg, LogLevel level) {
		GameLogEntity log = new GameLogEntity();
		log.setGame(game);
		log.setMsg(msg);
		log.setLogLevel(level);
		log.setLoggedDate(new Date());
		persist(log);
	}

}
