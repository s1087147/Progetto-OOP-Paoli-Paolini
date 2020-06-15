package it.univpm.projectGeoTwitter.utils.filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.univpm.projectGeoTwitter.exception.IllegalValueException;
import it.univpm.projectGeoTwitter.exception.OperatorNotFoundException;
import it.univpm.projectGeoTwitter.model.Geo;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.Calculator;
import it.univpm.projectGeoTwitter.service.CapoluogoGetter;
import it.univpm.projectGeoTwitter.service.FilterValueManager;

/**
 * Classe che gestisce il filtro sulla distanza.
 * @author Davide Paolini
 * @author Francesco Paoli Leonardi
 */
public class RadiusFilter {

	/**
	 * Metodo che applica un filtro sulla distanza.
	 * @param tweets Collection dei tweet su cui eseguire il filtro.
	 * @param operator stringa che indica l'operatore del filtro.
	 * @param filterValue valore/valori della distanza.
	 * 
	 * @throws OperatorNotFoundException quando il nome dell'operatore fornito non è valido. 
	 * @throws IllegalValueException i valori forniti dall'utente non possono essere utilizzati per creare un intervallo di distanza.
	 * 
	 * @return {@literal ArrayList<TwitterData>} contenente tutti gli elementi di tweets che rispettano la condizione imposta dal filtro.
	 */
	public static ArrayList<TwitterData> getTweetsWithRadius(Collection<TwitterData> tweets, String operator,
			Object filterValue) throws /*IllegalAccessException, InvocationTargetException,*/ OperatorNotFoundException, IllegalValueException { //TEST ECCEZIONI

		ArrayList<TwitterData> tweetsWithinRadius = new ArrayList<>();
		if (filterValue.getClass() != LinkedHashMap.class)
			throw new IllegalValueException("Il valore inserito non è corretto.");

		HashMap<String, Object> jsonMap = new ObjectMapper().convertValue(filterValue,
				new TypeReference<HashMap<String, Object>>() {});

		String capoluogoName = jsonMap.get("capoluogo").toString();
		filterValue = jsonMap.get("distanza");

		Geo capoluogo = CapoluogoGetter.getCapoluogo(capoluogoName);

		if (operator.equals("less")) {
			double radius = FilterValueManager.getRadius(filterValue);
			for (TwitterData tweet : tweets) {

				double distance = Calculator.distance(tweet.getLongit(), tweet.getLatit(), capoluogo.getLongit(),
						capoluogo.getLatit());
				if (distance < radius)
					tweetsWithinRadius.add(tweet);
			}
		}

		else if (operator.equals("greater")) {
			double radius = FilterValueManager.getRadius(filterValue);
			for (TwitterData tweet : tweets) {

				double distance = Calculator.distance(tweet.getLongit(), tweet.getLatit(), capoluogo.getLongit(),
						capoluogo.getLatit());
				if (distance > radius)
					tweetsWithinRadius.add(tweet);
			}
		}

		else if (operator.equals("between")) {
			ArrayList<Double> radius = FilterValueManager.getRadiusArray(filterValue);
			for (TwitterData tweet : tweets) {

				double distance = Calculator.distance(tweet.getLongit(), tweet.getLatit(), capoluogo.getLongit(),
						capoluogo.getLatit());
				if (distance > radius.get(0) && distance < radius.get(1))
					tweetsWithinRadius.add(tweet);
			}
		} else
			throw new OperatorNotFoundException("L'operatore richiesto non esiste.");

		return tweetsWithinRadius;
	}
}