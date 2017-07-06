package cz.jkoudelka.tictactoe.entityDomain.services.impl;

import java.util.Date;

import cz.jkoudelka.tictactoe.DAO.GenericEntityDAO;
import cz.jkoudelka.tictactoe.app.DAOLocator;
import cz.jkoudelka.tictactoe.app.ServiceLocator;
import cz.jkoudelka.tictactoe.entityDomain.PlayerEntity;
import cz.jkoudelka.tictactoe.entityDomain.PlayerLogEntity;
import cz.jkoudelka.tictactoe.entityDomain.enums.LogLevel;
import cz.jkoudelka.tictactoe.entityDomain.services.PlayerEntityService;

/**
 * Implementace servicy nad {@link PlayerEntity}.
 * 
 * @author jlochman
 *
 */
public class PlayerEntityServiceImpl implements PlayerEntityService {

	@Override
	public GenericEntityDAO<PlayerEntity> getDAO() {
		return DAOLocator.getInstance().getPlayerDAO();
	}

	@Override
	public void log(PlayerEntity entity, String msg, LogLevel level) {
		PlayerLogEntity log = new PlayerLogEntity();
		log.setPlayer(entity);
		log.setMsg(msg);
		log.setLogLevel(level);
		log.setLoggedDate(new Date());
		ServiceLocator.getInstance().getPlayerLogEntityService().persist(log);
	}

}
