package it.univpm.projectGeoTwitter.model;

/**
 * Modello per la rappresentazione dei capoluoghi delle Marche tramite le relative coordinate geografiche.
 * @author Francesco Paoli Leonardi
 */
public class Geo {

	private double longit;
	private double latit;
	
	public Geo(double longit, double latit) {
		
		super();
		this.longit = longit;
		this.latit = latit;
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
