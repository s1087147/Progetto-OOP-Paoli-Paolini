package it.univpm.projectGeoTwitter.utils.stats;

import java.util.Collection;

import it.univpm.projectGeoTwitter.model.TwitterData;

public class TextAverageLength {

	public static double averageLength(Collection<TwitterData> tweets) {
		
		double totalLength = 0;
		
		for(TwitterData tweet : tweets) {
			totalLength += tweet.getText().length();
		}
		
		return totalLength / tweets.size();
	}
}
