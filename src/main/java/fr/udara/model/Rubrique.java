package fr.udara.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Udara
 *
 */
@Entity
public class Rubrique {

	/** id : Integer */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** nom : String */
	private String nom;

	////////// RELATIONS //////////

	/** filConversation : List<FilConversation> */
	@OneToMany(mappedBy = "rubrique")
	private List<FilConversation> filConversation;

	////////// CONTROLEURS //////////

	/**
	 * Constructeur vide
	 */
	public Rubrique() {
	}

	/**
	 * Constructeur sans id
	 * 
	 * @param nom
	 * @param filConversation
	 */
	public Rubrique(String nom, List<FilConversation> filConversation) {
		super();
		this.nom = nom;
		this.filConversation = filConversation;
	}

	/**
	 * Constructeur complet
	 * 
	 * @param id
	 * @param nom
	 * @param filConversation
	 */
	public Rubrique(Integer id, String nom, List<FilConversation> filConversation) {
		super();
		this.id = id;
		this.nom = nom;
		this.filConversation = filConversation;
	}

	////////// TO STRING //////////

	/**
	 * Méthode toString pour afficher la valeur des attributs de l'instance
	 */
	@Override
	public String toString() {
		return "Rubrique n°" + id + "\nNom : " + nom + "\nFil de conversation : " + filConversation;
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