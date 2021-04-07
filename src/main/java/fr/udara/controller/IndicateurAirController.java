/**
 * 
 */
package fr.udara.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.udara.exception.BadRequestException;

/**
 * @author UDARA
 *
 */
@RestController
@RequestMapping("/api/indicateurair")
public class IndicateurAirController {
	
	/** indicateurAirService */
	private final IndicateurAirService indicateurAirService;

	/**
	 * Constructeur
	 * 
	 * @param indicateurAirService
	 */
	@Autowired
	public IndicateurAirController(indicateurAirService indicateurAirService) {
		this.indicateurAirService = indicateurAirService;
	}

	/**
	 * Méthode de récupération de toutes les indicateurAirs
	 * 
	 * @return la liste de toutes les indicateurAirs
	 */
	@GetMapping
	public List<IndicateurAir> findAll() {
		return indicateurAirService.findAll();
	}

	/**
	 * Méthode de récupération d'une indicateurAir selon son id
	 * 
	 * @param id id de la indicateurAir ciblée
	 * @return la indicateurAir dont l'id est passé en paramètre
	 */
	@GetMapping("{indicateurAir-id}")
	public IndicateurAir findById(@PathVariable(name = "indicateurAir-id") Long id) {
		return indicateurAirService.findById(id);
	}

	/**
	 * Méthode de création (ajout) d'une indicateurAir en DB
	 * Requête HTTP POST http://<server_url>/api/indicateurAirs
	 * 
	 * @param indicateurAir la indicateurAir à créer
	 * @param br      le BindingResult qui nous permet d'accéder aux potentielles
	 *                erreurs liées aux validators
	 * @return la indicateurAir créée
	 */
	@PostMapping()
	public IndicateurAir create(@Valid @RequestBody IndicateurAir indicateurAir, BindingResult br) {
		if (!br.getAllErrors().isEmpty()) {
			System.out.println(br.getAllErrors());
			throw new BadRequestException();
		}
		return indicateurAirService.create(indicateurAir);
	}

	/**
	 * Méthode de modification d'une indicateurAir selon son id
	 * Requête HTTP PUT http://<server_url>/api/indicateurAirs/:id --> Body en JSON
	 * 
	 * @param id l'id de la indicateurAir à modifier
	 * @param indicateurAir la indicateurAir passée en corps de requête
	 * @return la indicateurAir mise à jour
	 */
	@PutMapping("{id}")
	public IndicateurAir update(@PathVariable(name = "id") Long id, @RequestBody IndicateurAir indicateurAir) {
		indicateurAir.setId(id);
		return indicateurAirService.update(indicateurAir);
	}

	/**
	 * Méthode de suppression d'une indicateurAir selon son id
	 * Requête HTTP DELETE http://<server_url>/api/indicateurAirs/:id
	 * 
	 * @param id l'id de la indicateurAir à supprimer
	 */
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		indicateurAirService.deleteById(id);
	}

}
