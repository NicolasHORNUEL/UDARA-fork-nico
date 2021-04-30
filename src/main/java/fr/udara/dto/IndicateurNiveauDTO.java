package fr.udara.dto;

import java.util.List;

/**
 * Classe de données d'indicateurAir et niveauMeteo DTO
 * @author Udara
 *
 */
public class IndicateurNiveauDTO {

	
	/** nom : String */
	private String nom;

	/** valeurs : List<Float> */
	private List<Float> valeurs;

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
	 * @return the valeurs
	 */
	public List<Float> getValeurs() {
		return valeurs;
	}

	/** Setter
	 * @param valeurs the valeurs to set
	 */
	public void setValeurs(List<Float> valeurs) {
		this.valeurs = valeurs;
	}

	
}
