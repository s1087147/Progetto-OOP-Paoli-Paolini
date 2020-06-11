package it.univpm.projectGeoTwitter.utils.stats;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import it.univpm.projectGeoTwitter.model.Geo;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.Calculator;

/**
 * Classe che gestisce la statistica sul valore massimo della distanza tra la località di invio del tweet e
 * il capoluogo scelto.
 * @author Francesco Paoli Leonardi
 */
public class GeoMaxDistance {

	/**
	 * Metodo che applica la statistica sul valore massimo della distanza tra la località di invio del tweet
	 * e il capoluogo scelto.
	 * @param tweets Collection dei tweet su cui eseguire la statistica.
	 * @param capoluogo istanza di Geo contenente le coordinate del capoluogo scelto.
	 * 
	 * @return double rappresentante la distanza massima.
	 */
	public static double getMax(Collection<TwitterData> tweets, Geo capoluogo) {
		
		ArrayList<Double> distances = new ArrayList<>();
		double capoluogoLongit = capoluogo.getLongit();
		double capoluogoLatit = capoluogo.getLatit();
		
		for(TwitterData tweet : tweets) {
			distances.add(Calculator.distance(tweet.getLongit(), tweet.getLatit(), capoluogoLongit, capoluogoLatit));
		}
		
		return Collections.max(distances);
	}
}
