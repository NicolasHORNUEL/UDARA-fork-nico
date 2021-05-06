/**
 * 
 */
package fr.udara.dto.form;

/**
 * @author Udara
 *
 */
public class FormRubriqueDTO {

	/** id : Long */
	private Long id;
	
	/** nom : String */
	private String nom;

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
