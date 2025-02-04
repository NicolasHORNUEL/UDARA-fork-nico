/**
 * 
 */
package fr.udara.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.udara.model.Commune;
import fr.udara.model.CompteUtilisateur;

/**
 * Interface implémente des méthodes CRUD de JPA repository
 * @author UDARA
 *
 */
public interface CommuneRepository extends JpaRepository<Commune, Long> {
	
	//////////////////////////////////////////////////////////////////////
	////                                                             /////
	//// ACCÈS À UNE LISTE DE NOM DE COMMUNES PAR FILTRES SUCCESSIFS /////
	////                                                             /////
	//////////////////////////////////////////////////////////////////////
	/**
	 * @return une liste de tous les noms de region de la table commune
	 */
	@Query("SELECT DISTINCT region FROM Commune")
	List<String> findRegion();
	/**
	 * @param un nom d'une region en string
	 * @return une liste de codes departement en string 
	 */
	@Query("SELECT DISTINCT departement FROM Commune WHERE region=:region")
	List<String> findNomDepartementByRegion(String region);
	/**
	 * @param un code departement en string
	 * @return une liste de noms de commune en string
	 */
	@Query("SELECT nom FROM Commune WHERE departement=:departement")
	List<String> findNomCommuneByDepartement(String departement);
	
	/**
	 * Récupération d'une Commune en fonction de son nom
	 * 
	 * @param le nom en String d'un objet Commune
	 * @return l'objet Commune trouvé en base
	 */
	@Query("FROM Commune WHERE nom=:nom")
	Commune findByName(String nom);
	/**
	 * Récupération d'une Liste de Commune en fonction d'un nom
	 * 
	 * @param le nom en String d'un objet Commune
	 * @return une liste d'objet Commune trouvé en base
	 */
	@Query("FROM Commune WHERE nom LIKE %:nom%")
	List<Commune> findAllByNameLike(String nom);
	/**
	 * Récupération de la liste des departement dans la table commune
	 * 
	 * @return {@link List<Strin>} la liste des departement 
	 */
	@Query("SELECT DISTINCT departement FROM Commune")
	List<String> findDepartement();
	/**
	 * Recupération de la liste des nom de toutes les communes
	 * 
	 * @return list des nom de toute les communes
	 */
	@Query("SElECT nom FROM Commune")
	List<String> findAllNomCommune();
	/**
	 * recupére la liste des communes pour une région donnée
	 * 
	 * @param region
	 * @return la liste des commune pour une region
	 */
	@Query("SELECT c.nom FROM Commune c WHERE c.region =: region")
	List<String> findNomCommuneByRegion(String region);
	
	/**
	 * Récupère la liste des Compte Utilisateur pour un nom de commune donné
	 * @param nomCommune
	 * @return la liste des CompteUtilisateur pour un commune donné
	 */
	@Query("SELECT compteUtilisateurs FROM Commune WHERE nom =: nomCommune")
	List<CompteUtilisateur> findUserByCommune(String nomCommune);
	/**
	 * Récupère la liste des Compte Utilisateur pour un nom de region donné
	 * @param nomRegion
	 * @return la liste des CompteUtilisateur pour une region donné
	 */
	@Query("SELECT compteUtilisateurs FROM Commune WHERE region =: nomRegion")
	List<CompteUtilisateur> findUserByRegion(String nomRegion);
	

}
