package cz.jkoudelka.tictactoe.cpu.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cz.jkoudelka.tictactoe.cpu.CPULogicException;
import cz.jkoudelka.tictactoe.cpu.CPULogicInstance;
import cz.jkoudelka.tictactoe.cpu.Coordinates;
import cz.jkoudelka.tictactoe.game.Board;
import cz.jkoudelka.tictactoe.game.Board.BoardTile;

public class CPURandomizer extends CPULogicInstance {

	private Random rand = new Random();

	@Override
	public Coordinates play(Board board) {

		// dostanu vsechny pole, ktere jsou prazdny
		List<Coordinates> coordinates = new ArrayList<>();
		for (int row = 0; row < Board.ROWS; row++) {
			for (int col = 0; col < Board.COLS; col++) {
				if (board.getTile(row, col) == BoardTile.EMTPY) {
					coordinates.add(new Coordinates(row, col));
				}
			}
		}

		// tohle by nastat nemelo - sama logika hry by mela teto podmince
		// zabranit
		if (coordinates.size() == 0) {
			throw new CPULogicException("There is no empty tile to play");
		}

		// z prazdnych poli vyberu nahodne prazdne pole
		int index = rand.nextInt(coordinates.size());
		return coordinates.get(index);

	}

}
