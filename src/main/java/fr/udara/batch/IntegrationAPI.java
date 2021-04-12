package fr.udara.batch;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
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

	
@Service
public class IntegrationAPI {

	
	/** communeService */
	private CommuneService communeService;
	private NiveauMeteoService niveauMeteoService;
	private IndicateurAirService indicateurAirService;
	private RestTemplate restTemplate = new RestTemplate();
	private ObjectMapper mapper = new ObjectMapper();
	private String API_URL = "https://api.openweathermap.org/data/2.5/";	
	private String API_key_NiveauMeteo;
	private String API_key_IndicateurAir;
	private Commune commune;
	
	
	@Autowired
	public IntegrationAPI(CommuneService communeService, NiveauMeteoService niveauMeteoService, IndicateurAirService indicateurAirService) {
		ResourceBundle fichierProperties = ResourceBundle.getBundle("api");
		this.API_key_NiveauMeteo = fichierProperties.getString("api.key.niveau");
		this.API_key_IndicateurAir = fichierProperties.getString("api.key.indicateur");
		this.communeService = communeService;
		this.niveauMeteoService = niveauMeteoService;
		this.indicateurAirService = indicateurAirService;
		this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	/**
	 * Déclenchement des appels API tous les jours à 9h00, 12h00 et 18h00.
	 */
	@Scheduled(cron = "0 56 9,14,18 * * *")
	public void traite() throws Exception {
		System.out.println(this.API_key_NiveauMeteo);
		System.out.println(this.API_key_IndicateurAir);
		List<Commune> listeCommune = communeService.findAll();
		for (Commune commune : listeCommune) {
			this.commune = commune;
			interroge(commune);
			Thread.sleep(500);
		}
	}
	
	
	public void interroge(Commune commune) throws Exception {
		
		String nomCommune = URLEncoder.encode(commune.getNom(), "UTF-8");
		String urlNiveauMeteo = API_URL + "weather?q=" + nomCommune + "&appid=" + API_key_NiveauMeteo + "&units=metric";
		System.out.println(urlNiveauMeteo);

		String jsonNiveauMeteo = fetch(urlNiveauMeteo);
		if (jsonNiveauMeteo.indexOf("404") == -1) {
			LocalDateTime dateReleve = LocalDateTime.now();	
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
			if (jsonIndicateur.indexOf("404") == -1) {
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
		}
	}
	 
	
	
	public String fetch(String url) throws Exception {
		try {
			URI uri = new URI(url);
			ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
			return response.getBody();
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return url;
	}
	
	
//	public void process(HashMap<String, Float> map, AbstractValue abstractValue) {
//		LocalDateTime dateReleve = LocalDateTime.now();	
//		Iterator<String> iterCles = map.keySet().iterator();
//		while(iterCles.hasNext()) {
//			String nom = iterCles.next();
//			Float valeur = map.get(nom);
//			abstractValue.save(nom, valeur, dateReleve, commune);
//			System.out.println(nom + " : " + valeur);
//		}
//	}


}
