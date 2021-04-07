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
 * @author PC VALENTIN
 *
 */
@Entity
public class FilConversation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	
	@OneToMany(mappedBy="filConversation")
	private List<Message>message;
	
	@ManyToOne
	@JoinColumn(name = "id_rubrique")
	private Rubrique rubrique;

	/**
	 * Constructeur
	 * 
	 * @param id
	 * @param nom
	 */
	public FilConversation(Long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	/**
	 * Constructeur vide
	 */
	public FilConversation() {

	}

	@Override
	public String toString() {
		return "FilConversation [id=" + id + ", nom=" + nom + "]";
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
