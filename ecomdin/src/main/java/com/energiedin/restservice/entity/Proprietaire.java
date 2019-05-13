package com.energiedin.restservice.entity;




import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Proprietaire {

    @Id
    private String email;
	private String password;
    private String nom;
    private String prenom;   
    private String tel;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] pdp;
    private String adresse;
    private String ville;
    private int codePostal;
    
    @OneToOne(mappedBy = "proprietaire",fetch = FetchType.LAZY)
    @JsonIgnoreProperties("proprietaire")
    private Boutique boutique;
    
   

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public byte[] getPdp() {
		return pdp;
	}

	public void setPdp(byte[] pdp) {
		this.pdp = pdp;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public Boutique getBoutique() {
		return boutique;
	}

	public void setBoutique(Boutique boutique) {
		this.boutique = boutique;
	}

    
    
    
}