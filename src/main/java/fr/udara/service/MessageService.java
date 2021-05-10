package fr.udara.service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.udara.dto.MessageDTO;
import fr.udara.exception.NotFoundException;
import fr.udara.model.Message;
import fr.udara.repository.MessageRepository;

/**
 * Classe de service pour l'entité Message
 * @author udara
 *
 */
@Service
public class MessageService {
	
	private MessageRepository messageRepository;

	/** Constructeur
	 * 
	 */
	@Autowired
	public MessageService(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}
	
	
	/**
	 * @param un objet Message sans id
	 * @return l'objet Message avec un id
	 */
	@Transactional
	public Message save(Message message) {
		return messageRepository.save(message);
		
	}
	/**
	 * @return une liste d'objet Message
	 */
	public List<MessageDTO> findAll() {
		List<Message> listeMessage = messageRepository.findAll();
		List<MessageDTO> listeMessageDTO = new ArrayList<>();
		for (Message message : listeMessage) {
			MessageDTO messageDTO = new MessageDTO();
			messageDTO.setId(message.getId());
			messageDTO.setNom(message.getNom());
			messageDTO.setDate(message.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			System.out.println("tostring : " + message.getDate().toString());
			System.out.println("tostring : " + message.getDate().format(DateTimeFormatter.ofPattern("yyyy.MM.dd-HH.mm")));
			listeMessageDTO.add(messageDTO);
		}
		return listeMessageDTO;
	}

	
	/**
	 * @param id d'un objet Message
	 * @return une éventuelle liste d'objet Message
	 */
	public Message findById(Long id) {
		return messageRepository.findById(id).orElseThrow(() -> new NotFoundException());
	}


	public List<MessageDTO> searchByFilConversation(Long id) {
		List<Message> listeMessage = messageRepository.searchByFilConversation(id);
		List<MessageDTO> listeMessageDTO = new ArrayList<>();
		for (Message message : listeMessage) {
			MessageDTO messageDTO = new MessageDTO();
			messageDTO.setId(message.getId());
			messageDTO.setNom(message.getNom());
			messageDTO.setDate(message.getDate().format(DateTimeFormatter.ofPattern("yyyy.MM.dd-HH.mm")));
			listeMessageDTO.add(messageDTO);
		}
		return listeMessageDTO;
	}
	
	
	/**
	 * @param id d'un objet Message
	 * @return true si l'id existe
	 */
	public boolean existsById(Long id) {
		return messageRepository.existsById(id);
	}
	
	
	/**
	 * @return le nombre d'objet Message
	 */
	public long count() {
		return messageRepository.count();
	}
	
	
	/**
	 * @param id d'un objet Message
	 */
	@Transactional
	public void deleteById(Long id) {
		messageRepository.deleteById(id);
	}
	
	
	/**
	 * @param un objet Message
	 */
	@Transactional
	public void delete(Message message) {
		messageRepository.delete(message);
	}
	
}





