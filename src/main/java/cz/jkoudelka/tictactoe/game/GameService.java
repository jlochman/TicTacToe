package cz.jkoudelka.tictactoe.game;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import cz.jkoudelka.tictactoe.app.ServiceLocator;
import cz.jkoudelka.tictactoe.entityDomain.enums.GameResult;
import cz.jkoudelka.tictactoe.game.Board.BoardTile;
import cz.jkoudelka.tictactoe.utils.JSONUtils;

public class GameService {

	private BoardService boardService = ServiceLocator.getInstance().getBoardService();

	public String stringify(Game game) throws JsonProcessingException {
		return JSONUtils.objectToString(game);
	}

	public Game parse(String s) throws JsonParseException, JsonMappingException, IOException {
		return JSONUtils.stringToObject(s, Game.class);
	}

	public Board getLastBoard(Game game) {
		Board lastBoard = game.getBoards().get(game.getBoards().size() - 1);
		return boardService.copyBoard(lastBoard);
	}

	public GameResult checkResult(Game game) {
		return boardService.checkResult(getLastBoard(game));
	}

	public void playCPU(Game game, int row, int col) {
		Board board = getLastBoard(game);
		if (board.getTile(row, col) != BoardTile.EMTPY) {
			throw new IllegalArgumentException("Board tile is not empty");
		}
		board.setTile(row, col, BoardTile.CPU);
		game.addBoard(board);
	}

	public void playPlayer(Game game, int row, int col) {
		Board board = getLastBoard(game);
		if (board.getTile(row, col) != BoardTile.EMTPY) {
			throw new IllegalArgumentException("Board tile is not empty");
		}
		board.setTile(row, col, BoardTile.PLAYER);
		game.addBoard(board);
	}

}
