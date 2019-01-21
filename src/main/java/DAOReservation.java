import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class DAOReservation extends DAOGeneric {
	
	public static List<Reservation> listeReservation(Vol vol){
		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Reservation> query = em.createQuery("select r from Reservation r where r.vol=:vol", Reservation.class);
		query.setParameter("vol", vol);
		List<Reservation> resa = query.getResultList();
		return resa;
	}
}
