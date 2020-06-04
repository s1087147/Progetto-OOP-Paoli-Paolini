package it.univpm.projectGeoTwitter.utils.runner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import it.univpm.projectGeoTwitter.exception.BoundingBoxVertexException;
import it.univpm.projectGeoTwitter.exception.FilterNotFoundException;
import it.univpm.projectGeoTwitter.exception.NegativeRadiusException;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.FiltersImpl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FilterRunner {

	public static Collection<TwitterData> getFilters(Collection<TwitterData> tweets, Object body) throws
		SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, BoundingBoxVertexException, NegativeRadiusException {
		
		FiltersImpl filterInstance = new FiltersImpl();						//METODI DI FILTERSIMPL NON STATICI
		Collection<TwitterData> filteredData = tweets;						//INIZIALIZZO A TWEETS?
		
		HashMap<String, Object> jsonMap = new ObjectMapper().convertValue(body, new TypeReference<HashMap<String, Object>>(){});
		ArrayList<Object> filtersList = (ArrayList<Object>)jsonMap.get("filters");
		
		for (Object obj : filtersList) {
			try {
			jsonMap = new ObjectMapper().convertValue(obj, new TypeReference<HashMap<String, Object>>(){});
			String filter = jsonMap.get("filter").toString();
			String operator = jsonMap.get("operator").toString().toLowerCase();
			Object filterValue = jsonMap.get("filterValue");

			filter = "filter" + filter.substring(0, 1).toUpperCase() + filter.substring(1).toLowerCase();
			
			Method filterMethod = (FiltersImpl.class).getDeclaredMethod(filter, Collection.class, String.class, Object.class);
			filteredData = (Collection<TwitterData>) filterMethod.invoke(filterInstance, filteredData, operator, filterValue);
			} catch (NoSuchMethodException nsme) {
				throw new FilterNotFoundException("Nome del filtro non valido");
			}
			/*											//USARE PER DIMINUIRE I THROWS 
			catch (IllegalAccessException e) {
				throw e;
				
			} catch (IllegalArgumentException e) {
				throw e;
				
			} catch (InvocationTargetException e) {
				throw e;
			}
			*/
		}
		return filteredData;
	}
}
