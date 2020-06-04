package it.univpm.projectGeoTwitter.utils.stats;

import java.util.ArrayList;
import java.util.Collection;

import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.Calculator;

public class GeoVarianceCoord extends Calculator {

	public static double[] getVariance(Collection<TwitterData> tweets) {

		double[] coordinatesMean = GeoMeanCoord.getMean(tweets);
		
		double[] coordinatesVariance = new double[2];
		ArrayList<Double> coordinatesLongit = new ArrayList<Double>();
		ArrayList<Double> coordinatesLatit = new ArrayList<Double>();
		
		for(TwitterData tweet : tweets) {		
			coordinatesLongit.add(tweet.getLongit());
			coordinatesLatit.add(tweet.getLatit());
		}
		
		coordinatesVariance[0] = variance(coordinatesLongit, coordinatesMean[0]);
		coordinatesVariance[1] = variance(coordinatesLatit, coordinatesMean[1]);
		
		return coordinatesVariance;
	}
}
