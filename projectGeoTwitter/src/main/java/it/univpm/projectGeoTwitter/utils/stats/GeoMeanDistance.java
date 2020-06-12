package it.univpm.projectGeoTwitter.utils.stats;

import java.util.ArrayList;
import java.util.Collection;

import it.univpm.projectGeoTwitter.model.Geo;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.Calculator;

/**
 * Classe che gestisce la statistica riguardante la media delle distanze tra tutte le località di invio dei
 * tweets e il capoluogo scelto.
 * @author Francesco Paoli Leonardi
 */
public class GeoMeanDistance {

	/**
	 * Metodo che applica la statistica riguardante la media delle distanze tra tutte le località di invio dei
	 * tweets e il capoluogo scelto.
	 * @param tweets Collection dei tweet su cui eseguire la statistica.
	 * @param capoluogo istanza di Geo contenente le coordinate del capoluogo scelto.
	 * 
	 * @return double rappresentante la media di tutte le distanze.
	 */
	public static double getMean(Collection<TwitterData> tweets, Geo capoluogo) {

		double distancesMean;
		double capoluogoLongit = capoluogo.getLongit();
		double capoluogoLatit = capoluogo.getLatit();
		ArrayList<Double> distancesFromCapoluogo = new ArrayList<>();
		
		for(TwitterData tweet : tweets) {
			
			distancesFromCapoluogo.add(Calculator.distance(tweet.getLongit(), tweet.getLatit(), capoluogoLongit, capoluogoLatit));
		}
		
		distancesMean = Calculator.mean(distancesFromCapoluogo);
		
		return distancesMean;
	}
}