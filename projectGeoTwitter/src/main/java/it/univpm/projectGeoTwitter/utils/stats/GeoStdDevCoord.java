package it.univpm.projectGeoTwitter.utils.stats;

import java.util.HashMap;

import it.univpm.projectGeoTwitter.model.TwitterData;

public class GeoStdDevCoord {

	public static double[] getStdDev(HashMap<String, TwitterData> tweetsMap) {
		
		double[] coordinatesVariance = GeoVarianceCoord.getVariance(tweetsMap);
		double[] coordinatesStdDev = {
				Math.sqrt(coordinatesVariance[0]),
				Math.sqrt(coordinatesVariance[1])};
		
		return coordinatesStdDev;
	}
}