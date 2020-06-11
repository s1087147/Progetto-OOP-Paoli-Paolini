package it.univpm.projectGeoTwitter.utils.stats;

import java.util.ArrayList;
import java.util.Collection;

import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.Calculator;

/**
 * Classe che gestisce la statistica riguardante la varianza di longitudine e latitudine calcolata su tutte le
 * coordinate di provenienza dei tweets.
 * @author Francesco Paoli Leonardi
 */
public class GeoVarianceCoord {

	/**
	 * Metodo che applica la statistica riguardante la varianza di longitudine e latitudine calcolata su tutte
	 * le coordinate di provenienza dei tweets.
	 * @param tweets Collection dei tweet su cui eseguire la statistica.
	 * 
	 * @return double[] contenente la varianza di tutte le longitudini e latitudini relative ai tweets.
	 */
	public static double[] getVariance(Collection<TwitterData> tweets) {

		double[] coordinatesMean = GeoMeanCoord.getMean(tweets);
		
		double[] coordinatesVariance = new double[2];
		ArrayList<Double> coordinatesLongit = new ArrayList<Double>();
		ArrayList<Double> coordinatesLatit = new ArrayList<Double>();
		
		for(TwitterData tweet : tweets) {		
			coordinatesLongit.add(tweet.getLongit());
			coordinatesLatit.add(tweet.getLatit());
		}
		
		coordinatesVariance[0] = Calculator.variance(coordinatesLongit, coordinatesMean[0]);
		coordinatesVariance[1] = Calculator.variance(coordinatesLatit, coordinatesMean[1]);
		
		return coordinatesVariance;
	}
}
