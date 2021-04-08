package fr.udara.batch;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Udara
 *
 */
public class MeteoData {

	/** longitude : String */
	private String longitude;
	
	/** latitude : String */
	private String latitude;
	
	/** temperature : String */
	private String temperature;
	
	/** vent : String */
	private String vent;
	
	/** nuage : String */
	private String nuage;
	
	/** pluie : String */
	private String pluie;
	
	/** date : String */
	@JsonProperty("dt")
	private String date;

	
	/**
	 * @param coord
	 */
	@JsonProperty("coord")
	private void nested_coord(Map<String, String> coord) {
		this.longitude = coord.get("lon");
		this.latitude = coord.get("lat");
	}
	
	/**
	 * @param main
	 */
	@JsonProperty("main")
	private void nested_main(Map<String, String> main) {
		this.temperature = main.get("feels_like");
	}
	
	/**
	 * @param wind
	 */
	@JsonProperty("wind")
	private void nested_wind(Map<String, String> wind) {
		this.vent = wind.get("speed");
	}
	
	/**
	 * @param clouds
	 */
	@JsonProperty("clouds")
	private void nested_clouds(Map<String, String> clouds) {
		this.nuage = clouds.get("all");
	}
	
	/**
	 * @param rain
	 */
	@JsonProperty("rain")
	private void nested_rain(Map<String, String> rain) {
		this.pluie = rain.get("1h");
	}

//	@JsonProperty("department")
//	private void mapDepartmentName(Map<String,Object department) {
//	this.departName = ((Map<String,String>)department.get("departInfo")).get("departName");
//	}


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
	public String getLongitude() {
		return longitude;
	}

	/** Setter
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/** Getter
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/** Setter
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/** Getter
	 * @return the temperature
	 */
	public String getTemperature() {
		return temperature;
	}

	/** Setter
	 * @param temperature the temperature to set
	 */
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	/** Getter
	 * @return the vent
	 */
	public String getVent() {
		return vent;
	}

	/** Setter
	 * @param vent the vent to set
	 */
	public void setVent(String vent) {
		this.vent = vent;
	}

	/** Getter
	 * @return the nuage
	 */
	public String getNuage() {
		return nuage;
	}

	/** Setter
	 * @param nuage the nuage to set
	 */
	public void setNuage(String nuage) {
		this.nuage = nuage;
	}

	/** Getter
	 * @return the pluie
	 */
	public String getPluie() {
		return pluie;
	}

	/** Setter
	 * @param pluie the pluie to set
	 */
	public void setPluie(String pluie) {
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