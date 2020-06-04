package it.univpm.projectGeoTwitter.utils.stats;

import java.util.Collection;

import it.univpm.projectGeoTwitter.model.TwitterData;

public class GeoStdDevCoord {

	public static double[] getStdDev(Collection<TwitterData> tweets) {
		
		double[] coordinatesVariance = GeoVarianceCoord.getVariance(tweets);
		double[] coordinatesStdDev = {
				Math.sqrt(coordinatesVariance[0]),
				Math.sqrt(coordinatesVariance[1])};
		
		return coordinatesStdDev;
	}
}