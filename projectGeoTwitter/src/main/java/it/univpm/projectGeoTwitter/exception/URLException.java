package it.univpm.projectGeoTwitter.exception;

/** 
 * Eccezione personalizzata di tipo Exception.
 * Lanciata quando fallisce la chiamata all'API di Twitter.
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/IllegalArgumentException.html"> IllegalArgumentException</a>
 * @author Davide Paolini
 */
public class URLException extends Exception{
	
	public URLException() {
		super();
	}
	
	public URLException(String message) {
		super(message);
	}
}