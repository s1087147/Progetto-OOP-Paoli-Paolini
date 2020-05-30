package it.univpm.projectGeoTwitter.utils.stats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.Calculator;

public class GeoMean extends Calculator {

	public static double[] getMean(HashMap<String, TwitterData> hashMap) {

		double[] coordinatesMean = new double[2];
		ArrayList<Double> coordinatesLongit = new ArrayList<>();
		ArrayList<Double> coordinatesLatit = new ArrayList<>();
		
		for(TwitterData tweet : hashMap.values()) {		
			coordinatesLongit.add(tweet.getLongit());
			coordinatesLatit.add(tweet.getLatit());
		}
		
		coordinatesMean[0] = mean(coordinatesLongit);
		coordinatesMean[1] = mean(coordinatesLatit);
		
		return coordinatesMean;
	}
}
