package it.univpm.projectGeoTwitter.utils.filter;

import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.univpm.projectGeoTwitter.exception.BoundingBoxVertexException;
import it.univpm.projectGeoTwitter.exception.CoordinatesException;
import it.univpm.projectGeoTwitter.exception.IllegalValueException;
import it.univpm.projectGeoTwitter.exception.OperatorNotFoundException;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.Calculator;
import it.univpm.projectGeoTwitter.service.FilterValueManager;

public class BoundingBoxFilter {

	public static ArrayList<TwitterData> getTweetsWithinBoundingBox(
			Collection<TwitterData> tweets, String operator, Object filterValue)
					throws IllegalValueException, OperatorNotFoundException {
		
		ArrayList<TwitterData> tweetsBoundingBox = new ArrayList<>();
		
		HashMap<String, Object> jsonMap = new ObjectMapper().convertValue(filterValue, new TypeReference<HashMap<String, Object>>(){});
		ArrayList<Double> topleftCoords = FilterValueManager.getCoordsArray(jsonMap.get("topleft"));
		ArrayList<Double> bottomrightCoords = FilterValueManager.getCoordsArray(jsonMap.get("bottomright"));
		
		
		if(bottomrightCoords.get(0) < topleftCoords.get(0) || bottomrightCoords.get(1) > topleftCoords.get(1))
			throw new IllegalValueException("Le coordinate dei vertici della bounding box non sono validi. "
					+ "Il primo vertice deve essere posto in alto a sinistra rispetto al secondo");
		
		double[] boundingBoxLongit = { topleftCoords.get(0), topleftCoords.get(0), bottomrightCoords.get(0), bottomrightCoords.get(0) };
		double[] boundingBoxLatit = { topleftCoords.get(1), bottomrightCoords.get(1), bottomrightCoords.get(1), topleftCoords.get(1) };
		Path2D boundingBox = Calculator.polygonGenerator(boundingBoxLongit, boundingBoxLatit);

		boolean choice;
		
		if(operator.equals("inside"))
			choice = true;
		else if(operator.equals("outside"))
			choice = false;
		else
			throw new OperatorNotFoundException("L'operatore richiesto non esiste");
		
		for(TwitterData tweet : tweets) {
			if(boundingBox.contains(tweet.getLongit(), tweet.getLatit()) == choice) {
				
				tweetsBoundingBox.add(tweet);
			}
		}
		
		return tweetsBoundingBox;
	}
}
