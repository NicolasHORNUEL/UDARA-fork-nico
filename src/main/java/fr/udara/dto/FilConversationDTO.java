/**
 * 
 */
package fr.udara.dto;

/**
 * DTO associé au fil de conversation
 * 
 * @author UDARA
 *
 */

public class FilConversationDTO {
	
	/** nom : String */
	private String nom;
	
	/** Construteur vide */
	public FilConversationDTO() {
	}
	
	/** Construteur */
	public FilConversationDTO(String nom) {
		this.nom = nom;
	}

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
