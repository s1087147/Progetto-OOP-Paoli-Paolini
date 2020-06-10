package it.univpm.projectGeoTwitter.model;

/**
 * Modello per la deserializzazione degli oggetti contenuti nell'array "places" presente nella risposta dell'API di Twitter.
 * @author Davide Paolini
 */
public class Place {
	
	/**
	 * Stringa nel formato "nome della località, regione".
	 */
	private String full_name;
	
	/**
	 * Stringa che identifica univocamente l'oggetto Place.
	 */
	private String id;
	
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}	
}