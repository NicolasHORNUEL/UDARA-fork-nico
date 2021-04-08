package fr.udara.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author udara Entité IndicateurAir
 */
@Entity
public class IndicateurAir {

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

	/** commune : Commune : relation */
	@ManyToOne
	@JoinColumn(name = "Commune_id")
	private Commune commune;

	////////// CONSTRUCTEURS //////////

	/** Constructeur VIDE */
	private IndicateurAir() {
	}

	/**
	 * Constructeur sans id
	 * 
	 * @param nom
	 * @param valeur
	 * @param dateReleve
	 * @param commune
	 */
	public IndicateurAir(String nom, Float valeur, LocalDateTime dateReleve, Commune commune) {
		super();
		this.nom = nom;
		this.valeur = valeur;
		this.dateReleve = dateReleve;
		this.commune = commune;
	}

	/**
	 * Constructeur complet
	 * 
	 * @param id
	 * @param nom
	 * @param valeur
	 * @param dateReleve
	 * @param commune
	 */
	public IndicateurAir(Long id, String nom, Float valeur, LocalDateTime dateReleve, Commune commune) {
		super();
		this.id = id;
		this.nom = nom;
		this.valeur = valeur;
		this.dateReleve = dateReleve;
		this.commune = commune;
	}

	////////// TO STRING //////////

	/**
	 * Méthode toString pour afficher la valeur des attributs de l'instance
	 */
	@Override
	public String toString() {
		return "IndicateurAir n°" + id + ":\nNom : " + nom + "\nValeur : " + valeur + "\nDate de Releve : " + dateReleve
				+ "\nCommune : " + commune;
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

	/**
	 * Getter
	 *
	 * @return the commune
	 */
	public Commune getCommune() {
		return commune;
	}

	/**
	 * Setter
	 *
	 * @param commune the commune to set
	 */
	public void setCommune(Commune commune) {
		this.commune = commune;
	}

}
