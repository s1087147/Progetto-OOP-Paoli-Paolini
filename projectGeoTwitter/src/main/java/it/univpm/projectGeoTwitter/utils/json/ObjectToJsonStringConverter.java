package it.univpm.projectGeoTwitter.utils.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectToJsonStringConverter {

	public static String convert(Object obj) {
		
		ObjectMapper objectMapper = new ObjectMapper();
	    String json = "";
	    
		try {
			json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
	    }
		catch(JsonProcessingException jsonException) {
			//Gestione Eccezione
			System.err.println("Errore nella serializzazione.");
	    	jsonException.printStackTrace();
	    }
		
		return json;
	}
}
