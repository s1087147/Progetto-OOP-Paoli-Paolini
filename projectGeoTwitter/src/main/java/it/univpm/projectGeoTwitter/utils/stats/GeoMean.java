package it.univpm.projectGeoTwitter.utils.stats;

import java.util.ArrayList;
import java.util.Map;

import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.StatsCalculator;

public class GeoMean extends StatsCalculator {

	public static double[] getMean(Map<Integer, TwitterData> tweetsMap) {

		double[] coordinatesMean = new double[2];
		ArrayList<Double> coordinatesLatit = new ArrayList<Double>();
		ArrayList<Double> coordinatesLongit = new ArrayList<Double>();
		
		for(TwitterData tweet : tweetsMap.values()) {
			coordinatesLatit.add(tweet.getLatit());
			coordinatesLongit.add(tweet.getLongit());
		}
		
		coordinatesMean[0] = mean(coordinatesLatit);
		coordinatesMean[1] = mean(coordinatesLongit);
		
		return coordinatesMean;
	}
}
