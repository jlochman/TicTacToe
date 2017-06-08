package cz.jkoudelka.tictactoe.game;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import cz.jkoudelka.tictactoe.entityDomain.enums.GameResult;
import cz.jkoudelka.tictactoe.utils.JSONUtils;

public class BoardService {

	public String stringify(Board board) throws JsonProcessingException {
		return JSONUtils.objectToString(board);
	}

	public Board parse(String s) throws JsonParseException, JsonMappingException, IOException {
		return JSONUtils.stringToObject(s, Board.class);
	}

	public Board copyBoard(Board board) {
		Board newBoard = new Board();
		for (int row = 0; row < Board.ROWS; row++) {
			for (int col = 0; col < Board.COLS; col++) {
				newBoard.setTile(row, col, board.getTile(row, col));
			}
		}
		return newBoard;
	}

	public GameResult checkResult(Board board) {
		// TODO:
		return null;
	}
}
