package fr.udara.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe POJO de données Météo 
 * @author Udara
 *
 */
public class NiveauMeteoDTO {

	/** longitude : Float - xCoordonnee Latitude=X */
	private Float longitude;
	
	/** latitude : Float - yCoordonnee Longitude=Y */
	private Float latitude;
	
	/** temperature : Float - Température de perception humaine en degré Celsius */
	private Float temperature;
	
	/** vent : Float - Vitesse en métre par seconde */
	private Float vent;
	
	/** nuage : Float - Nébulosité en pourcentage */
	private Float nuage;
	
	/** pluie : Float - Humidité en pourcentage */
	private Float pluie;
	
	/** date : String */
	@JsonProperty("dt")
	private String date;

	/** indicateurMap : une map associant le nom (de type String) et la valeur (de type Float) d'un niveau Météo */
	private HashMap<String, Float> niveauMeteoMap = new HashMap<String, Float>();
	
	/**
	 * @param coord
	 */
	@JsonProperty("coord")
	private void nested_coord(Map<String, Float> coord) {
		this.longitude = coord.get("lon");
		this.latitude = coord.get("lat");
	}
	
	/**
	 * @param main
	 */
	@JsonProperty("main")
	private void nested_main(Map<String, Float> main) {
		this.temperature = main.get("feels_like");
		this.pluie = main.get("humidity");
		niveauMeteoMap.put("Température", this.temperature);
		niveauMeteoMap.put("Pluie", this.pluie);
	}
	
	/**
	 * @param wind
	 */
	@JsonProperty("wind")
	private void nested_wind(Map<String, Float> wind) {
		this.vent = wind.get("speed");
		niveauMeteoMap.put("Vent", this.vent);	
	}
	
	/**
	 * @param clouds
	 */
	@JsonProperty("clouds")
	private void nested_clouds(Map<String, Float> clouds) {
		this.nuage = clouds.get("all");
		niveauMeteoMap.put("Nuage", this.nuage);	
	}

	/** Getter
	 * @return the niveauMeteoMap
	 */
	public HashMap<String, Float> getNiveauMeteoMap() {
		return niveauMeteoMap;
	}

	/** Setter
	 * @param niveauMeteoMap the niveauMeteoMap to set
	 */
	public void setNiveauMeteoMap(HashMap<String, Float> niveauMeteoMap) {
		this.niveauMeteoMap = niveauMeteoMap;
	}

	/**
	 * Méthode toString pour afficher la valeur des attributs de l'instance
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MeteoData [longitude=");
		builder.append(longitude);
		builder.append(", latitude=");
		builder.append(latitude);
		builder.append(", temperature=");
		builder.append(temperature);
		builder.append(", vent=");
		builder.append(vent);
		builder.append(", nuage=");
		builder.append(nuage);
		builder.append(", pluie=");
		builder.append(pluie);
		builder.append(", date=");
		builder.append(date);
		builder.append("]");
		return builder.toString();
	}

	/** Getter
	 * @return the longitude
	 */
	public Float getLongitude() {
		return longitude;
	}

	/** Setter
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	/** Getter
	 * @return the latitude
	 */
	public Float getLatitude() {
		return latitude;
	}

	/** Setter
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	/** Getter
	 * @return the temperature
	 */
	public Float getTemperature() {
		return temperature;
	}

	/** Setter
	 * @param temperature the temperature to set
	 */
	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}

	/** Getter
	 * @return the vent
	 */
	public Float getVent() {
		return vent;
	}

	/** Setter
	 * @param vent the vent to set
	 */
	public void setVent(Float vent) {
		this.vent = vent;
	}

	/** Getter
	 * @return the nuage
	 */
	public Float getNuage() {
		return nuage;
	}

	/** Setter
	 * @param nuage the nuage to set
	 */
	public void setNuage(Float nuage) {
		this.nuage = nuage;
	}

	/** Getter
	 * @return the pluie
	 */
	public Float getPluie() {
		return pluie;
	}

	/** Setter
	 * @param pluie the pluie to set
	 */
	public void setPluie(Float pluie) {
		this.pluie = pluie;
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