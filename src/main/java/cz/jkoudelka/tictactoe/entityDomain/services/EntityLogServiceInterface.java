package cz.jkoudelka.tictactoe.entityDomain.services;

import cz.jkoudelka.tictactoe.entityDomain.PersistenceObject;
import cz.jkoudelka.tictactoe.entityDomain.enums.LogLevel;

/**
 * Obecny interface pro entity, ktere na sobe maji navazane logovani. vynucuji
 * si implementaci metody {@link #log(PersistenceObject, String, LogLevel)} a
 * poskytuji pro uzivatele pohodlnejsi metody
 * {@link #info(PersistenceObject, String)},
 * {@link #warn(PersistenceObject, String)} a
 * {@link #error(PersistenceObject, String)}.
 * 
 * @author jlochman
 *
 * @param <T>
 *            entitni trida, na kterou se ma logovat
 */
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

	/**
	 * Zalogovani zpravy
	 * 
	 * @param entity
	 *            nad kterou entitou
	 * @param msg
	 *            zprava
	 * @param level
	 *            uroven logu
	 */
	public void log(T entity, String msg, LogLevel level);

}
