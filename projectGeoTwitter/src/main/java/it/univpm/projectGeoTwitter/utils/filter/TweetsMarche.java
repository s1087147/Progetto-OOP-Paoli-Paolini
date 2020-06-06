package it.univpm.projectGeoTwitter.utils.filter;

import java.util.ArrayList;
import java.util.Collection;

import it.univpm.projectGeoTwitter.exception.CoordinatesException;
import it.univpm.projectGeoTwitter.exception.OperatorNotFoundException;
import it.univpm.projectGeoTwitter.model.PoligonoMarche;
import it.univpm.projectGeoTwitter.model.TwitterData;

public class TweetsMarche {
																										
	public static ArrayList<TwitterData> getTweetsMarche(Collection<TwitterData> tweets, String operator, Object filterValue)
			throws CoordinatesException, OperatorNotFoundException {
		
		ArrayList<TwitterData> tweetsInsideMarche = new ArrayList<>();
		
		PoligonoMarche regioneMarche = new PoligonoMarche();
		
		boolean choice;
		
		if(operator.equals("inside"))
			choice = true;
		else if(operator.equals("outside"))
			choice = false;
		else
			throw new OperatorNotFoundException("L'operatore richiesto non esiste");
		
		for(TwitterData tweet : tweets) {
			
			if(regioneMarche.getPoligonoMarche()
						    .contains(tweet.getLongit(), tweet.getLatit()) == choice) {

				tweetsInsideMarche.add(tweet);
			}
		}
		
		return tweetsInsideMarche;
	}
}
