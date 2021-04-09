package fr.udara.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.udara.model.Role;

/**
 * @author Udara
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long>{

}
