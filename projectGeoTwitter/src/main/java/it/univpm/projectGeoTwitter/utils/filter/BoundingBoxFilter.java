package it.univpm.projectGeoTwitter.utils.filter;

import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.HashMap;

import it.univpm.projectGeoTwitter.exception.OperatorNotFoundException;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.Calculator;

public class BoundingBoxFilter {

	public static ArrayList<TwitterData> getTweetsWithinBoundingBox(
			HashMap<String, TwitterData> tweetsMap, String operator, double[] coordinatesUpLeft, double[] coordinatesDownRight) {
		
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
		
		boolean choice;
		
		if(operator.equals("inside"))
			choice = true;
		else if(operator.equals("outside"))
			choice = false;
		else
			throw new OperatorNotFoundException("L'operatore richiesto non esiste");
		
		for(TwitterData tweet : tweetsMap.values()) {
			
			if(boundingBox.contains(tweet.getLongit(), tweet.getLatit()) == choice) {
				
				tweetsWithinBoundingBox.add(tweet);
			}
		}
		
		return tweetsWithinBoundingBox;
	}
}
