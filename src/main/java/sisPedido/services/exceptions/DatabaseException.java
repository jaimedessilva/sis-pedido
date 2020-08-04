package sisPedido.services.exceptions;

/**Project: sisPedido
 * File: DatabaseException.java
 * @author jaime
 * Em 03-08-2020 **/

public class DatabaseException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;

	/*
	 * Construct
	 */
	public DatabaseException(String msg) {
		super(msg);
	}

}
