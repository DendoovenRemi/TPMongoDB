package com.bankonet.model;


public final class CompteCourant extends Compte{
	/* Attributs */
	private float decouvertAutorise;
	public static int nbCompteCourants = 0;
	
	/* Constructeurs */
	public CompteCourant() {
		super();
	}
	
	public CompteCourant(int identifiant, String libelle, float solde, float decouvertAutorise) {
		super(identifiant, libelle, solde);
		this.decouvertAutorise = decouvertAutorise;
		nbCompteCourants++;
	}

	/* Getters and Setters */
	public float getDecouvertAutorise() {
		return decouvertAutorise;
	}

	public void setDecouvertAutorise(float decouvertAutorise) {
		this.decouvertAutorise = decouvertAutorise;
	}
	
}
