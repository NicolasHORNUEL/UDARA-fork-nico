package fr.udara.dto;

public class MessageDTO {

	/** id : Long */
	private Long id;
	/** nom : String */
	private String nom;
	/** date : String */
	private String date;
	
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
	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/** Getter
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/** Setter
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
}
