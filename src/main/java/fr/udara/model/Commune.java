/**
 * 
 */
package fr.udara.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

/**
 * @author Udara
 */
@Entity
public class Commune {

	/** id : Long */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** nom : String */
	@NotEmpty
	private String nom;

	/** departement : String */
	private String departement;

	/** region : String */
	private String region;

	/** population : Integer */
	private Integer population;

	/** xCoordonnee Latitude=X : Float */
	private Float xCoordonnee;

	/** yCoordonnee Longitude=Y : Float */
	private Float yCoordonnee;

	////////// RELATIONS //////////

	/** indicateurAirs : List<IndicateurAir> */
	@OneToMany(mappedBy = "commune")
	private List<IndicateurAir> indicateurAirs;

	/** niveauMeteos : List<NiveauMeteo> */
	@OneToMany(mappedBy = "commune")
	private List<NiveauMeteo> niveauMeteos;

	/** favories : List<Favori> */
	@OneToMany(mappedBy = "commune")
	private List<Favori> favoris;

	/** messages : List<Message> */
	@OneToMany(mappedBy = "commune")
	private List<CompteUtilisateur> compteUtilisateurs;

	////////// CONSTRUCTEURS //////////

	/** Constructeur vide */
	public Commune() {
	}

	/**
	 * Constructeur pour intégrer le fichier JSON de l'API JSON
	 * 
	 * @param nom
	 * @param departement
	 * @param region
	 * @param population
	 * @param xCoordonnee
	 * @param yCoordonnee
	 * @param indicateurAirs
	 * @param niveauMeteos
	 * @param favoris
	 * @param compteUtilisateurs
	 */
	public Commune(@NotEmpty String nom, String departement, String region, Integer population,
			@NotEmpty Float xCoordonnee, @NotEmpty Float yCoordonnee) {
		this.nom = nom;
		this.departement = departement;
		this.region = region;
		this.population = population;
		this.xCoordonnee = xCoordonnee;
		this.yCoordonnee = yCoordonnee;;
	}

	
	/**
	 * Constructeur sans id
	 * 
	 * @param nom
	 * @param departement
	 * @param region
	 * @param population
	 * @param xCoordonnee
	 * @param yCoordonnee
	 * @param indicateurAirs
	 * @param niveauMeteos
	 * @param favoris
	 * @param compteUtilisateurs
	 */
	public Commune(@NotEmpty String nom, String departement, String region, Integer population,
			@NotEmpty Float xCoordonnee, @NotEmpty Float yCoordonnee, List<IndicateurAir> indicateurAirs,
			List<NiveauMeteo> niveauMeteos, List<Favori> favoris, List<CompteUtilisateur> compteUtilisateurs) {
		super();
		this.nom = nom;
		this.departement = departement;
		this.region = region;
		this.population = population;
		this.xCoordonnee = xCoordonnee;
		this.yCoordonnee = yCoordonnee;
		this.indicateurAirs = indicateurAirs;
		this.niveauMeteos = niveauMeteos;
		this.favoris = favoris;
		this.compteUtilisateurs = compteUtilisateurs;
	}

	/**
	 * Constructeur complet
	 * 
	 * @param id
	 * @param nom
	 * @param departement
	 * @param region
	 * @param population
	 * @param xCoordonnee
	 * @param yCoordonnee
	 * @param indicateurAirs
	 * @param niveauMeteos
	 * @param favoris
	 * @param compteUtilisateurs
	 */
	public Commune(Long id, @NotEmpty String nom, String departement, String region, Integer population,
			@NotEmpty Float xCoordonnee, @NotEmpty Float yCoordonnee, List<IndicateurAir> indicateurAirs,
			List<NiveauMeteo> niveauMeteos, List<Favori> favoris, List<CompteUtilisateur> compteUtilisateurs) {
		super();
		this.id = id;
		this.nom = nom;
		this.departement = departement;
		this.region = region;
		this.population = population;
		this.xCoordonnee = xCoordonnee;
		this.yCoordonnee = yCoordonnee;
		this.indicateurAirs = indicateurAirs;
		this.niveauMeteos = niveauMeteos;
		this.favoris = favoris;
		this.compteUtilisateurs = compteUtilisateurs;
	}

	////////// TO STRING //////////
	
	@Override
	public String toString() {
		return "Commune n°" + id + "\nNom : " + nom + "\nDepartement : " + departement + "\nRegion : " + region
				+ "\nPopulation : " + population + "\nCoordonnee X : " + xCoordonnee + "\nCoordonnee Y : " + yCoordonnee
				+ "\nIndicateurAirs : " + indicateurAirs + "\nNiveau Meteos : " + niveauMeteos + "\nFavoris : "
				+ favoris + "\nCompte utilisateur" + compteUtilisateurs;
	}

	////////// GETTERS & SETTERS //////////

	/**
	 * Getter
	 * 
	 * @return id de la commune
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setter
	 * 
	 * @param id id à modifier
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Getter
	 * 
	 * @return nom de la commune
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter
	 * 
	 * @param nom nom à modifier
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter
	 * 
	 * @return département dont dépend la commune courante
	 */
	public String getDepartement() {
		return departement;
	}

	/**
	 * Setter
	 * 
	 * @param departement département à modifier
	 */
	public void setDepartement(String departement) {
		this.departement = departement;
	}

	/**
	 * Getter
	 * 
	 * @return région dont dépend la commune courante
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * Setter
	 * 
	 * @param region région à modifier
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * Getter
	 * 
	 * @return population de la commune
	 */
	public Integer getPopulation() {
		return population;
	}

	/**
	 * Setter
	 * 
	 * @param population population à modifier
	 */
	public void setPopulation(Integer population) {
		this.population = population;
	}

	/**
	 * Getter
	 * 
	 * @return coordonnée en x
	 */
	public Float getxCoordonnee() {
		return xCoordonnee;
	}

	/**
	 * Setter
	 * 
	 * @param xCoordonnee coordonnée en x à modifier
	 */
	public void setxCoordonnee(Float xCoordonnee) {
		this.xCoordonnee = xCoordonnee;
	}

	/**
	 * Getter
	 * 
	 * @return yCoordonnee coordonnée en y
	 */
	public Float getyCoordonnee() {
		return yCoordonnee;
	}

	/**
	 * Setter
	 * 
	 * @param yCoordonnee coordonnée en y à modifier
	 */
	public void setyCoordonnee(Float yCoordonnee) {
		this.yCoordonnee = yCoordonnee;
	}

	/**
	 * Getter
	 *
	 * @return the indicateurAirs
	 */
	public List<IndicateurAir> getIndicateurAirs() {
		return indicateurAirs;
	}

	/**
	 * Setter
	 *
	 * @param indicateurAirs the indicateurAirs to set
	 */
	public void setIndicateurAirs(List<IndicateurAir> indicateurAirs) {
		this.indicateurAirs = indicateurAirs;
	}

	/**
	 * Getter
	 *
	 * @return the niveauMeteos
	 */
	public List<NiveauMeteo> getNiveauMeteos() {
		return niveauMeteos;
	}

	/**
	 * Setter
	 *
	 * @param niveauMeteos the niveauMeteos to set
	 */
	public void setNiveauMeteos(List<NiveauMeteo> niveauMeteos) {
		this.niveauMeteos = niveauMeteos;
	}

	/**
	 * Getter
	 *
	 * @return the favoris
	 */
	public List<Favori> getFavoris() {
		return favoris;
	}

	/**
	 * Setter
	 *
	 * @param favoris the favoris to set
	 */
	public void setFavoris(List<Favori> favoris) {
		this.favoris = favoris;
	}

	/**
	 * Getter
	 *
	 * @return the compteUtilisateurs
	 */
	public List<CompteUtilisateur> getCompteUtilisateurs() {
		return compteUtilisateurs;
	}

	/**
	 * Setter
	 *
	 * @param compteUtilisateurs the compteUtilisateurs to set
	 */
	public void setCompteUtilisateurs(List<CompteUtilisateur> compteUtilisateurs) {
		this.compteUtilisateurs = compteUtilisateurs;
	}

}
