package cz.jkoudelka.tictactoe.gameInstance;

import java.util.ArrayList;
import java.util.List;

/**
 * Instance hry, ktera obsahuje historii {@link Board}.
 * 
 * @author jlochman
 *
 */
public class GameInstance {

	private List<Board> boards = new ArrayList<>();

	public GameInstance() {
	}

	public List<Board> getBoards() {
		return boards;
	}

	public void addBoard(Board board) {
		boards.add(board);
	}

}
