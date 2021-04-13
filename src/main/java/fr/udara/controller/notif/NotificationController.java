/**
 * 
 */
package fr.udara.controller.notif;

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

import fr.udara.dto.NotificationDTO;
import fr.udara.dto.form.FormNotificationDTO;
import fr.udara.exception.BadRequestException;
import fr.udara.model.Notification;
import fr.udara.service.NotificationService;

/**
 * @author UDARA
 *
 */
@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
	
	/** notificationService */
	private final NotificationService notificationService;

	/**
	 * Constructeur
	 * 
	 * @param notificationService
	 */
	@Autowired
	public NotificationController(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	/**
	 * Méthode de récupération de toutes les notifications
	 * 
	 * @return la liste de toutes les notifications
	 */
	@GetMapping
	public List<Notification> findAll() {
		return notificationService.findAll();
	}

	/**
	 * Méthode de récupération d'une notification selon son id
	 * 
	 * @param id id de la notification ciblée
	 * @return la notification dont l'id est passé en paramètre
	 */
	@GetMapping("{notification-id}")
	public Notification findById(@PathVariable(name = "notification-id") Long id) {
		return notificationService.findById(id);
	}
	
	@GetMapping("listNotif/{compteUtilisateur-id}")
	public List<NotificationDTO> findNotifDTOByIdCompteUtilisateur(@PathVariable(name = "compteUtilisateur-id") Long id) {
		return notificationService.findNotifDTOByIdCompteUtilisateur(id);
	}

	/**
	 * Méthode de création (ajout) d'une notification en DB
	 * Requête HTTP POST http://<server_url>/api/notifications
	 * 
	 * @param notification la notification à créer
	 * @param br      le BindingResult qui nous permet d'accéder aux potentielles
	 *                erreurs liées aux validators
	 * @return la notification créée
	 */
	@PostMapping()
	public void create(@Valid @RequestBody FormNotificationDTO notificationDTO, BindingResult br) {
		if (!br.getAllErrors().isEmpty()) {
			System.out.println(br.getAllErrors());
			throw new BadRequestException();
		}
		notificationService.save(notificationDTO);
	}

	/**
	 * Méthode de modification d'une notification selon son id
	 * Requête HTTP PUT http://<server_url>/api/notifications/:id --> Body en JSON
	 * 
	 * @param id l'id de la notification à modifier
	 * @param notification la notification passée en corps de requête
	 * @return la notification mise à jour
	 */
//	@PutMapping("{id}")
//	public Notification update(@PathVariable(name = "id") Long id, @RequestBody Notification notification) {
//		notification.setId(id);
//		return notificationService.save(notification);
//	}

	/**
	 * Méthode de suppression d'une notification selon son id
	 * Requête HTTP DELETE http://<server_url>/api/notifications/:id
	 * 
	 * @param id l'id de la notification à supprimer
	 */
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		notificationService.deleteById(id);
	}
	
	

}
