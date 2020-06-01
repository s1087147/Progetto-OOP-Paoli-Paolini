package it.univpm.projectGeoTwitter.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.utils.filter.BoundingBoxFilter;
import it.univpm.projectGeoTwitter.utils.filter.RadiusFilter;
import it.univpm.projectGeoTwitter.utils.filter.TextFilter;

public class FiltersImpl implements Filters {

	@Override
	public ArrayList<TwitterData> getTweetsWithThisText(HashMap<String, TwitterData> tweetsMap, String operator, String text) {
		
		return TextFilter.getTweetsWithThisText(tweetsMap, operator, text);
	}

	@Override
	public ArrayList<TwitterData> getTweetsWithinRadius(
			HashMap<String, TwitterData> tweetsMap, String capoluogo, String operator, double[] radius)
					throws SecurityException, IllegalAccessException,
					IllegalArgumentException, InvocationTargetException{
		
		return RadiusFilter.getTweetsWithinRadius(tweetsMap, capoluogo, operator, radius);
	}
	
	@Override
	public ArrayList<TwitterData> getTweetsWithinBoundingBox(
			HashMap<String, TwitterData> tweetsMap, String operator, double[] coordinatesUpLeft, double[] coordinatesDownRight) {
		
		return BoundingBoxFilter.getTweetsWithinBoundingBox(tweetsMap, operator, coordinatesUpLeft, coordinatesDownRight);
	}
	
	@Override
	public Collection<TwitterData> getTweetsFiltered(
			HashMap<String, TwitterData> tweetsMap, String filter, String operator, Object filterValue) {
		
		if(text)
			return getTweetsWithThisText
		return null;
	}
}
