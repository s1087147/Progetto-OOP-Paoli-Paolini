package it.univpm.projectGeoTwitter.utils.filter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.univpm.projectGeoTwitter.exception.CapoluogoNotFoundException;
import it.univpm.projectGeoTwitter.exception.IllegalValueException;
import it.univpm.projectGeoTwitter.exception.OperatorNotFoundException;
import it.univpm.projectGeoTwitter.model.CapoluoghiMarche;
import it.univpm.projectGeoTwitter.model.Geo;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.Calculator;
import it.univpm.projectGeoTwitter.service.CapoluogoGetter;

public class RadiusFilter extends Calculator{

	public static ArrayList<TwitterData> getTweetsWithinRadius(
			HashMap<String, TwitterData> tweetsMap, String operator, Object filterValue)
					throws SecurityException, IllegalAccessException,
					IllegalArgumentException, InvocationTargetException{
		
		ArrayList<TwitterData> tweetsWithinRadius = new ArrayList<>();
		if(filterValue.getClass() != LinkedHashMap.class)
			throw new IllegalValueException("Il valore inserito non è corretto."); 	//"filterValue" : {"capoluogo" : "esempio", "distanza" : [0, 100]}
		
		HashMap<String, Object> jsonMap = new ObjectMapper().convertValue(filterValue, new TypeReference<HashMap<String, Object>>(){});
		String capoluogoName = jsonMap.get("capoluogo").toString();
		ArrayList<Double> radius = (ArrayList<Double>) jsonMap.get("distance");
		
		try {
			Geo capoluogo = CapoluogoGetter.getCapoluogo(capoluogoName);
			
			if(operator.equals("inside")) {
				for(TwitterData tweet : tweetsMap.values()) {
					
					double distance = distance(tweet.getLongit(), tweet.getLatit(), capoluogo.getLongit(), capoluogo.getLatit());
					if(distance < radius.get(0))
						tweetsWithinRadius.add(tweet);
				}
			}
			
			else if(operator.equals("outside")) {
				for(TwitterData tweet : tweetsMap.values()) {
					
					double distance = distance(tweet.getLongit(), tweet.getLatit(), capoluogo.getLongit(), capoluogo.getLatit());
					if(distance > radius.get(0))
						tweetsWithinRadius.add(tweet);
				}
			}
			
			else if(operator.equals("beetween")) {
				for(TwitterData tweet : tweetsMap.values()) {
					
					double distance = distance(tweet.getLongit(), tweet.getLatit(), capoluogo.getLongit(), capoluogo.getLatit());
					if(distance > radius.get(0) && distance < radius.get(1))
						tweetsWithinRadius.add(tweet);
				}
			}
			else
				throw new OperatorNotFoundException("L'operatore richiesto non esiste");
			
			return tweetsWithinRadius;
		}
		catch(NoSuchMethodException e) {
			throw new CapoluogoNotFoundException("Il campo inserito non fa riferimento ad alcun capoluogo");
		}		
	}
}
