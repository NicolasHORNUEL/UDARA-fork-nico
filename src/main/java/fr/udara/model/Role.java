package fr.udara.model;

/**
 * @author udara
 * 
 */
public enum Role {

	/** ROLE_ADMINISTRATEUR : Role */
	ROLE_ADMINISTRATEUR("ROLE_ADMINISTRATEUR"),

	/** ROLE_UTILISATEUR : Role */
	ROLE_UTILISATEUR("ROLE_UTILISATEUR");

	/** role : String */
	private String role;

	/**
	 * Constructeur
	 * 
	 * @param role
	 */
	private Role(String role) {
		this.role = role;
	}

	/**
	 * Getter
	 *
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Setter
	 *
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

}
