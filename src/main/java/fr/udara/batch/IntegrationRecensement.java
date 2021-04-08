package fr.udara.batch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.udara.model.Commune;
import fr.udara.service.CommuneService;

@Service
public class IntegrationRecensement {

	public static CommuneService communeService;
	
	//@Autowired
	public IntegrationRecensement(CommuneService communeService) {
		this.communeService = communeService;
	}
	
	
	public static void traite() throws Exception {

		Path path = Paths.get("src/main/resources/recensement.csv");

		try {
			
			LocalTime time1 = LocalTime.now();
			
			List<String> lignes = Files.readAllLines(path);
			int nbLigne = 0;
			for (int i = 2; i < lignes.size(); i++) {
				String ligne = lignes.get(i);
				ajout(ligne);
				nbLigne++;
				System.err.println("Ligne " + (i + 1) + " du tableau Excel enregistrée.");
			}
			
			LocalTime time2 = LocalTime.now();
			Duration duration = Duration.between(time1, time2);
			System.out.print("Traitement de " + nbLigne + " lignes effectué en " + duration.toMinutes() + " minutes.");

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void ajout(String ligne) {
		
		String[] decoupage = ligne.split(";", -1);
		String nom = decoupage[6];
		String departement = decoupage[2];
		String region = decoupage[1];
		Integer population = Integer.parseInt(decoupage[9].replaceAll(" ", ""));
		
		Commune commune = new Commune(nom, departement, region, population);
		communeService.save(commune);
		
	}
	

}
