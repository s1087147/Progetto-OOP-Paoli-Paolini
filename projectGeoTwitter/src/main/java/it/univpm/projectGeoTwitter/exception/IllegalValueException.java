package it.univpm.projectGeoTwitter.exception;

/** 
 * Eccezione personalizzata di tipo IllegalArgumentException.
 * Lanciata quando i valori da passare al filtro inseriti dall'utente non sono validi.
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/IllegalArgumentException.html"> IllegalArgumentException</a>
 * @author Davide Paolini
 */

public class IllegalValueException extends IllegalArgumentException{
	
	public IllegalValueException() {
		super();
	}
	
	public IllegalValueException(String message) {
		super(message);
	}
}
