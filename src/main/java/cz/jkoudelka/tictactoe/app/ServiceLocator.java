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
import cz.jkoudelka.tictactoe.game.BoardService;
import cz.jkoudelka.tictactoe.game.GameInstanceService;
import cz.jkoudelka.tictactoe.observer.ObserverManager;

public class ServiceLocator {

	private DatabaseService dbService;

	private GameEntityService gameEntityService;
	private GameLogEntityService gameLogEntityService;
	private PlayerEntityService playerEntityService;
	private PlayerLogEntityService playerLogEntityService;
	private LogEntityService logEntityService;

	private BoardService boardService;
	private GameInstanceService gameInstanceService;

	private ObserverManager observerManager;

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

		logEntityService = new LogEntityServiceImpl();
		gameEntityService = new GameEntityServiceImpl();
		gameLogEntityService = new GameLogEntityServiceImpl();
		playerEntityService = new PlayerEntityServiceImpl();
		playerLogEntityService = new PlayerLogEntityServiceImpl();

		boardService = new BoardService();
		gameInstanceService = new GameInstanceService();

		observerManager = new ObserverManager();
	}

	public DatabaseService getDBService() {
		return dbService;
	}

	public GameEntityService getGameEntityService() {
		return gameEntityService;
	}

	public GameLogEntityService getGameLogEntityService() {
		return gameLogEntityService;
	}

	public PlayerEntityService getPlayerEntityService() {
		return playerEntityService;
	}

	public PlayerLogEntityService getPlayerLogEntityService() {
		return playerLogEntityService;
	}

	public LogEntityService getLogEntityService() {
		return logEntityService;
	}

	public BoardService getBoardService() {
		return boardService;
	}

	public GameInstanceService getGameInstanceService() {
		return gameInstanceService;
	}

	public ObserverManager getObserverManager() {
		return observerManager;
	}

}
