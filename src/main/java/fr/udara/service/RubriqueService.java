package fr.udara.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.udara.dto.form.FormRubriqueDTO;
import fr.udara.exception.NotFoundException;
import fr.udara.model.Rubrique;
import fr.udara.repository.RubriqueRepository;

/**
 * Classe de service pour l'entité Rubrique
 * 
 * @author udara
 *
 */
@Service
public class RubriqueService {

	private RubriqueRepository rubriqueRepository;

	/**
	 * Constructeur
	 * 
	 */
	@Autowired
	public RubriqueService(RubriqueRepository rubriqueRepository) {
		this.rubriqueRepository = rubriqueRepository;
	}

	/**
	 * Création d'une rubrique
	 * 
	 * @param rubriqueDTO
	 */
	@Transactional
	public void save(FormRubriqueDTO rubriqueDTO) {
		Rubrique rubrique = new Rubrique();

		rubrique.setNom(rubriqueDTO.getNom());
		rubriqueRepository.save(rubrique);
	}

	@Transactional
	public void update(FormRubriqueDTO rubriqueDTO, Long id) {

		Rubrique rubrique = rubriqueRepository.findById(id).orElseThrow(() -> new NotFoundException());

		rubrique.setNom(rubriqueDTO.getNom());

		rubriqueRepository.save(rubrique);
	}

	/**
	 * @return une liste d'objet FormRubriqueDTO
	 */
	public List<FormRubriqueDTO> findAll() {
		List<Rubrique> rubriques = rubriqueRepository.findAll();
		List<FormRubriqueDTO> rubriquesDTO = new ArrayList<>();

		for (Rubrique rubrique : rubriques) {
			FormRubriqueDTO rubriqueDTO = new FormRubriqueDTO();
			rubriqueDTO.setId(rubrique.getId());
			rubriqueDTO.setNom(rubrique.getNom());
			rubriquesDTO.add(rubriqueDTO);
		}
		return rubriquesDTO;
	}

	/**
	 * @param id d'un objet Rubrique
	 * @return une éventuelle liste d'objet Rubrique
	 */
	public FormRubriqueDTO findById(Long id) {
		Rubrique rubrique = rubriqueRepository.findById(id).orElseThrow(() -> new NotFoundException());
		FormRubriqueDTO rubriqueDTO = new FormRubriqueDTO();
		rubriqueDTO.setId(rubrique.getId());
		rubriqueDTO.setNom(rubrique.getNom());
		return rubriqueDTO;

	}

	/**
	 * @param id d'un objet Rubrique
	 * @return true si l'id existe
	 */
	public boolean existsById(Long id) {
		return rubriqueRepository.existsById(id);
	}

	/**
	 * @return le nombre d'objet Rubrique
	 */
	public long count() {
		return rubriqueRepository.count();
	}

	/**
	 * @param id d'un objet Rubrique
	 */
	@Transactional
	public void deleteById(Long id) {
		rubriqueRepository.deleteById(id);
	}

	/**
	 * @param un objet Rubrique
	 */
	@Transactional
	public void delete(Rubrique rubrique) {
		rubriqueRepository.delete(rubrique);
	}

}
