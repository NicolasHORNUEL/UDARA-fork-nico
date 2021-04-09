package fr.udara.model;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * @author Udara
 *
 */
@Entity
public class Notification {

	/** id : Long */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** texte : String */
	private String texte;

	/** commune : String */
	private String commune;

	/** lu : boolean */
	private boolean lu;

	private Time heure;

	////////// RELATIONS //////////

	@ManyToMany
	@JoinTable(name = "REL_COMPTE_NOTIFICATION", joinColumns = @JoinColumn(name = "ID_NOTIF", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ID_COMPTE", referencedColumnName = "id"))
	private List<CompteUtilisateur> compteUtilisateurs;

	////////// CONSTRUCTEURS //////////

	/**
	 * Constructeur vide
	 */
	public Notification() {
	}

	/**
	 * Constructeur sans id
	 * 
	 * @param texte
	 * @param commune
	 * @param lu
	 * @param compteUtilisateurs
	 * @param heure
	 */
	public Notification(String texte, String commune, boolean lu, List<CompteUtilisateur> compteUtilisateurs,
			Time heure) {
		super();
		this.texte = texte;
		this.commune = commune;
		this.lu = lu;
		this.compteUtilisateurs = compteUtilisateurs;
		this.heure = heure;
	}

	/**
	 * Constructeur complet
	 * 
	 * @param id
	 * @param texte
	 * @param commune
	 * @param lu
	 * @param compteUtilisateurs
	 * @param heure
	 */
	public Notification(Long id, String texte, String commune, boolean lu, List<CompteUtilisateur> compteUtilisateurs,
			Time heure) {
		super();
		this.id = id;
		this.texte = texte;
		this.commune = commune;
		this.lu = lu;
		this.compteUtilisateurs = compteUtilisateurs;
		this.heure = heure;
	}

	////////// TO STRING //////////

	/**
	 * Méthode toString pour afficher la valeur des attributs de l'instance
	 */
	@Override
	public String toString() {
		return "Notification n°" + id + "\nTexte : " + texte + "\nCommune : " + commune + "\nLu=" + lu;
	}

	////////// GETTERS & SETTERS //////////

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setter
	 * 
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

	/**
	 * Getter
	 *
	 * @return the compteUtilisateurs
	 */
	public List<CompteUtilisateur> getCompteUtilisateurs() {
		return compteUtilisateurs;
	}

	/**
	 * Setter
	 *
	 * @param compteUtilisateurs the compteUtilisateurs to set
	 */
	public void setCompteUtilisateurs(List<CompteUtilisateur> compteUtilisateurs) {
		this.compteUtilisateurs = compteUtilisateurs;
	}

	/**
	 * Getter
	 * 
	 * @return the heure
	 */
	public Time getHeure() {
		return heure;
	}

	/**
	 * Setter
	 * 
	 * @param heure the heure to set
	 */
	public void setHeure(Time heure) {
		this.heure = heure;
	}

}
