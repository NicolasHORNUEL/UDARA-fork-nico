package fr.udara.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Udara
 *
 */
public class CurrentWeatherData {

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
		builder.append("CurrentWeatherData [longitude=");
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
	
	
	
}