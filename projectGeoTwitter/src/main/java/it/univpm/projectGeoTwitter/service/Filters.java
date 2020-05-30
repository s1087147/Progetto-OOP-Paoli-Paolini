package it.univpm.projectGeoTwitter.service;

import java.util.ArrayList;
import java.util.HashMap;

import it.univpm.projectGeoTwitter.model.TwitterData;

public interface Filters {

	public abstract ArrayList<TwitterData> getTweetsWithThisText(HashMap<Integer, TwitterData> tweetsMap, String text);
	
	public abstract boolean tweetWithThisId(HashMap<Integer, TwitterData> tweetsMap,  String id);
	
	public abstract ArrayList<TwitterData> getTweetsWithinRadius (
			HashMap<Integer, TwitterData> tweetsMap, String capoluogo, double radius) throws /*CapoluogoNotFoundException*/ Exception;
	
	public abstract ArrayList<TwitterData> getTweetsWithinBoundingBox(
			HashMap<Integer, TwitterData> tweetsMap, double[] coordinatesUpLeft, double[] coordinatesDownRight);
}
