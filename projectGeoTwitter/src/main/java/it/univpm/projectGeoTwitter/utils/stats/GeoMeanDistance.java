package it.univpm.projectGeoTwitter.utils.stats;

import java.util.ArrayList;
import java.util.Collection;

import it.univpm.projectGeoTwitter.model.Geo;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.Calculator;

public class GeoMeanDistance extends Calculator{

	public static double getMean(Collection<TwitterData> tweets, Geo capoluogo) {

		double distancesMean;
		double capoluogoLongit = capoluogo.getLongit();
		double capoluogoLatit = capoluogo.getLatit();
		ArrayList<Double> distancesFromCapoluogo = new ArrayList<>();
		
		for(TwitterData tweet : tweets) {
			
			distancesFromCapoluogo.add(distance(tweet.getLongit(), tweet.getLatit(), capoluogoLongit, capoluogoLatit));
		}
		
		distancesMean = mean(distancesFromCapoluogo);
		
		return distancesMean;
	}
}
