/**
 * 
 */
package fr.udara.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.udara.dto.PageAccueilDTO;
import fr.udara.model.Commune;
import fr.udara.service.PageAccueilService;


/**
 * Controller appelé pour l'accès à la page d'accueil de l'appli :
 * infos météo + qualité de l'air + recensement
 * 
 * @author 	Udara
 *
 */
@RestController
@RequestMapping("/api/pagedaccueil")
public class PageAccueilController {
	
	/** niveauMeteoService */
	private final PageAccueilService pageAccueilService;
			
	/**
	 * Constructeur
	 * 
	 * @param pageAccueilService
	 */
	@Autowired
	public PageAccueilController(PageAccueilService pageAccueilService) {
		this.pageAccueilService = pageAccueilService;
	}
	
	/**
	 * Méthode de récupération des informations relatives à la
	 * meteo, la qualité de l'air et le recensement
	 * associées à une ville donnée
	 * 
	 * @return 
	 */
	@GetMapping
	public PageAccueilDTO home() {
		PageAccueilDTO pageAccueilDTO = new PageAccueilDTO();
		// D'où extraire la commune ? 
		Commune commune = new Commune();
		pageAccueilDTO.setNomCommune(commune.getNom());
		pageAccueilDTO.setPositionGPS(commune.getxCoordonnee() + " " + commune.getyCoordonnee());
		return pageAccueilDTO;
	}

}
