package it.univpm.projectGeoTwitter.utils.stats;

import java.util.Collection;

import it.univpm.projectGeoTwitter.model.Geo;
import it.univpm.projectGeoTwitter.model.TwitterData;

/**
 * Classe che gestisce la statistica riguardante la deviazione standard delle distanze tra tutte le località di invio dei
 * tweets e il capoluogo scelto.
 * @author Francesco Paoli Leonardi
 */
public class GeoStdDevDistance {

	/**
	 * Metodo che applica la statistica riguardante la deviazione standard delle distanze tra tutte le località di invio dei
	 * tweets e il capoluogo scelto.
	 * @param tweets Collection dei tweet su cui eseguire la statistica.
	 * @param capoluogo istanza di Geo contenente le coordinate del capoluogo scelto.
	 * 
	 * @return double rappresentante la deviazione standard di tutte le distanze.
	 */
	public static double getStdDev(Collection<TwitterData> tweets, Geo capoluogo) {
	
		double coordinatesVariance = GeoVarianceDistance.getVariance(tweets, capoluogo);
		double coordinatesStdDev = Math.sqrt(coordinatesVariance);
		
		return coordinatesStdDev;
	}
}
