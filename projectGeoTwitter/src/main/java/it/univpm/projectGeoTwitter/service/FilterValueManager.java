package it.univpm.projectGeoTwitter.service;

import java.util.ArrayList;

import it.univpm.projectGeoTwitter.exception.IllegalValueException;

/**
 * Gestore della deserializzazione degli oggetti "filterValue" nei body delle richieste di filtraggio da parte dei client.
 * @author Davide Paolini
 * @author Francesco Paoli Leonardi
 */
public class FilterValueManager {
	
	/**
	 * Metodo usato per ottenere due valori: un raggio esterno e un raggio interno.
	 * @param filterValue oggetto "filterValue" da deserializzare.
	 * @return ArrayList di Double contenente i valori del raggio interno e del raggio esterno.
	 * @throws IllegalValueException quando non è possibile ricondurre filterValue ad un array di due Double o sono presenti valori negativi.
	 */
	public static ArrayList<Double> getRadiusArray(Object filterValue) throws IllegalValueException {
		ArrayList<Double> radius = new ArrayList<>();
		if (filterValue.getClass() == ArrayList.class) {
			for(Number num : (ArrayList<Number>)filterValue)
				radius.add(num.doubleValue());
			if(radius.size() != 2)
				throw new IllegalValueException("Sono solamente ammessi 2 valori per la distanza.");
			if(radius.get(0)< 0 || radius.get(1) < 0)
				throw new IllegalValueException("Non sono ammessi valori negativi per la distanza.");
		}
		else
			throw new IllegalValueException("Valori della distanza non validi.");
		
		return radius;
	}
	
	/**
	 * Metodo usato per ottenere una distanza.
	 * @param filterValue oggetto "filterValue" da deserializzare.
	 * @return double che rappresenta la distanza.
	 * @throws IllegalValueException quando non è possibile ricondurre filterValue un double o sono presenti valori negativi.
	 */	
	public static double getRadius(Object filterValue) throws IllegalValueException {
		double radius;
		if (filterValue instanceof Number) {		
			radius = ((Number) filterValue).doubleValue();
			if(radius < 0)
				throw new IllegalValueException("Non sono ammessi valori negativi per la distanza.");
		}
		else
			throw new IllegalValueException("Valori della distanza non validi.");
		
		return radius;
	}
	
	/**
	 * Metodo usato per ottenere i valori della longitudine e della latitudine.
	 * @param filterValue oggetto "filterValue" da deserializzare.
	 * @return ArrayList di Double contenente i valori della longitudine e della latitudine.
	 * @throws IllegalValueException quando non è possibile ricondurre filterValue ad un array di due Double o a coordinate valide.
	 */
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