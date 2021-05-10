package fr.udara.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.udara.dto.FilConversationDTO;
import fr.udara.dto.RubriqueDTO;
import fr.udara.exception.NotFoundException;
import fr.udara.model.FilConversation;
import fr.udara.model.Rubrique;
import fr.udara.repository.FilConversationRepository;
import fr.udara.repository.RubriqueRepository;

/**
 * Classe de service pour l'entité FilConversation
 * 
 * @author udara
 *
 */
@Service
public class FilConversationService {

	
	
	/** filConversationRepository : FilConversationRepository */
	private FilConversationRepository filConversationRepository;
	/** rubriqueRepository : RubriqueRepository */
	private RubriqueRepository rubriqueRepository;
	
	

	/**
	 * Constructeur
	 * 
	 */
	@Autowired
	public FilConversationService(FilConversationRepository filConversationRepository) {
		this.filConversationRepository = filConversationRepository;
	}

	
	
	/**
	 * @param un objet FilConversation sans id
	 */
	@Transactional
	public void save(FilConversationDTO filConversationDTO) {
		FilConversation filConversation = new FilConversation();
		filConversation.setNom(filConversationDTO.getNom());
		Rubrique rubrique = rubriqueRepository.findById(filConversationDTO.getRubrique().getId())
				.orElseThrow(() -> new NotFoundException());
		filConversation.setRubrique(rubrique);
		filConversationRepository.save(filConversation);
	}

	/**
	 * @return une liste d'objet FilConversationDTO
	 */
	public List<FilConversation> findAll() {
		return filConversationRepository.findAll();
	}

	/**
	 * 
	 * @return la liste de toutes les filConversationDTO
	 */
	public List<FilConversationDTO> findAllDTO() {
		List<FilConversation> conversations = filConversationRepository.findAll();
		List<FilConversationDTO> listFilConversationDTO = new ArrayList<>();
		for (FilConversation filConversation : conversations) {
			FilConversationDTO filConversationDTO = new FilConversationDTO();
			filConversationDTO.setId(filConversation.getId());
			filConversationDTO.setNom(filConversation.getNom().toUpperCase());
			Rubrique rubrique = filConversation.getRubrique();
			RubriqueDTO rubriqueDTO = new RubriqueDTO();
			rubriqueDTO.setId(rubrique.getId());
			rubriqueDTO.setNom(rubrique.getNom());
			filConversationDTO.setRubrique(rubriqueDTO);
			listFilConversationDTO.add(filConversationDTO);
		}
		return listFilConversationDTO;
	}
	

	/**
	 * @param id d'un objet FilConversation
	 * @return une liste d'objet FilConversation
	 */
	public FilConversationDTO findById(Long id) {
		FilConversation filConversation = filConversationRepository.findById(id)
				.orElseThrow(() -> new NotFoundException());
		FilConversationDTO filConversationDTO = new FilConversationDTO();
		filConversationDTO.setNom(filConversation.getNom());
		Rubrique rubrique = filConversation.getRubrique();
		RubriqueDTO rubriqueDTO = new RubriqueDTO();
		rubriqueDTO.setId(rubrique.getId());
		rubriqueDTO.setNom(rubrique.getNom());
		filConversationDTO.setRubrique(rubriqueDTO);
		return filConversationDTO;
	}
	
    /**
     * @param id de la rubrique
     * @return la liste de  tout les filc= de conversation pour une rubrique 
     */
    public List<FilConversationDTO> findByRubriqueId(Long id) {
        List<FilConversation> filConversationByRubrique = filConversationRepository.findByRubriqueId(id);
        List<FilConversationDTO> listFilConversationDTO = new ArrayList<>();
        for (FilConversation filConversation : filConversationByRubrique) {
            FilConversationDTO filConversationDTO = new FilConversationDTO();
            
            filConversationDTO.setId(filConversation.getId());
            filConversationDTO.setNom(filConversation.getNom().toUpperCase());
            
            Rubrique rubrique = filConversation.getRubrique();
            RubriqueDTO rubriqueDTO = new RubriqueDTO();
            rubriqueDTO.setId(rubrique.getId());
            rubriqueDTO.setNom(rubrique.getNom());
            filConversationDTO.setRubrique(rubriqueDTO);
            listFilConversationDTO.add(filConversationDTO);
        }
        return listFilConversationDTO;
    }

	/**
	 * @param id d'un objet FilConversation
	 * @return true si l'id existe
	 */
	public boolean existsById(Long id) {
		return filConversationRepository.existsById(id);
	}

	/**
	 * @return le nombre d'objet FilConversation
	 */
	public long count() {
		return filConversationRepository.count();
	}

	/**
	 * @param id d'un objet FilConversation
	 */
	@Transactional
	public void deleteById(Long id) {
		filConversationRepository.deleteById(id);
	}

	/**
	 * @param un objet FilConversation
	 */
	@Transactional
	public void delete(FilConversation filConversation) {
		filConversationRepository.delete(filConversation);
	}

}
