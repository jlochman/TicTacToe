package cz.jkoudelka.tictactoe.entityDomain.services;

import java.util.List;

import cz.jkoudelka.tictactoe.DAO.GenericEntityDAO;
import cz.jkoudelka.tictactoe.entityDomain.PersistenceObject;

public interface EntityServiceInterface<T extends PersistenceObject> {

	public GenericEntityDAO<T> getDAO();

	public default void persist(T entity) {
		getDAO().persist(entity);
	}

	public default void update(T entity) {
		getDAO().update(entity);
	}

	public default T findById(Long id) {
		return getDAO().findById(id);
	}

	public default void delete(T entity) {
		getDAO().delete(entity);
	}

	public default List<T> findAll(int startPosition, int maxResults) {
		return getDAO().findAll(startPosition, maxResults);
	}

	public default List<T> findAll(int startPosition) {
		return getDAO().findAll(startPosition, Integer.MAX_VALUE);
	}

	public default List<T> findAll() {
		return getDAO().findAll(0, Integer.MAX_VALUE);
	}

	public default void deleteAll() {
		getDAO().deleteAll();
	}

}
