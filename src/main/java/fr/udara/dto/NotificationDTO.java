package fr.udara.dto;

/**
 * DTO associé a l'affichage d'une notification
 * 
 * @author Udara
 *
 */
public class NotificationDTO {
	
	/** texte : String */
	private String texte;
	
	/** heure : String */
	private String heure;
	
	/** lu : Boolean */
	private Boolean lu;

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
	 * @return the heure
	 */
	public String getHeure() {
		return heure;
	}

	/**
	 * Setter
	 *
	 * @param heure the heure to set
	 */
	public void setHeure(String heure) {
		this.heure = heure;
	}

	/**
	 * Getter
	 *
	 * @return the lu
	 */
	public Boolean getLu() {
		return lu;
	}

	/**
	 * Setter
	 *
	 * @param lu the lu to set
	 */
	public void setLu(Boolean lu) {
		this.lu = lu;
	}
	
	
	

}
