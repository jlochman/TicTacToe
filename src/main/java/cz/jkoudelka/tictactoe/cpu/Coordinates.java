package cz.jkoudelka.tictactoe.cpu;

/**
 * zaobaleni souradnic do jedne tridy. Tato trida je vraceno metoodu v
 * {@link CPULogicInstance}
 * 
 * @author jlochman
 *
 */
public class Coordinates {

	private int row;
	private int col;

	public Coordinates(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	@Override
	public int hashCode() {
		return 100 * row + col;
	}

}
