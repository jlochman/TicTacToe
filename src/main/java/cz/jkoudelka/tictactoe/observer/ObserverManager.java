package cz.jkoudelka.tictactoe.observer;

import java.util.HashSet;
import java.util.Set;

import javafx.application.Platform;

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
