/**
 * 
 */
package fr.udara.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.udara.model.Favori;

/**
 * Interface implémente des méthodes CRUD de JPA repository
 * @author UDARA
 *
 */
public interface FavoriRepository extends JpaRepository<Favori, Long> {
	
	/**
	 * Récupération d'une Favori en fonction de son nom
	 * 
	 * @param le nom en String d'un objet Favori
	 * @return l'objet Favori trouvé en base
	 */
	@Query("FROM Favori WHERE nom=:nom")
	Favori findByName(String nom);
	
	/**
	 * Récupération d'une Liste de Favori en fonction d'un nom
	 * 
	 * @param le nom en String d'un objet Favori
	 * @return une liste d'objet Favori trouvé en base
	 */
	@Query("FROM Favori WHERE nom LIKE %:nom%")
	List<Favori> findAllByNameLike(String nom);
	
	/**
	 * Recupération de la liste des nom de toutes les Favoris
	 * 
	 * @return list des nom de toute les Favoris
	 */
	@Query("SElECT nom FROM Favori")
	List<String> findAllNomFavori();
	

}
