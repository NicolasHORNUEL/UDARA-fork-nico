/**
 * 
 */
package fr.udara.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Udara
 *
 */
@Entity
public class Favori {

	/** id : Long */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** nom : String */
	@NotEmpty
	private String nom;

	/** niveauMeteo : String */
	@NotEmpty
	private String niveauMeteo;

	/** indicateurAir : String */
	@NotEmpty
	private String indicateurAir;

	/** echelleTemps : EchelleTemps */
	@NotNull
	@Enumerated(EnumType.STRING)
	private EchelleTemps echelleTemps;

	////////// RELATIONS //////////

	/** commune : Commune */
	@ManyToOne
	@JoinColumn(name = "Commune_id")
	private Commune commune;

	/** compteUtilisateur : CompteUtilisateur */
	@ManyToOne
	@JoinColumn(name = "CompteUtilisateur_id")
	private CompteUtilisateur compteUtilisateur;

	////////// CONSTRUCTEURS //////////

	/**
	 * Constructeur vide
	 */
	public Favori() {
	}

	/**
	 * Constructeur sans id
	 * @param nom
	 * @param niveauMeteo
	 * @param indicateurAir
	 * @param echelleTemps
	 * @param commune
	 * @param compteUtilisateur
	 */
	public Favori(@NotEmpty String nom, @NotEmpty String niveauMeteo, @NotEmpty String indicateurAir,
			EchelleTemps echelleTemps, Commune commune, CompteUtilisateur compteUtilisateur) {
		super();
		this.nom = nom;
		this.niveauMeteo = niveauMeteo;
		this.indicateurAir = indicateurAir;
		this.echelleTemps = echelleTemps;
		this.commune = commune;
		this.compteUtilisateur = compteUtilisateur;
	}

	/**
	 * Constructeur complet
	 * @param id
	 * @param nom
	 * @param niveauMeteo
	 * @param indicateurAir
	 * @param echelleTemps
	 * @param commune
	 * @param compteUtilisateur
	 */
	public Favori(Long id, @NotEmpty String nom, @NotEmpty String niveauMeteo, @NotEmpty String indicateurAir,
			EchelleTemps echelleTemps, Commune commune, CompteUtilisateur compteUtilisateur) {
		super();
		this.id = id;
		this.nom = nom;
		this.niveauMeteo = niveauMeteo;
		this.indicateurAir = indicateurAir;
		this.echelleTemps = echelleTemps;
		this.commune = commune;
		this.compteUtilisateur = compteUtilisateur;
	}



	////////// TO STRING //////////

	/**
	 * Méthode toString pour afficher la valeur des attributs de l'instance
	 */
	@Override
	public String toString() {
		return "Favori n°" + id + "\nNom=" + nom + "\nNiveauMeteo : " + niveauMeteo + "\nIndicateurAir : "
				+ indicateurAir + "\nEchelleTemps : " + echelleTemps;
	}

	////////// GETTERS & SETTERS //////////

	/**
	 * Getter
	 * 
	 * @return l'id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setter
	 * 
	 * @param id l'id à modifier
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Getter
	 * 
	 * @return le nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter
	 * 
	 * @param nom le nom à modifier
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter
	 * 
	 * @return le niveauMeteo
	 */
	public String getNiveauMeteo() {
		return niveauMeteo;
	}

	/**
	 * Setter
	 * 
	 * @param niveauMeteo le niveauMeteo à modifier
	 */
	public void setNiveauMeteo(String niveauMeteo) {
		this.niveauMeteo = niveauMeteo;
	}

	/**
	 * Getter
	 * 
	 * @return l'indicateurAir
	 */
	public String getIndicateurAir() {
		return indicateurAir;
	}

	/**
	 * Setter
	 * 
	 * @param indicateurAir l'indicateurAir à modifier
	 */
	public void setIndicateurAir(String indicateurAir) {
		this.indicateurAir = indicateurAir;
	}

	/**
	 * Getter
	 * 
	 * @return l'echelleTemps
	 */
	public EchelleTemps getEchelleTemps() {
		return echelleTemps;
	}

	/**
	 * Setter
	 * 
	 * @param echelleTemps l'echelleTemps à modifier
	 */
	public void setEchelleTemps(EchelleTemps echelleTemps) {
		this.echelleTemps = echelleTemps;
	}

	/** Getter
	 * @return the commune
	 */
	public Commune getCommune() {
		return commune;
	}

	/** Setter
	 * @param commune the commune to set
	 */
	public void setCommune(Commune commune) {
		this.commune = commune;
	}

	/** Getter
	 * @return the compteUtilisateur
	 */
	public CompteUtilisateur getCompteUtilisateur() {
		return compteUtilisateur;
	}

	/** Setter
	 * @param compteUtilisateur the compteUtilisateur to set
	 */
	public void setCompteUtilisateur(CompteUtilisateur compteUtilisateur) {
		this.compteUtilisateur = compteUtilisateur;
	}

}
