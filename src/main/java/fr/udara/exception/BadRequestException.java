package fr.udara.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception lancée lorsque la requête envoyée au serveur retourne un
 * staut BAD_REQUEST
 * @author Udara
 *
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
	
}
