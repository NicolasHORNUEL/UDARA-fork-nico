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

import fr.udara.dto.IndicateurAirDTO;
import fr.udara.dto.IndicateurAirWrapperDTO;
import fr.udara.dto.NiveauMeteoDTO;
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
	/** niveauMeteoService */
	private NiveauMeteoService niveauMeteoService;
	/** indicateurAirService */
	private IndicateurAirService indicateurAirService;
	/** restTemplate */
	private RestTemplate restTemplate = new RestTemplate();
	/** mapper */
	private ObjectMapper mapper;
	/** API_URL : "https://api.openweathermap.org/data/2.5/" */
	private String API_URL;
	/** API_key_NiveauMeteo */
	private String API_key_NiveauMeteo;
	/** API_key_IndicateurAir */
	private String API_key_IndicateurAir;
	
	
	@Autowired
	public IntegrationAPI(CommuneService communeService, NiveauMeteoService niveauMeteoService, IndicateurAirService indicateurAirService) {
		ResourceBundle fichierProperties = ResourceBundle.getBundle("api");
		this.API_key_NiveauMeteo = fichierProperties.getString("api.key.niveau");
		this.API_key_IndicateurAir = fichierProperties.getString("api.key.indicateur");
		this.API_URL = fichierProperties.getString("api.url");
		this.communeService = communeService;
		this.niveauMeteoService = niveauMeteoService;
		this.indicateurAirService = indicateurAirService;
		this.mapper = new ObjectMapper();
		this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		System.out.println("OK");
	}

	/**
	 * Déclenchement des appels API tous les jours à 6h00, 12h00 et 18h00.
	 */
	@Scheduled(cron = "0 19 12,14,18 * * *")
	public void traite() throws Exception {
		List<Commune> listeCommune = communeService.findAll();
		for (Commune commune : listeCommune) {
			interroge(commune);
			Thread.sleep(500);
		}
	}
	
	
	/**
	 * Le nom de la commune passé en paramètre est utilisé pour interrogé l'API météo.
	 * La réponse de l'API est un JSON qui est désérialisé en objet JAVA.
	 * Chaque objet est ajouté à une map (String nom, Float valeur).
	 * Celle-ci permet de boucler sur l'ensemble des clé/valeur de la réponse de l'API.
	 * Cette boucle permet d'instancier une classe entité et enfin enregistrer en base les objets créés.
	 * @param un objet commune
	 * @throws Exception
	 */
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
	 
	
	
	/**
	 * @param url d'API : les variables/paramétres à la requête GET sont présents dans le path.
	 * @return une string : un objet litteral de type json.
	 * @throws Exception
	 */
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
	
	


}
