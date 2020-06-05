package it.univpm.projectGeoTwitter.utils.stats;

import java.util.ArrayList;
import java.util.Collection;

import it.univpm.projectGeoTwitter.model.Geo;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.Calculator;

public class GeoVarianceDistance {

	public static double getVariance(Collection<TwitterData> tweets, Geo capoluogo) {

		double capoluogoLongit = capoluogo.getLongit();
		double capoluogoLatit = capoluogo.getLatit();
		
		double distancesMean = GeoMeanDistance.getMean(tweets, capoluogo);
		
		ArrayList<Double> distancesFromCapoluogo = new ArrayList<>();
		
		for(TwitterData tweet : tweets) {
			
			distancesFromCapoluogo.add(Calculator.distance(tweet.getLongit(), tweet.getLatit(), capoluogoLongit, capoluogoLatit));
		}
		
		distancesMean = Calculator.variance(distancesFromCapoluogo, distancesMean);
		
		return distancesMean;
	}
}
