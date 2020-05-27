package it.univpm.projectGeoTwitter.service;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.univpm.projectGeoTwitter.model.TwitterData;

public class ArrayListToJsonStringConverter {

	public static String convert(ArrayList<TwitterData> arrayList) {
		
		ObjectMapper objectMapper = new ObjectMapper();
	    String json = "";
	    
		try {
			json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrayList);
	    }
		catch(Exception e) {
			
	    	e.printStackTrace();
	    }
		
		return json;
	}
}
