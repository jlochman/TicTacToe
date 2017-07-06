package cz.jkoudelka.tictactoe.observer;

import java.util.HashSet;
import java.util.Set;

import javafx.application.Platform;

/**
 * Registruje a odregistrovava {@link Observer}y a vyvolava {@link Event}y.
 * Pokud je pres tuto tridu vyvolan event, kazdy registrovany observer je
 * upozornen a postara se o zpracovani patricneho eventu. O Jaky event se jedna
 * se pozna podle tridy, na kterou je event typovan.
 * 
 * @author jlochman
 *
 */
public class ObserverManager {

	private Set<Observer> observers = new HashSet<>();

	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	public void unregisterObserver(Observer observer) {
		observers.remove(observer);
	}

	public void raiseEvent(Event event) {
		for (Observer observer : observers) {
			Platform.runLater(() -> observer.processEvent(event));
		}
	}

}
