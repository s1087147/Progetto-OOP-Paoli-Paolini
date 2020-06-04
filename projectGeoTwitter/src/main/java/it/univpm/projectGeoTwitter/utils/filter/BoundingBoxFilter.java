package it.univpm.projectGeoTwitter.utils.filter;

import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.univpm.projectGeoTwitter.exception.BoundingBoxVertexException;
import it.univpm.projectGeoTwitter.exception.IllegalValueException;
import it.univpm.projectGeoTwitter.exception.NegativeRadiusException;
import it.univpm.projectGeoTwitter.exception.OperatorNotFoundException;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.Calculator;

public class BoundingBoxFilter {

	public static ArrayList<TwitterData> getTweetsWithinBoundingBox(
			Collection<TwitterData> tweets, String operator, Object filterValue) {
		
		ArrayList<TwitterData> tweetsWithinBoundingBox = new ArrayList<>();
		
		HashMap<String, Object> jsonMap = new ObjectMapper().convertValue(filterValue, new TypeReference<HashMap<String, Object>>(){});
		ArrayList<Double> topleftCoords = getCoordsArray(jsonMap.get("topleft"));
		ArrayList<Double> bottomrightCoords = getCoordsArray(jsonMap.get("bottomright"));
		
		
		//LA CONDIZIONE DELL'IF DIPENDE DA COME VERRA' GESTITO DENTRO QUESTO CLASSE l'Object filterValue (ovvero la BoundingBox)
		if(bottomrightCoords.get(0) < topleftCoords.get(0) || bottomrightCoords.get(1) > topleftCoords.get(1))
			throw new BoundingBoxVertexException("Le coordinate dei vertici della bounding box non sono validi. "
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
				
				tweetsWithinBoundingBox.add(tweet);
			}
		}
		
		return tweetsWithinBoundingBox;
	}
	
	private static ArrayList<Double> getCoordsArray(Object filterValue) {
		ArrayList<Double> coords = new ArrayList<>();
		if (filterValue.getClass() == ArrayList.class) {
			try {
			for(Number num : (ArrayList<Number>)filterValue)
				coords.add(num.doubleValue());
			//ECCEZIONE PER COORDINATE NEGATIVE?
			} catch (ClassCastException cce) {
				throw new IllegalValueException("Punti della BoundingBox non validi.");
			}
			if(coords.get(0)< 0 || coords.get(1) < 0)
				throw new NegativeRadiusException();
		}
		else
			throw new IllegalValueException("Punti della BoundingBox non validi.");
		return coords;
	}
}
