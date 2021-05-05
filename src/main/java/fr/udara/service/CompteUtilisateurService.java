package fr.udara.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.udara.dto.CompteUtilisateurDTO;
import fr.udara.dto.form.FormInscriptionDTO;
import fr.udara.dto.form.FormModifInfoPersoDTO;
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
	public void save(FormInscriptionDTO formInscriptionDTO) {

		CompteUtilisateur compteUtilisateur = new CompteUtilisateur();
		compteUtilisateur.setNom(formInscriptionDTO.getNom());
		compteUtilisateur.setPrenom(formInscriptionDTO.getPrenom());
		compteUtilisateur.setNomUtilisateur(formInscriptionDTO.getNomUtilisateur());
		compteUtilisateur.setEmail(formInscriptionDTO.getEmail());
		compteUtilisateur.setMotDePasse(formInscriptionDTO.getMotDePasse());
		compteUtilisateur.setCodePostal(formInscriptionDTO.getCodePostal());
		compteUtilisateur.setStatutActif(true);
		compteUtilisateur.setRole(Role.ROLE_UTILISATEUR);
		Commune commune = communeRepository.findByName(formInscriptionDTO.getVille());
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
	public void update(FormModifInfoPersoDTO formModif, Long id) {

		CompteUtilisateur compteUtilisateur = compteUtilisateurRepository.findById(id)
				.orElseThrow(() -> new NotFoundException());

		compteUtilisateur.setNom(formModif.getNom());
		compteUtilisateur.setPrenom(formModif.getPrenom());
		compteUtilisateur.setNomUtilisateur(formModif.getNomUtilisateur());
		compteUtilisateur.setMotDePasse(formModif.getMotDePasse());
		compteUtilisateur.setMotDePasse(formModif.getConfirmerMotDePasse());
		compteUtilisateur.setMotDePasse(formModif.getNouveauMotDePasse());
		compteUtilisateur.setMotDePasse(formModif.getVille());
		compteUtilisateur.setCodePostal(formModif.getCodePostal());
		compteUtilisateur.setEmail(formModif.getEmail());
		
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
			utilisateurDTO.setNom(compteUtilisateur.getNom().toUpperCase());
			utilisateurDTO.setPrenom(compteUtilisateur.getPrenom());
			utilisateurDTO.setNomUtilisateur(compteUtilisateur.getNomUtilisateur());
			utilisateurDTO.setCommune(compteUtilisateur.getCommune().getNom());
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
	public CompteUtilisateur findByEmail(String userEmail) {

		CompteUtilisateur compteUtilisateur = null;

		try {
			compteUtilisateur = compteUtilisateurRepository.findByEmail(userEmail);
		} catch (Exception e) {
			throw e;
		}

		return compteUtilisateur;
	}

}
