package it.univpm.projectGeoTwitter.utils.stats;

import java.util.Collection;

import it.univpm.projectGeoTwitter.exception.GenericErrorException;
import it.univpm.projectGeoTwitter.exception.OperatorNotFoundException;
import it.univpm.projectGeoTwitter.model.TwitterData;

/**
 * Classe che gestisce la statistica sul numero medio di caratteri per tweet.
 * @author Francesco Paoli Leonardi
 */
public class TextAverageLength {

	/**
	 * Metodo che applica la statistica sul numero medio di caratteri per tweet.
	 * @param tweets Collection dei tweet su cui eseguire la statistica.
	 * 
	 * @return double rappresentante il numero medio di caratteri per tweet.
	 */
	public static double averageLength(Collection<TwitterData> tweets) {
		
		double totalLength = 0;
		
		for(TwitterData tweet : tweets) {
			totalLength += tweet.getText().length();
		}
		
		return totalLength / tweets.size();
	}
}
