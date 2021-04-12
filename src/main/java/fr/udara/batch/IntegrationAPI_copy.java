package fr.udara.batch;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.udara.model.Commune;
import fr.udara.model.IndicateurAir;
import fr.udara.model.NiveauMeteo;
import fr.udara.service.CommuneService;
import fr.udara.service.IndicateurAirService;
import fr.udara.service.NiveauMeteoService;

	
//@Service
public class IntegrationAPI_copy {

	
	/** communeService */
	private static CommuneService communeService;
	private static NiveauMeteoService niveauMeteoService;
	private static IndicateurAirService indicateurAirService;
	private static RestTemplate restTemplate = new RestTemplate();
	private static ObjectMapper mapper = new ObjectMapper();
	private static String API_URL = "https://api.openweathermap.org/data/2.5/";	
	private static String API_key_NiveauMeteo = "35595a57302ef787310ab42e25caee5b";
	private static String API_key_IndicateurAir = "874668853d8469f7d7c2fa58e57a23f7";

	private static String metric = "metric";
	private Commune commune;
	
	
	//@Autowired
	public IntegrationAPI_copy(CommuneService communeService, NiveauMeteoService niveauMeteoService, IndicateurAirService indicateurAirService) {
		this.communeService = communeService;
		this.niveauMeteoService = niveauMeteoService;
		this.indicateurAirService = indicateurAirService;
		this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	/**
	 * Déclenchement des appels API tous les jours à 6h00, 12h00 et 18h00.
	 */
	@Scheduled(cron = "0 0 6,12,18 * * *")
	public static void traite() throws Exception {
		List<Commune> listeCommune = communeService.findAll();
		for (Commune commune : listeCommune) {
			System.err.println(commune.getNom());
			interroge(commune);
			Thread.sleep(500);
		}
	}
	
	
	public static void interroge(Commune commune) throws Exception {
		
		LocalDateTime dateReleve = LocalDateTime.now();	
		String nomCommune = URLEncoder.encode(commune.getNom(), "UTF-8");

		String urlNiveauMeteo = API_URL + "weather?q=" + nomCommune + "&appid=" + API_key_NiveauMeteo + "&units=" + metric;
		
		System.out.println(urlNiveauMeteo);
		String jsonNiveauMeteo = fetch(urlNiveauMeteo);
		NiveauMeteoDTO beanNiveauMeteo = mapper.readValue(jsonNiveauMeteo, NiveauMeteoDTO.class);
		HashMap<String, Float> mapNiveauMeteo = beanNiveauMeteo.getNiveauMeteoMap();
		Iterator<String> iterClesNiveauMeteo = mapNiveauMeteo.keySet().iterator();
		while(iterClesNiveauMeteo.hasNext()) {
			String nom = iterClesNiveauMeteo.next();
			Float valeur = mapNiveauMeteo.get(nom);
			NiveauMeteo niveauMeteo = new NiveauMeteo(nom, valeur, dateReleve, commune);
			niveauMeteoService.save(niveauMeteo);
			System.out.println(nom + " : " + valeur);
		}

		String urlIndicateurAir = API_URL + "air_pollution?lat=" + beanNiveauMeteo.getLatitude() + "&lon=" + beanNiveauMeteo.getLongitude() + "&appid=" + API_key_IndicateurAir;
		System.out.println(urlIndicateurAir);

		String jsonIndicateur = fetch(urlIndicateurAir);
		IndicateurAirWrapperDTO beanIndicateur = mapper.readValue(jsonIndicateur, IndicateurAirWrapperDTO.class);
		List<IndicateurAirDTO> indicateurAirDTOs = beanIndicateur.getIndicateurAirDTOs();
		for (IndicateurAirDTO indicateurAirDTO : indicateurAirDTOs) {
			HashMap<String, Float> mapIndicateur = indicateurAirDTO.getIndicateurMap();
			Iterator<String> iterClesIndicateur = mapIndicateur.keySet().iterator();
			while(iterClesIndicateur.hasNext()) {
				String nom = iterClesIndicateur.next();
				Float valeur = mapIndicateur.get(nom);
				IndicateurAir indicateurAir = new IndicateurAir(nom, valeur, dateReleve, commune);
				indicateurAirService.save(indicateurAir);
				System.out.println(nom + " : " + valeur);
			}
		}	
	}
	 
	
	
	public static String fetch(String url) throws Exception {
		try {
			URI uri = new URI(url);
			ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
			String jsonString = response.getBody();
			return jsonString;
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return url;
	}
	

}
