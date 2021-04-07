/**
 * 
 */
package fr.udara.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.udara.model.CompteUtilisateur;

/**
 * Interface implémente des méthodes CRUD de JPA repository
 * @author UDARA
 *
 */
public interface CompteUtilisateurRepository extends JpaRepository<CompteUtilisateur, Long>{

}
