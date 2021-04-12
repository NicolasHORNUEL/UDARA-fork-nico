package fr.udara.batch;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author UDARA
 *
 */
@Service
public abstract class AbstractValueService {
	
	
	
	/**
	 * @param un objet IndicateurAir sans id
	 * @return l'objet IndicateurAir avec un id
	 */
	@Transactional
	public abstract AbstractValue save();
}

