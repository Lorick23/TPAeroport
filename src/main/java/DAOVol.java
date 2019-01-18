import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class DAOVol  extends DAOGeneric<Vol> {
	
	public DAOVol() {
		super(Vol.class);
	}
	
	public List<Vol> listeVol() {
		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Vol> query = em.createQuery("from Vol", Vol.class);
		List<Vol> vols = query.getResultList();
		return vols;
	}
	
	public Vol volParNum(int num) {
		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Vol> query = em.createQuery("select v from Vol v where v.numVol=:numVol", Vol.class);
		query.setParameter("numVol", num);
		Vol vol = query.getSingleResult();
		return vol;
	}
	
	public List<Vol> volParVilles(Villes villeDep, Villes villeArr) {
		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Vol> query = em.createQuery("select v from Vol v where v.villeDep=:villeDep and v.villeArr=:villeArr", Vol.class);
		query.setParameter("villeDep", villeDep);
		query.setParameter("villeArr", villeArr);
		List<Vol> vols = query.getResultList();
		return vols;
	}
	
//	TypedQuery<User> query = em.createQuery(
//		       "select u " +
//		       "from User u " +
//		       "inner join u.passport " +
//		       "where u.id =:id ", User.class);
//		query.setParameter("id", 1L);

	
}
