package it.univpm.projectGeoTwitter.utils.filter;

import java.util.HashMap;
import java.util.Map;

import it.univpm.projectGeoTwitter.model.TwitterData;

public class IdFilter {

	public static boolean tweetWithThisId(HashMap<String, TwitterData> hashMap, String id) {
		
		for(TwitterData tweet : hashMap.values()) {
			
			System.out.println(tweet.getId() + " " + id);
			
			if(tweet.getId().equals(id)) {
				
				return true;
			}
		}
		
		return false;
	}
}
