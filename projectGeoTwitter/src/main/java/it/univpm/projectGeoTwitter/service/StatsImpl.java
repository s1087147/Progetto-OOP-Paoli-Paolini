package it.univpm.projectGeoTwitter.service;

import java.util.ArrayList;
import java.util.HashMap;

import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.utils.stats.GeoMean;
import it.univpm.projectGeoTwitter.utils.stats.GeoVariance;
import it.univpm.projectGeoTwitter.utils.stats.TweetInsideMarche;
import it.univpm.projectGeoTwitter.utils.stats.TweetsInsideMarche;

public class StatsImpl implements Stats {
	
	@Override
	public double[] getMean(HashMap<Integer, TwitterData> tweetsMap) {

		return GeoMean.getMean(tweetsMap);
	}

	@Override
	public double[] getVariance(HashMap<Integer, TwitterData> tweetsMap) {

		return GeoVariance.getVariance(tweetsMap);
	}
	
	@Override
	public ArrayList<TwitterData> getTweetsInsideMarche(HashMap<Integer, TwitterData> tweetsMap) {
		
		return TweetsInsideMarche.tweetsInsideMarche(tweetsMap);
	}
	
	@Override
	public boolean tweetInsideMarche(HashMap<Integer, TwitterData> tweetsMap, String id) {
		
		return TweetInsideMarche.tweetInsideMarche(tweetsMap, id);
	}

}
