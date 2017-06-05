package cz.jkoudelka.tictactoe.DAO.database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import cz.jkoudelka.tictactoe.entityDomain.PersistenceObject;

public class DatabaseService {

	private EntityManagerFactory emf;

	public DatabaseService() {
		emf = Persistence.createEntityManagerFactory("tictactoeDB");
	}

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
