package it.univpm.projectGeoTwitter.utils.stats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import it.univpm.projectGeoTwitter.model.Geo;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.Calculator;

public class GeoMaxDistance extends Calculator {

	public static double getMax(HashMap<String, TwitterData> tweetsMap, Geo capoluogo) {
		
		ArrayList<Double> distances = new ArrayList<>();
		double capoluogoLongit = capoluogo.getLongit();
		double capoluogoLatit = capoluogo.getLatit();
		
		for(TwitterData tweet : tweetsMap.values()) {
			distances.add(distance(tweet.getLongit(), tweet.getLatit(), capoluogoLongit, capoluogoLatit));
		}
		
		return Collections.max(distances);
	}
}
