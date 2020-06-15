package it.univpm.projectGeoTwitter.exception;

/** 
 * Eccezione personalizzata di tipo IllegalArgumentException.
 * Lanciata quando il filtro richiesto dall'utente non esiste.
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/IllegalArgumentException.html"> IllegalArgumentException</a>
 * @author Davide Paolini
 */
public class FilterNotFoundException extends IllegalArgumentException {

	public FilterNotFoundException() {
		super();
	}
	
	public FilterNotFoundException(String message) {
		super(message);
	}
}