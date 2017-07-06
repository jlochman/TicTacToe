package cz.jkoudelka.tictactoe.gameInstance;

import com.fasterxml.jackson.annotation.JsonValue;

import cz.jkoudelka.tictactoe.utils.JSONUtils;

/**
 * Popisuje jedno pole 3x3.
 * 
 * @author jlochman
 *
 */
public class Board {

	public final static int ROWS = 3;
	public final static int COLS = 3;

	private BoardTile[][] tiles = new BoardTile[ROWS][COLS];

	public Board() {
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				tiles[row][col] = BoardTile.EMTPY;
			}
		}
	}

	public BoardTile[][] getTiles() {
		return tiles;
	}

	public BoardTile getTile(int row, int col) {
		validateRowColIndex(row, col);
		return tiles[row][col];
	}

	public void setTile(int row, int col, BoardTile tile) {
		validateRowColIndex(row, col);
		tiles[row][col] = tile;
	}

	/**
	 * validace, zda dany radek a sloupec je v hracim poli
	 * 
	 * @param row
	 * @param col
	 */
	private void validateRowColIndex(int row, int col) {
		if (row < 0 || row >= ROWS) {
			throw new IllegalArgumentException("row index out of bounds");
		}
		if (col < 0 || col >= COLS) {
			throw new IllegalArgumentException("col index out of bounds");
		}
	}

	/**
	 * Enum popisujici, komu dane pole patri
	 * 
	 * @author jlochman
	 *
	 */
	public enum BoardTile {

		PLAYER, CPU, EMTPY;

		/**
		 * tohle je kvuli prevodu BoardTile na String pres {@link JSONUtils}.
		 * Misto PLAYER se ulozi 0, Misto CPU se ulozi 1 a misto EMPTY se ulozi
		 * 2.
		 * 
		 * @return
		 */
		@JsonValue
		public int toValue() {
			return ordinal();
		}

	}

}
