package it.univpm.projectGeoTwitter.model;

public class Coordinates{
	//String type
	double[] coordinates;

	public double[] getCoordinates() {
		return coordinates;
	}
	public double getLongit() {
		return coordinates[0];
	}
	public double getLatit() {
		return coordinates[1];
	}
}
