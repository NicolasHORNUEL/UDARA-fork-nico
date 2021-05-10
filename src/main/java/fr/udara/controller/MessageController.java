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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.udara.dto.MessageDTO;
import fr.udara.exception.BadRequestException;
import fr.udara.model.Message;
import fr.udara.service.MessageService;

/**
 * @author UDARA
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/api/messages")
public class MessageController {
	
	/** messageService */
	private final MessageService messageService;

	/**
	 * Constructeur
	 * 
	 * @param messageService
	 */
	@Autowired
	public MessageController(MessageService messageService) {
		this.messageService = messageService;
	}

	/**
	 * Méthode de récupération de toutes les messages
	 * 
	 * @return la liste de toutes les messages
	 */
	@GetMapping
	public List<MessageDTO> findAll() {
		return messageService.findAll();
	}

	/**
	 * Méthode de récupération d'une message selon son id
	 * 
	 * @param id id de la message ciblée
	 * @return la message dont l'id est passé en paramètre
	 */
	@GetMapping("{message-id}")
	public Message findById(@PathVariable(name = "message-id") Long id) {
		return messageService.findById(id);
	}

	/**
	 * @param email en string
	 * @return un éventuel compteUtilisateur
	 */
	@GetMapping("searchByFilConversation")
	public List<MessageDTO> searchByFilConversation(@RequestParam(required = true) Long id) {
		return messageService.searchByFilConversation(id);
	}
	
	
	/**
	 * Méthode de création (ajout) d'une message en DB
	 * Requête HTTP POST http://<server_url>/api/messages
	 * 
	 * @param message la message à créer
	 * @param br      le BindingResult qui nous permet d'accéder aux potentielles
	 *                erreurs liées aux validators
	 * @return la message créée
	 */
	@PostMapping()
	public Message create(@Valid @RequestBody Message message, BindingResult br) {
		if (!br.getAllErrors().isEmpty()) {
			System.out.println(br.getAllErrors());
			throw new BadRequestException();
		}
		return messageService.save(message);
	}

	/**
	 * Méthode de modification d'une message selon son id
	 * Requête HTTP PUT http://<server_url>/api/messages/:id --> Body en JSON
	 * 
	 * @param id l'id de la message à modifier
	 * @param message la message passée en corps de requête
	 * @return la message mise à jour
	 */
	@PutMapping("{id}")
	public Message update(@PathVariable(name = "id") Long id, @RequestBody Message message) {
		message.setId(id);
		return messageService.save(message);
	}

	/**
	 * Méthode de suppression d'une message selon son id
	 * Requête HTTP DELETE http://<server_url>/api/messages/:id
	 * 
	 * @param id l'id de la message à supprimer
	 */
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		messageService.deleteById(id);
	}

}
