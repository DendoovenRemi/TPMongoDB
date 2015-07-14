package com.bankonet;

import java.util.Scanner;

import com.bankonet.model.Client;
import com.bankonet.model.CompteCourant;
import com.bankonet.mongodb.ClientDao;

public class BankonetConseillerMain {
	private static Scanner sc;
	
	public static void main(String[] args) {
		BankonetConseillerMain bcm = new BankonetConseillerMain();
		sc = new Scanner(System.in);
		bcm.menu();
	}
	
	private void menu() {
		int choice;
		
		System.out.println("***** APPLICATION CONSEILLER BANCAIRE ******");
		System.out.println("0. Arrêter le programme");
		System.out.println("1. Ouvrir un compte");
		System.out.println("Veuillez choisir une action.");
		choice = sc.nextInt();
		
		switch (choice) {
		case 0:
			this.closeApp();			
			
		case 1:
			this.openCompte();
			break;
			
		default:
			System.out.println("Commande inconnue.");
		}
	}
	
	private void closeApp() {
		System.out.println("Arrêt de l'application.");
		System.exit(0);
	}
	
	private void openCompte() {
		String nom, prenom, login, libelle;
		float solde, decouvertAutorise;
		
		System.out.println("Ouverture d'un compte");
		sc.nextLine();
		System.out.println("Nom du client ?");
		nom = sc.nextLine();
		System.out.println("Prénom du client ?");
		prenom = sc.nextLine();
		System.out.println("Login du client ?");
		login = sc.nextLine();
		solde = 0F;
		decouvertAutorise = 0F;
		libelle = nom + "_" + prenom + "_COURANT_1";		
		CompteCourant compteCourant = new CompteCourant(CompteCourant.nbCompteCourants, libelle, solde, decouvertAutorise);
		Client client = new Client(nom, prenom, login, "secret");
		client.creerCompteCourant(compteCourant);
		
		ClientDao clientDao = new ClientDao();
		clientDao.ecrireClient(client);
		clientDao.closeConnection();
	}
}
