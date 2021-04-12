package fr.udara.batch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.udara.dto.CommuneDTO;
import fr.udara.model.Commune;
import fr.udara.service.CommuneService;

//@Service
public class IntegrationFile {

	@Autowired
	private CommuneService communeService;
	@Autowired
	private ObjectMapper mapper;

	private Path pathJSON;
	private Path pathCSV;

	//@Autowired
//	public IntegrationFile(CommuneService communeService) {
//		this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//		this.communeService = communeService;
//	}
	//@Autowired
	public IntegrationFile(CommuneService communeService) {
		this.pathJSON = Paths.get("src/main/resources/weather_16.json");
		this.pathCSV = Paths.get("src/main/resources/recensement.csv");
		this.mapper = new ObjectMapper();
		this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		this.communeService = communeService;

	}

	/**
	 * Méthode traite qui exécute la lecture du fichier weather_16.json ligne par ligne.
	 * Chaque ligne du fichier est un objet litteral de type JSON.
	 * l'objet json est ensuite désérialisé en objet JAVA.
	 * la valeur nom (d'une ville consultable sur l'API) est interrogé 
	 * Chaque objet JAVA est ajouté à une map (String nom, Float valeur).
	 * Celle-ci permet de boucler sur l'ensemble des clé/valeur de la réponse de l'API.
	 * Cette boucle permet d'instancier une classe entité et enfin enregistrer en base les objets créés.
	 * @throws Exception
	 */
	public void traite() throws Exception {

		try {

			LocalTime time1 = LocalTime.now();

			List<String> lignesJSON = Files.readAllLines(pathJSON);
			List<String> lignesCSV = Files.readAllLines(pathCSV);

			int nbLigneJSON_FR = 0;
			int nbLigneSave = 0;

			for (String jsonCommune : lignesJSON) {

				CommuneDTO pojo = mapper.readValue(jsonCommune, CommuneDTO.class);

				Float lat = pojo.getLat(); // Latitude=X
				Float lon = pojo.getLon(); // Longitude=Y
				String nom = pojo.getName();
				String departement = null;
				String region = null;
				Integer maxPop = 0;
				Integer population = 0;

				int nbOccurence = 0;

				for (int i = 2; i < lignesCSV.size(); i++) {
					String string = lignesCSV.get(i);
					String[] decoupage = string.split(";", -1);
					String nomVille = decoupage[6];
					
					if (nom.equals(nomVille)) {
						
						nbOccurence += 1;
						if (nbOccurence > 1) {
							i = lignesCSV.size() - 1;
						} else {
							population = Integer.parseInt(decoupage[9].replaceAll(" ", ""));
							if (population > maxPop) {
								maxPop = population;
								departement = decoupage[2];
								region = decoupage[1];
							}
						}
					}
				}

				nbLigneJSON_FR++;

				if (nbOccurence == 1) {
					nom = nom.toLowerCase();
					region = region.toLowerCase();
					Commune commune = new Commune(nom, departement, region, maxPop, lat, lon);
					communeService.save(commune);
					System.out.println("Ligne: " + nbLigneJSON_FR + "/8815, Commune ENREGISTRÉE : " + nom + ". (Nombre d'occurence dans le fichier de recensement: " + nbOccurence + ").");
					nbLigneSave++;
				} else {
					System.err.println("Ligne: " + nbLigneJSON_FR + "/8815, Commune INVALIDÉE   : " + nom + ". (Nombre d'occurence dans le fichier de recensement: " + nbOccurence + ").");
				}

			}
			LocalTime time2 = LocalTime.now();
			Duration duration = Duration.between(time1, time2);
			System.out.print("Traitement des 8815 lignes du fichier weather_16.json effectué en " + duration.toMinutes() + " minutes. "
					+ nbLigneSave + " communes enregistrées.");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
