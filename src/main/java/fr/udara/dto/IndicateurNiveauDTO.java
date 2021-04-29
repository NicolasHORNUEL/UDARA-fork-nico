package fr.udara.dto;

import java.time.LocalDateTime;

/**
 * Classe de données d'indicateurAir et niveauMeteo DTO
 * @author Udara
 *
 */
public class IndicateurNiveauDTO {

	
	/** nom : String */
	private String nom;

	/** valeur : Float */
	private Float valeur;

	/** dateReleve : LocalDateTime */
	private LocalDateTime dateReleve;

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
	 * @return the valeur
	 */
	public Float getValeur() {
		return valeur;
	}

	/** Setter
	 * @param valeur the valeur to set
	 */
	public void setValeur(Float valeur) {
		this.valeur = valeur;
	}

	/** Getter
	 * @return the dateReleve
	 */
	public LocalDateTime getDateReleve() {
		return dateReleve;
	}

	/** Setter
	 * @param dateReleve the dateReleve to set
	 */
	public void setDateReleve(LocalDateTime dateReleve) {
		this.dateReleve = dateReleve;
	}

	
}
