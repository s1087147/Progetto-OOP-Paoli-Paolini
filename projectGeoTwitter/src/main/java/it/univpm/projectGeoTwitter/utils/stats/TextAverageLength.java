package it.univpm.projectGeoTwitter.utils.stats;

import java.util.HashMap;

import it.univpm.projectGeoTwitter.model.TwitterData;

public class TextAverageLength {

	public static double averageLength(HashMap<String, TwitterData> tweetsMap) {
		
		double totalLength = 0;
		
		for(TwitterData tweet : tweetsMap.values()) {
			totalLength += tweet.getText().length();
		}
		
		return totalLength / tweetsMap.size();
	}
}
