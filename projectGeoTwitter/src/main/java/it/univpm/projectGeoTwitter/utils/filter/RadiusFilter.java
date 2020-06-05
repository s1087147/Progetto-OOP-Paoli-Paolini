package it.univpm.projectGeoTwitter.utils.filter;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.univpm.projectGeoTwitter.exception.CapoluogoNotFoundException;
import it.univpm.projectGeoTwitter.exception.IllegalValueException;
import it.univpm.projectGeoTwitter.exception.NegativeRadiusException;
import it.univpm.projectGeoTwitter.exception.OperatorNotFoundException;
import it.univpm.projectGeoTwitter.model.Geo;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.Calculator;
import it.univpm.projectGeoTwitter.service.CapoluogoGetter;

public class RadiusFilter {

	public static ArrayList<TwitterData> getTweetsWithinRadius(
			Collection<TwitterData> tweets, String operator, Object filterValue) throws IllegalAccessException,
					InvocationTargetException, CapoluogoNotFoundException, IllegalValueException, NegativeRadiusException {
		
		ArrayList<TwitterData> tweetsWithinRadius = new ArrayList<>();
		if(filterValue.getClass() != LinkedHashMap.class)
			throw new IllegalValueException("Il valore inserito non è corretto."); 	//"filterValue" : {"capoluogo" : "esempio", "distanza" : [0, 100]}
		
		HashMap<String, Object> jsonMap = new ObjectMapper().convertValue(filterValue, new TypeReference<HashMap<String, Object>>(){});
		
		//CONTROLLO SUL TIPO DI CAPOLUOGO
		String capoluogoName = jsonMap.get("capoluogo").toString();
		filterValue = jsonMap.get("distanza");
		
		try {
			Geo capoluogo = CapoluogoGetter.getCapoluogo(capoluogoName);
			
			if(operator.equals("inside")) {
				double radius = getRadius(filterValue);
				for(TwitterData tweet : tweets) {
					
					double distance = Calculator.distance(tweet.getLongit(), tweet.getLatit(), capoluogo.getLongit(), capoluogo.getLatit());
					if(distance < radius)
						tweetsWithinRadius.add(tweet);
				}
			}
			
			else if(operator.equals("outside")) {
				double radius = getRadius(filterValue);
				for(TwitterData tweet : tweets) {
					
					double distance = Calculator.distance(tweet.getLongit(), tweet.getLatit(), capoluogo.getLongit(), capoluogo.getLatit());
					if(distance > radius)
						tweetsWithinRadius.add(tweet);
				}
			}
			
			else if(operator.equals("between")) {
				ArrayList<Double> radius = getRadiusArray(filterValue);
				for(TwitterData tweet : tweets) {
					
					double distance = Calculator.distance(tweet.getLongit(), tweet.getLatit(), capoluogo.getLongit(), capoluogo.getLatit());
					if(distance > radius.get(0) && distance < radius.get(1))
						tweetsWithinRadius.add(tweet);
				}
			}
			else
				throw new OperatorNotFoundException("L'operatore richiesto non esiste");
			
			return tweetsWithinRadius;
			
		} catch(NoSuchMethodException e) {
			throw new CapoluogoNotFoundException("Il campo inserito non fa riferimento ad alcun capoluogo");
		}	
	}
	private static ArrayList<Double> getRadiusArray(Object filterValue) throws IllegalValueException, NegativeRadiusException {
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
	
	private static double getRadius(Object filterValue) throws IllegalValueException, NegativeRadiusException {
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
}
