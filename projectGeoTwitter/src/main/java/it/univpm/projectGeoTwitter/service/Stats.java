package it.univpm.projectGeoTwitter.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import it.univpm.projectGeoTwitter.model.Geo;
import it.univpm.projectGeoTwitter.model.TwitterData;

public interface Stats {

	public abstract double[] getMean(Collection<TwitterData> tweets);
	
	public abstract double getMean(Collection<TwitterData> tweets, Geo capoluogo);
	
	public abstract double[] getVariance(Collection<TwitterData> tweets);
	
	public abstract double getVariance(Collection<TwitterData> tweets, Geo capoluogo);
	
	public abstract double[] getStdDev(Collection<TwitterData> tweets);
	
	public abstract double getStdDev(Collection<TwitterData> tweets, Geo capoluogo);
	
	public abstract double getMax(Collection<TwitterData> tweets, Geo capoluogo);
	
	public abstract double getMin(Collection<TwitterData> tweets, Geo capoluogo);
	
	public abstract double getTextAverageLength(Collection<TwitterData> tweets);
	
	public abstract int countTweetsInsideMarche(Collection<TwitterData> tweets);
	
	public abstract ArrayList<TwitterData> getTweetsInsideMarche(Collection<TwitterData> tweets);
	
	public abstract boolean tweetInsideMarche(HashMap<String, TwitterData> tweets, String id);
}
