package it.univpm.projectGeoTwitter.exception;

public class OperatorNotFoundException extends IllegalArgumentException{

	public OperatorNotFoundException() {
		super();
	}
	
	public OperatorNotFoundException(String message) {
		super(message);
	}
}
