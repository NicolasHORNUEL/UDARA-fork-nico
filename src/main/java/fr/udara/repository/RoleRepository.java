/**
 * 
 */
package fr.udara.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.udara.model.Role;

/**
 * Interface implémente des méthodes CRUD de JPA repository
 * @author UDARA
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long>{

}
