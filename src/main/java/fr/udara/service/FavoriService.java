package fr.udara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.udara.exception.NotFoundException;
import fr.udara.model.Favori;
import fr.udara.repository.FavoriRepository;


/**
 * Classe de service pour l'entité Favori
 * @author udara
 *
 */
@Service
public class FavoriService {
	
	private FavoriRepository favoriRepository;

	/** Constructeur
	 * 
	 */
	@Autowired
	public FavoriService(FavoriRepository favoriRepository) {
		this.favoriRepository = favoriRepository;
	}
	
	
	/**
	 * @param un objet Favori sans id
	 * @return l'objet Favori avec un id
	 */
	@Transactional
	public Favori save(Favori favori) {
		return favoriRepository.save(favori);
		
	}
	/**
	 * @return une liste d'objet Favori
	 */
	public List<Favori> findAll() {
		return favoriRepository.findAll();
	}

	
	/**
	 * @param id d'un objet Favori
	 * @return une liste d'objet Favori
	 */
	public Favori findById(Long id) {
		return favoriRepository.findById(id).orElseThrow(() -> new NotFoundException());
	}

	
	/**
	 * @param id d'un objet Favori
	 * @return true si l'id existe
	 */
	public boolean existsById(Long id) {
		return favoriRepository.existsById(id);
	}
	
	
	/**
	 * @return le nombre d'objet Favori
	 */
	public long count() {
		return favoriRepository.count();
	}
	
	
	/**
	 * @param id d'un objet Favori
	 */
	@Transactional
	public void deleteById(Long id) {
		favoriRepository.deleteById(id);
	}
	
	
	/**
	 * @param un objet Favori
	 */
	@Transactional
	public void delete(Favori favori) {
		favoriRepository.delete(favori);
	}
	
}


