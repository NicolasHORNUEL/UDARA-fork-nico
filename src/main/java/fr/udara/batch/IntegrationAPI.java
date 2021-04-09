package fr.udara.batch;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.udara.model.Commune;
import fr.udara.service.CommuneService;

	
@Service
public class IntegrationAPI {

	@Autowired
	private static CommuneService communeService;
	private static RestTemplate restTemplate = new RestTemplate();
	private static ObjectMapper mapper = new ObjectMapper();
	private static String url_Meteo = "https://api.openweathermap.org/data/2.5/weather?";
	private static String url_Indicateur = "http://api.openweathermap.org/data/2.5/air_pollution?";
	private static String API_key = "5365db9398346b11fec2438e41e3563b";
	private static String metrics = "metrics";
	
	@Autowired
	public IntegrationAPI(CommuneService communeService) {
		this.communeService = communeService;
		this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	public static void traite() throws Exception {
		List<Commune> listeCommune = communeService.findAll();
		for (Commune commune : listeCommune) {
			String nomCommune = URLEncoder.encode(commune.getNom(), "UTF-8");
			interroge(nomCommune);
			Thread.sleep(10000);
		}
	}
	
	
	public static void interroge(String nomCommune) throws Exception {
		
		url_Meteo += "q=" + nomCommune + "&appid=" + API_key + "&units=" + metrics;
		String jsonMeteo = fetch(url_Meteo);
		MeteoData bean = mapper.readValue(jsonMeteo, MeteoData.class);

		url_Indicateur += "lat=" + bean.getLatitude() + "&lon=" + bean.getLongitude() + "&appid=" + API_key;
		String jsonIndicateur = fetch(url_Indicateur);
		IndicateurDataWrapper bean_Indicateur = mapper.readValue(jsonIndicateur, IndicateurDataWrapper.class);
		
		System.out.println("bean_Indicateur.getIndicateurDatas() : " + bean_Indicateur.getIndicateurDatas());
		
	}
	
	public static String fetch(String url) throws Exception {
			
		try {
			URI uri = new URI(url);
			ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
			String jsonString = response.getBody();
			
			System.out.println(jsonString);

			return jsonString;
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;

	}

}
