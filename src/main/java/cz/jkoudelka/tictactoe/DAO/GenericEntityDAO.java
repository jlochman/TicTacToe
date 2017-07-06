package cz.jkoudelka.tictactoe.DAO;

import java.util.List;

import cz.jkoudelka.tictactoe.entityDomain.PersistenceObject;

/**
 * Zakladni metody pro pristup k DAO objektum. Ukazka prace s generikou (<T
 * extends PersistenceObject>).
 * 
 * @author jlochman
 *
 * @param <T>
 */
public interface GenericEntityDAO<T extends PersistenceObject> {

	/**
	 * Ulozeni nove entity
	 * 
	 * @param entity
	 */
	public void persist(T entity);

	/**
	 * Update exustujici entity
	 * 
	 * @param entity
	 */
	public void update(T entity);

	/**
	 * Nalezeni entity podle id
	 * 
	 * @param id
	 * @return
	 */
	public T findById(Long id);

	/**
	 * Odstraneni existujici entity
	 * 
	 * @param entity
	 */
	public void delete(T entity);

	/**
	 * Ziskani entit
	 * 
	 * @param startPosition
	 * @param maxResults
	 * @return
	 */
	public List<T> findAll(int startPosition, int maxResults);

	/**
	 * Odstraneni vsech entit
	 * 
	 */
	public void deleteAll();

}
