package it.univpm.projectGeoTwitter.utils.stats;

import java.util.HashMap;

import it.univpm.projectGeoTwitter.model.Geo;
import it.univpm.projectGeoTwitter.model.TwitterData;

public class GeoStdDevDistance {

public static double getStdDev(HashMap<String, TwitterData> tweetsMap, Geo capoluogo) {
	
		double coordinatesVariance = GeoVarianceDistance.getVariance(tweetsMap, capoluogo);
		double coordinatesStdDev = Math.sqrt(coordinatesVariance);
		
		return coordinatesStdDev;
	}
}
