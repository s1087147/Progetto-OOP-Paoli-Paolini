package it.univpm.projectGeoTwitter.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.utils.stats.GeoMean;
import it.univpm.projectGeoTwitter.utils.stats.GetTweets;
import it.univpm.projectGeoTwitter.utils.stats.GeoVariance;
import it.univpm.projectGeoTwitter.utils.stats.TweetInsideMarche;
import it.univpm.projectGeoTwitter.utils.stats.TweetsInsideMarche;

public class StatsImpl implements Stats {

	@Override
	public Collection<TwitterData> getAllTweets(Map<Integer, TwitterData> tweetsMap) {
		
		return GetTweets.getAllTweets(tweetsMap);
	}
	
	@Override
	public double[] getMean(HashMap<Integer, TwitterData> tweetsMap) {

		return GeoMean.getMean(tweetsMap);
	}

	@Override
	public double[] getVariance(Map<Integer, TwitterData> tweetsMap) {

		return GeoVariance.getVariance(tweetsMap);
	}
	
	@Override
	public ArrayList<TwitterData> getTweetsInsideMarche(Map<Integer, TwitterData> tweetsMap) {
		
		return TweetsInsideMarche.tweetsInsideMarche(tweetsMap);
	}
	
	@Override
	public boolean tweetInsideMarche(Map<Integer, TwitterData> tweetsMap, Integer id) {
		
		return TweetInsideMarche.tweetInsideMarche(tweetsMap, id);
	}

}
