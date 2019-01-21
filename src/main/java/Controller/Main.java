package Controller;

import Model.*;
import View.UI;

public class Main {

	public static void main(String[] args) {
		
		Vol volA = new Vol(1111, TypeAvion.B747, Villes.Nantes, Villes.Bordeaux, "2019/05/23");
		Vol volB = new Vol(2222, TypeAvion.A340, Villes.Paris, Villes.Marseille, "2019/02/12");
		Vol volC = new Vol(3333, TypeAvion.A330, Villes.Nantes, Villes.Bordeaux, "2019/04/20");
		
		DAOVol.create(volA);
		DAOVol.create(volB);
		DAOVol.create(volC);
		

		Reservation resA = new Reservation(volA, "Mattera", "Lorick", 29);
		Reservation resB = new Reservation(volA, "Payen", "Marine", 25);
		Reservation resC = new Reservation(volC, "Payen", "Marine", 25);
		
		DAOReservation.create(resA);
		DAOReservation.create(resB);
		DAOReservation.create(resC);
		
		UI.mainMenu();		
	}

}
