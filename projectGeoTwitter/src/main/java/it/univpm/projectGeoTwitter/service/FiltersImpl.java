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
	public ArrayList<TwitterData> filterText(HashMap<String, TwitterData> tweetsMap, String operator, Object filterValue) {
		
		return TextFilter.getTweetsWithThisText(tweetsMap, operator, filterValue);
	}

	@Override
	public ArrayList<TwitterData> filterDistance(
			HashMap<String, TwitterData> tweetsMap, String operator, Object filterValue){
		
		try {
			return RadiusFilter.getTweetsWithinRadius(tweetsMap, operator, filterValue);
		} catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ArrayList<TwitterData> filterBoundingbox(
			HashMap<String, TwitterData> tweetsMap, String operator, Object filterValue) {				
		
		return BoundingBoxFilter.getTweetsWithinBoundingBox(tweetsMap, operator, filterValue);
	}
	
	@Override
	public Collection<TwitterData> getTweetsFiltered( //SERVE?? ABBIAMO GIA' FilterRunner CHE RESTITUISCE LA COLLEZIONE FILTRATA
			HashMap<String, TwitterData> tweetsMap, String filter, String operator, Object filterValue) {
			
		return null;
	}
}
