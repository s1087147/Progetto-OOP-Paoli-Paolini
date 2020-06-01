package it.univpm.projectGeoTwitter.service;

import java.util.ArrayList;
import java.util.HashMap;


import it.univpm.projectGeoTwitter.model.Geo;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.utils.stats.GeoMaxDistance;
import it.univpm.projectGeoTwitter.utils.stats.GeoMeanCoord;
import it.univpm.projectGeoTwitter.utils.stats.GeoMeanDistance;
import it.univpm.projectGeoTwitter.utils.stats.GeoMinDistance;
import it.univpm.projectGeoTwitter.utils.stats.GeoStdDevCoord;
import it.univpm.projectGeoTwitter.utils.stats.GeoStdDevDistance;
import it.univpm.projectGeoTwitter.utils.stats.GeoVarianceCoord;
import it.univpm.projectGeoTwitter.utils.stats.GeoVarianceDistance;
import it.univpm.projectGeoTwitter.utils.stats.TweetInsideMarche;
import it.univpm.projectGeoTwitter.utils.stats.TweetsInsideMarche;

public class StatsImpl implements Stats {
	
	@Override
	public double[] getMean(HashMap<String, TwitterData> tweetsMap) {

		return GeoMeanCoord.getMean(tweetsMap);
	}
	
	@Override
	public double getMean(HashMap<String, TwitterData> tweetsMap, Geo capoluogo) {

		return GeoMeanDistance.getMean(tweetsMap, capoluogo);
	}

	@Override
	public double[] getVariance(HashMap<String, TwitterData> tweetsMap) {

		return GeoVarianceCoord.getVariance(tweetsMap);
	}
	
	@Override
	public double getVariance(HashMap<String, TwitterData> tweetsMap, Geo capoluogo) {

		return GeoVarianceDistance.getVariance(tweetsMap, capoluogo);
	}
	
	@Override
	public double[] getStdDev(HashMap<String, TwitterData> tweetsMap) {

		return GeoStdDevCoord.getStdDev(tweetsMap);
	}
	
	@Override
	public double getStdDev(HashMap<String, TwitterData> tweetsMap, Geo capoluogo) {

		return GeoStdDevDistance.getStdDev(tweetsMap, capoluogo);
	}
	
	@Override
	public double getMax(HashMap<String, TwitterData> tweetsMap, Geo capoluogo) {
		
		return GeoMaxDistance.getMax(tweetsMap, capoluogo);
	}
	
	@Override
	public double getMin(HashMap<String, TwitterData> tweetsMap, Geo capoluogo) {
		
		return GeoMinDistance.getMin(tweetsMap, capoluogo);
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
