package fr.udara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.udara.exception.NotFoundException;
import fr.udara.model.FilConversation;
import fr.udara.repository.FilConversationRepository;


/**
 * Classe de service pour l'entité FilConversation
 * @author udara
 *
 */
@Service
public class FilConversationService {
	
	private FilConversationRepository filConversationRepository;

	/** Constructeur
	 * 
	 */
	@Autowired
	private FilConversationService(FilConversationRepository filConversationRepository) {
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
	 * @param id d'un objet FilConversation
	 * @return une liste d'objet FilConversation
	 */
	public FilConversation findById(Long id) {
		return filConversationRepository.findById(id).orElseThrow(() -> new NotFoundException());
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
