package it.univpm.projectGeoTwitter.service;

import java.util.ArrayList;

public class Calculator {

	private final static long R = 6371; //reaggio della terra (in Km)
	
	public static double mean(ArrayList<Double> arrayDouble) {
		
		double temp = 0;
		
		for(double i: arrayDouble) {
			temp += i;
		}
		
		double mean = temp / (arrayDouble.size());
		
		return mean;
	}

	public static double variance(ArrayList<Double> arrayDouble, double mean) {
	
		double temp = 0;
		
		for(double i: arrayDouble) {
			temp += (i-mean)*(i-mean);
		}
		
		double variance = temp / (arrayDouble.size());
		
		return variance;
	}
	
	public static double distance(double[] coordinates1, double[] coordinates2) {
		
		double longit1 = Math.toRadians(coordinates1[0]);
		double latit1 = Math.toRadians(coordinates1[1]);
		double longit2 = Math.toRadians(coordinates2[0]);
		double latit2 = Math.toRadians(coordinates2[1]);
		
		double distanzaMiglia = R * Math.acos(Math.sin(latit1) * Math.sin(latit2) + Math.cos(latit1) * Math.cos(latit2)
				 * Math.cos(longit1-longit2));
		
		double distanzaKm = 1.60934 * distanzaMiglia;

		return distanzaKm;
	}
}
