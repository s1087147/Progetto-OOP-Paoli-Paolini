package it.univpm.projectGeoTwitter.utils.stats;

import java.util.HashMap;

import it.univpm.projectGeoTwitter.model.PoligonoMarche;
import it.univpm.projectGeoTwitter.model.TwitterData;

public class TweetInsideMarche {

	public static boolean tweetInsideMarche(HashMap<String, TwitterData> tweetsMap, String id) {
		
		PoligonoMarche regioneMarche = new PoligonoMarche();
		
		if(regioneMarche.getPoligonoMarche()
						.contains(tweetsMap.get(id).getLongit(), tweetsMap.get(id).getLatit())) {
			return true;
		}
		
		else {
			
			return false;
		}
	}
}
