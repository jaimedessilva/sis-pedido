package sisPedido.services.exceptions;

/**Project: sisPedido
 * File: ResourcesNotFoundException.java
 * @author jaime
 * Em 01-08-2020 **/

public class ResourcesNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/*
	 * Construct
	 */
	public ResourcesNotFoundException(Object id) {
		super("Resource not found. id " + id);
		
	}

	

}
