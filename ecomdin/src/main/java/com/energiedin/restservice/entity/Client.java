package com.energiedin.restservice.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Client {
		
	   @Id
		String email;
		String nom;
		String prenom;
		String adresse;
		int codePostal;
		String ville;
		String tel,password ;

		@OneToMany(mappedBy = "client",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	    @JsonIgnoreProperties("client")
		Set<Commande> commandes;
		
		public Set<Commande> getCommandes() {
			return commandes;
		}
		public void setCommandes(Set<Commande> commandes) {
			this.commandes = commandes;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
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
		public String getAdress() {
			return adresse;
		}
		public void setAdress(String adress) {
			this.adresse = adress;
		}
		public int getCodePostal() {
			return codePostal;
		}
		public void setCodePostal(int codePostal) {
			this.codePostal = codePostal;
		}
		public String getVille() {
			return ville;
		}
		public void setVille(String ville) {
			this.ville = ville;
		}
		public String getTel() {
			return tel;
		}
		public void setTel(String tel) {
			this.tel = tel;
		}
		public String getMotPass() {
			return password;
		}
		public void setMotPass(String motPass) {
			this.password = motPass;
		}

}
