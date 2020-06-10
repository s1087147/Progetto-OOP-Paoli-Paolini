package it.univpm.projectGeoTwitter.exception;

/** 
 * Eccezione personalizzata di tipo RuntimeException.
 * Lanciata quando si verifica un errore interno.
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/RuntimeException.html"> RuntimeException</a>
 * @author Davide Paolini
 */

public class GenericErrorException extends RuntimeException {

	public GenericErrorException() {
		super();
	}
	
	public GenericErrorException(String message) {
		super(message);
	}
}
