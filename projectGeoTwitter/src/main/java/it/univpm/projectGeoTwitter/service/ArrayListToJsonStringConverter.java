package it.univpm.projectGeoTwitter.service;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.univpm.projectGeoTwitter.model.TwitterData;

public class ArrayListToJsonStringConverter {

	public static String convert(ArrayList<TwitterData> arrayList) {
		
		ObjectMapper objectMapper = new ObjectMapper();
	    String json = "";
	    
		try {
			json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrayList);
	    }
		catch(JsonProcessingException jsonException) {
			//Gestione Eccezione
			System.err.println("Errore nella serializzazione.");
	    	jsonException.printStackTrace();
	    }
		
		return json;
	}
}
