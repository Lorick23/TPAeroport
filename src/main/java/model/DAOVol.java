package model;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import controller.*;

public class DAOVol  extends DAOGeneric {
	
	private DAOVol() {
		super();
	}
	
	public static List<Vol> listeVol() {
		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Vol> query = em.createQuery("from Vol", Vol.class);
		return query.getResultList();
	}
	
	public static Vol volParNum(int num) {
		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Vol> query = em.createQuery("select v from Vol v where v.numVol=:numVol", Vol.class);
		query.setParameter("numVol", num);
		return query.getSingleResult();
	}
	
	public static List<Vol> volParVilles(Villes villeDep, Villes villeArr) {
		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Vol> query = em.createQuery("select v from Vol v where v.villeDep=:villeDep and v.villeArr=:villeArr", Vol.class);
		query.setParameter("villeDep", villeDep);
		query.setParameter("villeArr", villeArr);
		return query.getResultList();
	}
	
}
