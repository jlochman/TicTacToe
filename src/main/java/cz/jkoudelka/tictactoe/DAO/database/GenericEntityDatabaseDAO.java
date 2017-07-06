package cz.jkoudelka.tictactoe.DAO.database;

import java.util.List;

import cz.jkoudelka.tictactoe.DAO.GenericEntityDAO;
import cz.jkoudelka.tictactoe.app.ServiceLocator;
import cz.jkoudelka.tictactoe.entityDomain.PersistenceObject;

/**
 * Interface starajici se o implementaci DAO metod definovanych v
 * GenericEntityDAO. Prostrednictvim servicy {@link DatabaseService} vola
 * patricne metody. Definuje novou metodu, {@link #getEntityClass()}, kterou je
 * treba definovat v konkretni implementaci.
 * 
 * @author jlochman
 *
 * @param <T>
 */
public interface GenericEntityDatabaseDAO<T extends PersistenceObject> extends GenericEntityDAO<T> {

	/**
	 * metoda vracejici tridu objektu T
	 * 
	 * @return
	 */
	public Class<T> getEntityClass();

	public default DatabaseService getDBService() {
		return ServiceLocator.getInstance().getDBService();
	}

	@Override
	public default void persist(T entity) {
		getDBService().persist(entity);
	}

	@Override
	public default void update(T entity) {
		getDBService().update(entity);
	}

	@Override
	public default T findById(Long id) {
		return getDBService().findById(id, getEntityClass());
	}

	@Override
	public default void delete(T entity) {
		getDBService().delete(entity);
	}

	@Override
	public default List<T> findAll(int startPosition, int maxResults) {
		return getDBService().findAll(startPosition, maxResults, getEntityClass());
	}

	@Override
	public default void deleteAll() {
		getDBService().deleteAll(getEntityClass());
	}

}
