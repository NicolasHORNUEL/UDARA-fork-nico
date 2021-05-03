/**
 * 
 */
package fr.udara.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.udara.model.IndicateurAir;

/**
 * Interface implémente des méthodes CRUD de JPA repository
 * @author UDARA
 *
 */
public interface IndicateurAirRepository extends JpaRepository<IndicateurAir, Long> {
	

	//////////////////////////////////////// COMMUNE //////////////////////////////////////////	

	
	/**
	 * VALEUR JOURNALIERE pour une COMMUNE d'un indicateur
	 * @param le nom en String d'un objet Commune et le nom d'un IndicateurAir
	 * @return une liste de nombre décimal Float trouvé en base
	 */
	@Query("SELECT valeur FROM IndicateurAir WHERE Commune_id = (SELECT id FROM Commune WHERE nom =:nomCommune) "
			+ " AND nom=:nomIndicateur ORDER BY dateReleve DESC" )
	List<Float> getValuesByIndicateurNameByDayByCommuneName(String nomCommune, String nomIndicateur, Pageable pageable);
	/**
	 * MOYENNE HEBDOMADAIRE pour une COMMUNE d'un indicateur
	 * @param le nom en String d'un objet Commune et le nom d'un IndicateurAir
	 * @return une liste de moyenne/semaine
	 */
	@Query("SELECT ROUND(AVG(valeur),2) FROM IndicateurAir WHERE Commune_id = (SELECT id FROM Commune WHERE nom =:nomCommune) "
			+ " AND nom=:nomIndicateur GROUP BY week(dateReleve) ORDER BY week(dateReleve) DESC " )
	List<Float> getValuesByIndicateurNameByWeekByCommuneName(String nomCommune, String nomIndicateur, Pageable pageable);
	/**
	 * MOYENNE MENSUELLE pour une COMMUNE d'un indicateur
	 * @param le nom en String d'un objet Commune et le nom d'un IndicateurAir
	 * @return une liste de moyenne/semaine
	 */
	@Query("SELECT ROUND(AVG(valeur),2) FROM IndicateurAir WHERE Commune_id = (SELECT id FROM Commune WHERE nom =:nomCommune) "
			+ " AND nom=:nomIndicateur GROUP BY month(dateReleve) ORDER BY month(dateReleve) DESC " )
	List<Float> getValuesByIndicateurNameByMonthByCommuneName(String nomCommune, String nomIndicateur, Pageable pageable);
	
	
	//////////////////////////////////////// FRANCE //////////////////////////////////////////
	
	
	/**
	 * MOYENNE JOURNALIERE pour LA FRANCE ENTIERE d'un indicateur
	 * @param le nom d'un indicateur, une pagination (début, fin)
	 * @return une liste de moyenne/jour
	 */
	@Query("SELECT ROUND(AVG(valeur),2) FROM IndicateurAir WHERE nom=:nomIndicateur GROUP BY day(dateReleve) ORDER BY day(dateReleve) DESC " )
	List<Float> getAveragesByIndicateurNameByDayFR(String nomIndicateur, Pageable pageable);
	/** 
	 * MOYENNE HEBDOMADAIRE pour LA FRANCE ENTIERE d'un indicateur
	 * @param le nom d'un indicateur, une pagination (début, fin)
	 * @return une liste de moyenne/jour
	 */
	@Query("SELECT ROUND(AVG(valeur),2) FROM IndicateurAir WHERE nom=:nomIndicateur GROUP BY week(dateReleve, 1) ORDER BY week(dateReleve, 1) DESC " )
	List<Float> getAveragesByIndicateurNameByWeekFR(String nomIndicateur, Pageable pageable);
	/**
	 * MOYENNE MENSUELLE pour LA FRANCE ENTIERE d'un indicateur
	 * @param le nom d'un indicateur, une pagination (début, fin)
	 * @return une liste de moyenne/jour
	 */
	@Query("SELECT ROUND(AVG(valeur),2) FROM IndicateurAir WHERE nom=:nomIndicateur GROUP BY month(dateReleve) ORDER BY month(dateReleve) DESC " )
	List<Float> getAveragesByIndicateurNameByMonthFR(String nomIndicateur, Pageable pageable);


}
