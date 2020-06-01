package it.univpm.projectGeoTwitter.utils.filter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import it.univpm.projectGeoTwitter.exception.CapoluogoNotFoundException;
import it.univpm.projectGeoTwitter.exception.OperatorNotFoundException;
import it.univpm.projectGeoTwitter.model.CapoluoghiMarche;
import it.univpm.projectGeoTwitter.model.Geo;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.Calculator;
import it.univpm.projectGeoTwitter.service.CapoluogoGetter;

public class RadiusFilter extends Calculator{

	public static ArrayList<TwitterData> getTweetsWithinRadius(
			HashMap<String, TwitterData> tweetsMap, String capoluogoName, String operator, double[] radius)
					throws SecurityException, IllegalAccessException,
					IllegalArgumentException, InvocationTargetException{
		
		ArrayList<TwitterData> tweetsWithinRadius = new ArrayList<>();
		
		try {
			Geo capoluogo = CapoluogoGetter.getCapoluogo(capoluogoName);
			
			if(operator.equals("inside")) {
				for(TwitterData tweet : tweetsMap.values()) {
					
					double distance = distance(tweet.getLongit(), tweet.getLatit(), capoluogo.getLongit(), capoluogo.getLatit());
					if(distance < radius[0])
						tweetsWithinRadius.add(tweet);
				}
			}
			
			else if(operator.equals("outside")) {
				for(TwitterData tweet : tweetsMap.values()) {
					
					double distance = distance(tweet.getLongit(), tweet.getLatit(), capoluogo.getLongit(), capoluogo.getLatit());
					if(distance > radius[0])
						tweetsWithinRadius.add(tweet);
				}
			}
			
			else if(operator.equals("beetween")) {
				for(TwitterData tweet : tweetsMap.values()) {
					
					double distance = distance(tweet.getLongit(), tweet.getLatit(), capoluogo.getLongit(), capoluogo.getLatit());
					if(distance > radius[0] && distance < radius[1])
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
		/*
		 * {
		 * 		filterValue: [10, 20] //doppio raggio
		 * 		filterValue: [10, 0] //singolo raggio
		 * }
		 */
	}
}
