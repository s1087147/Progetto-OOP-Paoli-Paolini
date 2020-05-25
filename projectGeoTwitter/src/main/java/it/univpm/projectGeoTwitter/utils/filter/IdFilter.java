package it.univpm.projectGeoTwitter.utils.filter;

import java.util.Map;

import it.univpm.projectGeoTwitter.model.TwitterData;

public class IdFilter {

	public static TwitterData getTweetWithThisId(Map<Integer, TwitterData> tweetsMap, Integer id) {
		
		TwitterData tweetWithThisId = null;
		
		for(TwitterData tweet : tweetsMap.values()) {
			
			if(tweet.getId() == id) {
				
				tweetWithThisId = tweet;
				break;
			}
		}
		
		return tweetWithThisId;
	}
}
