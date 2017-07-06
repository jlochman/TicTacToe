package cz.jkoudelka.tictactoe.gameInstance;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import cz.jkoudelka.tictactoe.app.ServiceLocator;
import cz.jkoudelka.tictactoe.entityDomain.enums.GameResult;
import cz.jkoudelka.tictactoe.gameInstance.Board.BoardTile;
import cz.jkoudelka.tictactoe.utils.JSONUtils;

/**
 * Servica nad GameInstance.
 * 
 * @author jlochman
 *
 */
public class GameInstanceService {

	private BoardService boardService = ServiceLocator.getInstance().getBoardService();

	/**
	 * Prevod gameInstance na String
	 * 
	 * @param gameInstance
	 * @return
	 * @throws JsonProcessingException
	 */
	public String stringify(GameInstance gameInstance) throws JsonProcessingException {
		return JSONUtils.objectToString(gameInstance);
	}

	/**
	 * Prevod Stringu na gameInstance
	 * 
	 * @param s
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public GameInstance parse(String s) throws JsonParseException, JsonMappingException, IOException {
		if (s == null) {
			return new GameInstance();
		}
		return JSONUtils.stringToObject(s, GameInstance.class);
	}

	/**
	 * Vraci posledni stav.
	 * 
	 * @param gameInstance
	 * @return
	 */
	public Board getLastBoard(GameInstance gameInstance) {
		Board board;
		if (gameInstance.getBoards().size() == 0) {
			board = new Board();
		} else {
			board = gameInstance.getBoards().get(gameInstance.getBoards().size() - 1);
		}
		return boardService.copyBoard(board);
	}

	/**
	 * 
	 * Kontrola vysledku hry
	 * 
	 * @param gameInstance
	 * @return
	 */
	public GameResult checkResult(GameInstance gameInstance) {
		return boardService.checkResult(getLastBoard(gameInstance));
	}

	/**
	 * Zahraje hrac
	 * 
	 * @param gameInstance
	 * @param row
	 * @param col
	 */
	public void playCPU(GameInstance gameInstance, int row, int col) {
		Board board = getLastBoard(gameInstance);
		if (board.getTile(row, col) != BoardTile.EMTPY) {
			throw new IllegalArgumentException("Board tile is not empty");
		}
		board.setTile(row, col, BoardTile.CPU);
		gameInstance.addBoard(board);
	}

	/**
	 * Zahraje CPU
	 * 
	 * @param gameInstance
	 * @param row
	 * @param col
	 */
	public void playPlayer(GameInstance gameInstance, int row, int col) {
		Board board = getLastBoard(gameInstance);
		if (board.getTile(row, col) != BoardTile.EMTPY) {
			throw new IllegalArgumentException("Board tile is not empty");
		}
		board.setTile(row, col, BoardTile.PLAYER);
		gameInstance.addBoard(board);
	}

}
