package fr.udara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.udara.exception.NotFoundException;
import fr.udara.model.Notification;
import fr.udara.repository.NotificationRepository;

/**
 * Classe de service pour l'entité Notification
 * @author udara
 *
 */
@Service
public class NotificationService {
	
	private NotificationRepository notificationRepository;

	/** Constructeur
	 * 
	 */
	@Autowired
	private NotificationService(NotificationRepository notificationRepository) {
		this.notificationRepository = notificationRepository;
	}
	
	
	/**
	 * @param un objet Notification sans id
	 * @return l'objet Notification avec un id
	 */
	@Transactional
	public Notification save(Notification notification) {
		return notificationRepository.save(notification);
	}
	
	/**
	 * @return une liste d'objet Notification
	 */
	public List<Notification> findAll() {
		return notificationRepository.findAll();
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
	
}





