package it.univpm.projectGeoTwitter.utils.stats;

import java.util.Collection;

import it.univpm.projectGeoTwitter.model.TwitterData;

/**
 * Classe che gestisce la statistica riguardante la deviazione standard di longitudine e latitudine calcolata su tutte le
 * coordinate di provenienza dei tweets.
 * @author Francesco Paoli Leonardi
 */
public class GeoStdDevCoord {

	/**
	 * Metodo che applica la statistica riguardante la deviazione standard di longitudine e latitudine calcolata su tutte
	 * le coordinate di provenienza dei tweets.
	 * @param tweets Collection dei tweet su cui eseguire la statistica.
	 * 
	 * @return double[] contenente la deviazione standard di tutte le longitudini e latitudini relative ai tweets.
	 */
	public static double[] getStdDev(Collection<TwitterData> tweets) {
		
		double[] coordinatesVariance = GeoVarianceCoord.getVariance(tweets);
		double[] coordinatesStdDev = {
				Math.sqrt(coordinatesVariance[0]),
				Math.sqrt(coordinatesVariance[1])};
		
		return coordinatesStdDev;
	}
}