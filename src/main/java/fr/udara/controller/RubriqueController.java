/**
 * 
 */
package fr.udara.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.udara.dto.form.FormRubriqueDTO;
import fr.udara.exception.BadRequestException;
import fr.udara.service.RubriqueService;

/**
 * @author UDARA
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/api/rubriques")
public class RubriqueController {

	/** rubriqueService */
	private final RubriqueService rubriqueService;

	/**
	 * Constructeur
	 * 
	 * @param rubriqueService
	 */
	@Autowired
	public RubriqueController(RubriqueService rubriqueService) {
		this.rubriqueService = rubriqueService;
	}

	/**
	 * Méthode de récupération de toutes les rubriques
	 * 
	 * @return la liste de toutes les rubriques
	 */
	@GetMapping
	public List<FormRubriqueDTO> findAll() {
		return rubriqueService.findAll();
	}

	/**
	 * Méthode de récupération d'une rubrique selon son id
	 * 
	 * @param id id de la rubrique ciblée
	 * @return la rubrique dont l'id est passé en paramètre
	 */
	@GetMapping("{rubrique-id}")
	public FormRubriqueDTO findById(@PathVariable(name = "rubrique-id") Long id) {
		return rubriqueService.findById(id);
	}

	/**
	 * Méthode de création (ajout) d'une rubrique en DB Requête HTTP POST
	 * http://<server_url>/api/rubriques
	 * 
	 * @param rubrique la rubrique à créer
	 * @param br       le BindingResult qui nous permet d'accéder aux potentielles
	 *                 erreurs liées aux validators
	 */
	@PostMapping()
	public void create(@Valid @RequestBody FormRubriqueDTO rubriqueDTO, BindingResult br) {
		if (!br.getAllErrors().isEmpty()) {
			System.out.println(br.getAllErrors());
			throw new BadRequestException();
		}
		rubriqueService.save(rubriqueDTO);
	}

	/**
	 * Méthode de modification d'une rubrique selon son id Requête HTTP PUT
	 * http://<server_url>/api/rubriques/:id --> Body en JSON
	 * 
	 * @param id       l'id de la rubrique à modifier
	 * @param rubrique la rubrique passée en corps de requête
	 * @return la rubrique mise à jour
	 */
	@PutMapping("{id}")
	public void update(@PathVariable(name = "id") Long id,
			@RequestBody FormRubriqueDTO rubriqueDTO) {

		rubriqueService.update(rubriqueDTO, id);
	}

	/**
	 * Méthode de suppression d'une rubrique selon son id Requête HTTP DELETE
	 * http://<server_url>/api/rubriques/:id
	 * 
	 * @param id l'id de la rubrique à supprimer
	 */
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		rubriqueService.deleteById(id);
	}

}
