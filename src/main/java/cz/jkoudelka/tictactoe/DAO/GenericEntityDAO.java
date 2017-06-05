package cz.jkoudelka.tictactoe.DAO;

import java.util.List;

import cz.jkoudelka.tictactoe.entityDomain.PersistenceObject;

public interface GenericEntityDAO<T extends PersistenceObject> {

	public void persist(T entity);

	public void update(T entity);

	public T findById(Long id);

	public void delete(T entity);

	public List<T> findAll(int startPosition, int maxResults);

	public void deleteAll();

}
