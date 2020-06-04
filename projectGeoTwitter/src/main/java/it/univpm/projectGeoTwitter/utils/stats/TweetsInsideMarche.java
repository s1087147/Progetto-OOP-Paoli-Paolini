package it.univpm.projectGeoTwitter.utils.stats;

import java.util.ArrayList;
import java.util.Collection;

import it.univpm.projectGeoTwitter.exception.CoordinatesException;
import it.univpm.projectGeoTwitter.model.PoligonoMarche;
import it.univpm.projectGeoTwitter.model.TwitterData;

public class TweetsInsideMarche {

	public static ArrayList<TwitterData> tweetsInsideMarche(Collection<TwitterData> tweets) {
		
		ArrayList<TwitterData> tweetsInsideMarche = new ArrayList<>();
		PoligonoMarche regioneMarche;
		
		try {
			regioneMarche = new PoligonoMarche();

		} catch(CoordinatesException e) {
			throw e;
		}
		
		for(TwitterData tweet : tweets) {
			
			if(regioneMarche.getPoligonoMarche()
						    .contains(tweet.getLongit(), tweet.getLatit())) {

				tweetsInsideMarche.add(tweet);
			}
		}
		
		return tweetsInsideMarche;
	}
}
