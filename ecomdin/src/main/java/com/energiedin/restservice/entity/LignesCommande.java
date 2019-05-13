package com.energiedin.restservice.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class LignesCommande {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	int id;
	int    qteCde ;
	double    prix_livraison ;
	String    couleur ;
	String   taille ;
	
	@ManyToOne
	@JoinColumn(name="id_commande") 
	@JsonIgnoreProperties("lignescommande")
	private Commande commande;
	
	@ManyToOne
	@JoinColumn(name="id_produit") 
	@JsonIgnoreProperties("lignescommande")
	Produit produit ;
	
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public int getQteCde() {
		return qteCde;
	}
	public void setQteCde(int qteCde) {
		this.qteCde = qteCde;
	}
	public double getPrix_livraison() {
		return prix_livraison;
	}
	public void setPrix_livraison(double prix_livraison) {
		this.prix_livraison = prix_livraison;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public String getTaille() {
		return taille;
	}
	public void setTaille(String taille) {
		this.taille = taille;
	}

}

