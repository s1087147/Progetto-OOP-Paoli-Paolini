package it.univpm.projectGeoTwitter.utils.stats;

import java.util.ArrayList;
import java.util.HashMap;

import it.univpm.projectGeoTwitter.model.TwitterData;

public class CountTweetsInsideMarche {

	public static int insideMarche(HashMap<String, TwitterData> tweetsMap) {
		
		ArrayList<TwitterData> tweetsInsideMarche = TweetsInsideMarche.tweetsInsideMarche(tweetsMap);
		
		return tweetsInsideMarche.size();
	}
}
