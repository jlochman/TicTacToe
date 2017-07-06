package cz.jkoudelka.tictactoe.entityDomain.services;

import cz.jkoudelka.tictactoe.entityDomain.PersistenceObject;
import cz.jkoudelka.tictactoe.entityDomain.enums.LogLevel;

public interface EntityLogServiceInterface<T extends PersistenceObject> {

	public default void info(T entity, String msg) {
		log(entity, msg, LogLevel.INFO);
	}

	public default void warn(T entity, String msg) {
		log(entity, msg, LogLevel.WARN);
	}

	public default void error(T entity, String msg) {
		log(entity, msg, LogLevel.ERROR);
	}

	public void log(T entity, String msg, LogLevel level);

}
