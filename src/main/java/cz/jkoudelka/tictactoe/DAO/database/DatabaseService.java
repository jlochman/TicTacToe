package cz.jkoudelka.tictactoe.DAO.database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import cz.jkoudelka.tictactoe.entityDomain.PersistenceObject;

/**
 * Servica, ktera pres EntityManager poskytuje zakladni metody pro praci s
 * entitama. Pro pristup k databazi je pouzito jiz hotove reseni JPA 2.0 (Java
 * Persistence API), specialne jeho konretni implementace - Hibernate. Hibernate
 * zprostredkovava most mezi SQL dotazy (SELECT * ...) a objekty.
 * EntityManagerFactory je halvnim objektem pro pristup k DB - konkretni
 * pripojeni k DB je definovano v src/main/resources/META-INF/persistence.xml.
 * EntityManager, ktery EntityManagerFactory vytvari, se pak pouziva pro
 * jednotlive transakcni operace nad DB.
 * 
 * @author jlochman
 *
 */
public class DatabaseService {

	private EntityManagerFactory emf;

	/**
	 * Inicializace EntityManagerFacotry
	 */
	public DatabaseService() {
		emf = Persistence.createEntityManagerFactory("tictactoeDB");
	}

	/**
	 * Ziskani EntityManageru pres EntityManagerFactory
	 * 
	 * @return
	 */
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void persist(PersistenceObject entity) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	public void update(PersistenceObject entity) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		entity = em.merge(entity);
		em.getTransaction().commit();
	}

	public <T extends PersistenceObject> T findById(Long id, Class<T> clazz) {
		EntityManager em = getEntityManager();
		return em.find(clazz, id);
	}

	public <T extends PersistenceObject> void delete(T entity) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.remove(em.contains(entity) ? entity : em.merge(entity));
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public <T extends PersistenceObject> List<T> findAll(int startPosition, int maxResults, Class<T> clazz) {
		EntityManager em = getEntityManager();

		Query q = em.createQuery("FROM " + clazz.getSimpleName());
		q.setFirstResult(startPosition);
		q.setMaxResults(maxResults);

		return q.getResultList();
	}

	public <T extends PersistenceObject> void deleteAll(Class<T> clazz) {
		EntityManager em = getEntityManager();
		em.createQuery("DELETE FROM " + clazz.getSimpleName()).executeUpdate();
	}

}
