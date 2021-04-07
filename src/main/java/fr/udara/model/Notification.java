package fr.udara.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	////////// RELATIONS //////////
	
	@ManyToMany
	@JoinTable(name="REL_COMPTE_NOTIFICATION",
		joinColumns= @JoinColumn(name="ID_NOTIF", referencedColumnName="id"),
		inverseJoinColumns= @JoinColumn(name="ID_COMPTE", referencedColumnName="id")
	)
	private List<CompteUtilisateur> compteUtilisateurs;


	/**
	 * Constructeur vide
	 */
	public Notification() {

	}
	
	/**
	 * Constructeur
	 * 
	 * @param id
	 * @param texte
	 * @param commune
	 * @param lu
	 */
	public Notification(Long id, String texte, String commune, boolean lu) {
		super();
		this.id = id;
		this.texte = texte;
		this.commune = commune;
		this.lu = lu;
	}

<<<<<<< HEAD
=======
	/**
	 * Constructeur
	 * 
	 * @param texte
	 * @param commune
	 * @param lu
	 */
	public Notification(String texte, String commune, boolean lu) {
		this.texte = texte;
		this.commune = commune;
		this.lu = lu;
	}
	
	/**
	 * Constructeur vide
	 */
	public Notification() {
>>>>>>> origin/master


	@Override
	public String toString() {
		return "Notification [id=" + id + ", texte=" + texte + ", commune=" + commune + ", lu=" + lu + "]";
	}

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

}
