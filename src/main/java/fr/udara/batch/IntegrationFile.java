package fr.udara.batch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.udara.model.Commune;
import fr.udara.service.CommuneService;

@Service
public class IntegrationFile {

	public static CommuneService communeService;
	private static ObjectMapper mapper = new ObjectMapper();
	private static Path pathJSON = Paths.get("src/main/resources/weather_16.json");
	private static Path pathCSV = Paths.get("src/main/resources/recensement.csv");

	@Autowired
	public IntegrationFile(CommuneService communeService) {
		this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		this.communeService = communeService;
	}

	public static void traite() throws Exception {
		
		try {
			
			LocalTime time1 = LocalTime.now();
			
			List<String> lignesJSON = Files.readAllLines(pathJSON);
			List<String> lignesCSV = Files.readAllLines(pathCSV);

			int nbLigneJSON_FR = 1;
			int nbLigneSave = 1;
			
			for (String jsonCommune : lignesJSON) {
				
				CommuneJSON pojo = mapper.readValue(jsonCommune, CommuneJSON.class);
				
				if (pojo.getCountry().equals("FR")) {
					Float lat = pojo.getLat(); // Latitude=X
					Float lon = pojo.getLon(); // Longitude=Y
					String nom = pojo.getName();
					String departement = null;
					String region = null;
					Integer maxPop = 0;
					Integer population = 0;
					
					for (int i = 2; i < lignesCSV.size(); i++) {
						String string = lignesCSV.get(i);
						String[] decoupage = string.split(";", -1);
						String nomVille = decoupage[6];
						if (nom.equals(nomVille)) {
							population = Integer.parseInt(decoupage[9].replaceAll(" ", ""));
							if (population > maxPop) {
								maxPop = population;
								departement = decoupage[2];
								region = decoupage[1];
							}
						}
					}
					
					if (maxPop > 10000) {
						Commune commune = new Commune(nom, departement, region, maxPop, lat, lon);
						communeService.save(commune);
						System.out.println("LigneJSON_FR : " + nbLigneJSON_FR + ", Commune enregistrée : " + pojo.getName());
						nbLigneSave++;
					}
	
					nbLigneJSON_FR++;

				}
				
			}
			LocalTime time2 = LocalTime.now();
			Duration duration = Duration.between(time1, time2);
			System.out.print("Traitement de " + nbLigneJSON_FR + " lignes effectué en " + duration.toMinutes() + " minutes. " + nbLigneSave + " communes enregistrées.");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}



}
