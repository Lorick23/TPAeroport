import java.util.List;

public class Services {
	
	private static DAOVol daoV = new DAOVol();
	private static DAOReservation daoR = new DAOReservation();
	
	public static void creationVol(Integer numVol, TypeAvion typeAvion, Villes villeDep, Villes villeArr,
			String dateDep) {
		Vol vol = new Vol(numVol, typeAvion, villeDep, villeArr, dateDep);
		daoV.create(vol);
	}
	
	public static void creationResa(Vol vol, String nom, String prenom, Integer age) {
		Reservation resa = new Reservation(vol, nom, prenom, age);
		daoR.create(resa);
		resa.setNumResa(resa.getVol().getNumVol()+"-"+resa.getId());
		daoR.update(resa);
	}
	
	public static List<Vol> listeVol() {
		return daoV.listeVol();
	}
	
	public static List<Reservation> listeResa(Vol vol) {
		return daoR.listeReservation(vol);
	}
	
	public static Vol volParNum(int num) {
		return daoV.volParNum(num);
	}
	
	public static List<Vol> volParVilles(Villes villeDep, Villes villeArr) {
		return daoV.volParVilles(villeDep, villeArr);
	}
}
