package it.univpm.projectGeoTwitter.utils.stats;

import java.util.ArrayList;
import java.util.Collection;

import it.univpm.projectGeoTwitter.model.TwitterData;

public class CountTweetsInsideMarche {

	public static int insideMarche(Collection<TwitterData> tweets) {
		
		ArrayList<TwitterData> tweetsInsideMarche = TweetsInsideMarche.tweetsInsideMarche(tweets);
		
		return tweetsInsideMarche.size();
	}
}
