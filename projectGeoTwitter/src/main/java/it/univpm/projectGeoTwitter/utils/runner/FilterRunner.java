package it.univpm.projectGeoTwitter.utils.runner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import it.univpm.projectGeoTwitter.exception.FilterNotFoundException;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.FiltersImpl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FilterRunner {

	public static Collection<TwitterData> getFilters(Collection<TwitterData> tweets, Object body) {
		
		FiltersImpl filterInstance = new FiltersImpl();						//METODI DI FILTERSIMPL NON STATICI
		Collection<TwitterData> filteredData = tweets;						//INIZIALIZZO A TWEETS?
		
		HashMap<String, Object> jsonMap = new ObjectMapper().convertValue(body, new TypeReference<HashMap<String, Object>>(){});
		ArrayList<Object> filtersList = (ArrayList<Object>)jsonMap.get("filters");
		
		for (Object obj : filtersList) {
			jsonMap = new ObjectMapper().convertValue(obj, new TypeReference<HashMap<String, Object>>(){});
			String filter = jsonMap.get("filter").toString();
			String operator = jsonMap.get("operator").toString().toLowerCase();
			Object filterValue = jsonMap.get("filterValue");

			filter = "filter" + filter.substring(0, 1).toUpperCase() + filter.substring(1).toLowerCase();
			
			try {
				Method filterMethod = (FiltersImpl.class).getDeclaredMethod(filter, Collection.class, String.class,
						Object.class);
				filteredData = (Collection<TwitterData>) filterMethod.invoke(filterInstance, filteredData, operator,
						filterValue);		//PASSO FILTEREDDATA INVECE CHE SU TWEETSMAP

			} catch (NoSuchMethodException | SecurityException e) {
				// GESTIONE ECCEZIONE
				throw new FilterNotFoundException("Il filtro selezionato non è disponibile");
				// e.printStackTrace();
			} catch (IllegalAccessException e) {
				// GESTIONE ECCEZIONE
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// GESTIONE ECCEZIONE
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// GESTIONE ECCEZIONE
				e.printStackTrace();
			}
		}
		return filteredData;
	}
}
