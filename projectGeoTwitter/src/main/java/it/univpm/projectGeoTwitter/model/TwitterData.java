package it.univpm.projectGeoTwitter.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import it.univpm.projectGeoTwitter.utils.json.TwitterDataDeserializer;

/**
 * Modello per la deserializzazione degli oggetti contenuti nell'array "data" presente nella risposta dell'API di Twitter.
 * @author Davide Paolini
 */
@JsonDeserialize(using = TwitterDataDeserializer.class)
public class TwitterData {

	/**
	 * Stringa che identifica univocamente il tweet.
	 */
	private String id;
	
	/**
	 * Testo del tweet.
	 */
	private String text;
	
	/**
	 * Stringa che identifica univocamente la località da cui è stato inviato il tweet.
	 */
	private String place_id;
	
	/**
	 * Stringa nel formato "nome della località, regione" da cui è stato inviato il tweet.
	 */
	private String place;
	
	/**
	 * Valore della longitudine da cui è stato inviato il tweet.
	 */
	private double longit;
	
	/**
	 * Valore della latitudine da cui è stato inviato il tweet.
	 */
	private double latit;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getPlace_id() {
		return place_id;
	}
	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}	
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public double getLongit() {
		return longit;
	}
	public void setLongit(double longit) {
		this.longit = longit;
	}
	public double getLatit() {
		return latit;
	}
	public void setLatit(double latit) {
		this.latit = latit;
	}
}