package fr.udara.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.udara.model.Commune;
import fr.udara.repository.CommuneRepository;

/**
 * Classe de service pour l'entité Commune
 * @author udara
 *
 */
@Service
public class CommuneService {
	
	private CommuneRepository communeRepository;

	/** Constructeur
	 * 
	 */
	@Autowired
	private CommuneService(CommuneRepository communeRepository) {
		this.communeRepository = communeRepository;
	}
	
	
	/**
	 * @param un objet Commune sans id
	 * @return l'objet Commune avec un id
	 */
	public Commune save(Commune commune) {
		return communeRepository.save(commune);
		
	}
	/**
	 * @return une liste d'objet Commune
	 */
	public List<Commune> findAll() {
		return communeRepository.findAll();
	}

	
	/**
	 * @param id d'un objet Commune
	 * @return une oéventuelle liste d'objet Commune
	 */
	public Optional<Commune> findById(Long id) {
		return communeRepository.findById(id);
	}

	
	/**
	 * @param id d'un objet Commune
	 * @return true si l'id existe
	 */
	public boolean existsById(Long id) {
		return communeRepository.existsById(id);
	}
	
	
	/**
	 * @return le nombre d'objet Commune
	 */
	public long count() {
		return communeRepository.count();
	}
	
	
	/**
	 * @param id d'un objet Commune
	 */
	public void deleteById(Long id) {
		communeRepository.deleteById(id);
	}
	
	
	/**
	 * @param un objet Commune
	 */
	public void delete(Commune commune) {
		communeRepository.delete(commune);
	}
	
}




