package com.energiedin.restservice.entity;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(
	    uniqueConstraints=
	        @UniqueConstraint(columnNames={"boutique", "nom"})
	)
@Entity
public class Categorie { 
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    
    @Column(nullable = false)
    private String nom;	 
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent")
    @JsonIgnoreProperties("sousCategories")
    Categorie parent ;
	

	@ManyToOne
	@JoinColumn(name = "boutique", nullable = false)
    @JsonIgnoreProperties("categories")
	Boutique boutique;

    @OneToMany(mappedBy = "parent",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("parent")
    private Set<Categorie> sousCategories;

   
    @OneToMany(mappedBy = "categorie",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("categorie")
    private Set<Produit> produits;
	
	
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Boutique getBoutique() {
		return boutique;
	}
	public void setBoutique(Boutique boutique) {
		this.boutique = boutique;
	}
    

	public Categorie getParent() {
		return parent;
	}
	public void setParent(Categorie parent) {
		this.parent = parent;
	}
	public Set<Categorie> getSousCategories() {
		return sousCategories;
	}
	public void setSousCategories(Set<Categorie> sousCategories) {
		this.sousCategories = sousCategories;
	}
	public Set<Produit> getProduits() {
		return produits;
	}
	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
   
    
    
}