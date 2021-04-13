/**
 * 
 */
package fr.udara.model;

/**
 * @author Udara
 *
 */
public enum EchelleTemps {
	
	/** JOURNALIERE : EchelleTemps */
	JOURNALIERE("JOURNALIERE"),
	
	/** HEBDOMADAIRE : EchelleTemps */
	HEBDOMADAIRE("HEBDOMADAIRE"),
	
	/** MENSUEL : EchelleTemps */
	MENSUEL("MENSUEL");
	
	/** role : String */
	private String echelleTemps;

	/** Getter
	 * @return the echelleTemps
	 */
	public String getEchelleTemps() {
		return echelleTemps;
	}

	/** Setter
	 * @param echelleTemps the echelleTemps to set
	 */
	public void setEchelleTemps(String echelleTemps) {
		this.echelleTemps = echelleTemps;
	}

	/** Constructeur
	 * 
	 */
	private EchelleTemps(String echelleTemps) {
		this.echelleTemps = echelleTemps;
	}

	
}
