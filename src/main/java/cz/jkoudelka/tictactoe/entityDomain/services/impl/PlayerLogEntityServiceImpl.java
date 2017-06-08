package cz.jkoudelka.tictactoe.entityDomain.services.impl;

import java.util.Date;

import cz.jkoudelka.tictactoe.DAO.GenericEntityDAO;
import cz.jkoudelka.tictactoe.app.DAOLocator;
import cz.jkoudelka.tictactoe.entityDomain.PlayerEntity;
import cz.jkoudelka.tictactoe.entityDomain.PlayerLogEntity;
import cz.jkoudelka.tictactoe.entityDomain.enums.LogLevel;
import cz.jkoudelka.tictactoe.entityDomain.services.PlayerLogEntityService;

public class PlayerLogEntityServiceImpl implements PlayerLogEntityService {

	@Override
	public GenericEntityDAO<PlayerLogEntity> getDAO() {
		return DAOLocator.getInstance().getPlayerLogDAO();
	}

	@Override
	public void info(PlayerEntity player, String msg) {
		log(player, msg, LogLevel.INFO);
	}

	@Override
	public void warn(PlayerEntity player, String msg) {
		log(player, msg, LogLevel.WARN);
	}

	@Override
	public void error(PlayerEntity player, String msg) {
		log(player, msg, LogLevel.ERROR);
	}

	private void log(PlayerEntity player, String msg, LogLevel level) {
		PlayerLogEntity log = new PlayerLogEntity();
		log.setPlayer(player);
		log.setMsg(msg);
		log.setLogLevel(level);
		log.setLoggedDate(new Date());
		persist(log);
	}

}
