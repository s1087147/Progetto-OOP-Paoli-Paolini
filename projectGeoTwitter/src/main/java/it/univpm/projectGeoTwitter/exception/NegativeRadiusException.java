package it.univpm.projectGeoTwitter.exception;

public class NegativeRadiusException extends IllegalArgumentException{
	
	public NegativeRadiusException() {
		super();
	}
	
	public NegativeRadiusException(String message) {
		super(message);
	}
}
