package fr.udara.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.udara.dto.CommuneDTO;
import fr.udara.dto.FilConversationDTO;
import fr.udara.exception.NotFoundException;
import fr.udara.model.Commune;
import fr.udara.model.FilConversation;
import fr.udara.repository.CommuneRepository;
import fr.udara.repository.FilConversationRepository;
import fr.udara.repository.IndicateurAirRepository;
import fr.udara.repository.NiveauMeteoRepository;

/**
 * Classe de service pour le DTO PageAccueilDTO
 * 
 * @author Udara
 *
 */
@Service
public class PageAccueilService {

	private CommuneRepository communeRepository;
	private IndicateurAirRepository indicateurAirRepository ;
	private NiveauMeteoRepository niveauMeteoRepository;

	/**
	 * Constructeur
	 * 
	 */
	@Autowired
	public PageAccueilService(CommuneRepository communeRepository, IndicateurAirRepository indicateurAirRepository,
			NiveauMeteoRepository niveauMeteoRepository) {
		this.communeRepository = communeRepository;
		this.indicateurAirRepository = indicateurAirRepository;
		this.niveauMeteoRepository = niveauMeteoRepository;
	}

	public String findNomCommuneByCompteUtilisateurId(Long id) {
		if (id == null) {
			throw new NotFoundException();
		}
		Commune commune = communeRepository.findById(id)
				.orElseThrow(() -> new NotFoundException());
		return commune.getNom();
	}

}
