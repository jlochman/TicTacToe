package cz.jkoudelka.tictactoe.game;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private List<Board> boards = new ArrayList<>();

	public Game() {
		boards.add(new Board());
	}

	public List<Board> getBoards() {
		return boards;
	}

	public void addBoard(Board board) {
		boards.add(board);
	}

}
