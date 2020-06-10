package it.univpm.projectGeoTwitter.exception;

/** 
 * Eccezione personalizzata di tipo RuntimeException.
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/RuntimeException.html"> RuntimeException</a>
 * @author Francesco Paoli Leonardi
 */
public class EmptyCollectionException extends RuntimeException {

	public EmptyCollectionException() {
		super();
	}
	
	public EmptyCollectionException(String message) {
		super(message);
	}
}