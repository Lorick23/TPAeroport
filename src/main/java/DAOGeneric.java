import javax.persistence.EntityManager;

public class DAOGeneric<T> {
	
	private Class<T> klass;
	
	public DAOGeneric(Class<T> klass) {
		this.klass = klass;
	}
	
	public void create(T entity) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.persist(entity);
		DatabaseHelper.commitTxAndClose(em);
	}

	public void update(T entity) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.merge(entity);
		DatabaseHelper.commitTxAndClose(em);
	}

	public void delete(T entity) {
		
		if (entity instanceof Vol) {
			if (((Vol) entity).getId() != null) {
				EntityManager em = DatabaseHelper.createEntityManager();
				DatabaseHelper.beginTx(em);
				T entity2 = em.find(klass, ((Vol) entity).getId());
				em.remove(entity2);
				DatabaseHelper.commitTxAndClose(em);
			}

			if (entity instanceof Reservation) {
				if (((Reservation) entity).getId() != null) {
					EntityManager em = DatabaseHelper.createEntityManager();
					DatabaseHelper.beginTx(em);
					T entity2 = em.find(klass, ((Reservation) entity).getId());
					em.remove(entity2);
					DatabaseHelper.commitTxAndClose(em);
				}
			}
		}
	}
}
