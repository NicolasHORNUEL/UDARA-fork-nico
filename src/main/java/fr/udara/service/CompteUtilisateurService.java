package fr.udara.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.udara.dto.CompteUtilisateurDTO;
import fr.udara.exception.NotFoundException;
import fr.udara.model.Commune;
import fr.udara.model.CompteUtilisateur;
import fr.udara.model.Role;
import fr.udara.repository.CommuneRepository;
import fr.udara.repository.CompteUtilisateurRepository;

/**
 * Classe de service pour l'entité CompteUtilisateur
 * 
 * @author udara
 *
 */
@Service
public class CompteUtilisateurService {

	/** compteUtilisateurRepository : CompteUtilisateurRepository */
	private CompteUtilisateurRepository compteUtilisateurRepository;

	/** communeRepository : CommuneRepository */
	private CommuneRepository communeRepository;

	/**
	 * Constructeur
	 * 
	 */
	@Autowired
	public CompteUtilisateurService(CompteUtilisateurRepository compteUtilisateurRepository,
			CommuneRepository communeRepository) {
		this.compteUtilisateurRepository = compteUtilisateurRepository;
		this.communeRepository = communeRepository;
	}

	/**
	 * @param un objet CompteUtilisateur sans id
	 * @return l'objet CompteUtilisateur avec un id
	 */
	@Transactional
	public void save(CompteUtilisateurDTO compteUtilisateurDTO) {

		CompteUtilisateur compteUtilisateur = new CompteUtilisateur();
		compteUtilisateur.setNom(compteUtilisateurDTO.getNom());
		compteUtilisateur.setPrenom(compteUtilisateurDTO.getPrenom());
		compteUtilisateur.setNomUtilisateur(compteUtilisateurDTO.getNomUtilisateur());
		compteUtilisateur.setEmail(compteUtilisateurDTO.getEmail());
		compteUtilisateur.setMotDePasse(compteUtilisateurDTO.getMotDePasse());
		compteUtilisateur.setCodePostal(compteUtilisateurDTO.getCodePostal());
		compteUtilisateur.setStatutActif(true);
		compteUtilisateur.setRole(Role.ROLE_UTILISATEUR);
		Commune commune = communeRepository.findByName(compteUtilisateurDTO.getCommune());
		if (commune != null) {
			compteUtilisateur.setCommune(commune);
		}
		compteUtilisateurRepository.save(compteUtilisateur);

	}


	/**
	 * Méthode qui permet de modifier le compte utilisateur dont l'id est passé en paramètre
	 * @param formModif
	 * @param id
	 */
	@Transactional
	public void update(CompteUtilisateurDTO compteUtilisateurDTO, Long id) {

		CompteUtilisateur compteUtilisateur = compteUtilisateurRepository.findById(id)
				.orElseThrow(() -> new NotFoundException());

		compteUtilisateur.setNom(compteUtilisateurDTO.getNom());
		compteUtilisateur.setPrenom(compteUtilisateurDTO.getPrenom());
		compteUtilisateur.setMotDePasse(compteUtilisateurDTO.getMotDePasse());
		compteUtilisateur.setCodePostal(compteUtilisateurDTO.getCodePostal());
		compteUtilisateur.setStatutActif(compteUtilisateurDTO.getStatutActif());
		Commune commune = communeRepository.findByName(compteUtilisateurDTO.getCommune());
		if (commune != null) {
			compteUtilisateur.setCommune(commune);
		}
		
		compteUtilisateurRepository.save(compteUtilisateur);
	}

	/**
	 * 
	 * @return une liste d'objet CompteUtilisateur
	 */
	public List<CompteUtilisateur> findAll() {
		return compteUtilisateurRepository.findAll();
	}

	/**
	 * Méthode de récupération des modèles CompteUtilisateur et transformations en
	 * DTO
	 * 
	 * @return une liste d'objet CompteUtilisateurDTO
	 */
	public List<CompteUtilisateurDTO> findAllDTO() {
		List<CompteUtilisateur> comptes = compteUtilisateurRepository.findAll();

		List<CompteUtilisateurDTO> comptesDTO = new ArrayList<>();

		for (CompteUtilisateur compteUtilisateur : comptes) {
			CompteUtilisateurDTO utilisateurDTO = new CompteUtilisateurDTO();
			utilisateurDTO.setId(compteUtilisateur.getId());
			utilisateurDTO.setNom(compteUtilisateur.getNom().toUpperCase());
			utilisateurDTO.setPrenom(compteUtilisateur.getPrenom());
			utilisateurDTO.setNomUtilisateur(compteUtilisateur.getNomUtilisateur());
			utilisateurDTO.setCommune(compteUtilisateur.getCommune().getNom());
			utilisateurDTO.setEmail(compteUtilisateur.getEmail());
			utilisateurDTO.setMotDePasse(compteUtilisateur.getMotDePasse());
			utilisateurDTO.setCodePostal(compteUtilisateur.getCodePostal());
			utilisateurDTO.setStatutActif(compteUtilisateur.getStatutActif());
			comptesDTO.add(utilisateurDTO);
		}
		return comptesDTO;
	}

	/**
	 * @param id d'un objet CompteUtilisateur
	 * @return une liste d'objet CompteUtilisateur
	 */
	public CompteUtilisateur findById(Long id) {
		return compteUtilisateurRepository.findById(id).orElseThrow(() -> new NotFoundException());
	}

	/**
	 * @param id d'un objet CompteUtilisateur
	 * @return true si l'id existe
	 */
	public boolean existsById(Long id) {
		return compteUtilisateurRepository.existsById(id);
	}

	/**
	 * @return le nombre d'objet CompteUtilisateur
	 */
	public long count() {
		return compteUtilisateurRepository.count();
	}

	/**
	 * @param id d'un objet CompteUtilisateur
	 */
	@Transactional
	public void deleteById(Long id) {
		compteUtilisateurRepository.deleteById(id);
	}

	/**
	 * @param un objet CompteUtilisateur
	 */
	@Transactional
	public void delete(CompteUtilisateur compteUtilisateur) {
		compteUtilisateurRepository.delete(compteUtilisateur);
	}

	/**
	 * @param nomUtilisateurOrMail
	 * @return
	 */
	public CompteUtilisateurDTO findByEmail(String userEmail) {

		CompteUtilisateur compteUtilisateur = compteUtilisateurRepository.findByEmail(userEmail);
		CompteUtilisateurDTO compteUtilisateurDTO = new CompteUtilisateurDTO();
		if (compteUtilisateur != null) {
			compteUtilisateurDTO.setId(compteUtilisateur.getId());
			compteUtilisateurDTO.setNom(compteUtilisateur.getNom().toUpperCase());
			compteUtilisateurDTO.setPrenom(compteUtilisateur.getPrenom());
			compteUtilisateurDTO.setNomUtilisateur(compteUtilisateur.getNomUtilisateur());
			compteUtilisateurDTO.setEmail(compteUtilisateur.getEmail());
			compteUtilisateurDTO.setMotDePasse(compteUtilisateur.getMotDePasse());
			compteUtilisateurDTO.setCodePostal(compteUtilisateur.getCodePostal());
			compteUtilisateurDTO.setStatutActif(compteUtilisateur.getStatutActif());
			compteUtilisateurDTO.setCommune(compteUtilisateur.getCommune().getNom());
		} 
		return compteUtilisateurDTO;
	}
	

}
