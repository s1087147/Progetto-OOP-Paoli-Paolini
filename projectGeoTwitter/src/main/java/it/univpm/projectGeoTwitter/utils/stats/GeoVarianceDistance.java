package it.univpm.projectGeoTwitter.utils.stats;

import java.util.ArrayList;
import java.util.HashMap;

import it.univpm.projectGeoTwitter.model.Geo;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.Calculator;

public class GeoVarianceDistance extends Calculator {

	public static double getVariance(HashMap<String, TwitterData> tweetsMap, Geo capoluogo) {

		double capoluogoLongit = capoluogo.getLongit();
		double capoluogoLatit = capoluogo.getLatit();
		
		double distancesMean = GeoMeanDistance.getMean(tweetsMap, capoluogo);
		
		ArrayList<Double> distancesFromCapoluogo = new ArrayList<>();
		
		for(TwitterData tweet : tweetsMap.values()) {
			
			distancesFromCapoluogo.add(distance(tweet.getLongit(), tweet.getLatit(), capoluogoLongit, capoluogoLatit));
		}
		
		distancesMean = variance(distancesFromCapoluogo, distancesMean);
		
		return distancesMean;
	}
}
