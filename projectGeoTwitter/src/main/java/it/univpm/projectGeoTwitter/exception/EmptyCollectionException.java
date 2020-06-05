package it.univpm.projectGeoTwitter.exception;

public class EmptyCollectionException extends RuntimeException {

	public EmptyCollectionException() {
		super();
	}
	
	public EmptyCollectionException(String message) {
		super(message);
	}
}
