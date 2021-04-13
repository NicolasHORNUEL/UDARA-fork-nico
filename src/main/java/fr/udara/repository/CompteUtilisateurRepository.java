/**
 * 
 */
package fr.udara.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.udara.model.CompteUtilisateur;
import fr.udara.model.Notification;

/**
 * Interface implémente des méthodes CRUD de JPA repository
 * @author UDARA
 *
 */
public interface CompteUtilisateurRepository extends JpaRepository<CompteUtilisateur, Long>{
	
	/**
	 * Récupération d'un compte uilisateur en fonction de son nom d'utilisateur ou sont mail
	 * 
	 * @param nomUtilisateurOrMail
	 * @return CompteUtilisateur
	 */
	@Query("FROM CompteUtilisateur WHERE mail=:userEmail")
	CompteUtilisateur findByEmail(String userEmail);
	
	/**
	 * @param id
	 * @return la liste des notification pour un id utilisateur donné
	 */
	@Query("SELECT c.notifications FROM CompteUtilisateur c WHERE c.id =: id")
	List<Notification> findNotifByIdCompteUtilisateur(Long id);

}
