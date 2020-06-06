package it.univpm.projectGeoTwitter.service;

import java.awt.geom.Path2D;
import java.util.ArrayList;

import it.univpm.projectGeoTwitter.exception.CoordinatesException;
import it.univpm.projectGeoTwitter.exception.IllegalValueException;

public class Calculator {

	private final static long R = 6371; //raggio della terra (in Km)
	
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
	
	public static double distance(double longit1, double latit1, double longit2, double latit2) {
		
		longit1 = Math.toRadians(longit1);
		latit1 = Math.toRadians(latit1);
		longit2 = Math.toRadians(longit2);
		latit2 = Math.toRadians(latit2);
		
		double distanzaMiglia = R * Math.acos(Math.sin(latit1) * Math.sin(latit2) + Math.cos(latit1) * Math.cos(latit2)
				 * Math.cos(longit1-longit2));
		
		double distanzaKm = 1.60934 * distanzaMiglia;
		
		return distanzaKm;
	}
	
	public static Path2D polygonGenerator(double[] arrayLongit, double[] arrayLatit) throws IllegalValueException {
		
		Path2D poligono = new Path2D.Double();
		
		poligono.moveTo(arrayLongit[0], arrayLatit[0]);
		for(int i = 1; i < arrayLongit.length; i++) {
			if(arrayLongit[i] < -180 ||  arrayLongit[i] > 180 || arrayLatit[i] < -90 || arrayLatit[i] > 90) {
				throw new IllegalValueException("Una o più delle coordinate inserite non è valida.");
			}
			else {
				poligono.lineTo(arrayLongit[i], arrayLatit[i]);
			}
		}
		poligono.closePath();
		
		return poligono;
	}
}
