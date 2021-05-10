/**
 * 
 */
package fr.udara.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.udara.model.FilConversation;

/**
 * Interface implémente des méthodes CRUD de JPA repository
 * @author UDARA
 *
 */
public interface FilConversationRepository extends JpaRepository<FilConversation, Long>{

	/**
     * Récupération d'une liste de filConversation pour un idRubrique Donné
     * @param id
     * @return
     */
    @Query("FROM FilConversation WHERE Rubrique_id =:id")
    List<FilConversation> findByRubriqueId(Long id); 
    
}
