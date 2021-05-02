/**
 * 
 */
package fr.udara.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.udara.dto.IndicateurNiveauDTO;
import fr.udara.exception.NotFoundException;
import fr.udara.model.EchelleTemps;
import fr.udara.model.NiveauMeteo;
import fr.udara.repository.NiveauMeteoRepository;

/**
 * @author UDARA
 *
 */
@Service
public class NiveauMeteoService {
	
	private NiveauMeteoRepository niveauMeteoRepository;
	private Pageable pageable = PageRequest.of(0, 7);

	/** Constructeur
	 * 
	 */
	@Autowired
	public NiveauMeteoService(NiveauMeteoRepository niveauMeteoRepository) {
		this.niveauMeteoRepository = niveauMeteoRepository;
	}
	
	
	/**
	 * @param un objet NiveauMeteo sans id
	 * @return l'objet NiveauMeteo avec un id
	 */
	@Transactional
	public NiveauMeteo save(NiveauMeteo niveauMeteo) {
		return niveauMeteoRepository.save(niveauMeteo);
		
	}
	/**
	 * @return une liste d'objet NiveauMeteo
	 */
	public List<NiveauMeteo> findAll() {
		return niveauMeteoRepository.findAll();
	}


	//////////////////////////////////////// COMMUNE //////////////////////////////////////////	
	public List<IndicateurNiveauDTO> getValuesByNiveauNameByCommuneName(String nomCommune, List<String> nomNiveaux, EchelleTemps echelleTemps) {
		List<IndicateurNiveauDTO> listeIndicateurNiveauDTO = new ArrayList<>();
		for (String nomNiveau : nomNiveaux) {
			List<Float> listeNiveauMeteo = new ArrayList<>();
			if (echelleTemps.equals(EchelleTemps.JOURNALIERE)) {
				listeNiveauMeteo = niveauMeteoRepository.getValuesByNiveauNameByDayByCommuneName(nomCommune, nomNiveau, this.pageable);
			} else if (echelleTemps.equals(EchelleTemps.HEBDOMADAIRE)) {
				listeNiveauMeteo = niveauMeteoRepository.getValuesByNiveauNameByWeekByCommuneName(nomCommune, nomNiveau, this.pageable);
			} else if (echelleTemps.equals(EchelleTemps.MENSUEL)) {
				listeNiveauMeteo = niveauMeteoRepository.getValuesByNiveauNameByMonthByCommuneName(nomCommune, nomNiveau, this.pageable);
			}
			IndicateurNiveauDTO indicateurNiveauDTO = new IndicateurNiveauDTO();
			indicateurNiveauDTO.setNom(nomNiveau);
			indicateurNiveauDTO.setValeurs(listeNiveauMeteo);
			listeIndicateurNiveauDTO.add(indicateurNiveauDTO);
		}
		return listeIndicateurNiveauDTO;
	}
	//////////////////////////////////////// FRANCE //////////////////////////////////////////
	public List<IndicateurNiveauDTO> getAveragesByNiveauNameFR(List<String> nomNiveaux, EchelleTemps echelleTemps) {
		List<IndicateurNiveauDTO> listeIndicateurNiveauDTO = new ArrayList<>();
		for (String nomNiveau : nomNiveaux) {
			List<Float> listeNiveauMeteo = new ArrayList<>();
			if (echelleTemps.equals(EchelleTemps.JOURNALIERE)) {
				listeNiveauMeteo = niveauMeteoRepository.getAveragesByNiveauNameByDayFR(nomNiveau, this.pageable);
			} else if (echelleTemps.equals(EchelleTemps.HEBDOMADAIRE)) {
				listeNiveauMeteo = niveauMeteoRepository.getAveragesByNiveauNameByWeekFR(nomNiveau, this.pageable);
			} else if (echelleTemps.equals(EchelleTemps.MENSUEL)) {
				listeNiveauMeteo = niveauMeteoRepository.getAveragesByNiveauNameByMonthFR(nomNiveau, this.pageable);
			}
			IndicateurNiveauDTO indicateurNiveauDTO = new IndicateurNiveauDTO();
			indicateurNiveauDTO.setNom(nomNiveau);
			indicateurNiveauDTO.setValeurs(listeNiveauMeteo);
			listeIndicateurNiveauDTO.add(indicateurNiveauDTO);
		}
		return listeIndicateurNiveauDTO;
	}
	
	
	/**
	 * @param id d'un objet NiveauMeteo
	 * @return une oéventuelle liste d'objet NiveauMeteo
	 */
	public NiveauMeteo findById(Long id) {
		return niveauMeteoRepository.findById(id).orElseThrow(() -> new NotFoundException());
	}

	
	/**
	 * @param id d'un objet NiveauMeteo
	 * @return true si l'id existe
	 */
	public boolean existsById(Long id) {
		return niveauMeteoRepository.existsById(id);
	}
	
	
	/**
	 * @return le nombre d'objet NiveauMeteo
	 */
	public long count() {
		return niveauMeteoRepository.count();
	}
	
	
	/**
	 * @param id d'un objet NiveauMeteo
	 */
	@Transactional
	public void deleteById(Long id) {
		niveauMeteoRepository.deleteById(id);
	}
	
	
	/**
	 * @param un objet NiveauMeteo
	 */
	@Transactional
	public void delete(NiveauMeteo niveauMeteo) {
		niveauMeteoRepository.delete(niveauMeteo);
	}

}
