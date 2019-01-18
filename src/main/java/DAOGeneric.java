import javax.persistence.EntityManager;

public class DAOGeneric<T> {
	
	public static <T> void create(T entity) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.persist(entity);
		DatabaseHelper.commitTxAndClose(em);
	}

	public static <T> void update(T entity) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.merge(entity);
		DatabaseHelper.commitTxAndClose(em);
	}

	public static <T> void delete(T entity) {
		
		if (entity instanceof Vol) {
			if (((Vol) entity).getId() != null) {
				EntityManager em = DatabaseHelper.createEntityManager();
				DatabaseHelper.beginTx(em);
				Vol entity2 = em.find(Vol.class, ((Vol) entity).getId());
				em.remove(entity2);
				DatabaseHelper.commitTxAndClose(em);
			}

			if (entity instanceof Reservation) {
				if (((Reservation) entity).getId() != null) {
					EntityManager em = DatabaseHelper.createEntityManager();
					DatabaseHelper.beginTx(em);
					Reservation entity2 = em.find(Reservation.class, ((Reservation) entity).getId());
					em.remove(entity2);
					DatabaseHelper.commitTxAndClose(em);
				}
			}
		}
	}
}
