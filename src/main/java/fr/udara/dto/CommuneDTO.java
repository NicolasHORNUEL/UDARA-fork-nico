package fr.udara.dto;

/**
 * @author Udara
 *
 */
public class CommuneDTO {
	
	/** nom : String */
	private String nom;
	
	/** xCoordonnee Latitude=X : String */
	private String xCoordonnee;

	/** yCoordonnee Longitude=Y : String */
	private Float yCoordonnee;

	/**
	 * Constructeur vide
	 */
	public CommuneDTO() {
	}
	
	/**
	 * Constructeur
	 * 
	 * @param nom de la commune
	 * @param xCoordonnee
	 * @param yCoordonnee
	 */
	public CommuneDTO(String nom, String xCoordonnee, Float yCoordonnee) {
		this.nom = nom;
		this.xCoordonnee = xCoordonnee;
		this.yCoordonnee = yCoordonnee;
	}

	/**
	 * Getter
	 * 
	 * @return the commune
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter
	 * 
	 * @param commune the commune to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter
	 * 
	 * @return the xCoordonnee
	 */
	public String getxCoordonnee() {
		return xCoordonnee;
	}

	/**
	 * Setter
	 * 
	 * @param xCoordonnee the xCoordonnee to set
	 */
	public void setxCoordonnee(String xCoordonnee) {
		this.xCoordonnee = xCoordonnee;
	}

	/**
	 * Getter
	 * 
	 * @return the yCoordonnee
	 */
	public Float getyCoordonnee() {
		return yCoordonnee;
	}

	/**
	 * Setter
	 * 
	 * @param yCoordonnee the yCoordonnee to set
	 */
	public void setyCoordonnee(Float yCoordonnee) {
		this.yCoordonnee = yCoordonnee;
	}

}
