/**
 * 
 */
package fr.udara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.udara.model.CompteUtilisateur;

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
	@Query("SELECT cu FROM CompteUtilisateur WHERE cu.nomUtilisateur=:nomUtilisateurOrMail OR u.email=:nomUtilisateurOrMail")
	CompteUtilisateur findByUsernameOrEmail(String nomUtilisateurOrMail);

}
