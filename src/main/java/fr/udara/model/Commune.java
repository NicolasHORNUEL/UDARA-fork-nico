/**
 * 
 */
package fr.udara.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

/**
 * @author Udara
 * Entité Commune
 */
@Entity
public class Commune {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String nom;
	
	private String departement;
	
	private String region;
	
	private Integer population;
	
	@NotEmpty
	private Float xCoordonnee;
	
	@NotEmpty
	private Float yCoordonnee;
	
	/**
	 * Constructeur vide
	 */
	public Commune() {
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
	 */
	public Commune(String nom, String departement, String region, Integer population,
			Float xCoordonnee, Float yCoordonnee) {
		this.nom = nom;
		this.departement = departement;
		this.region = region;
		this.population = population;
		this.xCoordonnee = xCoordonnee;
		this.yCoordonnee = yCoordonnee;
	}

	/**
	 * 
	 * Constructeur complet, avec id
	 * 
	 * @param id
	 * @param nom
	 * @param departement
	 * @param region
	 * @param population
	 * @param xCoordonnee
	 * @param yCoordonnee
	 */
	public Commune(Long id, String nom, String departement, String region, Integer population,
			Float xCoordonnee, Float yCoordonnee) {
		this.id = id;
		this.nom = nom;
		this.departement = departement;
		this.region = region;
		this.population = population;
		this.xCoordonnee = xCoordonnee;
		this.yCoordonnee = yCoordonnee;
	}
	
	/**
	 * Méthode toString pour afficher la valeur des attributs de l'instance
	 */
	@Override
	public String toString() {
		return "Commune [id=" + id + ", nom=" + nom + ", departement=" + departement + ", region=" + region
				+ ", population=" + population + ", xCoordonnee=" + xCoordonnee + ", yCoordonnee=" + yCoordonnee + "]";
	}

	/**
	 * Getter
	 * @return id de la commune
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setter
	 * @param id id à modifier
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Getter
	 * @return nom de la commune
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter
	 * @param nom nom à modifier
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter
	 * @return département dont dépend la commune courante
	 */
	public String getDepartement() {
		return departement;
	}

	/**
	 * Setter
	 * @param departement département à modifier
	 */
	public void setDepartement(String departement) {
		this.departement = departement;
	}

	/**
	 * Getter
	 * @return région dont dépend la commune courante
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * Setter
	 * @param region région à modifier
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * Getter
	 * @return population de la commune
	 */
	public Integer getPopulation() {
		return population;
	}

	/**
	 * Setter
	 * @param population population à modifier
	 */
	public void setPopulation(Integer population) {
		this.population = population;
	}

	/**
	 * Getter
	 * @return coordonnée en x
	 */
	public Float getxCoordonnee() {
		return xCoordonnee;
	}
	
	/**
	 * Setter
	 * @param xCoordonnee coordonnée en x à modifier
	 */
	public void setxCoordonnee(Float xCoordonnee) {
		this.xCoordonnee = xCoordonnee;
	}

	/**
	 * Getter
	 * @return yCoordonnee coordonnée en y
	 */
	public Float getyCoordonnee() {
		return yCoordonnee;
	}

	/**
	 * Setter
	 * @param yCoordonnee coordonnée en y à modifier
	 */
	public void setyCoordonnee(Float yCoordonnee) {
		this.yCoordonnee = yCoordonnee;
	}
	
}
