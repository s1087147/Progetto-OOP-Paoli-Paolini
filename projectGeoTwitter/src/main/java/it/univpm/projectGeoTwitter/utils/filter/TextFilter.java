package it.univpm.projectGeoTwitter.utils.filter;

import java.util.ArrayList;
import java.util.HashMap;

import it.univpm.projectGeoTwitter.exception.OperatorNotFoundException;
import it.univpm.projectGeoTwitter.model.TwitterData;

public class TextFilter {

	public static ArrayList<TwitterData> getTweetsWithThisText(HashMap<String, TwitterData> tweetsMap, String operator, String text) {
		
		ArrayList<TwitterData> tweetsWithThisText = new ArrayList<TwitterData>();
		boolean choice;
		
		if(operator.equals("contains"))
			choice = true;
		else if(operator.equals("not_contains"))
			choice = false;
		else
			throw new OperatorNotFoundException("L'operatore richiesto non esiste");
		
		for(TwitterData tweet : tweetsMap.values()) {
			
			if(tweet.getText().contains(text) == choice) {
					
				tweetsWithThisText.add(tweet);
			}
		}
		
		return tweetsWithThisText;
	}
}
