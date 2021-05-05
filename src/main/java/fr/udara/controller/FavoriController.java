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

import fr.udara.dto.FavoriDTO;
import fr.udara.exception.BadRequestException;
import fr.udara.model.Favori;
import fr.udara.service.FavoriService;

/**
 * Controller associé à la classe Favori
 * 
 * @author Udara
 */
@CrossOrigin
@RestController
@RequestMapping("/api/favoris")
public class FavoriController {

	/** favoriService */
	private final FavoriService favoriService;

	/**
	 * Constructeur
	 * 
	 * @param favoriService
	 */
	@Autowired
	public FavoriController(FavoriService favoriService) {
		this.favoriService = favoriService;
	}

	/**
	 * Méthode de récupération de tous les favorisDTO
	 * 
	 * @return la liste de tous les favorisDTO
	 */
	@GetMapping
	public List<FavoriDTO> findAll() {
		return favoriService.findAllDTO();
	}

	/**
	 * Méthode de récupération d'un favori selon son id
	 * 
	 * @param id l'id du favori ciblé
	 * @return le favori dont l'id est passé en paramètre
	 */
	@GetMapping("{favori-id}")
	public Favori findById(@PathVariable(name = "favori-id") Long id) {
		return favoriService.findById(id);
	}

	/**
	 * Méthode de création (ajout) d'un favori en DB
	 * Requête HTTP POST http://<server_url>/api/favoris
	 * 
	 * @param favori le favori à créer
	 * @param br      le BindingResult qui nous permet d'accéder aux potentielles
	 *                erreurs liées aux validators
	 * @return le favori créé
	 */
	@PostMapping()
	public Favori create(@Valid @RequestBody Favori favori, BindingResult br) {
		if (!br.getAllErrors().isEmpty()) {
			System.out.println(br.getAllErrors());
			throw new BadRequestException();
		}
		return favoriService.save(favori);
	}

	/**
	 * Méthode de modification d'un favori selon son id
	 * Requête HTTP PUT http://<server_url>/api/favoris/:id --> Body en JSON
	 * 
	 * @param id l'id de la favori à modifier
	 * @param favori la favori passée en corps de requête
	 * @return la favori mise à jour
	 */
	@PutMapping("{id}")
	public Favori update(@PathVariable(name = "id") Long id, @RequestBody Favori favori) {
		favori.setId(id);
		return favoriService.save(favori);
	}

	/**
	 * Méthode de suppression d'un favori selon son id
	 * Requête HTTP DELETE http://<server_url>/api/favoris/:id
	 * 
	 * @param id l'id du favori à supprimer
	 */
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable Long id) {
		favoriService.deleteById(id);
	}

}
