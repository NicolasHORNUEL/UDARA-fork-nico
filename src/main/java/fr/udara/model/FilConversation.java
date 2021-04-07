package fr.udara.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Udara
 *
 */
@Entity
public class FilConversation {

	/** id : Integer */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
	private Integer id;

	/** nom : String */
=======
	private Long id;
>>>>>>> origin/master
	private String nom;

	////////// RELATIONS //////////

	/** message : List<Message> */
	@OneToMany(mappedBy = "filConversation")
	private List<Message> message;

	/** rubrique : Rubrique */
	@ManyToOne
	@JoinColumn(name = "Rubrique_id")
	private Rubrique rubrique;

	////////// CONTROLEURS //////////

	/**
	 * Constructeur vide
	 */
	public FilConversation() {
		super();
	}

	/**
	 * Constructeur sans id
	 * 
	 * @param nom
	 * @param message
	 * @param rubrique
	 */
<<<<<<< HEAD
	public FilConversation(String nom, List<Message> message, Rubrique rubrique) {
=======
	public FilConversation(Long id, String nom) {
>>>>>>> origin/master
		super();
		this.nom = nom;
		this.message = message;
		this.rubrique = rubrique;
	}

	/**
	 * Constructeur complet
	 * 
	 * @param id
	 * @param nom
	 * @param message
	 * @param rubrique
	 */
	public FilConversation(Integer id, String nom, List<Message> message, Rubrique rubrique) {
		super();
		this.id = id;
		this.nom = nom;
		this.message = message;
		this.rubrique = rubrique;
	}

	////////// TO STRING //////////

	
	/**
	 * Méthode toString pour afficher la valeur des attributs de l'instance
	 */
	@Override
	public String toString() {
		return "FilConversation n°" + id + "\nNom=" + nom + "\nMessage=" + message + "\nRubrique=" + rubrique;
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

	/**
	 * Getter
	 * 
	 * @return the message
	 */
	public List<Message> getMessage() {
		return message;
	}

	/**
	 * Setter
	 * 
	 * @param message the message to set
	 */
	public void setMessage(List<Message> message) {
		this.message = message;
	}

	/**
	 * Getter
	 * 
	 * @return the rubrique
	 */
	public Rubrique getRubrique() {
		return rubrique;
	}

	/**
	 * Setter
	 * 
	 * @param rubrique the rubrique to set
	 */
	public void setRubrique(Rubrique rubrique) {
		this.rubrique = rubrique;
	}

}
