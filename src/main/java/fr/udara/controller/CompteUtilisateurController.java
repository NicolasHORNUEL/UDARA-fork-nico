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

import fr.udara.dto.CompteUtilisateurDTO;
import fr.udara.dto.form.FormInscriptionDTO;
import fr.udara.dto.form.FormModifInfoPersoDTO;
import fr.udara.exception.BadRequestException;
import fr.udara.model.CompteUtilisateur;
import fr.udara.service.CompteUtilisateurService;

/**
 * @author UDARA
 *
 */
@RestController
@RequestMapping("/api/compteutilisateurs")
public class CompteUtilisateurController {

	/** compteUtilisateurService */
	private final CompteUtilisateurService compteUtilisateurService;

	/**
	 * Constructeur
	 * 
	 * @param compteUtilisateurService
	 */
	@Autowired
	public CompteUtilisateurController(CompteUtilisateurService compteUtilisateurService) {
		this.compteUtilisateurService = compteUtilisateurService;
	}

	/**
	 * Méthode de récupération de toutes les compteUtilisateursDTO
	 * 
	 * @return la liste de toutes les compteUtilisateurs
	 */
	@CrossOrigin
	@GetMapping
	public List<CompteUtilisateurDTO> findAll() {
		return compteUtilisateurService.findAllDTO();
	}

	/**
	 * Méthode de récupération d'une compteUtilisateur selon son id
	 * 
	 * @param id id de la compteUtilisateur ciblée
	 * @return la compteUtilisateur dont l'id est passé en paramètre
	 */
	@CrossOrigin
	@GetMapping("{compteUtilisateur-id}")
	public CompteUtilisateur findById(@PathVariable(name = "compteUtilisateur-id") Long id) {
		return compteUtilisateurService.findById(id);
	}

	/**
	 * Méthode de création (ajout) d'une compteUtilisateur en DB Requête HTTP POST
	 * http://<server_url>/api/compteUtilisateurs
	 * 
	 * @param compteUtilisateur la compteUtilisateur à créer
	 * @param br                le BindingResult qui nous permet d'accéder aux
	 *                          potentielles erreurs liées aux validators
	 * @return la compteUtilisateur créée
	 */
	@CrossOrigin
	@PostMapping()
	public void create(@Valid @RequestBody FormInscriptionDTO formInscriptionDTO, BindingResult br) {
		if (!br.getAllErrors().isEmpty()) {
			System.out.println(br.getAllErrors());
			throw new BadRequestException();
		}
		compteUtilisateurService.save(formInscriptionDTO);
	}

	/**
	 * Méthode de modification d'une compteUtilisateur selon son id Requête HTTP PUT
	 * http://<server_url>/api/compteUtilisateurs/:id --> Body en JSON
	 * 
	 * @param id                l'id de la compteUtilisateur à modifier
	 * @param compteUtilisateur la compteUtilisateur passée en corps de requête
	 * @return la compteUtilisateur mise à jour
	 */
	@CrossOrigin
	@PutMapping("{id}")
	public void update(@PathVariable(name = "id") Long id, @RequestBody FormModifInfoPersoDTO formModifInfoPersoDTO) {

		compteUtilisateurService.update(formModifInfoPersoDTO, id);
	}

	/**
	 * Méthode de suppression d'une compteUtilisateur selon son id Requête HTTP
	 * DELETE http://<server_url>/api/compteUtilisateurs/:id
	 * 
	 * @param id l'id de la compteUtilisateur à supprimer
	 */
	@CrossOrigin
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		compteUtilisateurService.deleteById(id);
	}

}
