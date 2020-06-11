package it.univpm.projectGeoTwitter.service;

import java.awt.geom.Path2D;
import java.util.ArrayList;

import it.univpm.projectGeoTwitter.exception.IllegalValueException;

/**
 * Classe adibita all'espletamento di calcoli algebrici e istanziamento di oggetti Path2D.
 * @author Francesco Paoli Leonardi
 */
public class Calculator {

	/**
	 * long rappresentante il raggio del pianeta Terra (in Km).
	 */
	private final static long R = 6371;
	
	/**
	 * Metodo che calcola la media di tutti i valori contenuti in un ArrayList<Double>.
	 * @param arrayDouble contenente i valori su cui calcolare la media.
	 * 
	 * @return double rappresentante la media dei valori contenuti in arrayDouble.
	 */
	public static double mean(ArrayList<Double> arrayDouble) {
		
		double temp = 0;
		
		for(double i: arrayDouble) {
			temp += i;
		}
		
		double mean = temp / (arrayDouble.size());
		
		return mean;
	}

	/**
	 * Metodo che calcola la varianza di tutti i valori contenuti in un ArrayList<Double>.
	 * @param arrayDouble contenente i valori su cui calcolare la media.
	 * @param mean media di tutti i valori contenuti in arrayDouble.
	 * 
	 * @return double rappresentante la varianza dei valori contenuti in arrayDouble.
	 */
	public static double variance(ArrayList<Double> arrayDouble, double mean) {
	
		double temp = 0;
		
		for(double i: arrayDouble) {
			temp += (i-mean)*(i-mean);
		}
		
		double variance = temp / (arrayDouble.size());
		
		return variance;
	}
	
	/**
	 * Metodo che calcola la distanza geodetica tra due punti geografici.
	 * @param longit1 longitudine del primo punto.
	 * @param latit1 latitudine del primo punto.
	 * @param longit2 longitudine del secondo punto.
	 * @param latit2 latitudine del secondo punto.
	 * 
	 * @return double rappresentante la distanza tra i due punti geografici.
	 */
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
	
	/**
	 * Metodo che istanzia un oggetto Path2D rappresentante il poligono che delimita la regione Marche.
	 * @param arrayLongit contenente le longitudini dei punti geografici con cui si istanzia il poligono
	 * delimitante le Marche.
	 * @param arrayLatit contenente le latitudini dei punti geografici con cui si istanzia il poligono
	 * delimitante le Marche.
	 * 
	 * @return Path2D rappresentante il poligono che delimita la regione Marche.
	 * 
	 * @throws IllegalValueException quando uno o più valori delle coordinate fornite non è valido.
	 */
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
