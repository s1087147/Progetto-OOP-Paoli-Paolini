package it.univpm.projectGeoTwitter.utils.stats;

import java.util.ArrayList;
import java.util.Collection;

import it.univpm.projectGeoTwitter.exception.CoordinatesException;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.utils.filter.TweetsMarche;

public class CountTweetsInsideMarche {

	public static int insideMarche(Collection<TwitterData> tweets) throws CoordinatesException {
		
		ArrayList<TwitterData> tweetsInsideMarche = TweetsMarche.getTweetsMarche(tweets, "inside", "");
		
		return tweetsInsideMarche.size();
	}
}
