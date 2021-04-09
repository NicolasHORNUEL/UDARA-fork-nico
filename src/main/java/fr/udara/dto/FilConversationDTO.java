/**
 * 
 */
package fr.udara.dto;

import javax.persistence.Entity;

/**
 * DTO associé au compte utilisateur
 * 
 * @author UDARA
 *
 */

@Entity
public class FilConversationDTO {

	private String nom;

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

}
