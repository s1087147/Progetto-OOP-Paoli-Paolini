package it.univpm.projectGeoTwitter.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.model.TwitterMetadata;

@Service
public class DataService {

	private static HashMap<Integer, TwitterData> dataRepo = new HashMap<>();
	
	private static ArrayList<TwitterMetadata> metadata = new ArrayList<>();

	public DataService(){
		// Download JSON
		try {
		String json = JsonManager.getJson();
		// Caricamento TwitterData
		JsonManager.loadData(json, dataRepo);
		} catch (JsonProcessingException e) {			//extends IOException
			//GESTIONE ECCEZIONE
			System.err.println("Errore nella letture del JSON.");
		} catch (IOException ioException){
			//GESTIONE ECCEZIONE
			System.err.println("Errore nella lettura degli id.");
		}
		//Caricamento Metadata
		JsonManager.loadMetadata(metadata);
	}
	
	public static Collection<TwitterData> getData(){
		return dataRepo.values();
		//return JsonData(dataRepo);
	}
	
	public static Collection<TwitterMetadata> getMetadata(){
		return metadata;
	}

	public static HashMap<Integer, TwitterData> getDataRepo() {						//Hashmap o Collection?
		return dataRepo;
	}
}