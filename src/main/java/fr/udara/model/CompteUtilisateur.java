/**
 * 
 */
package fr.udara.model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.UniqueElements;

/**
 * @author udara
 *
 */
@Entity
@Table( name = "Compte_utilisateur", uniqueConstraints = { 
		@UniqueConstraint( columnNames = {"mail"} ),
		@UniqueConstraint( columnNames = {"nomUtilisateur"} )
})
public class CompteUtilisateur {

	/** id : Long */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** nom : String */
	private String nom;

	/** prenom : String */
	private String prenom;

	/** nomUtilisateur : String */
	private String nomUtilisateur;

	/** mail : String */
	private String mail;

	/** codePostal : String */
	@Max(value = 5)
	private String codePostal;

	/** role : Role */
	@Enumerated
	private Role role;

	////////// RELATIONS //////////

	////////// CONTROLEURS //////////

	/**
	 * Constructeurs vide
	 */
	public CompteUtilisateur() {
		super();
	}

	/**
	 * Construsteur avec tous les attribus
	 * 
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param nomUtilisateur
	 * @param mail
	 * @param codePostal
	 * @param role
	 */
	public CompteUtilisateur(Long id, String nom, String prenom, @UniqueElements String nomUtilisateur,
			@UniqueElements String mail, @Max(5) String codePostal, Role role) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.nomUtilisateur = nomUtilisateur;
		this.mail = mail;
		this.codePostal = codePostal;
		this.role = role;
	}

	/**
	 * Constructeur sans id
	 * 
	 * @param nom
	 * @param prenom
	 * @param nomUtilisateur
	 * @param mail
	 * @param codePostal
	 * @param role
	 */
	public CompteUtilisateur(String nom, String prenom, @UniqueElements String nomUtilisateur,
			@UniqueElements String mail, @Max(5) String codePostal, Role role) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.nomUtilisateur = nomUtilisateur;
		this.mail = mail;
		this.codePostal = codePostal;
		this.role = role;
	}

	
	//////////TO STRING //////////
	
	/**
	 *ToString
	 */
	@Override
	public String toString() {
		return "CompteUtilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", nomUtilisateur="
				+ nomUtilisateur + ", mail=" + mail + ", codePostal=" + codePostal + ", role=" + role + "]";
	}
	
	//////////GETTERS & SETTERS //////////

	/**
	 * Getter
	 * @return {@link Long} the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setter
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Getter
	 * @return the nomUtilisateur
	 */
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	/**
	 * Setter
	 * @param nomUtilisateur the nomUtilisateur to set
	 */
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	/**
	 * Getter
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * Setter
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * Getter
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * Setter
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * Getter
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Setter
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}	
	
}
