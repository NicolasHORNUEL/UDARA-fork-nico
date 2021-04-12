package fr.udara.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Udara
 *
 */
@Entity
public class Message {

	/** id : Long */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** nom : String */
	private String nom;

	/** date : LocalDateTime */
	private LocalDateTime date;

	////////// RELATIONS //////////

	/** filConversation : FilConversation */
	@ManyToOne
	@JoinColumn(name = "FilConversation_id")
	private FilConversation filConversation;

	/** compteUtilisateur : CompteUtilisateur */
	@ManyToOne
	@JoinColumn(name = "CompteUtilisateur_id")
	private CompteUtilisateur compteUtilisateur;

	////////// CONSTRUCTEURS //////////

	/**
	 * Constructeur vide
	 */
	public Message() {
	}

	/**
	 * Constructeur sans id
	 * 
	 * @param nom
	 * @param date
	 * @param filConversation
	 * @param compteUtilisateur
	 */
	public Message(String nom, LocalDateTime date, FilConversation filConversation,
			CompteUtilisateur compteUtilisateur) {
		super();
		this.nom = nom;
		this.date = date;
		this.filConversation = filConversation;
		this.compteUtilisateur = compteUtilisateur;
	}

	/**
	 * Constructeur complet
	 * 
	 * @param id
	 * @param nom
	 * @param filConversation
	 * @param compteUtilisateur
	 */
	public Message(Long id, String nom, FilConversation filConversation, CompteUtilisateur compteUtilisateur) {
		super();
		this.id = id;
		this.nom = nom;
		this.filConversation = filConversation;
		this.compteUtilisateur = compteUtilisateur;
	}

	////////// TO STRING //////////

	@Override
	public String toString() {
		return "Message n°" + id + "\nNom : " + nom + "\nDate : " + date + "\nFil de Conversation : " + filConversation
				+ "\nCompte Utilisateur : " + compteUtilisateur;
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
	 * @return the filConversation
	 */
	public FilConversation getFilConversation() {
		return filConversation;
	}

	/**
	 * Setter
	 * 
	 * @param filConversation the filConversation to set
	 */
	public void setFilConversation(FilConversation filConversation) {
		this.filConversation = filConversation;
	}

	/**
	 * Getter
	 * 
	 * @return the compteUtilisateur
	 */
	public CompteUtilisateur getCompteUtilisateur() {
		return compteUtilisateur;
	}

	/**
	 * Setter
	 * 
	 * @param compteUtilisateur the compteUtilisateur to set
	 */
	public void setCompteUtilisateur(CompteUtilisateur compteUtilisateur) {
		this.compteUtilisateur = compteUtilisateur;
	}

	/**
	 * Getter
	 * 
	 * @return the date
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/**
	 * Setter
	 * 
	 * @param date the date to set
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

}
