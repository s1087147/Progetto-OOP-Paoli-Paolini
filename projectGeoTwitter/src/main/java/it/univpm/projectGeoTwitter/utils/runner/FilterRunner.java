package it.univpm.projectGeoTwitter.utils.runner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import it.univpm.projectGeoTwitter.exception.FilterNotFoundException;
import it.univpm.projectGeoTwitter.exception.GenericErrorException;
import it.univpm.projectGeoTwitter.exception.IllegalValueException;
import it.univpm.projectGeoTwitter.exception.OperatorNotFoundException;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.FiltersImpl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FilterRunner extends FiltersImpl {

	public static Collection<TwitterData> getFilters(Collection<TwitterData> tweets, Object body)
			throws IllegalValueException, GenericErrorException, InvocationTargetException, FilterNotFoundException,
				OperatorNotFoundException {
		
		FilterRunner filterInstance = new FilterRunner();
		Collection<TwitterData> filteredData = tweets;
		
		HashMap<String, Object> jsonMap = new ObjectMapper().convertValue(body, new TypeReference<HashMap<String, Object>>(){});
		ArrayList<Object> filtersList = (ArrayList<Object>)jsonMap.get("filters");
		
		for (Object obj : filtersList) {
			
			jsonMap = new ObjectMapper().convertValue(obj, new TypeReference<HashMap<String, Object>>(){});
			String filter = jsonMap.get("filter").toString();
			filter = "filter" + filter.substring(0, 1).toUpperCase() + filter.substring(1).toLowerCase();
			String operator = jsonMap.get("operator").toString().toLowerCase();
				
			Method filterMethod;
			
			try {
				if(jsonMap.containsKey("filterValue")) {
					Object filterValue = jsonMap.get("filterValue");
					filterMethod = (FiltersImpl.class).getDeclaredMethod(filter, Collection.class, String.class, Object.class);
					filteredData = (Collection<TwitterData>) filterMethod.invoke(filterInstance, filteredData, operator, filterValue);
				}
				else {
					filterMethod = (FiltersImpl.class).getDeclaredMethod(filter, Collection.class, String.class);
					filteredData = (Collection<TwitterData>) filterMethod.invoke(filterInstance, filteredData, operator);
				}
				
			} catch (NoSuchMethodException e) {
				throw new FilterNotFoundException("Nome del filtro non valido");
				
			} catch (IllegalAccessException | IllegalArgumentException e) {
				throw new GenericErrorException("Si è vericato un errore interno generico durante l'esecuzione.");
			}
		}
		return filteredData;
	}
}
