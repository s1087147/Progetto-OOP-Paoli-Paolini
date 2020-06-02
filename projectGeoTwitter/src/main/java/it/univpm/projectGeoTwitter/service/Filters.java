package it.univpm.projectGeoTwitter.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import it.univpm.projectGeoTwitter.exception.CapoluogoNotFoundException;
import it.univpm.projectGeoTwitter.model.TwitterData;

public interface Filters {

	public abstract ArrayList<TwitterData> filterText(HashMap<String, TwitterData> tweetsMap, String operator, Object filterValue);
	
	public abstract ArrayList<TwitterData> filterDistance (
			HashMap<String, TwitterData> tweetsMap, String operator,Object filterValue)
					throws SecurityException, IllegalAccessException,
					IllegalArgumentException, InvocationTargetException;
	
	public abstract ArrayList<TwitterData> filterBoundingBox(
			HashMap<String, TwitterData> tweetsMap, String operator, Object filterValue);
	
	public abstract Collection<TwitterData> getTweetsFiltered(
			HashMap<String, TwitterData> tweetsMap, String filterType, String operator, Object filterValue);
}
