/**
 * 
 */
package fr.udara.dto.form;

/**
 * @author udara
 *
 */
public class FormFilConversationDTO {
	
	/** motdepasse : String */
	private String rubrique;
	
	/** motdepasse : String */
	private String nom;

	/**
	 * Getter
	 * @return the rubrique
	 */
	public String getRubrique() {
		return rubrique;
	}

	/**
	 * Setter
	 * @param rubrique the rubrique to set
	 */
	public void setRubrique(String rubrique) {
		this.rubrique = rubrique;
	}

	/**
	 * Getter
	 * @return the titre
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter
	 * @param titre the titre to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

}
