package it.univpm.projectGeoTwitter.utils.filter;

import java.util.Map;

import it.univpm.projectGeoTwitter.model.TwitterData;

public class IdFilter {

	public static boolean tweetWithThisId(Map<Integer, TwitterData> tweetsMap, String id) {
		
		for(TwitterData tweet : tweetsMap.values()) {
			
			System.out.println(tweet.getId() + " " + id);
			
			if(tweet.getId().equals(id)) {
				
				return true;
			}
		}
		
		return false;
	}
}
