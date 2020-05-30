package it.univpm.projectGeoTwitter.utils.filter;

import java.util.ArrayList;
import java.util.HashMap;

import it.univpm.projectGeoTwitter.model.TwitterData;

public class TextFilter {

	public static ArrayList<TwitterData> getTweetsWithThisText(HashMap<String, TwitterData> tweetsMap, String text) {
		
		ArrayList<TwitterData> tweetsWithThisText = new ArrayList<TwitterData>();
		
		for(TwitterData tweet : tweetsMap.values()) {
			
			if(tweet.getText().contains(text)) {
				
				tweetsWithThisText.add(tweet);
			}
		}
		
		return tweetsWithThisText;
	}
}
