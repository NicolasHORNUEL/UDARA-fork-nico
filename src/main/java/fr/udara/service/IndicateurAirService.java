/**
 * 
 */
package fr.udara.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.udara.model.IndicateurAir;
import fr.udara.repository.IndicateurAirRepository;

/**
 * @author UDARA
 *
 */
@Service
public class IndicateurAirService {
	
	private IndicateurAirRepository indicateurAirRepository;

	/** Constructeur
	 * 
	 */
	@Autowired
	private IndicateurAirService(IndicateurAirRepository indicateurAirRepository) {
		this.indicateurAirRepository = indicateurAirRepository;
	}
	
	
	/**
	 * @param un objet IndicateurAir sans id
	 * @return l'objet IndicateurAir avec un id
	 */
	@Transactional
	public IndicateurAir save(IndicateurAir indicateurAir) {
		return indicateurAirRepository.save(indicateurAir);
		
	}
	/**
	 * @return une liste d'objet IndicateurAir
	 */
	public List<IndicateurAir> findAll() {
		return indicateurAirRepository.findAll();
	}

	
	/**
	 * @param id d'un objet IndicateurAir
	 * @return une oéventuelle liste d'objet IndicateurAir
	 */
	public Optional<IndicateurAir> findById(Long id) {
		return indicateurAirRepository.findById(id);
	}

	
	/**
	 * @param id d'un objet IndicateurAir
	 * @return true si l'id existe
	 */
	public boolean existsById(Long id) {
		return indicateurAirRepository.existsById(id);
	}
	
	
	/**
	 * @return le nombre d'objet IndicateurAir
	 */
	public long count() {
		return indicateurAirRepository.count();
	}
	
	
	/**
	 * @param id d'un objet IndicateurAir
	 */
	@Transactional
	public void deleteById(Long id) {
		indicateurAirRepository.deleteById(id);
	}
	
	
	/**
	 * @param un objet IndicateurAir
	 */
	@Transactional
	public void delete(IndicateurAir indicateurAir) {
		indicateurAirRepository.delete(indicateurAir);
	}

}
