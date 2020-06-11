package it.univpm.projectGeoTwitter.utils.stats;

import java.util.ArrayList;
import java.util.Collection;

import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.Calculator;

/**
 * Classe che gestisce la statistica riguardante la media di longitudine e latitudine calcolata su tutte le
 * coordinate di provenienza dei tweets.
 * @author Francesco Paoli Leonardi
 */
public class GeoMeanCoord {

	/**
	 * Metodo che applica la statistica riguardante la media di longitudine e latitudine calcolata su tutte
	 * le coordinate di provenienza dei tweets.
	 * @param tweets Collection dei tweet su cui eseguire la statistica.
	 * 
	 * @return double[] contenente la media di tutte le longitudini e latitudini relative ai tweets.
	 */
	public static double[] getMean(Collection<TwitterData> tweets) {

		double[] coordinatesMean = new double[2];
		ArrayList<Double> coordinatesLongit = new ArrayList<>();
		ArrayList<Double> coordinatesLatit = new ArrayList<>();
		
		for(TwitterData tweet : tweets) {
			coordinatesLongit.add(tweet.getLongit());
			coordinatesLatit.add(tweet.getLatit());
		}
		
		coordinatesMean[0] = Calculator.mean(coordinatesLongit);
		coordinatesMean[1] = Calculator.mean(coordinatesLatit);
		
		return coordinatesMean;
	}
}
