package fr.udara.batch;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe POJO de données d'indicateur 
 * @author udara
 *
 */
public class IndicateurData {
	
	/** Сoncentration of CO (Carbon monoxide), μg/m3 : Float */
	private Float co;
	/** Сoncentration of NO (Nitrogen monoxide), μg/m3 : Float */
	private Float no;
	/** Сoncentration of NO2 (Nitrogen dioxide), μg/m3 : Float */
	private Float no2;
	/** Сoncentration of O3 (Ozone), μg/m3 : Float */
	private Float o3;
	/** Сoncentration of SO2 (Sulphur dioxide), μg/m3 : Float */
	private Float so2;
	/** Сoncentration of PM2.5 (Fine particles matter), μg/m3 : Float */
	private Float pm2_5;
	/** Сoncentration of PM10 (Coarse particulate matter), μg/m3 : Float */
	private Float pm10;
	/** Сoncentration of NH3 (Ammonia), μg/m3 : Float */
	private Float nh3;
	
	/**
	 * Obtenir la valeur des clés "co","no","no2","o3","so2","pm2_5","pm10","nh3"
	 * @param objet components
	 */
	@JsonProperty("components")
	private void nested_co(Map<String, Float> components) {
		this.co = components.get("co");
		this.no = components.get("no");
		this.no2 = components.get("no2");
		this.o3 = components.get("o3");
		this.so2 = components.get("so2");
		this.pm2_5 = components.get("pm2_5");
		this.pm10 = components.get("pm10");
		this.nh3 = components.get("nh3");
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IndicateurData [co=");
		builder.append(co);
		builder.append(", no=");
		builder.append(no);
		builder.append(", no2=");
		builder.append(no2);
		builder.append(", o3=");
		builder.append(o3);
		builder.append(", so2=");
		builder.append(so2);
		builder.append(", pm2_5=");
		builder.append(pm2_5);
		builder.append(", pm10=");
		builder.append(pm10);
		builder.append(", nh3=");
		builder.append(nh3);
		builder.append("]");
		return builder.toString();
	}

	/** Getter
	 * @return the co
	 */
	public Float getCo() {
		return co;
	}

	/** Setter
	 * @param co the co to set
	 */
	public void setCo(Float co) {
		this.co = co;
	}

	/** Getter
	 * @return the no
	 */
	public Float getNo() {
		return no;
	}

	/** Setter
	 * @param no the no to set
	 */
	public void setNo(Float no) {
		this.no = no;
	}

	/** Getter
	 * @return the no2
	 */
	public Float getNo2() {
		return no2;
	}

	/** Setter
	 * @param no2 the no2 to set
	 */
	public void setNo2(Float no2) {
		this.no2 = no2;
	}

	/** Getter
	 * @return the o3
	 */
	public Float getO3() {
		return o3;
	}

	/** Setter
	 * @param o3 the o3 to set
	 */
	public void setO3(Float o3) {
		this.o3 = o3;
	}

	/** Getter
	 * @return the so2
	 */
	public Float getSo2() {
		return so2;
	}

	/** Setter
	 * @param so2 the so2 to set
	 */
	public void setSo2(Float so2) {
		this.so2 = so2;
	}

	/** Getter
	 * @return the pm25
	 */
	public Float getPm25() {
		return pm2_5;
	}

	/** Setter
	 * @param pm25 the pm25 to set
	 */
	public void setPm25(Float pm25) {
		this.pm2_5 = pm25;
	}

	/** Getter
	 * @return the pm10
	 */
	public Float getPm10() {
		return pm10;
	}

	/** Setter
	 * @param pm10 the pm10 to set
	 */
	public void setPm10(Float pm10) {
		this.pm10 = pm10;
	}

	/** Getter
	 * @return the nh3
	 */
	public Float getNh3() {
		return nh3;
	}

	/** Setter
	 * @param nh3 the nh3 to set
	 */
	public void setNh3(Float nh3) {
		this.nh3 = nh3;
	}
	
	
}
