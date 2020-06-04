package it.univpm.projectGeoTwitter.exception;

import java.time.Instant;

public class ErrorMessage {
	private Instant timestamp;
	private String title;
	private String description;
	//private String trace;
	
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
