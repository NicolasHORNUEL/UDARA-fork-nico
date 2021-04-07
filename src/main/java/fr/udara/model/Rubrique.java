package fr.udara.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author PC VALENTIN
 *
 */
@Entity
public class Rubrique {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	
	@OneToMany(mappedBy="Rubrique")
	private List<FilConversation>filConversation;

	/**
	 * Constructeur
	 * 
	 * @param id
	 * @param nom
	 */
	public Rubrique(Integer id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	/**
	 * Constructeur vide
	 */
	public Rubrique() {

	}

	@Override
	public String toString() {
		return "Rubrique [id=" + id + ", nom=" + nom + "]";
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