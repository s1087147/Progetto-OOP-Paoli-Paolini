package it.univpm.projectGeoTwitter.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import it.univpm.projectGeoTwitter.model.TwitterData;

public interface Stats {
	
	public abstract Collection<TwitterData> getAllTweets(Map<Integer, TwitterData> tweetsMap);

	public abstract double[] getMean(HashMap<Integer, TwitterData> tweetsMap);
	
	public abstract double[] getVariance(Map<Integer, TwitterData> tweetsMap);
	
	public abstract ArrayList<TwitterData> getTweetsInsideMarche(Map<Integer, TwitterData> tweetsMap);
	
	public abstract boolean tweetInsideMarche(Map<Integer, TwitterData> tweetsMap, Integer id);
}
