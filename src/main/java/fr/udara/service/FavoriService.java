package fr.udara.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.udara.dto.FavoriDTO;
import fr.udara.exception.NotFoundException;
import fr.udara.model.Commune;
import fr.udara.model.CompteUtilisateur;
import fr.udara.model.Favori;
import fr.udara.repository.CommuneRepository;
import fr.udara.repository.CompteUtilisateurRepository;
import fr.udara.repository.FavoriRepository;


/**
 * Classe de service pour l'entité Favori
 * @author udara
 *
 */
@Service
public class FavoriService {
	
	/** FavoriRepository : FavoriRepository */
	private FavoriRepository favoriRepository;
	/** compteUtilisateurRepository : CompteUtilisateurRepository */
	private CompteUtilisateurRepository compteUtilisateurRepository;
	/** communeRepository : CommuneRepository */
	private CommuneRepository communeRepository;

	/** Constructeur
	 * 
	 */
	@Autowired
	public FavoriService(FavoriRepository favoriRepository, CommuneRepository communeRepository, CompteUtilisateurRepository compteUtilisateurRepository) {
		this.favoriRepository = favoriRepository;
		this.communeRepository = communeRepository;
		this.compteUtilisateurRepository = compteUtilisateurRepository;
	}
	
	/**
	 * Pour récupérer un objet Favori par son nom.
	 * 
	 * @param nom d'une favori en String.
	 * @return un objet Favori.
	 */
	public Favori findByName(String name) {
		return favoriRepository.findByName(name);
	}
	
	/**
	 * Pour récupérer une liste d'objet Favori.
	 * 
	 * @param nom d'une favori en String.
	 * @return une liste de Favori.
	 */
	public List<Favori> findAllByNameLike(String name) {
		return favoriRepository.findAllByNameLike(name);
	}

	
	/**
	 * @param un objet FavoriDTO
	 */
	@Transactional
	public void save(FavoriDTO favoriDTO) {
		
		Favori favori = new Favori();
		
		favori.setNom(favoriDTO.getNom());
		
		List<String> listeIndicateur = favoriDTO.getIndicateurAir();
		StringBuilder sbIndicateur = new StringBuilder();
		for (int i = 0; i < listeIndicateur.size(); i++) {
			sbIndicateur.append(listeIndicateur.get(i));
			sbIndicateur.append(",");
		}
		favori.setIndicateurAir(sbIndicateur.toString());
		
	      
		List<String> listeNiveau = favoriDTO.getNiveauMeteo();
		StringBuilder sbNiveau = new StringBuilder();
		for (int i = 0; i < listeNiveau.size(); i++) {
			sbNiveau.append(listeNiveau.get(i));
			sbNiveau.append(",");
		}
		favori.setNiveauMeteo(sbNiveau.toString());

		favori.setEchelleTemps(favoriDTO.getEchelleTemps());
		
		Commune commune = communeRepository.findByName(favoriDTO.getCommune());
		if (commune != null) {
			favori.setCommune(commune);
		}
		
		CompteUtilisateur compteUtilisateur = compteUtilisateurRepository.findByEmail(favoriDTO.getCompteUtilisateur());
		if (compteUtilisateur != null) {
			favori.setCompteUtilisateur(compteUtilisateur);
		}
		favoriRepository.save(favori);
	}
	
	/**
	 * @return une liste d'objet Favori
	 */
	public List<Favori> findAll() {
		return favoriRepository.findAll();
	}

	/**
	 * Méthode de récupération des Favoris au format DTO
	 * 
	 * @return une liste d'objet FavoriDTO
	 */
	public List<FavoriDTO> findAllDTO() {
		List<Favori> listeFavoris = favoriRepository.findAll();
		List<FavoriDTO> listeFavorisDTO = new ArrayList<>();
		for (Favori favori : listeFavoris) {
			FavoriDTO favoriDTO = new FavoriDTO();
			
			favoriDTO.setId(favori.getId());
			favoriDTO.setNom(favori.getNom());
			favoriDTO.setEchelleTemps(favori.getEchelleTemps());;
			
			String[] decoupageAir = favori.getIndicateurAir().split(",");
			List<String> decoupageAirDTO = Arrays.asList(decoupageAir);
			favoriDTO.setIndicateurAir(decoupageAirDTO);
			
			String[] decoupageMeteo = favori.getNiveauMeteo().split(",");
			List<String> decoupageMeteoDTO = Arrays.asList(decoupageMeteo);
			favoriDTO.setNiveauMeteo(decoupageMeteoDTO);
			
			listeFavorisDTO.add(favoriDTO);
		}
		return listeFavorisDTO;
	}
	
	/**
	 * @return la liste de tous les noms de favoris
	 */
	public List<String> findAllNomFavori() {
		return favoriRepository.findAllNomFavori();
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


