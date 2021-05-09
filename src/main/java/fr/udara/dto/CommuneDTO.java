package fr.udara.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Classe de données de Commune 
 * @author Udara
 *
 */
public class CommuneDTO {

	/** id : Long */
	private Long id;
	/** name de type String ("name":"Peyrat-le-Chateau") */
	private String name;
	/** lat de type Float, coordonnées GPS latitude ("coord":{"lon":1.77233,"lat":45.815781})  */
	private Float lat;
	/** lon de type Float, coordonnées GPS longitude ("coord":{"lon":1.77233,"lat":45.815781}) */
	private Float lon;
	/** departement : String */
	private String departement;
	/** region : String */
	private String region;
	/** population : Integer */
	private Integer population;
	
	/**
	 * Obtenir la valeur des clés  de l'objet "city"
	 * "id" en Long
	 * "name" en String
	 * "findname" en String
	 * "lon" en Float de l'objet "coord" imbriqué
	 * "lat" en Float de l'objet "coord" imbriqué
	 * @param objet city
	 */
	@SuppressWarnings("unchecked")
	@JsonProperty("city")
	private void nested_city(Map<String, Object> city) {
		this.name = city.get("name").toString();
		this.lat = Float.parseFloat(((Map<String,Object>)city.get("coord")).get("lat").toString());
		this.lon = Float.parseFloat(((Map<String,Object>)city.get("coord")).get("lon").toString());
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CommuneDTO [name=");
		builder.append(name);
		builder.append(", lat=");
		builder.append(lat);
		builder.append(", lon=");
		builder.append(lon);
		builder.append(", departement=");
		builder.append(departement);
		builder.append(", region=");
		builder.append(region);
		builder.append(", population=");
		builder.append(population);
		builder.append("]");
		return builder.toString();
	}



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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/** Setter
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** Getter
	 * @return the lon
	 */
	public Float getLon() {
		return lon;
	}

	/** Setter
	 * @param lon the lon to set
	 */
	public void setLon(Float lon) {
		this.lon = lon;
	}

	/** Getter
	 * @return the lat
	 */
	public Float getLat() {
		return lat;
	}

	/** Setter
	 * @param lat the lat to set
	 */
	public void setLat(Float lat) {
		this.lat = lat;
	}

	/** Getter
	 * @return the departement
	 */
	public String getDepartement() {
		return departement;
	}

	/** Setter
	 * @param departement the departement to set
	 */
	public void setDepartement(String departement) {
		this.departement = departement;
	}

	/** Getter
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/** Setter
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/** Getter
	 * @return the population
	 */
	public Integer getPopulation() {
		return population;
	}

	/** Setter
	 * @param population the population to set
	 */
	public void setPopulation(Integer population) {
		this.population = population;
	}

}
