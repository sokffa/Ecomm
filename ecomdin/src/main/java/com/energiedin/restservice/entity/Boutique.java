package com.energiedin.restservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Boutique {

    @Id
    private String boutique;
    
	@OneToMany(mappedBy = "boutique",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("boutique")
    private Set<Produit> produits;
    
    @OneToMany(mappedBy = "boutique",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("boutique")
    private Set<Categorie> categories;
    
    @OneToOne
    @JoinColumn(name = "id_proprietaire")
    @JsonIgnoreProperties("boutique")
    private Proprietaire proprietaire;

    
	 public String getBoutique() {
			return boutique;
		}

		public void setNom(String boutique) {
			this.boutique = boutique;
		}

		public Set<Produit> getProduits() {
			return produits;
		}

		public void setProduits(Set<Produit> produits) {
			this.produits = produits;
		}

		public Set<Categorie> getCategories() {
			return categories;
		}

		public void setCategories(Set<Categorie> categories) {
			this.categories = categories;
		}
		
		public Proprietaire getProprietaire() {
			return proprietaire;
		}

		public void setProprietaire(Proprietaire proprietaire) {
			this.proprietaire = proprietaire;
		}


}