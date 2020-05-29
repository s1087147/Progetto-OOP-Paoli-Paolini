package it.univpm.projectGeoTwitter.utils.filter;

import java.util.ArrayList;
import java.util.HashMap;

import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.Calculator;

public class RadiusFilter extends Calculator{

	public static ArrayList<TwitterData> getTweetsWithinRadius(
			HashMap<Integer, TwitterData> tweetsMap, double[] capoluogoCoordinates, double radius) {
		
		ArrayList<TwitterData> tweetsWithinRadius = new ArrayList<>();
		
		for(TwitterData tweet : tweetsMap.values()) {
			
			double[] tweetCoordinates = tweet.getGeo().getCoordinates().getCoordinates();
			
			if(Calculator.distance(tweetCoordinates, capoluogoCoordinates) < radius) {
				
				tweetsWithinRadius.add(tweet);
			}
		}
		
		return tweetsWithinRadius;
	}
}