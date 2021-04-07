/**
 * 
 */
package fr.udara.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.udara.model.Rubrique;

/**
 * Interface implémente des méthodes CRUD de JPA repository
 * @author UDARA
 *
 */
public interface RubriqueRepository extends JpaRepository<Rubrique, Long> {

}
