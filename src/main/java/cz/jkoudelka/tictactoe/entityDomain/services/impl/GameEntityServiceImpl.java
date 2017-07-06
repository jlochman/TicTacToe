package cz.jkoudelka.tictactoe.entityDomain.services.impl;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import cz.jkoudelka.tictactoe.DAO.GenericEntityDAO;
import cz.jkoudelka.tictactoe.app.DAOLocator;
import cz.jkoudelka.tictactoe.app.ServiceLocator;
import cz.jkoudelka.tictactoe.entityDomain.GameEntity;
import cz.jkoudelka.tictactoe.entityDomain.GameLogEntity;
import cz.jkoudelka.tictactoe.entityDomain.enums.LogLevel;
import cz.jkoudelka.tictactoe.entityDomain.services.GameEntityService;
import cz.jkoudelka.tictactoe.game.GameInstance;

public class GameEntityServiceImpl implements GameEntityService {

	@Override
	public GenericEntityDAO<GameEntity> getDAO() {
		return DAOLocator.getInstance().getGameDAO();
	}

	@Override
	public GameInstance getGameInstance(GameEntity entity) {
		if (entity.getHistory() == null) {
			return new GameInstance();
		}

		try {
			return ServiceLocator.getInstance().getGameInstanceService().parse(entity.getHistory());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new GameInstance();
	}

	@Override
	public void setGameInstance(GameEntity entity, GameInstance game) {
		try {
			entity.setHistory(ServiceLocator.getInstance().getGameInstanceService().stringify(game));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void log(GameEntity entity, String msg, LogLevel level) {
		GameLogEntity log = new GameLogEntity();
		log.setGame(entity);
		log.setMsg(msg);
		log.setLogLevel(level);
		log.setLoggedDate(new Date());
		ServiceLocator.getInstance().getGameLogEntityService().persist(log);
	}

}
