package cz.jkoudelka.tictactoe.gameInstance;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import cz.jkoudelka.tictactoe.entityDomain.enums.GameResult;
import cz.jkoudelka.tictactoe.gameInstance.Board.BoardTile;
import cz.jkoudelka.tictactoe.utils.JSONUtils;

/**
 * Servica poskytujici metody pro praci s {@link Board}
 * 
 * @author jlochman
 *
 */
public class BoardService {

	/**
	 * Prevod board na String
	 * 
	 * @param board
	 * @return
	 * @throws JsonProcessingException
	 */
	public String stringify(Board board) throws JsonProcessingException {
		return JSONUtils.objectToString(board);
	}

	/**
	 * Prevod Stringu na board
	 * 
	 * @param s
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public Board parse(String s) throws JsonParseException, JsonMappingException, IOException {
		return JSONUtils.stringToObject(s, Board.class);
	}

	/**
	 * Prekopirovani board do nove promenne.
	 * 
	 * @param board
	 * @return
	 */
	public Board copyBoard(Board board) {
		Board newBoard = new Board();
		for (int row = 0; row < Board.ROWS; row++) {
			for (int col = 0; col < Board.COLS; col++) {
				newBoard.setTile(row, col, board.getTile(row, col));
			}
		}
		return newBoard;
	}

	/**
	 * Zkontroluje, zda dana board uz nevede k neci vyhre
	 * 
	 * @param board
	 * @return
	 */
	public GameResult checkResult(Board board) {
		if (isAnythingConnected(board, BoardTile.PLAYER)) {
			return GameResult.PLAYER_WINS;
		}
		if (isAnythingConnected(board, BoardTile.CPU)) {
			return GameResult.CPU_WINS;
		}
		if (countTiles(board, BoardTile.EMTPY) == 0) {
			return GameResult.SPLIT;
		} else {
			return GameResult.DNF;
		}
	}

	/**
	 * Spocita, kolik poli daneho typu board obsahuje
	 * 
	 * @param board
	 * @param tile
	 * @return
	 */
	public int countTiles(Board board, BoardTile tile) {
		int count = 0;
		for (int row = 0; row < Board.ROWS; row++) {
			for (int col = 0; col < Board.COLS; col++) {
				if (board.getTile(row, col) == tile) {
					count++;
				}
			}
		}
		return count;
	}

	private boolean isAnythingConnected(Board board, BoardTile tile) {
		return isAnyRowConnected(board, tile) || isAnyColConnected(board, tile) || isAnyDiagConnected(board, tile);
	}

	private boolean isAnyRowConnected(Board board, BoardTile tile) {
		for (int row = 0; row < Board.ROWS; row++) {
			for (int col = 0; col < Board.COLS; col++) {
				if (board.getTile(row, col) != tile) {
					break;
				}
				if (col == Board.COLS - 1) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isAnyColConnected(Board board, BoardTile tile) {
		for (int col = 0; col < Board.COLS; col++) {
			for (int row = 0; row < Board.ROWS; row++) {

				if (board.getTile(row, col) != tile) {
					break;
				}
				if (row == Board.ROWS - 1) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isAnyDiagConnected(Board board, BoardTile tile) {

		for (int i = 0; i < Board.COLS; i++) {
			if (board.getTile(i, i) != tile) {
				break;
			}
			if (i == Board.COLS - 1) {
				return true;
			}
		}

		for (int row = 0, col = Board.COLS - 1; row < Board.ROWS; row++, col--) {
			if (board.getTile(row, col) != tile) {
				break;
			}
			if (row == Board.ROWS - 1) {
				return true;
			}
		}

		return false;
	}

}
