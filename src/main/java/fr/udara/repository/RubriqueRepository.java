/**
 * 
 */
package fr.udara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.udara.model.Rubrique;

/**
 * Interface implémente des méthodes CRUD de JPA repository
 * 
 * @author UDARA
 *
 */
public interface RubriqueRepository extends JpaRepository<Rubrique, Long> {

	/**
	 * Récupération du type de la rubrique
	 * @param id
	 * @return String nom
	 */
	@Query("FROM Rubrique WHERE nom =: nomRubrique")
	Rubrique findByNom(String nomRubString);
}
