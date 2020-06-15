package it.univpm.projectGeoTwitter.exception;

/** 
 * Eccezione personalizzata di tipo IllegalArgumentException.
 * Lanciata quando l'operatore per il filtro inserito dall'utente non esiste.
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/IllegalArgumentException.html"> IllegalArgumentException</a>
 * @author Davide Paolini
 */
public class OperatorNotFoundException extends IllegalArgumentException{

	public OperatorNotFoundException() {
		super();
	}
	
	public OperatorNotFoundException(String message) {
		super(message);
	}
}