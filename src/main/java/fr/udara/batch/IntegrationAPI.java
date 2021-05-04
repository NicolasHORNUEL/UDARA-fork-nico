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

	
/**
 * Classe de service injectée au contexte Spring Boot.
 * Cette classe permet de récupérer des informations de niveau météo et d'indicateur d'air à heure régulière.
 * Elle a besoin de classe de service existant dans le contexte Spring Boot.
 * Elle a besoin du fichier src/main/resources/api.proprietes pour appeler l'API openweather.
 * A l'issue de sa boucle sur l'ensemble des Communes existantes en base de données,
 * un objet NiveauMeteo et un objet IndicateurAir sont enregistrés en base de donnée.
 * @author Udara
 *
 */
@Service
public class IntegrationAPI {

	/** Déclarer l'attribut ou Récupérer l'instance communeService */
	@Autowired private CommuneService communeService;
	/** Déclarer l'attribut ou Récupérer l'instance niveauMeteoService */
	@Autowired private NiveauMeteoService niveauMeteoService;
	/** Déclarer l'attribut ou Récupérer l'instance indicateurAirService */
	@Autowired private IndicateurAirService indicateurAirService;
	/** Déclarer l'attribut ou Déclaration de mapper de type ObjectMapper */
	@Autowired private ObjectMapper mapper;
	/** Déclaration de restTemplate de type RestTemplate */
	private RestTemplate restTemplate;
	/** Déclaration de fichierProperties de type ResourceBundle */
	private ResourceBundle fichierProperties;
	/**  Déclaration de API_URL : "https://api.openweathermap.org/data/2.5/" de type String */
	private String API_URL;
	/**  Déclaration de API_key_NiveauMeteo de type String */
	private String API_key_NiveauMeteo;
	/**  Déclaration de API_key_IndicateurAir de type String */
	private String API_key_IndicateurAir;

	
	/** 
	 * Constructeur d'injection de propriétés et d'instance supplémentaire au contexte Spring Boot.
	 * Le fichier src/main/resources/api.proprietes valorise les variables d'instance nécessaire à l'appel de l'API openweather.
	 * Les classes RestTemplate et ObjectMapper sont instanciées et injectées au contexte Spring Boot dès le démarrage de Spring Boot.
	 * La classe RestTemplate permet de passer des requetes http.
	 * La classe ObjectMapper est utilisé pour traduire la réponse http du format JSON en objet JAVA
	 */
	@Autowired
	public IntegrationAPI() {
		this.fichierProperties = ResourceBundle.getBundle("api");
		this.API_key_NiveauMeteo = fichierProperties.getString("api.key.niveau");
		this.API_key_IndicateurAir = fichierProperties.getString("api.key.indicateur");
		this.API_URL = fichierProperties.getString("api.url");
		this.restTemplate = new RestTemplate();
		this.mapper = new ObjectMapper();
		this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	/**
	 * Déclenchement des appels API tous les jours à 6h00, 12h00 et 18h00.
	 * @Scheduled est utilisable sur des méthodes avec un type de retour VOID.
	 */
	//@Scheduled(cron = "0 0 6,12,18 * * *") 	// tous les jours à 6h00, 12h00 et 18h00
	@Scheduled(cron = "0 0 18 * * *") 	// tous les jours à 12h00
	//@Scheduled(initialDelay = 0, fixedRate = Long.MAX_VALUE)
	//@Scheduled(cron = "0 12 15 * * *") 		// tous les jours à 15h12
	//@Scheduled(cron = "*/20 * * * * *") 		// toutes les 20 secondes
	public void traite() throws Exception {
		List<Commune> listeCommune = communeService.findAll();
		if (listeCommune.size() == 0) {
			//NettoyageFichier.nettoyer();
			IntegrationFile integrationFile = new IntegrationFile(communeService, mapper);
			integrationFile.traite();
		}
		for (int i = 0; i < listeCommune.size(); i++) {
			Commune commune = listeCommune.get(i);
			interroge(commune);
			Thread.sleep(500);
		}
	}
	
	
	/**
	 * Le nom de la commune passé en paramètre est utilisé pour interrogé l'API météo.
	 * La réponse de l'API est un JSON qui est désérialisé en objet JAVA.
	 * Chaque objet JAVA est ajouté à une map (String nom, Float valeur).
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
			System.out.println("RestClientException : " + e.getMessage());
			return "404";
		} catch (URISyntaxException e) {
			System.out.println("URISyntaxException : " + e.getMessage());
		}
		return "404";
	}
	
	


}
