package sisPedido.controllers.exceptions;

import java.io.Serializable;
import java.time.Instant;

/**Project: sisPedido
 * File: StandardError.java
 * @author jaime
 * Em 01-08-2020 **/

public class StandardError implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Instant timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
	
	/*
	 * Construct
	 */
	public StandardError() {
		super();
	}

	/*
	 * Construct
	 */
	public StandardError(Instant timestamp, Integer status, String error, String message, String path) {
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	/* Getter */
	public Instant getTimestamp() {
		return timestamp;
	}

	/* Setter */
	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	/* Getter */
	public Integer getStatus() {
		return status;
	}

	/* Setter */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/* Getter */
	public String getError() {
		return error;
	}

	/* Setter */
	public void setError(String error) {
		this.error = error;
	}

	/* Getter */
	public String getMessage() {
		return message;
	}

	/* Setter */
	public void setMessage(String message) {
		this.message = message;
	}

	/* Getter */
	public String getPath() {
		return path;
	}

	/* Setter */
	public void setPath(String path) {
		this.path = path;
	}

}
