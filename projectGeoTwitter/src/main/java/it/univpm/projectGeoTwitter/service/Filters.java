package it.univpm.projectGeoTwitter.service;

import java.util.ArrayList;
import java.util.HashMap;

import it.univpm.projectGeoTwitter.exception.CapoluogoNotFoundException;
import it.univpm.projectGeoTwitter.model.TwitterData;

public interface Filters {

	public abstract ArrayList<TwitterData> getTweetsWithThisText(HashMap<String, TwitterData> tweetsMap, String text);
	
	public abstract boolean tweetWithThisId(HashMap<String, TwitterData> tweetsMap,  String id);
	
	public abstract ArrayList<TwitterData> getTweetsWithinRadius (
			HashMap<String, TwitterData> tweetsMap, String capoluogo, double radius) throws CapoluogoNotFoundException;
	
	public abstract ArrayList<TwitterData> getTweetsWithinBoundingBox(
			HashMap<String, TwitterData> tweetsMap, double[] coordinatesUpLeft, double[] coordinatesDownRight);
}
