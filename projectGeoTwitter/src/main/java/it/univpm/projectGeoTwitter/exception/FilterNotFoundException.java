package it.univpm.projectGeoTwitter.exception;

public class FilterNotFoundException extends IllegalArgumentException {

	public FilterNotFoundException() {
		super();
	}
	
	public FilterNotFoundException(String message) {
		super(message);
	}
}
