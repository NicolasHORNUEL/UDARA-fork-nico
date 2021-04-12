package fr.udara.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class NettoyageFichier {

	public static void nettoyer() throws IOException {

		Path path = Paths.get("../../weather_16_origin.json");

		List<String> origine = Files.readAllLines(path);
		List<String> copie = new ArrayList<>();

		copie.add("PREMIERE LIGNE");
		
		for (int i = 0; i < origine.size(); i++) {

			String ligneOrigine = origine.get(i);
			String country = ligneOrigine.split(",")[3];

			if (country.indexOf("FR") != -1) {

				String name = ligneOrigine.split(",")[1];

				boolean exist = false;

				for (int j = 1; j < copie.size(); j++) {

					String ligneCopie = copie.get(j);
					
					if (ligneCopie.indexOf(name) != -1) {
						exist = true;
						System.err.println(name);
						System.err.println(exist);
						j = copie.size() - 1;
						copie.remove(j);
					} 
				}

				if (!exist) {
					System.out.println(exist);
					copie.add(ligneOrigine);
					System.out.println("i : " + i + " VILLE : " + name);
				}

			}
		}

		Path pathCible = Paths.get("../../weather_16.json");
		Files.write(pathCible, copie);
	}

}
