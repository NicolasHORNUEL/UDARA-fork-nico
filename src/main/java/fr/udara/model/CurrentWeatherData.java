package fr.udara.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentWeatherData {

	@JsonProperty("main")
	private NiveauMeteo niveauMeteo;
	
	@JsonProperty("dt")
	private String dateReleve;

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CurrentWeatherData [niveauMeteo=");
		builder.append(niveauMeteo);
		builder.append(", dateReleve=");
		builder.append(dateReleve);
		builder.append("]");
		return builder.toString();
	}

	/** Getter
	 * @return the niveauMeteo
	 */
	public NiveauMeteo getNiveauMeteo() {
		return niveauMeteo;
	}

	/** Setter
	 * @param niveauMeteo the niveauMeteo to set
	 */
	public void setNiveauMeteo(NiveauMeteo niveauMeteo) {
		this.niveauMeteo = niveauMeteo;
	}

	/** Getter
	 * @return the dateReleve
	 */
	public String getDateReleve() {
		return dateReleve;
	}

	/** Setter
	 * @param dateReleve the dateReleve to set
	 */
	public void setDateReleve(String dateReleve) {
		this.dateReleve = dateReleve;
	}


	



}