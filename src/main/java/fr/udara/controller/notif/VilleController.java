/**
 * 
 */
package fr.udara.controller.notif;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.udara.service.CommuneService;

/**
 * @author manon
 *
 */
@RestController
@RequestMapping("/api/notifications/communes")
public class VilleController {
	
	/** communeService : CommuneService */
	private final CommuneService communeService;

	/**
	 * Constructeur 
	 * @param communeService
	 */
	public VilleController(CommuneService communeService) {
		super();
		this.communeService = communeService;
	}
	
	/**
	 * @return la liste de toute les communes
	 */
	@GetMapping
	public List<String> findAllNomCommune() {
		return communeService.findAllNomCommune();
	}
	
	
	/**
	 * @param region
	 * @return la liste des communes pour une region donné
	 */
	@GetMapping("{nom-region}")
	public List<String> findNomCommuneByRegion(@PathVariable(name = "nom-region") String region) {
		return communeService.findNomCommuneByRegion(region);
	}
	

}
