/**
 * 
 */
package fr.udara.dto;

import javax.persistence.Entity;

/**
 * DTO associé au compte utilisateur
 * @author Udara
 *
 */
@Entity
public class CompteUtilisateurDTO {
	
	/** nom : String */
	private String nom;

	/** prenom : String */
	private String prenom;

	/** nomUtilisateur : String */
	private String nomUtilisateur;

	/** commune : String */
	private String commune;

	/**
	 * Getter
	 * 
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter
	 * 
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter
	 * 
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter
	 * 
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Getter
	 * 
	 * @return the nomUtilisateur
	 */
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	/**
	 * Setter
	 * 
	 * @param nomUtilisateur the nomUtilisateur to set
	 */
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	/**
	 * Getter
	 * 
	 * @return the commune
	 */
	public String getCommune() {
		return commune;
	}

	/**
	 * Setter
	 * 
	 * @param commune the commune to set
	 */
	public void setCommune(String commune) {
		this.commune = commune;
	}

}
