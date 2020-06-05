package it.univpm.projectGeoTwitter.exception;

public class GenericErrorException extends RuntimeException {

	public GenericErrorException() {
		super();
	}
	
	public GenericErrorException(String message) {
		super(message);
	}
}
