package fr.udara.dto;

import java.util.List;

import fr.udara.model.EchelleTemps;

/**
 * DTO associé à un object Favori
 * @author udara
 *
 */
public class FavoriDTO {

	/** id : Long */
	private Long id;
	/** nom : String */
	private String nom;
	/** niveauMeteo : String */
	private List<String> niveauMeteo;
	/** indicateurAir : String */
	private List<String> indicateurAir;
	/** echelleTemps : EchelleTemps */
	private EchelleTemps echelleTemps;
	/** commune : String */
	private String commune;
	/** compteUtilisateur : String */
	private String compteUtilisateur;
	
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
	 * @return the niveauMeteo
	 */
	public List<String> getNiveauMeteo() {
		return niveauMeteo;
	}
	/** Setter
	 * @param niveauMeteo the niveauMeteo to set
	 */
	public void setNiveauMeteo(List<String> niveauMeteo) {
		this.niveauMeteo = niveauMeteo;
	}
	/** Getter
	 * @return the indicateurAir
	 */
	public List<String> getIndicateurAir() {
		return indicateurAir;
	}
	/** Setter
	 * @param indicateurAir the indicateurAir to set
	 */
	public void setIndicateurAir(List<String> indicateurAir) {
		this.indicateurAir = indicateurAir;
	}
	/** Getter
	 * @return the echelleTemps
	 */
	public EchelleTemps getEchelleTemps() {
		return echelleTemps;
	}
	/** Setter
	 * @param echelleTemps the echelleTemps to set
	 */
	public void setEchelleTemps(EchelleTemps echelleTemps) {
		this.echelleTemps = echelleTemps;
	}
	/** Getter
	 * @return the commune
	 */
	public String getCommune() {
		return commune;
	}
	/** Setter
	 * @param commune the commune to set
	 */
	public void setCommune(String commune) {
		this.commune = commune;
	}
	/** Getter
	 * @return the compteUtilisateur
	 */
	public String getCompteUtilisateur() {
		return compteUtilisateur;
	}
	/** Setter
	 * @param compteUtilisateur the compteUtilisateur to set
	 */
	public void setCompteUtilisateur(String compteUtilisateur) {
		this.compteUtilisateur = compteUtilisateur;
	}
	

	
}
