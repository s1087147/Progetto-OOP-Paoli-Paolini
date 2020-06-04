package it.univpm.projectGeoTwitter.utils.stats;

import java.util.ArrayList;
import java.util.Collection;

import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.Calculator;

public class GeoMeanCoord extends Calculator {

	public static double[] getMean(Collection<TwitterData> tweets) {

		double[] coordinatesMean = new double[2];
		ArrayList<Double> coordinatesLongit = new ArrayList<>();
		ArrayList<Double> coordinatesLatit = new ArrayList<>();
		
		for(TwitterData tweet : tweets) {
			coordinatesLongit.add(tweet.getLongit());
			coordinatesLatit.add(tweet.getLatit());
		}
		
		coordinatesMean[0] = mean(coordinatesLongit);
		coordinatesMean[1] = mean(coordinatesLatit);
		
		return coordinatesMean;
	}
}
