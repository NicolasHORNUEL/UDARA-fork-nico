/**
 * 
 */
package fr.udara.controller.notif;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.udara.service.CommuneService;

/**
 * @author Udara
 *
 */
@RestController
@RequestMapping("/api/notifications/Region")
public class RegionController {

	/** communeService : CommuneService */
	private final CommuneService communeService;

	/**
	 * Constructeur
	 * 
	 * @param communeService
	 */
	public RegionController(CommuneService communeService) {
		super();
		this.communeService = communeService;
	}

	/**
	 * @return la liste des regions
	 */
	@GetMapping
	public List<String> findRegion() {
		return communeService.findRegion();
	}

}
