package cz.jkoudelka.tictactoe.entityDomain.enums;

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
