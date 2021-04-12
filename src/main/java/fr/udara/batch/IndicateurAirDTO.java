package fr.udara.batch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe DTO de données d'indicateur associé à la réponse JSON de l'API openweather : à chaque clé, sa valeur.
 * @author udara
 *
 */
public class IndicateurAirDTO {

	/** noms : une liste de String, tous les polluants existant dans l'API */
	private List<String> noms =  Arrays.asList("co","no","no2","o3","so2","pm2_5","pm10","nh3");
	
	/** indicateurMap : une map associant le nom (de type String) et la valeur (de type Float) d'un indicateur */
	private HashMap<String, Float> indicateurMap = new HashMap<String, Float>();
	
	/**
	 * Obtenir la valeur des clés "co","no","no2","o3","so2","pm2_5","pm10","nh3" de l'objet JSON
	 * Associer les valeurs avec le nom des indicateurs dans une Map
	 * @param objet JSON components
	 */
	@JsonProperty("components")
	private void nested_components(Map<String, Float> components) {
		for (String nom : noms) {
			indicateurMap.put(nom, components.get(nom));	
		}	
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IndicateurAirDTO [noms=");
		builder.append(noms);
		builder.append(", indicateurMap=");
		builder.append(indicateurMap);
		builder.append("]");
		return builder.toString();
	}

	/** Getter
	 * @return the noms
	 */
	public List<String> getNoms() {
		return noms;
	}

	/** Setter
	 * @param noms the noms to set
	 */
	public void setNoms(List<String> noms) {
		this.noms = noms;
	}

	/** Getter
	 * @return the indicateurMap
	 */
	public HashMap<String, Float> getIndicateurMap() {
		return indicateurMap;
	}

	/** Setter
	 * @param indicateurMap the indicateurMap to set
	 */
	public void setIndicateurMap(HashMap<String, Float> indicateurMap) {
		this.indicateurMap = indicateurMap;
	}


	
	
}



