package fr.udara.batch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.udara.model.Commune;
import fr.udara.service.CommuneService;

//@Service
public class IntegrationRecensement {

	@Autowired
	public static CommuneService communeService;
	
	public static void traite() throws Exception {

		Path path = Paths.get("src/main/resources/recensement.csv");
		boolean estFichier = Files.isRegularFile(path);
		boolean estLisible = Files.isReadable(path);
		System.out.println(estFichier);
		System.out.println(estLisible);

		try {
			List<String> lignes = Files.readAllLines(path);
			int nbLigne = 0;
			for (int i = 2; i < lignes.size(); i++) {
				String ligne = lignes.get(i);
				ajout(ligne);
				nbLigne++;
				System.err.println("Ligne " + (i + 1) + " du tableau Excel enregistrée.");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void ajout(String ligne) {
		
		String[] decoupage = ligne.split(";", -1);
		String nom = decoupage[6];
		String departement = decoupage[2];
		String region = decoupage[1];
		Integer population = Integer.parseInt(decoupage[9]);
		System.out.println(nom + departement + region + decoupage[9]);
		Commune commune = new Commune(nom, departement, region, population);
		communeService.save(commune);


	}

}
