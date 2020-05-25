package it.univpm.projectGeoTwitter.model;

import java.awt.geom.Path2D;

public class PoligonoMarche {

	private Path2D poligonoMarche;
	private final double[] latitMarche = {12.183837890625,13.3154296875,14.23004150390625,13.14239501953125};
	private final double[] longitMarche = {43.64800079902171,42.65820178455667,43.072900581493215,44.19795903948531};
	
	public PoligonoMarche() {
		
		poligonoMarche = new Path2D.Double();
		
		poligonoMarche.moveTo(latitMarche[0], longitMarche[0]);
		for(int i = 1; i < latitMarche.length; i++) {
			poligonoMarche.lineTo(latitMarche[i], longitMarche[i]);
		}
		poligonoMarche.closePath();
	}
	
	public Path2D getPoligonoMarche() {
		return poligonoMarche;
	}
	
}
