package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import controller.*;

public class DAOReservation extends DAOGeneric {
	
	private DAOReservation() {
		super();
	}

	public static List<Reservation> listeReservation(Vol vol) {
		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Reservation> query = em.createQuery("select r from Reservation r where r.vol=:vol",
				Reservation.class);
		query.setParameter("vol", vol);
		return query.getResultList();
	}
}
