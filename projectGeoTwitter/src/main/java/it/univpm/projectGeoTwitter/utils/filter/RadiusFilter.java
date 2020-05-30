package it.univpm.projectGeoTwitter.utils.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import it.univpm.projectGeoTwitter.exception.CapoluogoNotFoundException;
import it.univpm.projectGeoTwitter.model.CapoluoghiMarche;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.Calculator;

public class RadiusFilter extends Calculator{

	public static ArrayList<TwitterData> getTweetsWithinRadius(
			HashMap<String, TwitterData> tweetsMap, String capoluogo, double radius) throws CapoluogoNotFoundException{
		
		ArrayList<TwitterData> tweetsWithinRadius = new ArrayList<>();
		int index = -1;
		
		try {
			
			index = Arrays.asList(CapoluoghiMarche.getCapoluoghi()).indexOf(capoluogo);
		}
		catch(CapoluogoNotFoundException cnfe) {										//?????
			
			throw new CapoluogoNotFoundException(/*messaggio*/);
		}
		
		double[] capoluogoCoordinates = {
				CapoluoghiMarche.getCapoluoghiLongit()[index],
				CapoluoghiMarche.getCapoluoghiLatit()[index]};
		
		for(TwitterData tweet : tweetsMap.values()) {
			
			double[] tweetCoordinates = {tweet.getLongit(), tweet.getLatit()};			//GETTER PER ARRAY ASSENTE
			
			if(Calculator.distance(tweetCoordinates, capoluogoCoordinates) < radius) {
				
				tweetsWithinRadius.add(tweet);
			}
		}
		
		return tweetsWithinRadius;
	}
}
