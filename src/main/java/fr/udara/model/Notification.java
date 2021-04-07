package fr.udara.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author PC VALENTIN
 *
 */
@Entity
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String texte;
	private String commune;
	private boolean lu;

	/**
	 * Constructeur
	 * 
	 * @param id
	 * @param texte
	 * @param commune
	 * @param lu
	 */
	public Notification(Integer id, String texte, String commune, boolean lu) {
		super();
		this.id = id;
		this.texte = texte;
		this.commune = commune;
		this.lu = lu;
	}

	/**
	 * Constructeur vide
	 */
	public Notification() {

	}

	@Override
	public String toString() {
		return "Notification [id=" + id + ", texte=" + texte + ", commune=" + commune + ", lu=" + lu + "]";
	}

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter
	 * 
	 * @param id the id to set
	 */
	public void setId(Integer id) {
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

	/**
	 * Getter
	 * 
	 * @return the lu
	 */
	public boolean isLu() {
		return lu;
	}

	/**
	 * Setter
	 * 
	 * @param lu the lu to set
	 */
	public void setLu(boolean lu) {
		this.lu = lu;
	}

}
