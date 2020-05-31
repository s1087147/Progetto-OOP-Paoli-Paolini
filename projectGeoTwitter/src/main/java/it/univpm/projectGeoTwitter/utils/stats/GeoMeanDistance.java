package it.univpm.projectGeoTwitter.utils.stats;

import java.util.ArrayList;
import java.util.HashMap;

import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.Calculator;

public class GeoMeanDistance extends Calculator{

	public static double getMean(HashMap<String, TwitterData> hashMap, double capoluogoLongit, double capoluogoLatit) {

		double distancesMean;
		ArrayList<Double> distancesFromCapoluogo = new ArrayList<>();
		
		for(TwitterData tweet : hashMap.values()) {
			
			distancesFromCapoluogo.add(distance(tweet.getLongit(), tweet.getLatit(), capoluogoLongit, capoluogoLatit));
		}
		
		distancesMean = mean(distancesFromCapoluogo);
		
		return distancesMean;
	}
}
