package it.univpm.projectGeoTwitter.utils.stats;

import java.util.ArrayList;
import java.util.Map;

import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.Calculator;

public class GeoMean extends Calculator {

	public static double[] getMean(Map<Integer, TwitterData> tweetsMap) {

		double[] coordinatesMean = new double[2];
		ArrayList<Double> coordinatesLongit = new ArrayList<>();
		ArrayList<Double> coordinatesLatit = new ArrayList<>();
		
		for(TwitterData tweet : tweetsMap.values()) {		
			coordinatesLongit.add(tweet.getGeo().getCoordinates().getLongit());
			coordinatesLatit.add(tweet.getGeo().getCoordinates().getLatit());
		}
		
		coordinatesMean[0] = mean(coordinatesLongit);
		coordinatesMean[1] = mean(coordinatesLatit);
		
		return coordinatesMean;
	}
}
