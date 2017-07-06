package cz.jkoudelka.tictactoe.entityDomain.services;

import cz.jkoudelka.tictactoe.entityDomain.LogEntity;
import cz.jkoudelka.tictactoe.entityDomain.enums.LogLevel;

public interface LogEntityService extends EntityServiceInterface<LogEntity> {

	public default void info(String msg) {
		log(msg, LogLevel.INFO);
	}

	public default void warn(String msg) {
		log(msg, LogLevel.WARN);
	}

	public default void error(String msg) {
		log(msg, LogLevel.ERROR);
	}

	public void log(String msg, LogLevel level);

}
