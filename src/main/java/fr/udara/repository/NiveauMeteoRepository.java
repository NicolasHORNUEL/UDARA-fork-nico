/**
 * 
 */
package fr.udara.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.udara.model.NiveauMeteo;

/**
 * Interface implémente des méthodes CRUD de JPA repository
 * @author UDARA
 *
 */
public interface NiveauMeteoRepository extends JpaRepository<NiveauMeteo, Long>{
	

	//////////////////////////////////////// COMMUNE //////////////////////////////////////////	

	
	/**
	 * VALEUR JOURNALIERE pour une COMMUNE d'un NiveauMeteo
	 * @param le nom en String d'un objet Commune et le nom d'un NiveauMeteo
	 * @return une liste de nombre décimal Float trouvé en base
	 */
	@Query("SELECT valeur FROM NiveauMeteo WHERE Commune_id = (SELECT id FROM Commune WHERE nom =:nomCommune) "
			+ " AND nom=:nomNiveau ORDER BY dateReleve DESC" )
	List<Float> getValuesByNiveauNameByDayByCommuneName(String nomCommune, String nomNiveau, Pageable pageable);
	/**
	 * MOYENNE HEBDOMADAIRE pour une COMMUNE d'un NiveauMeteo
	 * @param le nom en String d'un objet Commune et le nom d'un NiveauMeteo
	 * @return une liste de moyenne/semaine
	 */
	@Query("SELECT AVG(valeur) FROM NiveauMeteo WHERE Commune_id = (SELECT id FROM Commune WHERE nom =:nomCommune) "
			+ " AND nom=:nomNiveau GROUP BY week(dateReleve) ORDER BY week(dateReleve) DESC " )
	List<Float> getValuesByNiveauNameByWeekByCommuneName(String nomCommune, String nomNiveau, Pageable pageable);
	/**
	 * MOYENNE MENSUELLE pour une COMMUNE d'un NiveauMeteo
	 * @param le nom en String d'un objet Commune et le nom d'un NiveauMeteo
	 * @return une liste de moyenne/semaine
	 */
	@Query("SELECT AVG(valeur) FROM NiveauMeteo WHERE Commune_id = (SELECT id FROM Commune WHERE nom =:nomCommune) "
			+ " AND nom=:nomNiveau GROUP BY month(dateReleve) ORDER BY month(dateReleve) DESC " )
	List<Float> getValuesByNiveauNameByMonthByCommuneName(String nomCommune, String nomNiveau, Pageable pageable);
	
	
	//////////////////////////////////////// FRANCE //////////////////////////////////////////
	
	
	/**
	 * MOYENNE JOURNALIERE pour LA FRANCE ENTIERE d'un NiveauMeteo
	 * @param le nom d'un NiveauMeteo, une pagination (début, fin)
	 * @return une liste de moyenne/jour
	 */
	@Query("SELECT AVG(valeur) FROM NiveauMeteo WHERE nom=:nomNiveau GROUP BY day(dateReleve) ORDER BY day(dateReleve) DESC " )
	List<Float> getAveragesByNiveauNameByDayFR(String nomNiveau, Pageable pageable);
	/** 
	 * MOYENNE HEBDOMADAIRE pour LA FRANCE ENTIERE d'un NiveauMeteo
	 * @param le nom d'un NiveauMeteo, une pagination (début, fin)
	 * @return une liste de moyenne/jour
	 */
	@Query("SELECT AVG(valeur) FROM NiveauMeteo WHERE nom=:nomNiveau GROUP BY week(dateReleve, 1) ORDER BY week(dateReleve, 1) DESC " )
	List<Float> getAveragesByNiveauNameByWeekFR(String nomNiveau, Pageable pageable);
	/**
	 * MOYENNE MENSUELLE pour LA FRANCE ENTIERE d'un NiveauMeteo
	 * @param le nom d'un NiveauMeteo, une pagination (début, fin)
	 * @return une liste de moyenne/jour
	 */
	@Query("SELECT AVG(valeur) FROM NiveauMeteo WHERE nom=:nomNiveau GROUP BY month(dateReleve) ORDER BY month(dateReleve) DESC " )
	List<Float> getAveragesByNiveauNameByMonthFR(String nomNiveau, Pageable pageable);

}
