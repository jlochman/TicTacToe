package cz.jkoudelka.tictactoe.cpu;

/**
 * pokud v implementaci CPULogicInstance nastane nejaka necekana vyjimka, mela
 * by byt vhozena pres tuto tridu
 * 
 * @author jlochman
 *
 */
public class CPULogicException extends RuntimeException {

	public CPULogicException() {
		super();
	}

	public CPULogicException(String s) {
		super(s);
	}

	private static final long serialVersionUID = -5271341324400736829L;

}
