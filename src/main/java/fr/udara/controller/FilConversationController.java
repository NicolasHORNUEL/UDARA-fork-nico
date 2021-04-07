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
import fr.udara.model.FilConversation;
import fr.udara.service.FilConversationService;

/**
 * @author UDARA
 *
 */
@RestController
@RequestMapping("/api/filconversations")
public class FilConversationController {
	/** filConversationService */
	private final FilConversationService filConversationService;

	/**
	 * Constructeur
	 * 
	 * @param filConversationService
	 */
	@Autowired
	public FilConversationController(FilConversationService filConversationService) {
		this.filConversationService = filConversationService;
	}

	/**
	 * Méthode de récupération de toutes les filConversations
	 * 
	 * @return la liste de toutes les filConversations
	 */
	@GetMapping
	public List<FilConversation> findAll() {
		return filConversationService.findAll();
	}

	/**
	 * Méthode de récupération d'une filConversation selon son id
	 * 
	 * @param id id de la filConversation ciblée
	 * @return la filConversation dont l'id est passé en paramètre
	 */
	@GetMapping("{filConversation-id}")
	public FilConversation findById(@PathVariable(name = "filConversation-id") Long id) {
		return filConversationService.findById(id);
	}

	/**
	 * Méthode de création (ajout) d'une filConversation en DB
	 * Requête HTTP POST http://<server_url>/api/filConversations
	 * 
	 * @param filConversation la filConversation à créer
	 * @param br      le BindingResult qui nous permet d'accéder aux potentielles
	 *                erreurs liées aux validators
	 * @return la filConversation créée
	 */
	@PostMapping()
	public FilConversation create(@Valid @RequestBody FilConversation filConversation, BindingResult br) {
		if (!br.getAllErrors().isEmpty()) {
			System.out.println(br.getAllErrors());
			throw new BadRequestException();
		}
		return filConversationService.save(filConversation);
	}

	/**
	 * Méthode de modification d'une filConversation selon son id
	 * Requête HTTP PUT http://<server_url>/api/filConversations/:id --> Body en JSON
	 * 
	 * @param id l'id de la filConversation à modifier
	 * @param filConversation la filConversation passée en corps de requête
	 * @return la filConversation mise à jour
	 */
	@PutMapping("{id}")
	public FilConversation update(@PathVariable(name = "id") Long id, @RequestBody FilConversation filConversation) {
		filConversation.setId(id);
		return filConversationService.save(filConversation);
	}

	/**
	 * Méthode de suppression d'une filConversation selon son id
	 * Requête HTTP DELETE http://<server_url>/api/filConversations/:id
	 * 
	 * @param id l'id de la filConversation à supprimer
	 */
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		filConversationService.deleteById(id);
	}

}
