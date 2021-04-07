package fr.udara.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author udara Entité NiveauMétéo
 */
@Entity
public class NiveauMeteo {

	/** id : Long */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** nom : String */
	private String nom;

	/** valeur : Float */
	private Float valeur;

	/** dateReleve : LocalDateTime */
	private LocalDateTime dateReleve;

	////////// RELATIONS //////////

	/** commune : Commune */
	@ManyToOne
	@JoinColumn(name = "Commune_id")
	private Commune commune;

	////////// CONTROLEURS //////////

	/** Constructeur VIDE */
	private NiveauMeteo() {
	}

	/**
	 * Constructor sans id
	 * 
	 * @param nom
	 * @param valeur
	 * @param dateReleve
	 */
	private NiveauMeteo(String nom, Float valeur, LocalDateTime dateReleve) {
		this.nom = nom;
		this.valeur = valeur;
		this.dateReleve = dateReleve;
	}

	/**
	 * Constructor complet
	 * 
	 * @param id
	 * @param nom
	 * @param valeur
	 * @param dateReleve
	 */
	private NiveauMeteo(Long id, String nom, Float valeur, LocalDateTime dateReleve) {
		this.id = id;
		this.nom = nom;
		this.valeur = valeur;
		this.dateReleve = dateReleve;
	}

	////////// TO STRING //////////

	/**
	 * Méthode toString pour afficher la valeur des attributs de l'instance
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NiveauMeteo [id=");
		builder.append(id);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", valeur=");
		builder.append(valeur);
		builder.append(", dateReleve=");
		builder.append(dateReleve);
		builder.append("]");
		return builder.toString();
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
	 * @return the valeur
	 */
	public Float getValeur() {
		return valeur;
	}

	/**
	 * Setter
	 * 
	 * @param valeur the valeur to set
	 */
	public void setValeur(Float valeur) {
		this.valeur = valeur;
	}

	/**
	 * Getter
	 * 
	 * @return the dateReleve
	 */
	public LocalDateTime getDateReleve() {
		return dateReleve;
	}

	/**
	 * Setter
	 * 
	 * @param dateReleve the dateReleve to set
	 */
	public void setDateReleve(LocalDateTime dateReleve) {
		this.dateReleve = dateReleve;
	}

}
