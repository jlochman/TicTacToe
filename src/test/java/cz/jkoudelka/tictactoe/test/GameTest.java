package cz.jkoudelka.tictactoe.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import cz.jkoudelka.tictactoe.app.ServiceLocator;
import cz.jkoudelka.tictactoe.game.Game;
import cz.jkoudelka.tictactoe.game.GameService;

public class GameTest {

	@Test
	public void parseTest() throws IOException {
		ServiceLocator.getInstance().initializeService();
		GameService gameService = ServiceLocator.getInstance().getGameService();

		Game game = new Game();
		gameService.playPlayer(game, 0, 0);
		gameService.playCPU(game, 0, 1);

		String s = gameService.stringify(game);
		assertNotNull(s);

		Game parsedGame = gameService.parse(s);
		assertEquals(parsedGame.getBoards().size(), game.getBoards().size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void illegalPlayerMoveTest() throws JsonProcessingException {
		ServiceLocator.getInstance().initializeService();
		GameService gameService = ServiceLocator.getInstance().getGameService();

		Game game = new Game();
		gameService.playPlayer(game, 0, 0);
		gameService.playCPU(game, 0, 1);
		gameService.playPlayer(game, 0, 0);
	}

}
