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

/**
 * Classe Service che si occupa di caricare i dati e i metadati relativi ai tweet.
 * @author Davide Paolini
 */
@Service
public class DataService {

	/**
	 * HashMap contenente i dati relativi ai tweet come valori e gli id dei tweet come chiavi.
	 */
	private static HashMap<String, TwitterData> dataRepo = new HashMap<>();
	
	/**
	 * ArrayList contenente l'elenco dei metadati.
	 */
	private static ArrayList<TwitterMetadata> metadata = new ArrayList<>();

	/**
	 * Si occupa di caricare dati e metadati nelle relative strutture.
	 */
	public DataService(){		
		try {
			// Download JSON dall'API Twitter
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
	
	/**
	 * Metodo che restituisce i dati relativi ai tweet.
	 * @return Collection contenente tutti i dati relativi ai tweet.
	 */
	public static Collection<TwitterData> getData(){
		return dataRepo.values();
	}
	
	/**
	 * Metodo che restituisce i metadati.
	 * @return Collection contenente tutti i metadati.
	 */
	public static Collection<TwitterMetadata> getMetadata(){
		return metadata;
	}
	
	/**
	 * Metodo che restituisce dataRepo.
	 * @return HashMap dataRepo.
	 */
	public static HashMap<String, TwitterData> getDataMap(){
		return dataRepo;
	}	
}