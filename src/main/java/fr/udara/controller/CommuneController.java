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

import fr.udara.dto.CommuneDTO;
import fr.udara.exception.BadRequestException;
import fr.udara.model.Commune;
import fr.udara.service.CommuneService;

/**
 * Controller associé à la classe Commune
 * 
 * @author Udara
 */
@RestController
@RequestMapping("/api/communes")
public class CommuneController {

	/** communeService */
	private final CommuneService communeService;

	/**
	 * Constructeur
	 * 
	 * @param communeService
	 */
	@Autowired
	public CommuneController(CommuneService communeService) {
		this.communeService = communeService;
	}

	/**
	 * Méthode de récupération de toutes les communes
	 * 
	 * @return la liste de tous les noms de communes
	 */
	@GetMapping("liste-commune")
	public List<String> findAll() {
		return communeService.findAllNomCommune();
	}

	/**
	 * Méthode de récupération de tous les noms de département
	 * 
	 * @return la liste de tous les noms de département
	 */
	@GetMapping("liste-departement")
	public List<String> findDepartement() {
		return communeService.findDepartement();
	}
	
	/**
	 * Méthode de récupération de toutes les noms de communes pour un département donné
	 * 
	 * @param departement
	 * @return la liste des noms de communes pour un département donné
	 */
	@GetMapping("searchByDepartement")
	public List<String> findNomCommuneByDepartement(@RequestParam(required = true) String departement) {
		return communeService.findNomCommuneByDepartement(departement);
	}
	
	
	/**
	 * Méthode de récupération de toutes les communes en CommuneDTO
	 * 
	 * @return la liste de toutes les communes au format DTO
	 */
	@GetMapping("liste-commune-dto")
	public List<CommuneDTO> findAllDTO() {
		return communeService.findAllDTO();
	}

	/**
	 * Méthode de récupération d'une commune selon son id
	 * 
	 * @param id id de la commune ciblée
	 * @return la commune dont l'id est passé en paramètre
	 */
	@GetMapping("{commune-id}")
	public Commune findById(@PathVariable(name = "commune-id") Long id) {
		return communeService.findById(id);
	}

	/**
	 * Méthode de récupération des communes selon leur nom
	 * 
	 * @param terme Le terme que contient les communes ciblées
	 * @return la liste des communes dont le nom contient le terme passé en
	 *         paramètre
	 */
	@GetMapping("search")
	public CommuneDTO findByName(@RequestParam(required = true) String terme) {
		return communeService.findByName(terme);
	}

	/**
	 * Méthode de création (ajout) d'une commune en DB Requête HTTP POST
	 * http://<server_url>/api/communes
	 * 
	 * @param commune la commune à créer
	 * @param br      le BindingResult qui nous permet d'accéder aux potentielles
	 *                erreurs liées aux validators
	 * @return la commune créée
	 */
	@PostMapping()
	public Commune create(@Valid @RequestBody Commune commune, BindingResult br) {
		if (!br.getAllErrors().isEmpty()) {
			System.out.println(br.getAllErrors());
			throw new BadRequestException();
		}
		return communeService.save(commune);
	}

	/**
	 * Méthode de modification d'une commune selon son id Requête HTTP PUT
	 * http://<server_url>/api/communes/:id --> Body en JSON
	 * 
	 * @param id      l'id de la commune à modifier
	 * @param commune la commune passée en corps de requête
	 * @return la commune mise à jour
	 */
	@PutMapping("{id}")
	public Commune update(@PathVariable(name = "id") Long id, @RequestBody Commune commune) {
		commune.setId(id);
		return communeService.save(commune);
	}

	/**
	 * Méthode de suppression d'une commune selon son id Requête HTTP DELETE
	 * http://<server_url>/api/communes/:id
	 * 
	 * @param id l'id de la commune à supprimer
	 */
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable Long id) {
		communeService.deleteById(id);
	}

}
