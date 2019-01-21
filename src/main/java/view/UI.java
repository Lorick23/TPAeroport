package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.*;

public class UI {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UI.class);
	private static final String WRONG_INPUT = "\nMauvaise Entrée Utilisateur";
	private static final String UR_CHOICE = "\nVotre choix :";
	private static final String NUM_VOL = "\nVeuillez renseigner le numéro de vol composé de 4 chiffres :";
	private static final String CITY_CHOICE = "\nQuel ville voulez-vous choisir ?\n1) " + Villes.PARIS + "\n2) "
	+ Villes.MARSEILLE + "\n3) " + Villes.NANTES + "\n4) " + Villes.LYON + "\n5) " + Villes.BORDEAUX;
	private static final String MONTH_CHOICE = "\nVeuillez renseigner le mois du vol :";
	private static final String DAY_CHOICE = "\nVeuillez renseigner le jour du vol :";
	private static final String AGE_CHOICE = "\nQuel est votre AGE ?";

	private UI() {
		throw new IllegalStateException("Utility class");
	}

	public static void mainMenu() {
		LOGGER.info("\nGESTIONNAIRE DES VOLS ET RESERVATION\n1) Gestion des vols\n2) Gestion des réservations\n3) Quitter\n" + UR_CHOICE);
		Scanner sc = new Scanner(System.in);
		Integer choix = null;
		String str = sc.nextLine();

		while (choix == null) {

			if (!(str.equals("1") || str.equals("2") || str.equals("3"))) {
				LOGGER.info(WRONG_INPUT + UR_CHOICE);
				str = sc.nextLine();
			} else {
				choix = Integer.parseInt(str);
			}
		}

		switch (choix) {
		case 1:
			menuVol();
			break;
		case 2:
			menuResa();
			break;
		case 3:
			exit();
			break;
		default:
			exit();
			break;
		}
	}

	private static void exit() {
		LOGGER.info("\nAUREVOIR");
		System.exit(0);
	}

	private static void menuVol() {
		LOGGER.info("\nGESTION DES VOL\n1) Création d'un vol\n2) Liste des vols\nRecherche d'avion :\n3) Par numéro\n4) Par ville de départ et d'arrivée\n" + UR_CHOICE);
		Scanner sc = new Scanner(System.in);
		Integer choix = null;
		String str = sc.nextLine();

		while (choix == null) {

			if (!(str.equals("1") || str.equals("2") || str.equals("3") || str.equals("4"))) {
				LOGGER.info(WRONG_INPUT + UR_CHOICE);
				str = sc.nextLine();
			} else {
				choix = Integer.parseInt(str);
			}
		}

		switch (choix) {
		case 1:
			menuCreationVol();
			break;
		case 2:
			menuListeVol();
			break;
		case 3:
			menuRechercheVolParNum();
			break;
		case 4:
			menuRechercheVolParVilles();
			break;
		default:
			exit();
			break;
		}
	}

	public static void menuCreationVol() {
		LOGGER.info("\nCREATION D'UN VOL" + NUM_VOL);
		boolean accept = false;
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		Integer numVol = null;
		TypeAvion typeAvion = null;
		Villes villeDep = null;
		Villes villeArr = null;
		Integer mois = null;
		Integer jour = null;
		String dateDep;

		while (numVol == null) {

			if (str.length() != 4) {
				LOGGER.info(WRONG_INPUT + NUM_VOL);
				str = sc.nextLine();
			} else {
				try {
					numVol = Integer.parseInt(str);
				} catch (NumberFormatException e) {
					LOGGER.error(e.getMessage());
					LOGGER.info(WRONG_INPUT + NUM_VOL);
					str = sc.nextLine();
				}
			}
		}
		LOGGER.info("\nQuel type d'avion voulez-vous choisir ?\n1) " + TypeAvion.A330 + "\n2) " + TypeAvion.A340
				+ "\n3) " + TypeAvion.A380 + "\n4) " + TypeAvion.B747);
		str = sc.nextLine();
		while (typeAvion == null) {
			if (!(str.equals("1") || str.equals("2") || str.equals("3") || str.equals("4"))) {
				LOGGER.info(WRONG_INPUT + UR_CHOICE);
				str = sc.nextLine();
			} else {
				switch (str) {
				case "1":
					typeAvion = TypeAvion.A330;
					break;
				case "2":
					typeAvion = TypeAvion.A340;
					break;
				case "3":
					typeAvion = TypeAvion.A380;
					break;
				case "4":
					typeAvion = TypeAvion.B747;
					break;
				default:
					exit();
					break;
				}
			}
		}
		LOGGER.info("\nDépart :" +CITY_CHOICE);
		str = sc.nextLine();
		while (villeDep == null) {
			if (!(str.equals("1") || str.equals("2") || str.equals("3") || str.equals("4") || str.equals("5"))) {
				LOGGER.info(WRONG_INPUT + UR_CHOICE);
				str = sc.nextLine();
			} else {
				switch (str) {
				case "1":
					villeDep = Villes.PARIS;
					break;
				case "2":
					villeDep = Villes.MARSEILLE;
					break;
				case "3":
					villeDep = Villes.NANTES;
					break;
				case "4":
					villeDep = Villes.LYON;
					break;
				case "5":
					villeDep = Villes.BORDEAUX;
					break;
				default:
					exit();
					break;
				}
			}
		}
		LOGGER.info("\nArrivée :" +CITY_CHOICE);
		str = sc.nextLine();
		while (villeArr == null) {
			if (!(str.equals("1") || str.equals("2") || str.equals("3") || str.equals("4") || str.equals("5"))) {
				LOGGER.info(WRONG_INPUT + UR_CHOICE);
				str = sc.nextLine();
			} else {
				switch (str) {
				case "1":
					villeArr = Villes.PARIS;
					break;
				case "2":
					villeArr = Villes.MARSEILLE;
					break;
				case "3":
					villeArr = Villes.NANTES;
					break;
				case "4":
					villeArr = Villes.LYON;
					break;
				case "5":
					villeArr = Villes.BORDEAUX;
					break;
				default:
					exit();
					break;
				}
			}
		}
		LOGGER.info(MONTH_CHOICE);
		str = sc.nextLine();
		while (mois == null) {
			try {
				mois = Integer.parseInt(str);
				if (mois < 1 || mois > 12) {
					mois = null;
					LOGGER.info(WRONG_INPUT + MONTH_CHOICE);
					str = sc.nextLine();
				}
			} catch (NumberFormatException e) {
				LOGGER.error(e.getMessage());
				LOGGER.info(WRONG_INPUT + MONTH_CHOICE);
				str = sc.nextLine();
			}
		}
		LOGGER.info(DAY_CHOICE);
		str = sc.nextLine();
		while (jour == null) {
			try {
				jour = Integer.parseInt(str);
				if (jour < 1 || jour > 31) {
					jour = null;
					LOGGER.info(WRONG_INPUT + DAY_CHOICE);
					str = sc.nextLine();
				}
			} catch (NumberFormatException e) {
				LOGGER.error(e.getMessage());
				LOGGER.info(WRONG_INPUT + DAY_CHOICE);
				str = sc.nextLine();
			}
		}
		dateDep = "2019/" + mois + "/" + jour;
		LOGGER.info("\n" + numVol + " " + typeAvion + " " + villeDep + " " + villeArr + " " + dateDep);
		Services.creationVol(numVol, typeAvion, villeDep, villeArr, dateDep);
	}

	public static void menuListeVol() {
		LOGGER.info("\nNuméro | Type  | Place | Départ                 | Arrivé             | Date");
		for (Vol vol : Services.listeVol()) {
			LOGGER.info("\n" + vol.getNumVol() + "   | " + vol.getTypeAvion() + "  | " + vol.getNbPlace() + " | "
					+ vol.getVilleDep() + "		| " + vol.getVilleArr() + "		| " + vol.getDateDep() + "\n");
		}
	}

	public static void menuRechercheVolParNum() {
		
		Scanner sc = new Scanner(System.in);
		Integer choix = null;
		boolean accept = false;

		String str = null;
		while (!accept) {
			try {
				LOGGER.info(NUM_VOL);
				for (Vol vol : Services.listeVol()) {
					LOGGER.info("- " + vol.getNumVol());
				}
				str = sc.nextLine();
				choix = Integer.parseInt(str);
				for (Vol vol : Services.listeVol()) {
					if (choix.equals(vol.getNumVol())) {
						accept = true;
					}
				}
			} catch (NumberFormatException e) {
				LOGGER.error(e.getMessage());
			}
		}
		LOGGER.info("\n" + Services.volParNum(choix).toString());
	}

	public static void menuRechercheVolParVilles() {

		Scanner sc = new Scanner(System.in);
		String str = null;
		Villes villeDep = null;
		Villes villeArr = null;
		LOGGER.info("\nDépart :" + CITY_CHOICE);
		str = sc.nextLine();
		while (villeDep == null) {
			if (!(str.equals("1") || str.equals("2") || str.equals("3") || str.equals("4") || str.equals("5"))) {
				LOGGER.info(WRONG_INPUT + UR_CHOICE);
				str = sc.nextLine();
			} else {
				switch (str) {
				case "1":
					villeDep = Villes.PARIS;
					break;
				case "2":
					villeDep = Villes.MARSEILLE;
					break;
				case "3":
					villeDep = Villes.NANTES;
					break;
				case "4":
					villeDep = Villes.LYON;
					break;
				case "5":
					villeDep = Villes.BORDEAUX;
					break;
				default:
					exit();
					break;
				}
			}
		}
		LOGGER.info("\nArrivée :" + CITY_CHOICE);
		str = sc.nextLine();
		while (villeArr == null) {
			if (!(str.equals("1") || str.equals("2") || str.equals("3") || str.equals("4") || str.equals("5"))) {
				LOGGER.info(WRONG_INPUT + UR_CHOICE);
				str = sc.nextLine();
			} else {
				switch (str) {
				case "1":
					villeArr = Villes.PARIS;
					break;
				case "2":
					villeArr = Villes.MARSEILLE;
					break;
				case "3":
					villeArr = Villes.NANTES;
					break;
				case "4":
					villeArr = Villes.LYON;
					break;
				case "5":
					villeArr = Villes.BORDEAUX;
					break;
				default:
					exit();
					break;
				}
			}
		}
		LOGGER.info("\n" + Services.volParVilles(villeDep, villeArr));
	}

	private static void menuResa() {
		LOGGER.info("\nGESTION DES RESERVATIONS\n1) Création d'une réservation\n2) Annuler une réservation\nListe des réservations :\n3) Par vol\n4) Par personne\n" + UR_CHOICE);
		Scanner sc = new Scanner(System.in);
		Integer choix = null;
		String str = sc.nextLine();

		while (choix == null) {

			if (!(str.equals("1") || str.equals("2") || str.equals("3") || str.equals("4"))) {
				LOGGER.info(WRONG_INPUT + UR_CHOICE);
				str = sc.nextLine();
			} else {
				choix = Integer.parseInt(str);
			}
		}

		switch (choix) {
		case 1:
			menuCreationResa();
			break;
		case 2:
			LOGGER.info("2");
			break;
		case 3:
			menuListeResa();
			break;
		case 4:
			LOGGER.info("4");
			break;
		default:
			exit();
			break;
		}
	}

	private static void menuCreationResa() {
		
		Vol volChoisi = new Vol();
		Scanner sc = new Scanner(System.in);
		Integer choix = null;
		boolean accept = false;
		String nom = null;
		String prenom = null;
		int age = -1;

		String str = null;
		while (!accept) {
			try {
				LOGGER.info("\nCREATION D'UNE RESERVATION" + NUM_VOL);
				for (Vol vol : Services.listeVol()) {
					LOGGER.info("- " + vol.getNumVol());
				}
				str = sc.nextLine();
				choix = Integer.parseInt(str);
				for (Vol vol : Services.listeVol()) {
					if (choix.equals(vol.getNumVol())) {
						volChoisi = vol;
						accept = true;
					}
				}
			} catch (NumberFormatException e) {
				LOGGER.error(e.getMessage());
			}
		}
		
		LOGGER.info("\nQuel est votre NOM ?");
		str = sc.nextLine();
		nom = str;
		
		LOGGER.info("\nQuel est votre PRENOM ?");
		str = sc.nextLine();
		prenom = str;

		while (age == -1) {
			LOGGER.info(AGE_CHOICE);
			str = sc.nextLine();
			try {
				age = Integer.parseInt(str);
			} catch (NumberFormatException e) {
				LOGGER.error(e.getMessage());
				LOGGER.info(WRONG_INPUT + AGE_CHOICE);
				str = sc.nextLine();
			}
		}
		Services.creationResa(volChoisi, nom, prenom, age);
	}

	private static void menuListeResa() {
		Vol volChoisi = new Vol();
		List<Vol> vols = new ArrayList<Vol>();
		vols = Services.listeVol();

		Scanner sc = new Scanner(System.in);
		Integer choix = null;
		boolean accept = false;
		String str = null;

		while (!accept) {
			try {
				LOGGER.info("\nANNULER UNE RESERVATION" + NUM_VOL);
				for (Vol vol : vols) {
					LOGGER.info("- " + vol.getNumVol());
				}
				str = sc.nextLine();
				choix = Integer.parseInt(str);
				for (Vol vol : vols) {
					if (choix.equals(vol.getNumVol())) {
						volChoisi = vol;
						accept = true;
					}
				}
			} catch (NumberFormatException e) {
				LOGGER.error(e.getMessage());
			}
		}
		LOGGER.info("\n" + Services.listeResa(volChoisi).toString());
	}
}
