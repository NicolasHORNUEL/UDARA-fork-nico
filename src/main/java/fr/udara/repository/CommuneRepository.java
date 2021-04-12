/**
 * 
 */
package fr.udara.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.udara.model.Commune;

/**
 * Interface implémente des méthodes CRUD de JPA repository
 * @author UDARA
 *
 */
public interface CommuneRepository extends JpaRepository<Commune, Long> {
	
	/**
	 * Récupération d'une Commune en fonction de son nom
	 * 
	 * @param le nom en String d'un objet Commune
	 * @return l'objet Commune trouvé en base
	 */
	@Query("FROM Commune WHERE nom=:nom")
	Commune findByName(String nom);
	
	/**
	 * Récupération d'une Liste de Commune en fonction d'un nom
	 * 
	 * @param le nom en String d'un objet Commune
	 * @return une liste d'objet Commune trouvé en base
	 */
	@Query("FROM Commune WHERE nom LIKE %:nom%")
	List<Commune> findAllByNameLike(String nom);

}
