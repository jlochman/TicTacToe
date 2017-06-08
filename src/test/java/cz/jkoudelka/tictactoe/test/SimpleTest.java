package cz.jkoudelka.tictactoe.test;

import org.junit.Test;

import cz.jkoudelka.tictactoe.app.DAOLocator;
import cz.jkoudelka.tictactoe.app.ServiceLocator;
import cz.jkoudelka.tictactoe.entityDomain.GameEntity;
import cz.jkoudelka.tictactoe.entityDomain.GameLogEntity;
import cz.jkoudelka.tictactoe.entityDomain.PlayerEntity;
import cz.jkoudelka.tictactoe.entityDomain.PlayerLogEntity;
import cz.jkoudelka.tictactoe.entityDomain.enums.LogLevel;
import cz.jkoudelka.tictactoe.entityDomain.services.PlayerEntityService;

public class SimpleTest {

	@Test
	public void simpleTest() {
		DAOLocator.getInstance().initializeDAOs();
		ServiceLocator.getInstance().initializeService();

		PlayerEntityService playerEntityService = ServiceLocator.getInstance().getPlayerEntityService();

		PlayerEntity player = new PlayerEntity();
		player.setName("Jan Lochman");
		player.setPwd("pwd");

		PlayerLogEntity playerLog = new PlayerLogEntity();
		playerLog.setLogLevel(LogLevel.WARN);
		playerLog.setMsg("newPlayer");
		player.addLogs(playerLog);

		GameEntity game = new GameEntity();
		game.setHistory("gameHistory, JSON");
		player.addGames(game);

		GameLogEntity gameLog = new GameLogEntity();
		gameLog.setLogLevel(LogLevel.INFO);
		gameLog.setMsg("testMSG");
		game.addLogs(gameLog);

		playerEntityService.persist(player);

		player.setPwd("newPWD");
		playerEntityService.update(player);
	}

}
