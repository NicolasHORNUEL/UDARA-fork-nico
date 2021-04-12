package fr.udara.batch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.udara.dto.CommuneDTO;
import fr.udara.model.Commune;
import fr.udara.service.CommuneService;

/**
 *  Classe de service non injecté au contexte Spring Boot.
 *  Elle permet d'intégrer par lot un enregistrement de données élémentaires à l'application.
 *  Elle est donc utilisable au lancement ou changement de base de données.
 * @author udara
 *
 */
public class IntegrationFile {

	/** Déclarer l'attribut ou Récupérer l'instance communeService */
	@Autowired private CommuneService communeService;
	/** Déclarer l'attribut ou Déclaration de mapper de type ObjectMapper */
	@Autowired private ObjectMapper mapper;
	/**  Fichier weather_16.json téléchargé à l'adresse : https://openweathermap.org/bulk
	 * Pour permettre d’appeler l'API et obtenir un résultat sans ambiguïté. 
	 * 209_578 villes disponibles dont 19_965 villes FRANÇAISES
	 * Le fichier a été nettoyé pour enlever les doublons afin d'éviter des réponses d'API en tableau
	 * et pouvoir associer les fichiers json et csv sans AUCUNE ambiguité 
	 * Seul 8_815 villes sont valides */
	private Path pathJSON = Paths.get("src/main/resources/weather_16.json");
	/**  Fichier recensement.csv fourni par Diginamic. 35_500 villes FRANÇAISES */
	private Path pathCSV = Paths.get("src/main/resources/recensement.csv");

	/**
	 * Constructeur de valorisation d'attribut avec les Beans communeService et ObjectMapper.
	 * L'objet mapper est instancié au démarrage de l'application dans la méthode run() car il est utilisé dans la classe IntegrationAPI quotidiennement.
	 */
	public IntegrationFile(CommuneService communeService, ObjectMapper mapper) {
		this.mapper = mapper;
		this.communeService = communeService;
	}

	/**
	 * Méthode qui exécute la lecture du fichier weather_16.json, ligne par ligne.
	 * Chaque ligne du fichier est un objet litteral de type JSON.
	 * l'objet json est ensuite désérialisé en objet JAVA avec ObjetMapper.
	 * Les attributs nom, latitude et longitude de l'objet Commune sont valorisés grâce à ce fichier.
	 * Ensuite la valeur de l'attribut "nom" de cet objet (le nom d'une ville consultable sur l'API) est cherché sur le fichier CVS de recensement.
	 * Si une, et une seule occurence est trouvée alors les attributs region, departement, et population sont valorisés.
	 * Un objet Commune est donc enregistré en base de données avec toutes ces valeurs nécessaires.
	 * 5_865 communes sont enregistrables.
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
					System.out.println("Ligne: " + nbLigneJSON_FR + "/8815 (Nombre d'occurence dans le fichier de recensement: " + nbOccurence + " ), Commune ENREGISTRÉE : " + nom);
					nbLigneSave++;
				} else {
					System.err.println("Ligne: " + nbLigneJSON_FR + "/8815 (Nombre d'occurence dans le fichier de recensement: " + nbOccurence + " ), Commune ENREGISTRÉE : " + nom);
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
