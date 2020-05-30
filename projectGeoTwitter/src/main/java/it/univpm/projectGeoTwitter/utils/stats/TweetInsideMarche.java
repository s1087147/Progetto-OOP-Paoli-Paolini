package it.univpm.projectGeoTwitter.utils.stats;

import java.util.HashMap;

import it.univpm.projectGeoTwitter.model.PoligonoMarche;
import it.univpm.projectGeoTwitter.model.TwitterData;

public class TweetInsideMarche {

	public static boolean tweetInsideMarche(HashMap<Integer, TwitterData> tweetsMap, String id) {
		
		PoligonoMarche regioneMarche = new PoligonoMarche();
		
		if(regioneMarche.getPoligonoMarche()
						.contains(tweetsMap.get(id.hashCode()).getGeo().getCoordinates().getLongit(),
								  tweetsMap.get(id.hashCode()).getGeo().getCoordinates().getLatit())) {
			return true;
		}
		
		else {
			
			return false;
		}
	}
}
