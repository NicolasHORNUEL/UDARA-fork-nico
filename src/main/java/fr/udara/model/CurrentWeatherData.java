package fr.udara.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentWeatherData {

	private String longitude;
	private String latitude;
	private String temperature;
	private String vent;
	private String nuage;
	private String pluie;
	@JsonProperty("dt")
	private String date;

	
	@JsonProperty("coord")
	private void nested_coord(Map<String, String> coord) {
		this.longitude = coord.get("lon");
		this.latitude = coord.get("lat");
	}
	
	@JsonProperty("main")
	private void nested_main(Map<String, String> main) {
		this.temperature = main.get("feels_like");
	}
	
	@JsonProperty("wind")
	private void nested_wind(Map<String, String> wind) {
		this.vent = wind.get("speed");
	}
	
	@JsonProperty("clouds")
	private void nested_clouds(Map<String, String> clouds) {
		this.nuage = clouds.get("all");
	}
	
	@JsonProperty("rain")
	private void nested_rain(Map<String, String> rain) {
		this.pluie = rain.get("1h");
	}

//	@JsonProperty("department")
//	private void mapDepartmentName(Map<String,Object department) {
//	this.departName = ((Map<String,String>)department.get("departInfo")).get("departName");
//	}


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