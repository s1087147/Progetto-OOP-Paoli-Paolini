package it.univpm.projectGeoTwitter.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

import it.univpm.projectGeoTwitter.exception.BoundingBoxVertexException;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.utils.filter.BoundingBoxFilter;
import it.univpm.projectGeoTwitter.utils.filter.RadiusFilter;
import it.univpm.projectGeoTwitter.utils.filter.TextFilter;

public class FiltersImpl implements Filters {

	@Override
	public ArrayList<TwitterData> filterText(Collection<TwitterData> tweets, String operator, Object filterValue) {
		
		return TextFilter.getTweetsWithThisText(tweets, operator, filterValue);
	}

	@Override
	public ArrayList<TwitterData> filterDistance(
			Collection<TwitterData> tweets, String operator, Object filterValue){
		
		try {
			return RadiusFilter.getTweetsWithinRadius(tweets, operator, filterValue);
		} catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ArrayList<TwitterData> filterBoundingbox(
			Collection<TwitterData> tweets, String operator, Object filterValue) {				
		
		return BoundingBoxFilter.getTweetsWithinBoundingBox(tweets, operator, filterValue);
	}
}
