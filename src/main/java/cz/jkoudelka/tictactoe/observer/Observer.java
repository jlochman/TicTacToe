package cz.jkoudelka.tictactoe.observer;

/**
 * Kazdy {@link Observer} registrovany v {@link ObserverManager} je upozornen,
 * kdyz jakakoliv {@link Event} nastane. Implementace metody
 * {@link #processEvent(Event)} jiz rozhodne, co se ma stat.
 * 
 * @author jlochman
 *
 */
public interface Observer {

	public void processEvent(Event event);

}
