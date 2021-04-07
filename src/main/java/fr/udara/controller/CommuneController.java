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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.udara.exception.BadRequestException;

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
	public CommuneController(communeService communeService) {
		this.communeService = communeService;
	}

	/**
	 * Méthode de récupération de toutes les communes
	 * 
	 * @return la liste de toutes les communes
	 */
	@GetMapping
	public List<Commune> findAll() {
		return communeService.findAll();
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
//	@GetMapping("search")
//	public List<Commune> findByNameLike(@RequestParam(required = true) String terme) {
//		return communeService.findByNameLike(terme);
//	}

	/**
	 * Méthode de création (ajout) d'une commune en DB
	 * Requête HTTP POST http://<server_url>/api/communes
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
		return communeService.create(commune);
	}

	/**
	 * Méthode de modification d'une commune selon son id
	 * Requête HTTP PUT http://<server_url>/api/communes/:id --> Body en JSON
	 * 
	 * @param id l'id de la commune à modifier
	 * @param commune la commune passée en corps de requête
	 * @return la commune mise à jour
	 */
	@PutMapping("{id}")
	public Commune update(@PathVariable(name = "id") Long id, @RequestBody Commune commune) {
		commune.setId(id);
		return communeService.update(commune);
	}

	/**
	 * Méthode de suppression d'une commune selon son id
	 * Requête HTTP DELETE http://<server_url>/api/communes/:id
	 * 
	 * @param id l'id de la commune à supprimer
	 */
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		communeService.deleteById(id);
	}

}
