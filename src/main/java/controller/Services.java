package controller;

import java.util.List;

import model.*;

public class Services {

	private Services() {
		throw new IllegalStateException("Services class");
	}

	public static void creationVol(Integer numVol, TypeAvion typeAvion, Villes villeDep, Villes villeArr,
			String dateDep) {
		Vol vol = new Vol(numVol, typeAvion, villeDep, villeArr, dateDep);
		DAOVol.create(vol);
	}

	public static void creationResa(Vol vol, String nom, String prenom, Integer age) {
		Reservation resa = new Reservation(vol, nom, prenom, age);
		DAOReservation.create(resa);
		resa.setNumResa(resa.getVol().getNumVol() + "-" + resa.getId());
		DAOReservation.update(resa);
	}

	public static List<Vol> listeVol() {
		return DAOVol.listeVol();
	}

	public static List<Reservation> listeResa(Vol vol) {
		return DAOReservation.listeReservation(vol);
	}

	public static Vol volParNum(int num) {
		return DAOVol.volParNum(num);
	}

	public static List<Vol> volParVilles(Villes villeDep, Villes villeArr) {
		return DAOVol.volParVilles(villeDep, villeArr);
	}
}
