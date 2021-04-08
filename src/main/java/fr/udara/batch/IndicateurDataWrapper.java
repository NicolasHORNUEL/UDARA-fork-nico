package fr.udara.batch;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IndicateurDataWrapper {
	
	@JsonProperty("list")
	private List<IndicateurData> indicateurDatas = new ArrayList<>();

	/** Getter
	 * @return the indicateurDatas
	 */
	public List<IndicateurData> getIndicateurDatas() {
		return indicateurDatas;
	}

	/** Setter
	 * @param indicateurDatas the indicateurDatas to set
	 */
	public void setIndicateurDatas(List<IndicateurData> indicateurDatas) {
		this.indicateurDatas = indicateurDatas;
	}
	

}
