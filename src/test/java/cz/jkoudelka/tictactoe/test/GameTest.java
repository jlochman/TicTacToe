package cz.jkoudelka.tictactoe.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import cz.jkoudelka.tictactoe.app.ServiceLocator;
import cz.jkoudelka.tictactoe.entityDomain.enums.GameResult;
import cz.jkoudelka.tictactoe.gameInstance.Board;
import cz.jkoudelka.tictactoe.gameInstance.GameInstance;
import cz.jkoudelka.tictactoe.gameInstance.GameInstanceService;

public class GameTest {

	@Test
	public void parseTest() throws IOException {
		ServiceLocator.getInstance().initializeService();
		GameInstanceService gameService = ServiceLocator.getInstance().getGameInstanceService();

		GameInstance game = new GameInstance();
		gameService.playPlayer(game, 0, 0);
		gameService.playCPU(game, 0, 1);

		String s = gameService.stringify(game);
		assertNotNull(s);

		GameInstance parsedGame = gameService.parse(s);
		assertEquals(parsedGame.getBoards().size(), game.getBoards().size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void illegalPlayerMoveTest() throws JsonProcessingException {
		ServiceLocator.getInstance().initializeService();
		GameInstanceService gameService = ServiceLocator.getInstance().getGameInstanceService();

		GameInstance game = new GameInstance();
		gameService.playPlayer(game, 0, 0);
		gameService.playCPU(game, 0, 1);
		gameService.playPlayer(game, 0, 0);
	}

	@Test
	public void rowWinTest() {
		ServiceLocator.getInstance().initializeService();
		GameInstanceService gameService = ServiceLocator.getInstance().getGameInstanceService();

		for (int row = 0; row < Board.ROWS; row++) {
			GameInstance game = new GameInstance();
			gameService.playPlayer(game, row, 0);
			gameService.playPlayer(game, row, 1);
			gameService.playPlayer(game, row, 2);
			assertEquals(gameService.checkResult(game), GameResult.PLAYER_WINS);
		}

	}

	@Test
	public void colWinTest() {
		ServiceLocator.getInstance().initializeService();
		GameInstanceService gameService = ServiceLocator.getInstance().getGameInstanceService();

		for (int col = 0; col < Board.COLS; col++) {
			GameInstance game = new GameInstance();
			gameService.playPlayer(game, 0, col);
			gameService.playPlayer(game, 1, col);
			gameService.playPlayer(game, 2, col);
			assertEquals(gameService.checkResult(game), GameResult.PLAYER_WINS);
		}
	}

	@Test
	public void diagWinTest() {
		ServiceLocator.getInstance().initializeService();
		GameInstanceService gameService = ServiceLocator.getInstance().getGameInstanceService();

		GameInstance game = new GameInstance();
		gameService.playPlayer(game, 0, 0);
		gameService.playPlayer(game, 1, 1);
		gameService.playPlayer(game, 2, 2);
		assertEquals(gameService.checkResult(game), GameResult.PLAYER_WINS);

		game = new GameInstance();
		gameService.playPlayer(game, 2, 0);
		gameService.playPlayer(game, 1, 1);
		gameService.playPlayer(game, 0, 2);
		assertEquals(gameService.checkResult(game), GameResult.PLAYER_WINS);

	}

}
