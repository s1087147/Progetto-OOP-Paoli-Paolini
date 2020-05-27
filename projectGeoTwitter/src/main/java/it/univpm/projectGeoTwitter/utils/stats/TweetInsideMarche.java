package it.univpm.projectGeoTwitter.utils.stats;

import java.util.Map;

import it.univpm.projectGeoTwitter.model.PoligonoMarche;
import it.univpm.projectGeoTwitter.model.TwitterData;

public class TweetInsideMarche {

	public static boolean tweetInsideMarche(Map<Integer, TwitterData> tweetsMap, Integer id) {
		
		PoligonoMarche regioneMarche = new PoligonoMarche();
		
		if(regioneMarche.getPoligonoMarche()
						.contains(tweetsMap.get(id).getGeo().getCoordinates().getLatit(),
								  tweetsMap.get(id).getGeo().getCoordinates().getLongit())) {
			return true;
		}
		
		else {
			
			return false;
		}
	}
}
