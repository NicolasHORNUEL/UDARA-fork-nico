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
	
	/** id : Long */
	private Long id;
	
	/** nom : String */
	private String nom;
	
	/** rubrique : RubriqueDTO */
	private RubriqueDTO rubrique;

	/** Getter
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Getter
	 * @return the rubrique
	 */
	public RubriqueDTO getRubrique() {
		return rubrique;
	}

	/** Setter
	 * @param rubrique the rubrique to set
	 */
	public void setRubrique(RubriqueDTO rubrique) {
		this.rubrique = rubrique;
	}


}
