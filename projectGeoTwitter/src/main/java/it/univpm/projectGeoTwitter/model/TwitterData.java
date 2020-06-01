package it.univpm.projectGeoTwitter.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import it.univpm.projectGeoTwitter.utils.json.TwitterDataDeserializer;

@JsonDeserialize(using = TwitterDataDeserializer.class)
public class TwitterData {

	String id;			
	String text;	
	String place_id;
	String place;
	double longit;
	double latit;
	
	//GETTERS	
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