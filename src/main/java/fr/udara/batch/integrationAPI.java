package fr.udara.batch;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class integrationAPI {
	
	
public static void traite() throws Exception {
	RestTemplate restTemplate = new RestTemplate();
	
	String API_key = "5365db9398346b11fec2438e41e3563b";
	String city_name = "Montpellier";
	String metrics = "metrics";
	String url_Meteo = "https://api.openweathermap.org/data/2.5/weather?q=" + city_name + "&appid=" + API_key + "&units=" + metrics;		
	URI uri = new URI(url_Meteo);
	
	ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
	String jsonString = response.getBody();
	
	ObjectMapper mapper = new ObjectMapper();
	mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	
	MeteoData bean = mapper.readValue(jsonString, MeteoData.class);
	System.out.println(bean);

	
	String url_Indicateur = "http://api.openweathermap.org/data/2.5/air_pollution?lat=" + bean.getLatitude() + "&lon=" + bean.getLongitude() + "&appid=" + API_key;	
	URI uri_Indicateur = new URI(url_Indicateur);
	ResponseEntity<String> response_Indicateur = restTemplate.getForEntity(uri_Indicateur, String.class);
	String jsonString_Indicateur = response_Indicateur.getBody();		
	IndicateurDataWrapper bean_Indicateur = mapper.readValue(jsonString_Indicateur, IndicateurDataWrapper.class);
	System.out.println(bean_Indicateur.getIndicateurDatas());
}

}
