package com.bankonet.model;

public abstract class Compte {
	/* Attributs */
	private int identifiant;
	private String libelle;
	private float solde;
	
	/* Constructeurs */
	public Compte() {
	}
	
	public Compte(int identifiant, String libelle, float solde) {
		this.identifiant = identifiant;
		this.libelle = libelle;
		this.solde = solde;
	}
	
	/* Methodes */
	public String toString() {
		return 	" Libelle : " + this.getLibelle() + 
				" Solde : " + this.getSolde() + "€";
	}

	/* Getters and Setters */
	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}
	
	

}
