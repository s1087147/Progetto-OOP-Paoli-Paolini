package it.univpm.projectGeoTwitter.utils.runner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.FiltersImpl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FilterRunner {

	public static Collection<TwitterData> getFilters(HashMap<String, TwitterData> tweetsMap, Object body) {
		
		FiltersImpl filterInstance = new FiltersImpl();			//METODI DI FILTERSIMPL NON STATICI
		Collection<TwitterData> filteredData = null;
		HashMap<String, Object> jsonMap = new ObjectMapper().convertValue(body, new TypeReference<HashMap<String, Object>>(){});
		String filter = jsonMap.get("filter").toString();
		String operator = jsonMap.get("operator").toString().toLowerCase();
		Object filterValue = jsonMap.get("filterValue");		

		filter = "filter" + filter.substring(0, 1).toUpperCase() + filter.substring(1).toLowerCase();
		try {
			Method filterMethod = (FiltersImpl.class).getDeclaredMethod(filter, HashMap.class, String.class, Object.class);
			filteredData = (Collection<TwitterData>) filterMethod.invoke(filterInstance, tweetsMap, operator, filterValue);
		} catch (NoSuchMethodException | SecurityException e) {
			//GESTIONE ECCEZIONE
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			//GESTIONE ECCEZIONE
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			//GESTIONE ECCEZIONE
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			//GESTIONE ECCEZIONE
			e.printStackTrace();
		}
		return filteredData;
	}
}
