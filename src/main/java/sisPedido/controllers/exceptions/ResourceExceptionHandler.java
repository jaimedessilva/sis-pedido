package sisPedido.controllers.exceptions;

import java.time.Instant;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import sisPedido.services.exceptions.ResourcesNotFoundException;

/**Project: sisPedido
 * File: ResourceExceptionHandler.java
 * @author jaime
 * Em 01-08-2020 **/

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourcesNotFoundException.class)
	public ResponseEntity<StandardError> 
	resourcesNotFoundException(ResourcesNotFoundException e, HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
		
	}
}
