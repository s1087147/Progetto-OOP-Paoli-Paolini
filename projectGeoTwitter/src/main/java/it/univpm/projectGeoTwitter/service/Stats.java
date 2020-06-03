package it.univpm.projectGeoTwitter.service;

import java.util.ArrayList;
import java.util.HashMap;

import it.univpm.projectGeoTwitter.model.Geo;
import it.univpm.projectGeoTwitter.model.TwitterData;

public interface Stats {

	public abstract double[] getMean(HashMap<String, TwitterData> tweetsMap);
	
	public abstract double getMean(HashMap<String, TwitterData> tweetsMap, Geo capoluogo);
	
	public abstract double[] getVariance(HashMap<String, TwitterData> tweetsMap);
	
	public abstract double getVariance(HashMap<String, TwitterData> tweetsMap, Geo capoluogo);
	
	public abstract double[] getStdDev(HashMap<String, TwitterData> tweetsMap);
	
	public abstract double getStdDev(HashMap<String, TwitterData> tweetsMap, Geo capoluogo);
	
	public abstract double getMax(HashMap<String, TwitterData> tweetsMap, Geo capoluogo);
	
	public abstract double getMin(HashMap<String, TwitterData> tweetsMap, Geo capoluogo);
	
	public abstract double getTextAverageLength(HashMap<String, TwitterData> tweetsMap);
	
	public abstract int countTweetsInsideMarche(HashMap<String, TwitterData> tweetsMap);
	
	public abstract ArrayList<TwitterData> getTweetsInsideMarche(HashMap<String, TwitterData> tweetsMap);
	
	public abstract boolean tweetInsideMarche(HashMap<String, TwitterData> tweetsMap, String id);
}
