package it.univpm.projectGeoTwitter.service;

import java.util.ArrayList;
import java.util.HashMap;

import it.univpm.projectGeoTwitter.model.TwitterData;

public interface Stats {

	public abstract double[] getMean(HashMap<String, TwitterData> tweetsMap);
	
	public abstract double[] getVariance(HashMap<String, TwitterData> tweetsMap);
	
	public abstract ArrayList<TwitterData> getTweetsInsideMarche(HashMap<String, TwitterData> tweetsMap);
	
	public abstract boolean tweetInsideMarche(HashMap<String, TwitterData> tweetsMap, String id);
}
