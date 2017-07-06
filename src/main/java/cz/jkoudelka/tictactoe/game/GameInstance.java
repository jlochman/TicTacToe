package cz.jkoudelka.tictactoe.game;

import java.util.ArrayList;
import java.util.List;

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
