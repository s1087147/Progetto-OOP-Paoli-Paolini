package it.univpm.projectGeoTwitter.service;

import java.util.ArrayList;
import java.util.Map;

import it.univpm.projectGeoTwitter.model.TwitterData;

public interface Filters {

	public abstract ArrayList<TwitterData> textFilter(Map<Integer, TwitterData> tweetsMap, String text);
	
	public abstract TwitterData idFilter(Map<Integer, TwitterData> tweetsMap,  String id);		//id -> String
	
	public abstract ArrayList<TwitterData> getTweetsWithinRadius(
			Map<Integer, TwitterData> tweetsMap, double[] capoluogoCoordinates, double radius);
}
