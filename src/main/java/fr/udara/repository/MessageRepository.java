/**
 * 
 */
package fr.udara.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.udara.model.Message;

/**
 * Interface implémente des méthodes CRUD de JPA repository
 * @author UDARA
 *
 */
public interface MessageRepository extends JpaRepository<Message, Long>{
	
	/**
	 * @param id d'un FilConversation
	 * @return la liste des messages pour un id FilConversation donné
	 */
	@Query("FROM Message WHERE FilConversation_id=:id")
	List<Message> searchByFilConversation(Long id);


	
}
