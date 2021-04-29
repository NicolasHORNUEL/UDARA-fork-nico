/**
 * 
 */
package fr.udara.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.udara.model.IndicateurAir;

/**
 * Interface implémente des méthodes CRUD de JPA repository
 * @author UDARA
 *
 */
public interface IndicateurAirRepository extends JpaRepository<IndicateurAir, Long> {
	

	
	/**
	 * Récupération d'une liste d'indicateurAir en fonction de son nom et du nom d'une commune
	 * 
	 * @param le nom en String d'un objet Commune et d'un IndicateurAir
	 * @return une liste d'objet IndicateurAir trouvé en base
	 */
	@Query("FROM IndicateurAir "
			+ " WHERE Commune_id = (SELECT id "
			+ " FROM Commune "
			+ " WHERE nom =:nomCommune) "
			+ " AND nom=:nomIndicateur"
			+ " ORDER BY dateReleve DESC" )
	List<IndicateurAir> getByName(String nomCommune, String nomIndicateur);

}
