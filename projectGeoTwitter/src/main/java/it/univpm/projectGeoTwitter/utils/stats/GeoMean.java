package it.univpm.projectGeoTwitter.utils.stats;

import java.util.ArrayList;
import java.util.Map;

import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.Calculator;

public class GeoMean extends Calculator {

	public static double[] getMean(Map<Integer, TwitterData> tweetsMap) {

		double[] coordinatesMean = new double[2];
		ArrayList<Double> coordinatesLatit = new ArrayList<>();
		ArrayList<Double> coordinatesLongit = new ArrayList<>();
		
		for(TwitterData tweet : tweetsMap.values()) {
			coordinatesLatit.add(tweet.getGeo().getCoordinates().getLatit());		
			coordinatesLongit.add(tweet.getGeo().getCoordinates().getLongit());	
		}
		
		coordinatesMean[0] = mean(coordinatesLatit);
		coordinatesMean[1] = mean(coordinatesLongit);
		
		return coordinatesMean;
	}
}
