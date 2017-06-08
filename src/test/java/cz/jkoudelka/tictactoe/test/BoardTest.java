package cz.jkoudelka.tictactoe.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import cz.jkoudelka.tictactoe.app.ServiceLocator;
import cz.jkoudelka.tictactoe.game.Board;
import cz.jkoudelka.tictactoe.game.BoardService;

public class BoardTest {

	@Test
	public void parseTest() throws JsonParseException, JsonMappingException, IOException {
		ServiceLocator.getInstance().initializeService();
		BoardService boardService = ServiceLocator.getInstance().getBoardService();

		Board board = new Board();
		String s = boardService.stringify(board);
		assertNotNull(s);

		Board parsedBoard = boardService.parse(s);
		for (int row = 0; row < Board.ROWS; row++) {
			for (int col = 0; col < Board.COLS; col++) {
				assertEquals(board.getTile(row, col), parsedBoard.getTile(row, col));
			}
		}
	}

}
