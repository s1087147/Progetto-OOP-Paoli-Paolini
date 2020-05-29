package it.univpm.projectGeoTwitter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Coordinates{
	//String type
	double[] coordinates;

	public double[] getCoordinates() {
		return coordinates;
	}
	@JsonIgnore
	public double getLongit() {
		return coordinates[0];
	}
	@JsonIgnore
	public double getLatit() {
		return coordinates[1];
	}
}
