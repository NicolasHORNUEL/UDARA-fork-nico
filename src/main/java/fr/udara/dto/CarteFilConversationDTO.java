/**
 * 
 */
package fr.udara.dto;

/**
 * @author UDARA
 *
 */
public class CarteFilConversationDTO {

	/** NomUtilisateur : String */
	private String NomUtilisateur;

	/** DateDePublication : String */
	private String DateDePublication;

	/** Message : String */
	private String Message;

	/** SujetDeConversation : String */
	private String SujetDeConversation;

	/**
	 * Getter
	 * 
	 * @return the nomUtilisateur
	 */
	public String getNomUtilisateur() {
		return NomUtilisateur;
	}

	/**
	 * Setter
	 * 
	 * @param nomUtilisateur the nomUtilisateur to set
	 */
	public void setNomUtilisateur(String nomUtilisateur) {
		NomUtilisateur = nomUtilisateur;
	}

	/**
	 * Getter
	 * 
	 * @return the dateDePublication
	 */
	public String getDateDePublication() {
		return DateDePublication;
	}

	/**
	 * Setter
	 * 
	 * @param dateDePublication the dateDePublication to set
	 */
	public void setDateDePublication(String dateDePublication) {
		DateDePublication = dateDePublication;
	}

	/**
	 * Getter
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return Message;
	}

	/**
	 * Setter
	 * 
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		Message = message;
	}

	/**
	 * Getter
	 * 
	 * @return the sujetDeConversation
	 */
	public String getSujetDeConversation() {
		return SujetDeConversation;
	}

	/**
	 * Setter
	 * 
	 * @param sujetDeConversation the sujetDeConversation to set
	 */
	public void setSujetDeConversation(String sujetDeConversation) {
		SujetDeConversation = sujetDeConversation;
	}

}
