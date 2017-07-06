package cz.jkoudelka.tictactoe.cpu;

import cz.jkoudelka.tictactoe.game.Board;

/**
 * Deklarace abstraktu CPU logiky. Konkretni implementace si vynucuje definovani
 * jedine metody {@link #play(Board)}.
 * 
 * @author jlochman
 *
 */
public abstract class CPULogicInstance {

	/**
	 * jedina metoda k implementaci v CPU logic
	 * 
	 * @param board
	 *            aktualni stav hry
	 * @return souradnice, kde CPU ma hrat
	 */
	public abstract Coordinates play(Board board);

}
