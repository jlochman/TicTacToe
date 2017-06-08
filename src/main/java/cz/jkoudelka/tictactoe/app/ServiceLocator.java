package cz.jkoudelka.tictactoe.app;

import cz.jkoudelka.tictactoe.DAO.database.DatabaseService;
import cz.jkoudelka.tictactoe.entityDomain.services.GameEntityService;
import cz.jkoudelka.tictactoe.entityDomain.services.GameLogEntityService;
import cz.jkoudelka.tictactoe.entityDomain.services.LogEntityService;
import cz.jkoudelka.tictactoe.entityDomain.services.PlayerEntityService;
import cz.jkoudelka.tictactoe.entityDomain.services.PlayerLogEntityService;
import cz.jkoudelka.tictactoe.entityDomain.services.impl.GameEntityServiceImpl;
import cz.jkoudelka.tictactoe.entityDomain.services.impl.GameLogEntityServiceImpl;
import cz.jkoudelka.tictactoe.entityDomain.services.impl.LogEntityServiceImpl;
import cz.jkoudelka.tictactoe.entityDomain.services.impl.PlayerEntityServiceImpl;
import cz.jkoudelka.tictactoe.entityDomain.services.impl.PlayerLogEntityServiceImpl;

public class ServiceLocator {

	private DatabaseService dbService;

	private LogEntityService logService;
	private GameEntityService gameService;
	private GameLogEntityService gameLogService;
	private PlayerEntityService playerService;
	private PlayerLogEntityService playerLogService;

	private static ServiceLocator instance;

	private ServiceLocator() {
	}

	public static ServiceLocator getInstance() {
		if (instance == null) {
			instance = new ServiceLocator();
		}
		return instance;
	}

	public void initializeService() {
		dbService = new DatabaseService();

		logService = new LogEntityServiceImpl();
		gameService = new GameEntityServiceImpl();
		gameLogService = new GameLogEntityServiceImpl();
		playerService = new PlayerEntityServiceImpl();
		playerLogService = new PlayerLogEntityServiceImpl();
	}

	public DatabaseService getDBService() {
		return dbService;
	}

	public LogEntityService getLogService() {
		return logService;
	}

	public GameEntityService getGameService() {
		return gameService;
	}

	public GameLogEntityService getGameLogService() {
		return gameLogService;
	}

	public PlayerEntityService getPlayerService() {
		return playerService;
	}

	public PlayerLogEntityService getPlayerLogService() {
		return playerLogService;
	}

}
