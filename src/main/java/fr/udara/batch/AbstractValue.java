package fr.udara.batch;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.transaction.annotation.Transactional;

import fr.udara.model.Commune;

public abstract class AbstractValue {
	
	/** id : Long */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** nom : String */
	private String nom;

	/** valeur : Float */
	private Float valeur;

	/** dateReleve : LocalDateTime */
	private LocalDateTime dateReleve;

	////////// RELATIONS //////////

	/** commune : Commune : relation */
	@ManyToOne
	@JoinColumn(name = "Commune_id")
	private Commune commune;

	////////// CONSTRUCTEURS //////////


	/**
	 * Constructeur sans id
	 * 
	 * @param nom
	 * @param valeur
	 * @param dateReleve
	 * @param commune
	 */
	public AbstractValue(String nom, Float valeur, LocalDateTime dateReleve, Commune commune) {
		super();
		this.nom = nom;
		this.valeur = valeur;
		this.dateReleve = dateReleve;
		this.commune = commune;
	}
	
	/**
	 * @param un objet IndicateurAir sans id
	 * @return l'objet IndicateurAir avec un id
	 */
	@Transactional
	public abstract AbstractValue save(String nom, Float valeur, LocalDateTime dateReleve, Commune commune);
}
