/**
 * 
 */
package fr.udara.dto.form;

import java.util.List;

/**
 * @author Udara
 *
 */
public class FormNotificationDTO {
	
	/** texte : String */
	private String texte;
	
	/** region : List<String> */
	private List<String> region;
	
	/** commune : List<String> */
	private List<String> commune;

	/**
	 * Getter
	 *
	 * @return the texte
	 */
	public String getTexte() {
		return texte;
	}

	/**
	 * Setter
	 *
	 * @param texte the texte to set
	 */
	public void setTexte(String texte) {
		this.texte = texte;
	}

	/**
	 * Getter
	 *
	 * @return the region
	 */
	public List<String> getRegion() {
		return region;
	}

	/**
	 * Setter
	 *
	 * @param region the region to set
	 */
	public void setRegion(List<String> region) {
		this.region = region;
	}

	/**
	 * Getter
	 *
	 * @return the commune
	 */
	public List<String> getCommune() {
		return commune;
	}

	/**
	 * Setter
	 *
	 * @param commune the commune to set
	 */
	public void setCommune(List<String> commune) {
		this.commune = commune;
	}

	
	

}
