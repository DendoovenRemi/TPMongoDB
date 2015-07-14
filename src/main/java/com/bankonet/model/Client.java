package com.bankonet.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

public class Client {
	/* Attributs */
	private String nom;
	private String prenom;
	private String login;
	private String password;
	private List<CompteCourant> compteCourantsList = new ArrayList<CompteCourant>();
	private List<CompteEpargne> comptesEpargnesList = new ArrayList<CompteEpargne>();
	
	/* Constructeurs */	
	public Client() {
		
	}
	
	public Client(String nom, String prenom, String login, String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
	}
	
	/* Methodes */
	public void creerCompteCourant(CompteCourant compte) {
		this.compteCourantsList.add(compte);
	}
	
	public Document toDocument() {
		Document cc = new Document();
		for (CompteCourant compte : compteCourantsList) {
			cc.append("libelle", compte.getLibelle())
					.append("solde", compte.getSolde());
		}
		Document cli = new Document().append("nom", this.nom)
				.append("prenom", this.prenom)
				.append("login", this.login)
				.append("password", this.password)
				.append("comptesCourants", cc);
		
		return cli;
	}
	
	public String toString() {
		String str = "";
		str += "Nom : " + this.getNom() + " - Prénom : " + this.prenom + " - Login : " + this.login + " - password : " + this.password + "\nComptes courants : ";
		for (CompteCourant compte : this.compteCourantsList) {
			str += compte.toString() + " - ";
		}
		str += "\nComptes Epargne : ";
		for (CompteEpargne compte : this.comptesEpargnesList) {
			str += compte.toString() + " - ";
		}
		return str;
	}

	/* Getters and Setters */
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
