package it.univpm.projectGeoTwitter.exception;

public class IdNotFoundException extends IllegalArgumentException{
	
	public IdNotFoundException() {
		super();
	}
	
	public IdNotFoundException(String message) {
		super(message);
	}
}
