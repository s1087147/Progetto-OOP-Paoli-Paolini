package it.univpm.projectGeoTwitter.exception;

public class CoordinatesException extends IllegalArgumentException {

	public CoordinatesException() {
		super();
	}
	
	public CoordinatesException(String message) {
		super(message);
	}
}
