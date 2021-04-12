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

	/** lu : boolean */
	private boolean lu;

	/** heure : LocalDateTime */
	private LocalDateTime heure;

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
	public Notification(String texte, boolean lu, List<CompteUtilisateur> compteUtilisateurs,
			LocalDateTime heure) {
		super();
		this.texte = texte;
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
	public Notification(Long id, String texte, boolean lu, List<CompteUtilisateur> compteUtilisateurs,
			LocalDateTime heure) {
		super();
		this.id = id;
		this.texte = texte;
		this.lu = lu;
		this.compteUtilisateurs = compteUtilisateurs;
		this.heure = heure;
	}

	////////// TO STRING //////////

	@Override
	public String toString() {
		return "Notification n°" + id + "\nTexte= : " + texte + "\nLu : " + lu + "\nHeure : " + heure
				+ "\nCompte Utilisateurs : " + compteUtilisateurs;
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
	public LocalDateTime getHeure() {
		return heure;
	}

	/**
	 * Setter
	 * 
	 * @param heure the heure to set
	 */
	public void setHeure(LocalDateTime heure) {
		this.heure = heure;
	}

}
