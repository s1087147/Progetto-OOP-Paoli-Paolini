package it.univpm.projectGeoTwitter.service;

import java.util.ArrayList;
import java.util.HashMap;

import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.utils.filter.BoundingBoxFilter;
import it.univpm.projectGeoTwitter.utils.filter.IdFilter;
import it.univpm.projectGeoTwitter.utils.filter.RadiusFilter;
import it.univpm.projectGeoTwitter.utils.filter.TextFilter;

public class FiltersImpl implements Filters {

	@Override
	public ArrayList<TwitterData> getTweetsWithThisText(HashMap<Integer, TwitterData> tweetsMap, String text) {
		
		return TextFilter.getTweetsWithThisText(tweetsMap, text);
	}

	@Override
	public boolean tweetWithThisId(HashMap<Integer, TwitterData> tweetsMap, String id) {
		
		return IdFilter.tweetWithThisId(tweetsMap, id);
	}

	@Override
	public ArrayList<TwitterData> getTweetsWithinRadius(
			HashMap<Integer, TwitterData> tweetsMap, double[] capoluogoCoordinates, double radius) {
		
		return RadiusFilter.getTweetsWithinRadius(tweetsMap, capoluogoCoordinates, radius);
	}
	
	@Override
	public ArrayList<TwitterData> getTweetsWithinBoundingBox(
			HashMap<Integer, TwitterData> tweetsMap, double[] coordinatesUpLeft, double[] coordinatesDownRight) {
		
		return BoundingBoxFilter.getTweetsWithinBoundingBox(tweetsMap, coordinatesUpLeft, coordinatesDownRight);
	}
}
