package it.univpm.projectGeoTwitter.utils.stats;

import java.util.ArrayList;
import java.util.HashMap;

import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.Calculator;
import it.univpm.projectGeoTwitter.utils.stats.GeoMeanCoord;

public class GeoVarianceCoord extends Calculator {

	public static double[] getVariance(HashMap<String, TwitterData> tweetsMap) {

		double[] coordinatesMean = GeoMeanCoord.getMean(tweetsMap);
		
		double[] coordinatesVariance = new double[2];
		ArrayList<Double> coordinatesLongit = new ArrayList<Double>();
		ArrayList<Double> coordinatesLatit = new ArrayList<Double>();
		
		for(TwitterData tweet : tweetsMap.values()) {		
			coordinatesLongit.add(tweet.getLongit());
			coordinatesLatit.add(tweet.getLatit());
		}
		
		coordinatesVariance[0] = variance(coordinatesLongit, coordinatesMean[0]);
		coordinatesVariance[1] = variance(coordinatesLatit, coordinatesMean[1]);
		
		return coordinatesVariance;
	}
}
