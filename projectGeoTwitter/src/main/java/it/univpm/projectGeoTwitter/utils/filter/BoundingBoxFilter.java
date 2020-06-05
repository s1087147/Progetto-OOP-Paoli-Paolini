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
import it.univpm.projectGeoTwitter.exception.NegativeRadiusException;
import it.univpm.projectGeoTwitter.exception.OperatorNotFoundException;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.Calculator;

public class BoundingBoxFilter {

	public static ArrayList<TwitterData> getTweetsWithinBoundingBox(
			Collection<TwitterData> tweets, String operator, Object filterValue) throws BoundingBoxVertexException,
				CoordinatesException, IllegalValueException, OperatorNotFoundException {
		
		ArrayList<TwitterData> tweetsBoundingBox = new ArrayList<>();
		
		HashMap<String, Object> jsonMap = new ObjectMapper().convertValue(filterValue, new TypeReference<HashMap<String, Object>>(){});
		ArrayList<Double> topleftCoords = getCoordsArray(jsonMap.get("topleft"));
		ArrayList<Double> bottomrightCoords = getCoordsArray(jsonMap.get("bottomright"));
		
		
		//LA CONDIZIONE DELL'IF DIPENDE DA COME VERRA' GESTITO DENTRO QUESTO CLASSE l'Object filterValue (ovvero la BoundingBox)
		if(bottomrightCoords.get(0) < topleftCoords.get(0) || bottomrightCoords.get(1) > topleftCoords.get(1))
			throw new BoundingBoxVertexException("Le coordinate dei vertici della bounding box non sono validi. "
					+ "Il primo vertice deve essere posto in alto a sinistra rispetto al secondo");
		
		double[] boundingBoxLongit = { topleftCoords.get(0), topleftCoords.get(0), bottomrightCoords.get(0), bottomrightCoords.get(0) };

		double[] boundingBoxLatit = { topleftCoords.get(1), bottomrightCoords.get(1), bottomrightCoords.get(1), topleftCoords.get(1) };
		/*
		System.out.println(topleftCoords.get(0)+" "+ topleftCoords.get(0)+" "+ bottomrightCoords.get(0)+" "+ bottomrightCoords.get(0) +"\n"+
				topleftCoords.get(1)+" "+ bottomrightCoords.get(1)+" "+ bottomrightCoords.get(1)+" "+ topleftCoords.get(1));
		*/
		/*
		for(double n : boundingBoxLongit)
			System.out.print(n + " ");
		System.out.print("\n");
		for(double n : boundingBoxLatit)
			System.out.print(n + " ");
		*/
		
		Path2D boundingBox;
		try {
			boundingBox = Calculator.polygonGenerator(boundingBoxLongit, boundingBoxLatit);
		
		} catch(CoordinatesException e) {
			throw e;
		}
		
		System.out.println(boundingBox);
		
		boolean choice;
		
		if(operator.equals("inside"))
			choice = true;
		else if(operator.equals("outside"))
			choice = false;
		else
			throw new OperatorNotFoundException("L'operatore richiesto non esiste");
		
		for(TwitterData tweet : tweets) {
			System.out.println(tweet.getLongit() + " " + tweet.getLatit());
			System.out.println(boundingBox.contains(tweet.getLongit(), tweet.getLatit()));
			if(boundingBox.contains(tweet.getLongit(), tweet.getLatit()) == choice) {
				
				tweetsBoundingBox.add(tweet);
			}
		}
		
		return tweetsBoundingBox;
	}
	
	private static ArrayList<Double> getCoordsArray(Object filterValue) {
		ArrayList<Double> coords = new ArrayList<>();
		if (filterValue.getClass() == ArrayList.class) {
			try {
				for(Number num : (ArrayList<Number>)filterValue)
					coords.add(num.doubleValue());
				if(coords.size() != 2)
					throw new IllegalValueException("Sono solamente ammessi 2 valori per le coordinate.");
				
			} catch (ClassCastException cce) {
				throw new IllegalValueException("Punti della BoundingBox non validi.");
			}
		}
		else
			throw new IllegalValueException("Punti della BoundingBox non validi.");
		return coords;
	}
}
