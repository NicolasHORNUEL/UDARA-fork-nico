/**
 * 
 */
package fr.udara.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.udara.model.NiveauMeteo;

/**
 * Interface implémente des méthodes CRUD de JPA repository
 * @author UDARA
 *
 */
public interface NiveauMeteoRepository extends JpaRepository<NiveauMeteo, Long>{
	
	/**
	 * Récupération d'une liste d'objet NiveauMeteo en fonction de son nom et du nom d'une commune
	 * 
	 * @param le nom en String d'un objet Commune et le nom d'un NiveauMeteo
	 * @return une liste d'objet NiveauMeteo trouvé en base
	 */
	@Query("FROM NiveauMeteo "
			+ " WHERE Commune_id = (SELECT id "
			+ " FROM Commune "
			+ " WHERE nom =:nomCommune) "
			+ " AND nom=:nomNiveau"
			+ " ORDER BY dateReleve DESC" )
	List<NiveauMeteo> getByName(String nomCommune, String nomNiveau);

	/**
	 * Récupération d'une liste d'objet NiveauMeteo en fonction du nom d'une commune
	 * 
	 * @param le nom en String d'un objet Commune
	 * @return une liste d'objet NiveauMeteo trouvé en base
	 */
	@Query("FROM NiveauMeteo "
			+ " WHERE Commune_id = (SELECT id "
			+ " FROM Commune "
			+ " WHERE nom =:nomCommune) "
			+ " ORDER BY dateReleve DESC" )
	List<NiveauMeteo> getAllByName(String nomCommune);
	
	
	/**
	 * Récupération d'une liste de valeur en fonction du nom d'une commune et du nom d'un niveau
	 * 
	 * @param le nom en String d'un objet Commune et le nom d'un NiveauMeteo
	 * @return une liste de nombre décimal Float trouvé en base
	 */
	@Query("SELECT valeur "
			+ " FROM NiveauMeteo "
			+ " WHERE Commune_id = (SELECT id "
			+ " FROM Commune "
			+ " WHERE nom =:nomCommune) "
			+ " AND nom=:nomIndicateur"
			+ " ORDER BY dateReleve DESC" )
	List<Float> getValuesByName(String nomCommune, String nomNiveau);

}
