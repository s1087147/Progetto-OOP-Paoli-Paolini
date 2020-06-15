package it.univpm.projectGeoTwitter.exception;

import java.time.Instant;

/** 
 * Modello degli errori da restituire al client.
 * @author Davide Paolini
 */
public class ErrorMessage {
	/**
	 * Istante in cui si è verificato l'errore.
	 */
	private Instant timestamp;
	
	/**
	 * Nome della classe dell'eccezione che è stata generata.
	 */
	private String title;
	
	/**
	 * Messaggio dell'eccezione lanciata.
	 */
	private String description;
	
	public ErrorMessage(Exception e) {
		this.timestamp = Instant.now();
		this.title = e.getClass().getSimpleName();
		this.description = e.getMessage();		
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}
}