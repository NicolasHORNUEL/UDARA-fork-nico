/**
 * 
 */
package fr.udara.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sun.nio.sctp.Notification;

/**
 * Interface implémente des méthodes CRUD de JPA repository
 * @author UDARA
 *
 */
public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
