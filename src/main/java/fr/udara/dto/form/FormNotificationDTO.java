/**
 * 
 */
package fr.udara.dto.form;

/**
 * @author Udara
 *
 */
public class FormNotificationDTO {
	
	/** texte : String */
	private String texte;
	
	/** region : String */
	private String region;
	
	/** commune : String */
	private String commune;

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
	public String getRegion() {
		return region;
	}

	/**
	 * Setter
	 *
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
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
