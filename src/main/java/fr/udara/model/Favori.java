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
import javax.validation.constraints.NotEmpty;

/**
 * @author Udara
 *
 */
@Entity
public class Favori {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String nom;
	
	@NotEmpty
	private String niveauMeteo;
	
	@NotEmpty
	private Boolean indicateurAir;
	
	@Enumerated(EnumType.STRING)
	private EchelleTemps echelleTemps;

	
	/**
	 * Constructeur vide
	 */
	public Favori() {
	}
	
	/**
	 * Constructeur sans id
	 * 
	 * @param nom
	 * @param niveauMeteo
	 * @param indicateurAir
	 * @param echelleTemps
	 */
	public Favori(String nom, String niveauMeteo, Boolean indicateurAir,
			EchelleTemps echelleTemps) {
		this.nom = nom;
		this.niveauMeteo = niveauMeteo;
		this.indicateurAir = indicateurAir;
		this.echelleTemps = echelleTemps;
	}

	/**
	 * Constructeur complet avec id
	 * 
	 * @param id
	 * @param nom
	 * @param niveauMeteo
	 * @param indicateurAir
	 * @param echelleTemps
	 */
	public Favori(Long id, String nom, String niveauMeteo, Boolean indicateurAir,
			EchelleTemps echelleTemps) {
		this.id = id;
		this.nom = nom;
		this.niveauMeteo = niveauMeteo;
		this.indicateurAir = indicateurAir;
		this.echelleTemps = echelleTemps;
	}
	
	/**
	 * Méthode toString pour afficher la valeur des attributs de l'instance
	 */
	@Override
	public String toString() {
		return "Favori [id=" + id + ", nom=" + nom + ", niveauMeteo=" + niveauMeteo + ", indicateurAir=" + indicateurAir
				+ ", echelleTemps=" + echelleTemps + "]";
	}

	/**
	 * Getter
	 * @return l'id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setter
	 * @param id l'id à modifier
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Getter
	 * @return le nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter
	 * @param nom le nom à modifier
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter
	 * @return le niveauMeteo
	 */
	public String getNiveauMeteo() {
		return niveauMeteo;
	}

	/**
	 * Setter
	 * @param niveauMeteo le niveauMeteo à modifier
	 */
	public void setNiveauMeteo(String niveauMeteo) {
		this.niveauMeteo = niveauMeteo;
	}

	/**
	 * Getter
	 * @return l'indicateurAir
	 */
	public Boolean getIndicateurAir() {
		return indicateurAir;
	}

	/**
	 * Setter
	 * @param indicateurAir l'indicateurAir à modifier
	 */
	public void setIndicateurAir(Boolean indicateurAir) {
		this.indicateurAir = indicateurAir;
	}

	/**
	 * Getter
	 * @return l'echelleTemps
	 */
	public EchelleTemps getEchelleTemps() {
		return echelleTemps;
	}

	/**
	 * Setter
	 * @param echelleTemps l'echelleTemps à modifier
	 */
	public void setEchelleTemps(EchelleTemps echelleTemps) {
		this.echelleTemps = echelleTemps;
	}

}
