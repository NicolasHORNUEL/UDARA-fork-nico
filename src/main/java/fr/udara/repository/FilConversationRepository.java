/**
 * 
 */
package fr.udara.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.udara.model.FilConversation;

/**
 * Interface implémente des méthodes CRUD de JPA repository
 * @author UDARA
 *
 */
public interface FilConversationRepository extends JpaRepository<FilConversation, Long>{

}
