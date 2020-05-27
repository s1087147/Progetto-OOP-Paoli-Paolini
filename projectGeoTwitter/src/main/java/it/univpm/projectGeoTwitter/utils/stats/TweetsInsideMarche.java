package it.univpm.projectGeoTwitter.utils.stats;

import java.util.ArrayList;
import java.util.Map;

import it.univpm.projectGeoTwitter.model.PoligonoMarche;
import it.univpm.projectGeoTwitter.model.TwitterData;

public class TweetsInsideMarche {

	public static ArrayList<TwitterData> tweetsInsideMarche(Map<Integer, TwitterData> tweetsMap) {
		
		ArrayList<TwitterData> tweetsInsideMarche = new ArrayList<>();
		PoligonoMarche regioneMarche = new PoligonoMarche();
		
		for(TwitterData tweet : tweetsMap.values()) {
			
			if(regioneMarche.getPoligonoMarche()
						    .contains(tweet.getGeo().getCoordinates().getLatit(),
						    		  tweet.getGeo().getCoordinates().getLongit())) {

				tweetsInsideMarche.add(tweet);
			}
		}
		
		return tweetsInsideMarche;
	}
}
