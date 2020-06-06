package it.univpm.projectGeoTwitter.service;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;

import it.univpm.projectGeoTwitter.exception.URLException;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.model.TwitterMetadata;
import it.univpm.projectGeoTwitter.utils.json.JsonManager;

@Service
public class DataService {

	private static HashMap<String, TwitterData> dataRepo = new HashMap<>();
	
	private static ArrayList<TwitterMetadata> metadata = new ArrayList<>();

	public DataService(){
		
		try {
			// Download JSON
			String json = JsonManager.getJson();
			// Caricamento TwitterData
			JsonManager.loadData(json, dataRepo);

		} catch (NullPointerException npException) {
			npException.printStackTrace();
			System.err.println("Errore fatale nella creazione del DataService!");
			System.exit(1);
		} catch (URLException urlException) {
			urlException.printStackTrace();
			System.err.println("Errore fatale nella richiesta all'API Twitter!");
			System.exit(1);
		} catch (JsonProcessingException jsonException) {
			jsonException.printStackTrace();
			System.err.println("Errore fatale nella lettura del JSON!");
			System.exit(1);
		} catch (IOException ioException) {
			ioException.printStackTrace();
			System.err.println("Errore nella lettura degli id.");
			System.exit(1);
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
}