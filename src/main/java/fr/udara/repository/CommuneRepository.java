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
	
	/**
	 * Récupération de la liste des region dans la table commune
	 * 
	 * @return {@link List<Strin>} la liste des region 
	 */
	@Query("SELECT region FROM Commune")
	List<String> findRegion();
	
	/**
	 * Recupération de la liste des nom de toutes les communes
	 * 
	 * @return list des nom de toute les communes
	 */
	@Query("SElECT nom FROM Commune")
	List<String> findAllNomCommune();
	
	/**
	 * recupére la liste des communes pour une région donnée
	 * 
	 * @param region
	 * @return la liste des commune pour une region
	 */
	@Query("SELECT c.nom FROM Commune c WHERE c.region =: region")
	List<String> findNomCommuneByRegion(String region);
	
	

}
