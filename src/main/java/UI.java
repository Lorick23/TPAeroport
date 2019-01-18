import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI {
	
	public static void mainMenu() {
		System.out.println("GESTIONNAIRE DES VOLS ET RESERVATION\n1) Gestion des vols\n2) Gestion des réservations\n3) Quitter\n\nVotre choix :");
		Scanner sc = new Scanner(System.in);
		Integer choix = null;
		String str = sc.nextLine();
		
		while(choix == null) {
			
			if(!(str.equals("1") || str.equals("2") ||str.equals("3"))) {
				System.out.println("Mauvaise Entrée Utilisateur\nVotre choix :");
				str = sc.nextLine();
			}
			else {
				choix = Integer.parseInt(str);
			}
		}
		
		switch(choix) {
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
		System.out.println("\nAUREVOIR");
		System.exit(0);
	}
	
	private static void menuVol() {
		System.out.println("\nGESTION DES VOL\n1) Création d'un vol\n2) Liste des vols\nRecherche d'avion :\n3) Par numéro\n4) Par ville de départ et d'arrivée\n\nVotre choix :");
		Scanner sc = new Scanner(System.in);
		Integer choix = null;
		String str = sc.nextLine();
		
		while(choix == null) {
			
			if(!(str.equals("1") || str.equals("2") || str.equals("3") || str.equals("4"))) {
				System.out.println("Mauvaise Entrée Utilisateur\nVotre choix :");
				str = sc.nextLine();
			}
			else {
				choix = Integer.parseInt(str);
			}
		}
		
		switch(choix) {
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
		System.out.println("\nCREATION D'UN VOL\nVeuillez renseigner le numéro de vol composé de 4 chiffres :");
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
		
		while(numVol == null) {
			
			if(str.length() != 4) {
				System.out.println("\nMauvaise Entrée Utilisateur\nVeuillez renseigner le numéro de vol composé de 4 chiffres :");
				str = sc.nextLine();
			}
			else {
				try {
					numVol = Integer.parseInt(str);
				}catch(NumberFormatException e){
					System.out.println(e.getMessage());
					System.out.println("\nMauvaise Entrée Utilisateur\nVeuillez renseigner le numéro de vol composé de 4 chiffres :");
					str = sc.nextLine();
				}
			}
		}
		System.out.println("\nQuel type d'avion voulez-vous choisir ?\n1) "+TypeAvion.A330+"\n2) "+TypeAvion.A340+"\n3) "+TypeAvion.A380+"\n4) "+TypeAvion.B747);
		str = sc.nextLine();
		while(typeAvion == null) {
			if(!(str.equals("1") || str.equals("2") || str.equals("3") || str.equals("4"))) {
				System.out.println("Mauvaise Entrée Utilisateur\nVotre choix :");
				str = sc.nextLine();
			}
			else {
				switch(str) {
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
		
		System.out.println("\nQuel ville de départ voulez-vous choisir ?\n1) "+Villes.Paris+"\n2) "+Villes.Marseille+"\n3) "+Villes.Nantes+"\n4) "+Villes.Lyon+"\n5) "+Villes.Bordeaux);
		str = sc.nextLine();
		while(villeDep == null) {
			if(!(str.equals("1") || str.equals("2") || str.equals("3") || str.equals("4") || str.equals("5"))) {
				System.out.println("Mauvaise Entrée Utilisateur\nVotre choix :");
				str = sc.nextLine();
			}
			else {
				switch(str) {
				case "1":
					villeDep = Villes.Paris;
					break;
				case "2":
					villeDep = Villes.Marseille;
					break;
				case "3":
					villeDep = Villes.Nantes;
					break;
				case "4":
					villeDep = Villes.Lyon;
					break;
				case "5":
					villeDep = Villes.Bordeaux;
					break;
				default:
					exit();
					break;
				}
			}
		}
		System.out.println("\nQuel ville d'arrivée voulez-vous choisir ?\n1) "+Villes.Paris+"\n2) "+Villes.Marseille+"\n3) "+Villes.Nantes+"\n4) "+Villes.Lyon+"\n5) "+Villes.Bordeaux);
		str = sc.nextLine();
		while(villeArr == null) {
			if(!(str.equals("1") || str.equals("2") || str.equals("3") || str.equals("4") || str.equals("5"))) {
				System.out.println("Mauvaise Entrée Utilisateur\nVotre choix :");
				str = sc.nextLine();
			}
			else {
				switch(str) {
				case "1":
					villeArr = Villes.Paris;
					break;
				case "2":
					villeArr = Villes.Marseille;
					break;
				case "3":
					villeArr = Villes.Nantes;
					break;
				case "4":
					villeArr = Villes.Lyon;
					break;
				case "5":
					villeArr = Villes.Bordeaux;
					break;
				default:
					exit();
					break;
				}
			}
		}
		System.out.println("\nQuel mois voulez-vous partir ?");
		str = sc.nextLine();
		while(mois == null) {
			try {
				mois = Integer.parseInt(str);
				if(mois < 1 || mois > 12) {
					mois = null;
					System.out.println("\nMauvaise Entrée Utilisateur\nVeuillez renseigner le mois du vol :");
					str = sc.nextLine();
				}
			}catch(NumberFormatException e){
				System.out.println(e.getMessage());
				System.out.println("\nMauvaise Entrée Utilisateur\nVeuillez renseigner le mois du vol :");
				str = sc.nextLine();
			}
		}
		System.out.println("\nQuel jour voulez-vous partir ?");
		str = sc.nextLine();
		while(jour == null) {
			try {
				jour = Integer.parseInt(str);
				if(jour < 1 || jour > 31) {
					jour = null;
					System.out.println("\nMauvaise Entrée Utilisateur\nVeuillez renseigner le jour du vol :");
					str = sc.nextLine();
				}
			}catch(NumberFormatException e){
				System.out.println(e.getMessage());
				System.out.println("\nMauvaise Entrée Utilisateur\nVeuillez renseigner le jour du vol :");
				str = sc.nextLine();
			}
		}
		dateDep = "2019/"+mois+"/"+jour;
		System.out.println(numVol + " "+typeAvion+" "+villeDep+" "+villeArr+" "+dateDep);
		Services.creationVol(numVol, typeAvion, villeDep, villeArr, dateDep);
	}

	public static void menuListeVol() {
		List<Vol> vols = new ArrayList<Vol>();
		vols = Services.listeVol();
		System.out.println("Numéro | Type  | Place | Départ                 | Arrivé             | Date");
		for(Vol vol : vols) {
			System.out.println(vol.getNumVol() +"   | "+vol.getTypeAvion()+"  | "+vol.getNbPlace()+" | "+vol.getVilleDep()+"		| "+vol.getVilleArr()+"		| "+vol.getDateDep()+"\n");
		}
	}

	public static void menuRechercheVolParNum(){
		List<Vol> vols = new ArrayList<Vol>();
		vols = Services.listeVol();
		
		Scanner sc = new Scanner(System.in);
		Integer choix = null;
		boolean accept = false;
		
		//String str = sc.nextLine();
		String str = null;
		while(!accept){
			try {
				System.out.println("\nVeuillez choisir votre Numero de vol :");
				for(Vol vol : vols) {
					System.out.println("- "+vol.getNumVol());
				}
				str = sc.nextLine();
				choix = Integer.parseInt(str);
				for(Vol vol : vols) {
					if(choix.equals(vol.getNumVol())) {
						accept = true;
					}
				}
			}catch(NumberFormatException e){
				System.out.println(e.getMessage());
			}
		}
		System.out.println("\n"+Services.volParNum(choix).toString());
	}

	public static void menuRechercheVolParVilles() {
		
		Scanner sc = new Scanner(System.in);
		String str = null;
		Villes villeDep = null;
		Villes villeArr = null;
		System.out.println("\nQuel ville de départ voulez-vous choisir ?\n1) "+Villes.Paris+"\n2) "+Villes.Marseille+"\n3) "+Villes.Nantes+"\n4) "+Villes.Lyon+"\n5) "+Villes.Bordeaux);
		str = sc.nextLine();
		while(villeDep == null) {
			if(!(str.equals("1") || str.equals("2") || str.equals("3") || str.equals("4") || str.equals("5"))) {
				System.out.println("Mauvaise Entrée Utilisateur\nVotre choix :");
				str = sc.nextLine();
			}
			else {
				switch(str) {
				case "1":
					villeDep = Villes.Paris;
					break;
				case "2":
					villeDep = Villes.Marseille;
					break;
				case "3":
					villeDep = Villes.Nantes;
					break;
				case "4":
					villeDep = Villes.Lyon;
					break;
				case "5":
					villeDep = Villes.Bordeaux;
					break;
				default:
					exit();
					break;
				}
			}
		}
		System.out.println("\nQuel ville d'arrivée voulez-vous choisir ?\n1) "+Villes.Paris+"\n2) "+Villes.Marseille+"\n3) "+Villes.Nantes+"\n4) "+Villes.Lyon+"\n5) "+Villes.Bordeaux);
		str = sc.nextLine();
		while(villeArr == null) {
			if(!(str.equals("1") || str.equals("2") || str.equals("3") || str.equals("4") || str.equals("5"))) {
				System.out.println("Mauvaise Entrée Utilisateur\nVotre choix :");
				str = sc.nextLine();
			}
			else {
				switch(str) {
				case "1":
					villeArr = Villes.Paris;
					break;
				case "2":
					villeArr = Villes.Marseille;
					break;
				case "3":
					villeArr = Villes.Nantes;
					break;
				case "4":
					villeArr = Villes.Lyon;
					break;
				case "5":
					villeArr = Villes.Bordeaux;
					break;
				default:
					exit();
					break;
				}
			}
		}
		System.out.println("\n"+Services.volParVilles(villeDep, villeArr));
	}
	
	private static void menuResa() {
		System.out.println("\nGESTION DES RESERVATIONS\n1) Création d'une réservation\n2) Annuler une réservation\nListe des réservations :\n3) Par vol\n4) Par personne\n\nVotre choix :");
		Scanner sc = new Scanner(System.in);
		Integer choix = null;
		String str = sc.nextLine();
		
		while(choix == null) {
			
			if(!(str.equals("1") || str.equals("2") || str.equals("3") || str.equals("4"))) {
				System.out.println("Mauvaise Entrée Utilisateur\nVotre choix :");
				str = sc.nextLine();
			}
			else {
				choix = Integer.parseInt(str);
			}
		}
		
		switch(choix) {
		case 1:
			menuCreationResa();
			break;
		case 2:
			System.out.println("2");
			break;
		case 3:
			menuListeResa();
			break;
		case 4:
			System.out.println("4");
			break;
		default:
			exit();
			break;
		}
	}

	private static void menuCreationResa() {
		Vol volChoisi = new Vol();
		List<Vol> vols = new ArrayList<Vol>();
		vols = Services.listeVol();
		
		Scanner sc = new Scanner(System.in);
		Integer choix = null;
		boolean accept = false;
		String nom = null;
		String prenom = null;
		int age = -1;
		String numResa;
		
		//String str = sc.nextLine();
		String str = null;
		while(!accept){
			try {
				System.out.println("\nCREATION D'UNE RESERVATION\nVeuillez choisir votre Numero de vol :");
				for(Vol vol : vols) {
					System.out.println("- "+vol.getNumVol());
				}
				str = sc.nextLine();
				choix = Integer.parseInt(str);
				for(Vol vol : vols) {
					if(choix.equals(vol.getNumVol())) {
						volChoisi = vol;
						accept = true;
					}
				}
			}catch(NumberFormatException e){
				System.out.println(e.getMessage());
			}
		}
		
		System.out.println("\nQuel est votre NOM ?");
		str = sc.nextLine();
		nom = str;
		
		System.out.println("\nQuel est votre PRENOM ?");
		str = sc.nextLine();
		prenom = str;
		
		while(age == -1) {
			System.out.println("\nQuel est votre AGE ?");
			str = sc.nextLine();
			try {
				age = Integer.parseInt(str);
			}catch(NumberFormatException e){
				System.out.println(e.getMessage());
				System.out.println("\nMauvaise Entrée Utilisateur\nQuel est votre AGE ?");
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
		
		while(!accept){
			try {
				System.out.println("\nANNULER UNE RESERVATION\nVeuillez choisir votre Numero de vol :");
				for(Vol vol : vols) {
					System.out.println("- "+vol.getNumVol());
				}
				str = sc.nextLine();
				choix = Integer.parseInt(str);
				for(Vol vol : vols) {
					if(choix.equals(vol.getNumVol())) {
						volChoisi = vol;
						accept = true;
					}
				}
			}catch(NumberFormatException e){
				System.out.println(e.getMessage());
			}
		}
		System.out.println("\n"+Services.listeResa(volChoisi).toString());
		
	}
	
	private static void menuDelResa() {
		
	}
}
