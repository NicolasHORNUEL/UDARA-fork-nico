package fr.udara.dto;

import java.time.LocalDateTime;

/**
 * DTO associé a l'affichage d'une notification
 * 
 * @author Udara
 *
 */
public class NotificationDTO {
	
	/** id : Long */
	private Long id;
	
	/** texte : String */
	private String texte;
	
	/** heure : LocalDateTime  */
	private LocalDateTime  heure;
	
	/** lu : Boolean */
	private Boolean lu;

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
	public LocalDateTime  getHeure() {
		return heure;
	}

	/**
	 * Setter
	 *
	 * @param heure the heure to set
	 */
	public void setHeure(LocalDateTime  heure) {
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
