package fr.udara.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.udara.model.Rubrique;
import fr.udara.repository.RubriqueRepository;

/**
 * Classe de service pour l'entité Rubrique
 * @author udara
 *
 */
@Service
public class RubriqueService {
	
	private RubriqueRepository rubriqueRepository;

	/** Constructeur
	 * 
	 */
	@Autowired
	private RubriqueService(RubriqueRepository rubriqueRepository) {
		this.rubriqueRepository = rubriqueRepository;
	}
	
	
	/**
	 * @param un objet Rubrique sans id
	 * @return l'objet Rubrique avec un id
	 */
	@Transactional
	public Rubrique save(Rubrique rubrique) {
		return rubriqueRepository.save(rubrique);
		
	}
	/**
	 * @return une liste d'objet Rubrique
	 */
	public List<Rubrique> findAll() {
		return rubriqueRepository.findAll();
	}

	
	/**
	 * @param id d'un objet Rubrique
	 * @return une éventuelle liste d'objet Rubrique
	 */
	public Optional<Rubrique> findById(Long id) {
		return rubriqueRepository.findById(id);
	}

	
	/**
	 * @param id d'un objet Rubrique
	 * @return true si l'id existe
	 */
	public boolean existsById(Long id) {
		return rubriqueRepository.existsById(id);
	}
	
	
	/**
	 * @return le nombre d'objet Rubrique
	 */
	public long count() {
		return rubriqueRepository.count();
	}
	
	
	/**
	 * @param id d'un objet Rubrique
	 */
	@Transactional
	public void deleteById(Long id) {
		rubriqueRepository.deleteById(id);
	}
	
	
	/**
	 * @param un objet Rubrique
	 */
	@Transactional
	public void delete(Rubrique rubrique) {
		rubriqueRepository.delete(rubrique);
	}
	
}





