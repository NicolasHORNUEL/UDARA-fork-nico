package fr.udara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.udara.exception.NotFoundException;
import fr.udara.model.CompteUtilisateur;
import fr.udara.repository.CompteUtilisateurRepository;

/**
 * Classe de service pour l'entité CompteUtilisateur
 * @author udara
 *
 */
@Service
public class CompteUtilisateurService {
	
	private CompteUtilisateurRepository compteUtilisateurRepository;

	/** Constructeur
	 * 
	 */
	@Autowired
	public CompteUtilisateurService(CompteUtilisateurRepository compteUtilisateurRepository) {
		this.compteUtilisateurRepository = compteUtilisateurRepository;
	}
	
	
	/**
	 * @param un objet CompteUtilisateur sans id
	 * @return l'objet CompteUtilisateur avec un id
	 */
	@Transactional
	public CompteUtilisateur save(CompteUtilisateur compteUtilisateur) {
		return compteUtilisateurRepository.save(compteUtilisateur);
		
	}
	/**
	 * @return une liste d'objet CompteUtilisateur
	 */
	public List<CompteUtilisateur> findAll() {
		return compteUtilisateurRepository.findAll();
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
	
}




