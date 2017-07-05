package cz.jkoudelka.tictactoe.entityDomain.services.impl;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import cz.jkoudelka.tictactoe.DAO.GenericEntityDAO;
import cz.jkoudelka.tictactoe.app.DAOLocator;
import cz.jkoudelka.tictactoe.app.ServiceLocator;
import cz.jkoudelka.tictactoe.entityDomain.GameEntity;
import cz.jkoudelka.tictactoe.entityDomain.services.GameEntityService;
import cz.jkoudelka.tictactoe.game.Game;

public class GameEntityServiceImpl implements GameEntityService {

	@Override
	public GenericEntityDAO<GameEntity> getDAO() {
		return DAOLocator.getInstance().getGameDAO();
	}

	@Override
	public Game getGame(GameEntity entity) {
		if (entity.getHistory() == null) {
			return new Game();
		}

		try {
			return ServiceLocator.getInstance().getGameService().parse(entity.getHistory());
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

		return new Game();
	}

	@Override
	public void setGame(GameEntity entity, Game game) {
		try {
			entity.setHistory(ServiceLocator.getInstance().getGameService().stringify(game));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
