/**
 * 
 */
package fr.udara.dto;

/**
 * DTO associé au compte utilisateur
 * @author Udara
 *
 */
public class CompteUtilisateurDTO {
	
	/** id : Long */
	private Long id;
	
	/** nom : String */
	private String nom;

	/** prenom : String */
	private String prenom;

	/** nomUtilisateur : String */
	private String nomUtilisateur;

	/** commune : String */
	private String commune;

	/** email : String */
	private String email;

	/** motDePasse : String */
	private String motDePasse;

	/** codePostal : String */
	private String codePostal;
	
	/** statutActif : Boolean */
	private Boolean statutActif;

	/** Getter
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/** Setter
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
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter
	 * 
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Getter
	 * 
	 * @return the nomUtilisateur
	 */
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	/**
	 * Setter
	 * 
	 * @param nomUtilisateur the nomUtilisateur to set
	 */
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	/**
	 * Getter
	 * 
	 * @return the commune
	 */
	public String getCommune() {
		return commune;
	}

	/**
	 * Setter
	 * 
	 * @param commune the commune to set
	 */
	public void setCommune(String commune) {
		this.commune = commune;
	}

	/** Getter
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/** Setter
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/** Getter
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/** Setter
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	/** Getter
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/** Setter
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/** Getter
	 * @return the statutActif
	 */
	public Boolean getStatutActif() {
		return statutActif;
	}

	/** Setter
	 * @param statutActif the statutActif to set
	 */
	public void setStatutActif(Boolean statutActif) {
		this.statutActif = statutActif;
	}

}
