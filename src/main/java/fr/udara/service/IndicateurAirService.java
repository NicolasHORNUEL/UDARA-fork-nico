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
import fr.udara.model.IndicateurAir;
import fr.udara.repository.IndicateurAirRepository;

/**
 * @author UDARA
 *
 */
@Service
public class IndicateurAirService {
	
	private IndicateurAirRepository indicateurAirRepository;
	private Pageable pageable = PageRequest.of(0, 7);


	/** Constructeur
	 * 
	 */
	@Autowired
	public IndicateurAirService(IndicateurAirRepository indicateurAirRepository) {
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



	//////////////////////////////////////// COMMUNE //////////////////////////////////////////	
	public List<IndicateurNiveauDTO> getValuesByIndicateurNameByCommuneName(String nomCommune, List<String> nomIndicateurs, EchelleTemps echelleTemps) {
		List<IndicateurNiveauDTO> listeIndicateurNiveauDTO = new ArrayList<>();
		for (String nomIndicateur : nomIndicateurs) {
			List<Float> listeIndicateurAir = new ArrayList<>();
			if (echelleTemps.equals(EchelleTemps.JOURNALIERE)) {
				listeIndicateurAir = indicateurAirRepository.getValuesByIndicateurNameByDayByCommuneName(nomCommune, nomIndicateur, this.pageable);
			} else if (echelleTemps.equals(EchelleTemps.HEBDOMADAIRE)) {
				listeIndicateurAir = indicateurAirRepository.getValuesByIndicateurNameByWeekByCommuneName(nomCommune, nomIndicateur, this.pageable);
			} else if (echelleTemps.equals(EchelleTemps.MENSUEL)) {
				listeIndicateurAir = indicateurAirRepository.getValuesByIndicateurNameByMonthByCommuneName(nomCommune, nomIndicateur, this.pageable);
			}
			IndicateurNiveauDTO indicateurNiveauDTO = new IndicateurNiveauDTO();
			indicateurNiveauDTO.setNom(nomIndicateur);
			indicateurNiveauDTO.setValeurs(listeIndicateurAir);
			listeIndicateurNiveauDTO.add(indicateurNiveauDTO);
		}
		return listeIndicateurNiveauDTO;
	}
	//////////////////////////////////////// FRANCE //////////////////////////////////////////
	public List<IndicateurNiveauDTO> getAveragesByIndicateurNameFR(List<String> nomIndicateurs, EchelleTemps echelleTemps) {
		List<IndicateurNiveauDTO> listeIndicateurNiveauDTO = new ArrayList<>();
		for (String nomIndicateur : nomIndicateurs) {
			List<Float> listeIndicateurAir = new ArrayList<>();
			if (echelleTemps.equals(EchelleTemps.JOURNALIERE)) {
				listeIndicateurAir = indicateurAirRepository.getAveragesByIndicateurNameByDayFR(nomIndicateur, this.pageable);
			} else if (echelleTemps.equals(EchelleTemps.HEBDOMADAIRE)) {
				listeIndicateurAir = indicateurAirRepository.getAveragesByIndicateurNameByWeekFR(nomIndicateur, this.pageable);
			} else if (echelleTemps.equals(EchelleTemps.MENSUEL)) {
				listeIndicateurAir = indicateurAirRepository.getAveragesByIndicateurNameByMonthFR(nomIndicateur, this.pageable);
			}
			IndicateurNiveauDTO indicateurNiveauDTO = new IndicateurNiveauDTO();
			indicateurNiveauDTO.setNom(nomIndicateur);
			indicateurNiveauDTO.setValeurs(listeIndicateurAir);
			listeIndicateurNiveauDTO.add(indicateurNiveauDTO);
		}
		return listeIndicateurNiveauDTO;
	}
	
	
	
	
	/**
	 * @param id d'un objet IndicateurAir
	 * @return une oéventuelle liste d'objet IndicateurAir
	 */
	public IndicateurAir findById(Long id) {
		return indicateurAirRepository.findById(id).orElseThrow(() -> new NotFoundException());
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
