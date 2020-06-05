package it.univpm.projectGeoTwitter.utils.filter;

import java.util.ArrayList;
import java.util.Collection;

import it.univpm.projectGeoTwitter.exception.CoordinatesException;
import it.univpm.projectGeoTwitter.model.PoligonoMarche;
import it.univpm.projectGeoTwitter.model.TwitterData;

public class TweetsMarche {
																										//filterValue serve???
	public static ArrayList<TwitterData> getTweetsMarche(Collection<TwitterData> tweets, String operator, Object filterValue)
			throws CoordinatesException {
		
		//FARE USO DELL'OPERATORE
		
		ArrayList<TwitterData> tweetsInsideMarche = new ArrayList<>();
		
		PoligonoMarche regioneMarche = new PoligonoMarche();
		
		for(TwitterData tweet : tweets) {
			
			if(regioneMarche.getPoligonoMarche()
						    .contains(tweet.getLongit(), tweet.getLatit())) {

				tweetsInsideMarche.add(tweet);
			}
		}
		
		return tweetsInsideMarche;
	}
}
