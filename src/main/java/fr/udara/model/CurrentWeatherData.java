package fr.udara.model;

import com.fasterxml.jackson.annotation.JsonRawValue;

public class CurrentWeatherData {
	
	 @JsonRawValue
	 private String json;

	 
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CurrentWeatherData [json=");
		builder.append(json);
		builder.append("]");
		return builder.toString();
	}

	/** Getter
	 * @return the json
	 */
	public String getJson() {
		return json;
	}

	/** Setter
	 * @param json the json to set
	 */
	public void setJson(String json) {
		this.json = json;
	}

	 
	 
	




}