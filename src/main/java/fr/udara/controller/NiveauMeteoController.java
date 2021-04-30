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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.udara.dto.IndicateurNiveauDTO;
import fr.udara.exception.BadRequestException;
import fr.udara.model.EchelleTemps;
import fr.udara.model.NiveauMeteo;
import fr.udara.service.NiveauMeteoService;

/**
 * @author UDARA
 *
 */
@RestController
@RequestMapping("/api/niveaumeteos")
public class NiveauMeteoController {
	
	/** niveauMeteoService */
	private final NiveauMeteoService niveauMeteoService;

	/**
	 * Constructeur
	 * 
	 * @param niveauMeteoService
	 */
	@Autowired
	public NiveauMeteoController(NiveauMeteoService niveauMeteoService) {
		this.niveauMeteoService = niveauMeteoService;
	}

	/**
	 * Méthode de récupération de toutes les niveauMeteos
	 * 
	 * @return la liste de toutes les niveauMeteos
	 */
	@GetMapping
	public List<NiveauMeteo> findAll() {
		return niveauMeteoService.findAll();
	}

	@GetMapping("search")
	public List<IndicateurNiveauDTO> getAllByName(
			@RequestParam("nomCommune") String nomCommune,
			@RequestParam("listNiveaux") List<String> nomNiveaux,
			@RequestParam("echelleTemps") EchelleTemps echelleTemps ) {
		return niveauMeteoService.getAllByName(nomCommune, nomNiveaux, echelleTemps);
	}
	
	/**
	 * Méthode de récupération d'une niveauMeteo selon son id
	 * 
	 * @param id id de la niveauMeteo ciblée
	 * @return la niveauMeteo dont l'id est passé en paramètre
	 */
	@GetMapping("{niveauMeteo-id}")
	public NiveauMeteo findById(@PathVariable(name = "niveauMeteo-id") Long id) {
		return niveauMeteoService.findById(id);
	}

	/**
	 * Méthode de création (ajout) d'une niveauMeteo en DB
	 * Requête HTTP POST http://<server_url>/api/niveauMeteos
	 * 
	 * @param niveauMeteo la niveauMeteo à créer
	 * @param br      le BindingResult qui nous permet d'accéder aux potentielles
	 *                erreurs liées aux validators
	 * @return la niveauMeteo créée
	 */
	@PostMapping()
	public NiveauMeteo create(@Valid @RequestBody NiveauMeteo niveauMeteo, BindingResult br) {
		if (!br.getAllErrors().isEmpty()) {
			System.out.println(br.getAllErrors());
			throw new BadRequestException();
		}
		return niveauMeteoService.save(niveauMeteo);
	}

	/**
	 * Méthode de modification d'une niveauMeteo selon son id
	 * Requête HTTP PUT http://<server_url>/api/niveauMeteos/:id --> Body en JSON
	 * 
	 * @param id l'id de la niveauMeteo à modifier
	 * @param niveauMeteo la niveauMeteo passée en corps de requête
	 * @return la niveauMeteo mise à jour
	 */
	@PutMapping("{id}")
	public NiveauMeteo update(@PathVariable(name = "id") Long id, @RequestBody NiveauMeteo niveauMeteo) {
		niveauMeteo.setId(id);
		return niveauMeteoService.save(niveauMeteo);
	}

	/**
	 * Méthode de suppression d'une niveauMeteo selon son id
	 * Requête HTTP DELETE http://<server_url>/api/niveauMeteos/:id
	 * 
	 * @param id l'id de la niveauMeteo à supprimer
	 */
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		niveauMeteoService.deleteById(id);
	}

}
