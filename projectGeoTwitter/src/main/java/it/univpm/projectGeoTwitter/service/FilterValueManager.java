package it.univpm.projectGeoTwitter.service;

import java.util.ArrayList;

import it.univpm.projectGeoTwitter.exception.IllegalValueException;
import it.univpm.projectGeoTwitter.exception.NegativeRadiusException;

public class FilterValueManager {

	public static ArrayList<Double> getRadiusArray(Object filterValue) throws IllegalValueException, NegativeRadiusException {
		ArrayList<Double> radius = new ArrayList<>();
		if (filterValue.getClass() == ArrayList.class) {
			for(Number num : (ArrayList<Number>)filterValue)
				radius.add(num.doubleValue());
			if(radius.size() != 2)
				throw new IllegalValueException("Sono solamente ammessi 2 valori per la distanza.");
			if(radius.get(0)< 0 || radius.get(1) < 0)
				throw new NegativeRadiusException("Non sono ammessi valori negativi per la distanza.");
		}
		else
			throw new IllegalValueException("Valori della distanza non validi.");
		
		return radius;
	}
	
	public static double getRadius(Object filterValue) throws IllegalValueException, NegativeRadiusException {
		double radius;
		if (filterValue instanceof Number) {		
			radius = ((Number) filterValue).doubleValue();
			if(radius < 0)
				throw new NegativeRadiusException();
		}
		else
			throw new IllegalValueException("Valori della distanza non validi.");
		
		return radius;
	}
	
	public static ArrayList<Double> getCoordsArray(Object filterValue) throws IllegalValueException {
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
