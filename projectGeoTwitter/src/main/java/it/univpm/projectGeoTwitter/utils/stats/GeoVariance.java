package it.univpm.projectGeoTwitter.utils.stats;

import java.util.ArrayList;
import java.util.Map;

import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.StatsCalculator;
import it.univpm.projectGeoTwitter.utils.stats.GeoMean;

public class GeoVariance extends StatsCalculator {

	public static double[] getVariance(Map<Integer, TwitterData> tweetsMap) {

		double[] coordinatesMean = GeoMean.getMean(tweetsMap);
		
		double[] coordinatesVariance = new double[2];
		ArrayList<Double> coordinatesLatit = new ArrayList<Double>();
		ArrayList<Double> coordinatesLongit = new ArrayList<Double>();
		
		for(TwitterData tweet : tweetsMap.values()) {
			coordinatesLatit.add(tweet.getLatit());
			coordinatesLongit.add(tweet.getLongit());
		}
		
		coordinatesVariance[0] = variance(coordinatesLatit, coordinatesMean[0]);
		coordinatesVariance[1] = variance(coordinatesLongit, coordinatesMean[1]);
		
		return coordinatesVariance;
	}
}
