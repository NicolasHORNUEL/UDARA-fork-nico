package fr.udara.model;

/**
 * @author udara
 * 
 */
public enum Role {
	
	ADMINISTRATEUR("1"),
	UTILISATEUR("2");
	
	private String role;
	
	////////// CONTROLEURS //////////

	/**
	 * Constructeur plein
	 * @param role
	 */
	private Role(String role) {
		this.role = role;
	}
	
	////////// GETTERS & SETTERS //////////

	/**
	 * Getter
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Setter
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	

}
