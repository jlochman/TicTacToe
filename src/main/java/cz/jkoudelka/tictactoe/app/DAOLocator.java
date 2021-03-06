package cz.jkoudelka.tictactoe.app;

import cz.jkoudelka.tictactoe.DAO.GameEntityDAO;
import cz.jkoudelka.tictactoe.DAO.GameLogEntityDAO;
import cz.jkoudelka.tictactoe.DAO.LogEntityDAO;
import cz.jkoudelka.tictactoe.DAO.PlayerEntityDAO;
import cz.jkoudelka.tictactoe.DAO.PlayerLogEntityDAO;
import cz.jkoudelka.tictactoe.DAO.database.GameEntityDatabaseDAO;
import cz.jkoudelka.tictactoe.DAO.database.GameLogEntityDatabaseDAO;
import cz.jkoudelka.tictactoe.DAO.database.LogEntityDatabaseDAO;
import cz.jkoudelka.tictactoe.DAO.database.PlayerEntityDatabaseDAO;
import cz.jkoudelka.tictactoe.DAO.database.PlayerLogEntityDatabaseDAO;

/**
 * Navrhovy vzor Singleton (jedna instance na aplikaci). Zprostredkovava pristup
 * k DAO, ktere inicializuje.
 * 
 * @author jlochman
 *
 */
public class DAOLocator {

	private LogEntityDAO logDAO;
	private PlayerEntityDAO playerDAO;
	private PlayerLogEntityDAO playerLogDAO;
	private GameEntityDAO gameDAO;
	private GameLogEntityDAO gameLogDAO;

	private static DAOLocator instance;

	/**
	 * privatni constructor
	 */
	private DAOLocator() {
	}

	/**
	 * jediny zpusob, jak je mozno ziskat instanci teto tridy
	 * 
	 * @return instance DAOLocatoru
	 */
	public static DAOLocator getInstance() {
		if (instance == null) {
			instance = new DAOLocator();
		}
		return instance;
	}

	/**
	 * inicializuje veskere DAO - DAO jsou v deklaraci typovany na interface,
	 * ale inicializuju je jako ...DatabaseDAO, tj. uz konkretni implementaci,
	 * ktera zprostredkovava pristup do DB.
	 */
	public void initializeDAOs() {
		logDAO = new LogEntityDatabaseDAO();
		playerDAO = new PlayerEntityDatabaseDAO();
		playerLogDAO = new PlayerLogEntityDatabaseDAO();
		gameDAO = new GameEntityDatabaseDAO();
		gameLogDAO = new GameLogEntityDatabaseDAO();
	}

	public LogEntityDAO getLogDAO() {
		return logDAO;
	}

	public PlayerEntityDAO getPlayerDAO() {
		return playerDAO;
	}

	public PlayerLogEntityDAO getPlayerLogDAO() {
		return playerLogDAO;
	}

	public GameEntityDAO getGameDAO() {
		return gameDAO;
	}

	public GameLogEntityDAO getGameLogDAO() {
		return gameLogDAO;
	}

}
