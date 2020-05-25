package it.univpm.projectGeoTwitter.utils.stats;

import java.util.Collection;
import java.util.Map;

import it.univpm.projectGeoTwitter.model.TwitterData;

public class GeoTweets {

	public static Collection<TwitterData> getAllTweets(Map<Integer, TwitterData> tweetsMap) {
		
		return tweetsMap.values();
	}
}
