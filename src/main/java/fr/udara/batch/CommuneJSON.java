package fr.udara.batch;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Classe POJO de données de Commune 
 * @author Udara
 *
 */
public class CommuneJSON {

	/** id de type Long ("id":2967103) */
	private Long id;
	/** name de type String ("name":"Peyrat-le-Chateau") */
	private String name;
	/** findname de type String ("findname":"PEYRAT-LE-CHATEAU") */
	private String findname;
	/** country de type String ("country":"FR") */
	private String country;
	/** lat de type Float, coordonnées GPS latitude ("coord":{"lon":1.77233,"lat":45.815781})  */
	private Float lat;
	/** lon de type Float, coordonnées GPS longitude ("coord":{"lon":1.77233,"lat":45.815781}) */
	private Float lon;
	
	/**
	 * Obtenir la valeur des clés  de l'objet "city"
	 * "id" en Long
	 * "name" en String
	 * "findname" en String
	 * "country" en String
	 * "lon" en Float de l'objet "coord" imbriqué
	 * "lat" en Float de l'objet "coord" imbriqué
	 * @param objet city
	 */
	@SuppressWarnings("unchecked")
	@JsonProperty("city")
	private void nested_city(Map<String, Object> city) {
		this.id = Long.parseLong(city.get("id").toString());
		this.name = city.get("name").toString();
		this.findname = city.get("findname").toString();
		this.country = city.get("country").toString();
		this.lat = Float.parseFloat(((Map<String,Object>)city.get("coord")).get("lat").toString());
		this.lon = Float.parseFloat(((Map<String,Object>)city.get("coord")).get("lon").toString());
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CommuneJSON [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", findname=");
		builder.append(findname);
		builder.append(", country=");
		builder.append(country);
		builder.append(", lon=");
		builder.append(lon);
		builder.append(", lat=");
		builder.append(lat);
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
	 * @return the findname
	 */
	public String getFindname() {
		return findname;
	}

	/** Setter
	 * @param findname the findname to set
	 */
	public void setFindname(String findname) {
		this.findname = findname;
	}

	/** Getter
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/** Setter
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
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

}
