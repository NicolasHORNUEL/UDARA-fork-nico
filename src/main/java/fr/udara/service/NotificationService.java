package fr.udara.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.udara.dto.NotificationDTO;
import fr.udara.dto.form.FormNotificationDTO;
import fr.udara.exception.NotFoundException;
import fr.udara.model.CompteUtilisateur;
import fr.udara.model.Notification;
import fr.udara.repository.CommuneRepository;
import fr.udara.repository.CompteUtilisateurRepository;
import fr.udara.repository.NotificationRepository;

/**
 * Classe de service pour l'entité Notification
 * @author udara
 *
 */
@Service
public class NotificationService {
	
	/** notificationRepository : NotificationRepository */
	private NotificationRepository notificationRepository;
	
	/** compteUtilisateurRepository : CompteUtilisateurRepository */
	private CompteUtilisateurRepository compteUtilisateurRepository;
	
	/** communeRepository : CommuneRepository */
	private CommuneRepository communeRepository;

	/** Constructeur
	 * 
	 */
	@Autowired
	public NotificationService(NotificationRepository notificationRepository) {
		this.notificationRepository = notificationRepository;
	}
	
	
	/**
	 * @param un objet Notification sans id
	 * @return l'objet Notification avec un id
	 */
	@Transactional
	public void save(FormNotificationDTO notificationDTO) {
		
		List<CompteUtilisateur> comptesUtilisateurs = new ArrayList<>();
		
		Notification notification = new Notification();
		
		notification.setTexte(notificationDTO.getTexte());
		notification.setLu(false);
		notification.setHeure(LocalDateTime.now());
		
		
		if (notificationDTO.getCommune() != null) {			
			
			comptesUtilisateurs = communeRepository.findUserByCommune(notificationDTO.getCommune());
			notification.setCompteUtilisateurs(comptesUtilisateurs);
			notificationRepository.save(notification);
			
		} else {
			
			comptesUtilisateurs = communeRepository.findUserByRegion(notificationDTO.getRegion());
			notification.setCompteUtilisateurs(comptesUtilisateurs);
			notificationRepository.save(notification);
			
		}
		
	}
	
	/**
	 * @return une liste d'objet Notification
	 */
	public List<NotificationDTO> findAll() {
		List<Notification> listeNotification = notificationRepository.findAll();
		List<NotificationDTO> listeNotificationDTO = new ArrayList<>();
		for (Notification notification : listeNotification) {
			NotificationDTO notificationDTO = new NotificationDTO();
			notificationDTO.setId(notification.getId());
			notificationDTO.setHeure(notification.getHeure());
			notificationDTO.setTexte(notification.getTexte());
			notificationDTO.setLu(notification.isLu());
			listeNotificationDTO.add(notificationDTO);
		}
		return listeNotificationDTO;
		
	}

	
	/**
	 * @param id d'un objet Notification
	 * @return une éventuelle liste d'objet Notification
	 */
	public Notification findById(Long id) {
		return notificationRepository.findById(id).orElseThrow(() -> new NotFoundException());
	}

	
	/**
	 * @param id d'un objet Notification
	 * @return true si l'id existe
	 */
	public boolean existsById(Long id) {
		return notificationRepository.existsById(id);
	}
	
	
	/**
	 * @return le nombre d'objet Notification
	 */
	public long count() {
		return notificationRepository.count();
	}
	
	
	/**
	 * @param id d'un objet Notification
	 */
	@Transactional
	public void deleteById(Long id) {
		notificationRepository.deleteById(id);
	}
	
	
	/**
	 * @param un objet Notification
	 */
	@Transactional
	public void delete(Notification notification) {
		notificationRepository.delete(notification);
	}
	
	
	/**
	 * @param id
	 * @return list des notification pour un compteUtilisateur donné
	 */
	public List<Notification> findNotifByIdCompteUtilisateur(Long id) {
		return compteUtilisateurRepository.findNotifByIdCompteUtilisateur(id);
	}
	
	/**
	 * Tranformation des Notification en notificationDTO
	 * 
	 * @param id
	 * @return la liste des notification dto
	 */
	public List<NotificationDTO> findNotifDTOByIdCompteUtilisateur(Long id) {
		
		List<Notification> notifications = compteUtilisateurRepository.findNotifByIdCompteUtilisateur(id);
		
		List<NotificationDTO> notificationsDTO = new ArrayList<>();
		
		for (Notification notification : notifications) {
			
			NotificationDTO notificationDTO = new NotificationDTO();
			notificationDTO.setTexte(notification.getTexte());
			notificationDTO.setHeure(notification.getHeure());
			notificationDTO.setLu(notification.isLu());
			notificationsDTO.add(notificationDTO);
		}
		
		return notificationsDTO;
		
	}
	
	
}





