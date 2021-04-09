package fr.udara.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.udara.dto.FilConversationDTO;
import fr.udara.exception.NotFoundException;
import fr.udara.model.FilConversation;
import fr.udara.repository.FilConversationRepository;

/**
 * Classe de service pour l'entité FilConversation
 * 
 * @author udara
 *
 */
@Service
public class FilConversationService {

	private FilConversationRepository filConversationRepository;

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
	 * @return l'objet FilConversation avec un id
	 */
	@Transactional
	public FilConversation save(FilConversation filConversation) {
		return filConversationRepository.save(filConversation);

	}

	/**
	 * @return une liste d'objet FilConversation
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

		List<FilConversationDTO> conversationsDTO = new ArrayList<>();

		for (FilConversation filConversation : conversations) {
			FilConversationDTO filConversationDTO = new FilConversationDTO();
			filConversationDTO.setNom(filConversation.getNom().toUpperCase());
			conversationsDTO.add(filConversationDTO);
		}
		return conversationsDTO;
	}

	/**
	 * @param id d'un objet FilConversation
	 * @return une liste d'objet FilConversation
	 */
	public FilConversationDTO findById(Long id) {
		FilConversationDTO filConversationDTO = new FilConversationDTO();
		FilConversation filConversation = filConversationRepository.findById(id)
				.orElseThrow(() -> new NotFoundException());
		filConversationDTO.setNom(filConversation.getNom());
		return filConversationDTO;
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
