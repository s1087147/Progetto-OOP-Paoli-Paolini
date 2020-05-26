package it.univpm.projectGeoTwitter.service;

import java.util.ArrayList;

public class Calculator {

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
		
		return Math.sqrt(Math.pow((coordinates1[0] - coordinates2[0]), 2) + Math.pow((coordinates1[1] - coordinates2[1]), 2));
	}
}
