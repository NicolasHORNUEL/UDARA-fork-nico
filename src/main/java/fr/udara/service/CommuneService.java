package fr.udara.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.udara.dto.CommuneDTO;
import fr.udara.exception.NotFoundException;
import fr.udara.model.Commune;
import fr.udara.repository.CommuneRepository;

/**
 * Classe de service pour l'entité Commune
 * 
 * @author udara
 *
 */
@Service
public class CommuneService {

	private CommuneRepository communeRepository;

	/**
	 * Constructeur
	 * 
	 */
	@Autowired
	public CommuneService(CommuneRepository communeRepository) {
		this.communeRepository = communeRepository;
	}

	/**
	 * Pour récupérer un objet Commune par son nom.
	 * 
	 * @param nom d'une commune en String.
	 * @return un objet Commune.
	 */
	public CommuneDTO findByName(String name) {
		Commune commune = communeRepository.findByName(name);
		CommuneDTO communeDTO = new CommuneDTO();
		communeDTO.setName(commune.getNom().toUpperCase());
		communeDTO.setRegion(commune.getRegion());
		communeDTO.setDepartement(commune.getDepartement());
		communeDTO.setPopulation(commune.getPopulation());
		communeDTO.setLat(commune.getyCoordonnee());
		communeDTO.setLon(commune.getxCoordonnee());
		return communeDTO;
	}

	/**
	 * Pour récupérer une liste d'objet Commune.
	 * 
	 * @param nom d'une commune en String.
	 * @return une liste de Commune.
	 */
	public List<CommuneDTO> findAllByNameLike(String name) {

		List<Commune> listeCommunes = communeRepository.findAllByNameLike(name);

		List<CommuneDTO> listeCommunesDTO = new ArrayList<>();

		for (Commune commune : listeCommunes) {
			CommuneDTO communeDTO = new CommuneDTO();
			communeDTO.setName(commune.getNom().toUpperCase());
			communeDTO.setRegion(commune.getRegion());
			communeDTO.setDepartement(commune.getDepartement());
			communeDTO.setPopulation(commune.getPopulation());
			communeDTO.setLat(commune.getyCoordonnee());
			communeDTO.setLon(commune.getxCoordonnee());
			listeCommunesDTO.add(communeDTO);
		}
		return listeCommunesDTO;
	}

	/**
	 * @param un objet Commune sans id
	 * @return l'objet Commune avec un id
	 */
	@Transactional
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
	 * Méthode de récupération des Communes au format DTO
	 * 
	 * @return une liste d'objet CommuneDTO
	 */
	public List<CommuneDTO> findAllDTO() {
		List<Commune> listeCommunes = communeRepository.findAll();

		List<CommuneDTO> listeCommunesDTO = new ArrayList<>();

		for (Commune commune : listeCommunes) {
			CommuneDTO communeDTO = new CommuneDTO();
			communeDTO.setName(commune.getNom().toUpperCase());
			communeDTO.setRegion(commune.getRegion());
			communeDTO.setDepartement(commune.getDepartement());
			communeDTO.setPopulation(commune.getPopulation());
			communeDTO.setLat(commune.getyCoordonnee());
			communeDTO.setLon(commune.getxCoordonnee());
			listeCommunesDTO.add(communeDTO);
		}
		return listeCommunesDTO;
	}

	/**
	 * @param id d'un objet Commune
	 * @return une oéventuelle liste d'objet Commune
	 */
	public Commune findById(Long id) {
		return communeRepository.findById(id).orElseThrow(() -> new NotFoundException());
	}

	/**
	 * @return la liste des region
	 */
	public List<String> findRegion() {
		return communeRepository.findRegion();
	}

	/**
	 * @return la liste des departement
	 */
	public List<String> findDepartement() {
		return communeRepository.findDepartement();
	}
	
	/**
	 * @return la les de toute les communes
	 */
	public List<String> findAllNomCommune() {
		return communeRepository.findAllNomCommune();
	}


	/**
	 * @param region
	 * @return la liste des commune pour un département donné
	 */
	public List<String> findNomCommuneByDepartement(String departement) {
		return communeRepository.findNomCommuneByDepartement(departement);
	}
	
	/**
	 * @param region
	 * @return la liste des commune pour une region donné
	 */
	public List<String> findNomCommuneByRegion(String region) {
		return communeRepository.findNomCommuneByRegion(region);
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
	@Transactional
	public void deleteById(Long id) {
		communeRepository.deleteById(id);
	}

	/**
	 * @param un objet Commune
	 */
	@Transactional
	public void delete(Commune commune) {
		communeRepository.delete(commune);
	}

}
