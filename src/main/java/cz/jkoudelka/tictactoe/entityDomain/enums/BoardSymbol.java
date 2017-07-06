package cz.jkoudelka.tictactoe.entityDomain.enums;

/**
 * Definuje symbol, se kterym bud player, nebo CPU hraje. pole {@link #text} se
 * pouziva pro zobrazeni symbolu v grafice.
 * 
 * @author jlochman
 *
 */
public enum BoardSymbol {

	CROSS("x"),

	NOUGHT("o");

	private String text;

	private BoardSymbol(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}

}
