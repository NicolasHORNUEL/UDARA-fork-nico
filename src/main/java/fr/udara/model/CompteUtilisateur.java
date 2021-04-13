package fr.udara.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * @author Udara
 *
 */
@Entity
@Table(name = "Compte_utilisateur", uniqueConstraints = { @UniqueConstraint(columnNames = { "email" }),
		@UniqueConstraint(columnNames = { "nomUtilisateur" }) })
public class CompteUtilisateur implements Serializable {
	
	/** serialVersionUID : long */
	private static final long serialVersionUID = 1L;

	/** id : Long */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** nom : String */
	@NotNull (message = "le nom ne doit pas être nul")
	private String nom;

	/** prenom : String */
	@NotNull (message = "le prénom ne doit pas être nul")
	private String prenom;

	/** nomUtilisateur : String */
	@NotNull (message = "le niom d'utilisateur ne doit pas être nul")
	private String nomUtilisateur;

	/** mail : String */
	@NotNull (message = "l'e-mail ne doit pas être nul")
	@Email
	private String email;
	
	/** motDePasse : String */
	@NotNull (message = "le mot de passe ne doit pas être nul")
	private String motDePasse;

	/** codePostal : String */
	@NotNull (message = "le code postal ne doit pas être nul")
	@Length(max = 5)
	private String codePostal;

	/** statutActif : Boolean */
	private Boolean statutActif;

	/** role : Role */
	@Enumerated(EnumType.STRING)
	private Role role;

	////////// RELATIONS //////////

	/** favoris : List<Favori> */
	@OneToMany(mappedBy = "compteUtilisateur")
	private List<Favori> favoris;

	/** messages : List<Message> */
	@OneToMany(mappedBy = "compteUtilisateur")
	private List<Message> messages;

	/** notifications : List<Notification> */
	@ManyToMany
	@JoinTable(name = "REL_COMPTE_NOTIFICATION", joinColumns = @JoinColumn(name = "ID_COMPTE", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ID_NOTIF", referencedColumnName = "id"))
	private List<Notification> notifications;

	@ManyToOne
	@JoinColumn(name = "Commune_id")
	private Commune commune;

	////////// CONSTRUCTEURS //////////

	/**
	 * Constructeurs vide
	 */
	public CompteUtilisateur() {
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
	 * @param favoris
	 * @param messages
	 * @param notifications
	 * @param commune
	 */
	public CompteUtilisateur(String nom, String prenom, String nomUtilisateur, String mail, String motDePasse, @Max(5) String codePostal,
			Boolean statutActif, Role role, List<Favori> favoris, List<Message> messages,
			List<Notification> notifications, Commune commune) {
		this.nom = nom;
		this.prenom = prenom;
		this.nomUtilisateur = nomUtilisateur;
		this.email = mail;
		this.motDePasse = motDePasse;
		this.codePostal = codePostal;
		this.statutActif = statutActif;
		this.role = role;
		this.favoris = favoris;
		this.messages = messages;
		this.notifications = notifications;
		this.commune = commune;
	}

	/**
	 * Constructeur complet
	 * 
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param nomUtilisateur
	 * @param mail
	 * @param codePostal
	 * @param role
	 * @param favoris
	 * @param messages
	 * @param notifications
	 * @param commune
	 */
	public CompteUtilisateur(Long id, String nom, String prenom, String nomUtilisateur, String mail, String motDePasse,
			@Max(5) String codePostal, Boolean statutActif, Role role, List<Favori> favoris, List<Message> messages,
			List<Notification> notifications, Commune commune) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.nomUtilisateur = nomUtilisateur;
		this.email = mail;
		this.motDePasse = motDePasse;
		this.codePostal = codePostal;
		this.statutActif = statutActif;
		this.role = role;
		this.favoris = favoris;
		this.messages = messages;
		this.notifications = notifications;
		this.commune = commune;
	}

	////////// TO STRING //////////

	@Override
	public String toString() {
		return "CompteUtilisateur n°" + id + "\nNom : " + nom + "\\nPrenom : " + prenom + "\\nNomUtilisateur : "
				+ nomUtilisateur + "\\nMail : " + email + "\\nCode Postal : " + codePostal + "\\nActif : " + statutActif
				+ "\\nRole : " + role + "\\nFavoris : " + favoris + "\\nMessages : " + messages + "\\nNotifications : "
				+ notifications + "\nCommune : " + commune;
	}

	////////// GETTERS & SETTERS //////////

	/**
	 * Getter
	 * 
	 * @return {@link Long} the id
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
	 * @return the mail
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter
	 * 
	 * @param mail the mail to set
	 */
	public void setEmail(String mail) {
		this.email = mail;
	}

	/**
	 * Getter
	 *
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * Setter
	 *
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	/**
	 * Getter
	 * 
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}
	
	/**
	 * Setter
	 * 
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * Getter
	 * 
	 * @return le statuActif
	 */
	public Boolean getStatutActif() {
		return statutActif;
	}

	/**
	 * Setter
	 * 
	 * @param statutActif the statutActif to set
	 */
	public void setStatutActif(Boolean statutActif) {
		this.statutActif = statutActif;
	}
	
	/**
	 * Getter
	 * 
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Setter
	 * 
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
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
	 * @return the messages
	 */
	public List<Message> getMessages() {
		return messages;
	}

	/**
	 * Setter
	 * 
	 * @param messages the messages to set
	 */
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	/**
	 * Getter
	 * 
	 * @return the notifications
	 */
	public List<Notification> getNotifications() {
		return notifications;
	}

	/**
	 * Setter
	 * 
	 * @param notifications the notifications to set
	 */
	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
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

	/**
	 * Getter
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
