package it.univpm.projectGeoTwitter.utils.stats;

import java.util.Collection;

import it.univpm.projectGeoTwitter.model.Geo;
import it.univpm.projectGeoTwitter.model.TwitterData;

public class GeoStdDevDistance {

public static double getStdDev(Collection<TwitterData> tweets, Geo capoluogo) {
	
		double coordinatesVariance = GeoVarianceDistance.getVariance(tweets, capoluogo);
		double coordinatesStdDev = Math.sqrt(coordinatesVariance);
		
		return coordinatesStdDev;
	}
}
