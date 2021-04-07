package fr.udara.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author PC VALENTIN
 *
 */
@Entity
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;

	@ManyToOne
	@JoinColumn(name = "id_filconversation")
	private FilConversation filConversation;

	@ManyToOne
	@JoinColumn(name = "id_compteutilisateur")
	private CompteUtilisateur compteUtilisateur;

	/**
	 * Constructeur
	 * 
	 * @param id
	 * @param nom
	 */
	public Message(Long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	/**
	 * Constructeur vide
	 */
	public Message() {
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", nom=" + nom + "]";
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
