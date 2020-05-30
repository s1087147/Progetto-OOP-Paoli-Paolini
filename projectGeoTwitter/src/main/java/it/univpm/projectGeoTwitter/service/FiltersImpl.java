package it.univpm.projectGeoTwitter.service;

import java.util.ArrayList;
import java.util.HashMap;

import it.univpm.projectGeoTwitter.exception.CapoluogoNotFoundException;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.utils.filter.BoundingBoxFilter;
import it.univpm.projectGeoTwitter.utils.filter.IdFilter;
import it.univpm.projectGeoTwitter.utils.filter.RadiusFilter;
import it.univpm.projectGeoTwitter.utils.filter.TextFilter;

public class FiltersImpl implements Filters {

	@Override
	public ArrayList<TwitterData> getTweetsWithThisText(HashMap<String, TwitterData> tweetsMap, String text) {
		
		return TextFilter.getTweetsWithThisText(tweetsMap, text);
	}

	@Override
	public boolean tweetWithThisId(HashMap<String, TwitterData> hashMap, String id) {
		
		return IdFilter.tweetWithThisId(hashMap, id);
	}

	@Override
	public ArrayList<TwitterData> getTweetsWithinRadius(
			HashMap<String, TwitterData> tweetsMap, String capoluogo, double radius) throws CapoluogoNotFoundException{
		
		return RadiusFilter.getTweetsWithinRadius(tweetsMap, capoluogo, radius);
	}
	
	@Override
	public ArrayList<TwitterData> getTweetsWithinBoundingBox(
			HashMap<String, TwitterData> tweetsMap, double[] coordinatesUpLeft, double[] coordinatesDownRight) {
		
		return BoundingBoxFilter.getTweetsWithinBoundingBox(tweetsMap, coordinatesUpLeft, coordinatesDownRight);
	}
}
