package it.univpm.projectGeoTwitter.service;

import java.util.ArrayList;
import java.util.HashMap;

import it.univpm.projectGeoTwitter.model.TwitterData;

public interface Stats {

	public abstract double[] getMean(HashMap<Integer, TwitterData> tweetsMap);
	
	public abstract double[] getVariance(HashMap<Integer, TwitterData> tweetsMap);
	
	public abstract ArrayList<TwitterData> getTweetsInsideMarche(HashMap<Integer, TwitterData> tweetsMap);
	
	public abstract boolean tweetInsideMarche(HashMap<Integer, TwitterData> tweetsMap, String id);
}
