package it.univpm.projectGeoTwitter.service;

import java.util.ArrayList;
import java.util.HashMap;

import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.utils.stats.GeoMeanCoord;
import it.univpm.projectGeoTwitter.utils.stats.GeoVarianceCoord;
import it.univpm.projectGeoTwitter.utils.stats.TweetInsideMarche;
import it.univpm.projectGeoTwitter.utils.stats.TweetsInsideMarche;

public class StatsImpl implements Stats {
	
	public static StatsModel getStats(HashMap<String, TwitterData> tweetsMap, String capoluogo) {
		
		
	}
	
	@Override
	public double[] getMean(HashMap<String, TwitterData> hashMap) {

		return GeoMeanCoord.getMean(hashMap);
	}

	@Override
	public double[] getVariance(HashMap<String, TwitterData> tweetsMap) {

		return GeoVarianceCoord.getVariance(tweetsMap);
	}
	
	@Override
	public ArrayList<TwitterData> getTweetsInsideMarche(HashMap<String, TwitterData> tweetsMap) {
		
		return TweetsInsideMarche.tweetsInsideMarche(tweetsMap);
	}
	
	@Override
	public boolean tweetInsideMarche(HashMap<String, TwitterData> tweetsMap, String id) {
		
		return TweetInsideMarche.tweetInsideMarche(tweetsMap, id);
	}
}
