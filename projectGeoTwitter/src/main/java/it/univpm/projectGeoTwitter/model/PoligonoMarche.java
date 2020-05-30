package it.univpm.projectGeoTwitter.model;

import java.awt.geom.Path2D;

import it.univpm.projectGeoTwitter.service.Calculator;

public class PoligonoMarche {

	private Path2D poligonoMarche;
	private final double[] longitMarche = {12.183837890625,13.3154296875,14.23004150390625,13.14239501953125};
	private final double[] latitMarche = {43.64800079902171,42.65820178455667,43.072900581493215,44.19795903948531};
	
	public PoligonoMarche() {
		
		poligonoMarche = Calculator.polygonGenerator(longitMarche, latitMarche);
	}
	
	public Path2D getPoligonoMarche() {
		return poligonoMarche;
	}
	
	//NON SO SE QUESTI GETTER SERVONO
	/*
	public double[] getLongitMarche() {
		return longitMarche;
	}

	public double[] getLatitMarche() {
		return latitMarche;
	}
	*/
}
