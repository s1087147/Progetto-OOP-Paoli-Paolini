package it.univpm.projectGeoTwitter.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import it.univpm.projectGeoTwitter.exception.CapoluogoNotFoundException;
import it.univpm.projectGeoTwitter.model.TwitterData;

public interface Filters {

	public abstract ArrayList<TwitterData> getTweetsWithThisText(HashMap<String, TwitterData> tweetsMap, String operator, String text);
	
	public abstract ArrayList<TwitterData> getTweetsWithinRadius (
			HashMap<String, TwitterData> tweetsMap, String capoluogo, String operator, double[] radius)
					throws SecurityException, IllegalAccessException,
					IllegalArgumentException, InvocationTargetException;
	
	public abstract ArrayList<TwitterData> getTweetsWithinBoundingBox(
			HashMap<String, TwitterData> tweetsMap, String operator, double[] coordinatesUpLeft, double[] coordinatesDownRight);
	
	public abstract Collection<TwitterData> getTweetsFiltered(
			HashMap<String, TwitterData> tweetsMap, String filterType, String operator, Object filterValue);
}
