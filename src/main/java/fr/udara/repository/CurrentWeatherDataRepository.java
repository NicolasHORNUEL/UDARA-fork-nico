/**
 * 
 */
package fr.udara.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.udara.model.CurrentWeatherData;

/**
 * Interface implémente des méthodes CRUD de JPA repository
 * @author UDARA
 *
 */
public interface CurrentWeatherDataRepository extends JpaRepository<CurrentWeatherData, Long>{

}
