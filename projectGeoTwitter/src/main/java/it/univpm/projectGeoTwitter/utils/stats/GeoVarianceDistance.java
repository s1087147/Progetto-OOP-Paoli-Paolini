package it.univpm.projectGeoTwitter.utils.stats;

import java.util.ArrayList;
import java.util.Collection;

import it.univpm.projectGeoTwitter.model.Geo;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.Calculator;

/**
 * Classe che gestisce la statistica riguardante la varianza delle distanze tra tutte le località di invio dei
 * tweets e il capoluogo scelto.
 * @author Francesco Paoli Leonardi
 */
public class GeoVarianceDistance {

	/**
	 * Metodo che applica la statistica riguardante la varianza delle distanze tra tutte le località di invio dei
	 * tweets e il capoluogo scelto.
	 * @param tweets Collection dei tweet su cui eseguire la statistica.
	 * @param capoluogo istanza di Geo contenente le coordinate del capoluogo scelto.
	 * 
	 * @return double rappresentante la varianza di tutte le distanze.
	 */
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
