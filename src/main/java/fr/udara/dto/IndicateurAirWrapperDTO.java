package fr.udara.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe DTO de données d'indicateur associé à la réponse JSON de l'API openweather.
 * @author udara
 *
 */
public class IndicateurAirWrapperDTO {
	
	/** indicateurAirDTOs : une liste d'indicateurAirDTO */
	@JsonProperty("list")
	private List<IndicateurAirDTO> indicateurAirDTOs = new ArrayList<>();

	/** Getter
	 * @return la liste d'objet indicateurAirDTO
	 */
	public List<IndicateurAirDTO> getIndicateurAirDTOs() {
		return indicateurAirDTOs;
	}

	/** Setter
	 * @param IndicateurAirDTOs the IndicateurAirDTOs to set
	 */
	public void setIndicateurAirDTO(List<IndicateurAirDTO> indicateurAirDTOs) {
		this.indicateurAirDTOs = indicateurAirDTOs;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IndicateurAirWrapperDTO [indicateurAirDTOs=");
		builder.append(indicateurAirDTOs);
		builder.append("]");
		return builder.toString();
	}
	

}
