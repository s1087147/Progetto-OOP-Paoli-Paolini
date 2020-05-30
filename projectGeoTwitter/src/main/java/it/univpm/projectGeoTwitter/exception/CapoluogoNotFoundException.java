package it.univpm.projectGeoTwitter.exception;

public class CapoluogoNotFoundException extends IllegalArgumentException{
	
	public CapoluogoNotFoundException() {
		super();
	}
	
	public CapoluogoNotFoundException(String message) {
		super(message);
	}
}
