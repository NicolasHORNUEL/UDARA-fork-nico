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
	@Query("SELECT m FROM Message m WHERE Filconversation_id =:id")
	List<Message> findByFilConversation(Long id);

	
}
