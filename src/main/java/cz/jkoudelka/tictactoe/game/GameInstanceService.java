package cz.jkoudelka.tictactoe.game;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import cz.jkoudelka.tictactoe.app.ServiceLocator;
import cz.jkoudelka.tictactoe.entityDomain.enums.GameResult;
import cz.jkoudelka.tictactoe.game.Board.BoardTile;
import cz.jkoudelka.tictactoe.utils.JSONUtils;

public class GameInstanceService {

	private BoardService boardService = ServiceLocator.getInstance().getBoardService();

	public String stringify(GameInstance game) throws JsonProcessingException {
		return JSONUtils.objectToString(game);
	}

	public GameInstance parse(String s) throws JsonParseException, JsonMappingException, IOException {
		if (s == null) {
			return new GameInstance();
		}
		return JSONUtils.stringToObject(s, GameInstance.class);
	}

	public Board getLastBoard(GameInstance game) {
		Board board;
		if (game.getBoards().size() == 0) {
			board = new Board();
		} else {
			board = game.getBoards().get(game.getBoards().size() - 1);
		}
		return boardService.copyBoard(board);
	}

	public GameResult checkResult(GameInstance game) {
		return boardService.checkResult(getLastBoard(game));
	}

	public void playCPU(GameInstance game, int row, int col) {
		Board board = getLastBoard(game);
		if (board.getTile(row, col) != BoardTile.EMTPY) {
			throw new IllegalArgumentException("Board tile is not empty");
		}
		board.setTile(row, col, BoardTile.CPU);
		game.addBoard(board);
	}

	public void playPlayer(GameInstance game, int row, int col) {
		Board board = getLastBoard(game);
		if (board.getTile(row, col) != BoardTile.EMTPY) {
			throw new IllegalArgumentException("Board tile is not empty");
		}
		board.setTile(row, col, BoardTile.PLAYER);
		game.addBoard(board);
	}

}
