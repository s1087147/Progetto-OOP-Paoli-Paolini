package it.univpm.projectGeoTwitter.utils.filter;

import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.HashMap;

import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.Calculator;

public class BoundingBoxFilter {

	public static ArrayList<TwitterData> getTweetsWithinBoundingBox(
			HashMap<Integer, TwitterData> tweetsMap, double[] coordinatesUpLeft, double[] coordinatesDownRight) {
		
		ArrayList<TwitterData> tweetsWithinBoundingBox = new ArrayList<>();
		
		double[] boundingBoxLongit = {coordinatesUpLeft[0],
									  coordinatesUpLeft[0],
									  coordinatesDownRight[0],
									  coordinatesDownRight[0]};
		
		double[] boundingBoxLatit = {coordinatesUpLeft[1],
								   coordinatesDownRight[1],
								   coordinatesDownRight[1],
								   coordinatesUpLeft[1]};
		
		Path2D boundingBox = Calculator.polygonGenerator(boundingBoxLongit, boundingBoxLatit);
		
		for(TwitterData tweet : tweetsMap.values()) {
			
			if(boundingBox.contains(tweet.getGeo().getCoordinates().getLongit(),
					tweet.getGeo().getCoordinates().getLatit())) {
				
				tweetsWithinBoundingBox.add(tweet);
			}
		}
		
		return tweetsWithinBoundingBox;
	}
}
