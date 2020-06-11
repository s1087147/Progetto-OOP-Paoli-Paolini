package it.univpm.projectGeoTwitter.utils.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.univpm.projectGeoTwitter.exception.URLException;
import it.univpm.projectGeoTwitter.model.Place;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.model.TwitterMetadata;

/**
 * Classe che si occupa della gestione dei Json.
 * @author Davide Paolini
 */
public class JsonManager {
	
	/**
	 * Stringa che rappresenta il percorso del file di testo contenente gli Id dei tweet da usare nella chiamata all'API di Twitter.
	 */
	final static String idpath = new File("src/main/resources/id.txt").getAbsolutePath();
	
	/**
	 * URL da usare per effettuare la chiamata all'API di Twitter.
	 */
	static String url;
	
	public JsonManager() {}
	
	/**
	 * Metodo che effettua la chiamata all'API di Twitter.
	 * 
	 * @throws IOException quando fallisce la lettura degli Id o del Json fornito da Twitter.
	 * @throws URLException quando fallisce la chiamata all'API di Twitter.
	 * 
	 * @return String rappresentante il Json fornito da Twitter in risposta alla chiamata effettuata.
	 */
	public static String getJson() throws IOException, URLException {
		url = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/labs/2/tweets"
				+ "?ids=" + readIds()				//Id dei tweet
				+ "&tweet.fields=geo"				//Ottieni dati geo
				+ "&expansions=geo.place_id"		//Includi informazioni sulla località 	
				+ "&place.fields=full_name";		//Mostra nome completo della località
		String content = "";
		String line = "";
		try {
		URLConnection connection = new URL(url).openConnection();
		connection.addRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
		InputStream input = connection.getInputStream();

		while ((line = new BufferedReader(new InputStreamReader(input)).readLine()) != null) {
			content += line;
		}
		} catch (IOException ioe) {
			if(ioe.getMessage().contains("HTTP response code"))
				throw new URLException(ioe.getMessage());
			throw ioe;
		}
		
		return content;
	}
	
	/**
	 * Metodo che carica i dati relativi ai tweet in una Map.
	 * @param json stringa in formato Json contenente i dati.
	 * @param data Map in cui effettuare il caricamento dei dati.
	 * @throws JsonProcessingException quando si verifica un errore nella deserializzazione del Json.
	 */
	public static void loadData(String json, Map<String, TwitterData> data) throws JsonProcessingException{
		ArrayList<TwitterData> appoggio = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		
		JsonNode tree = mapper.readTree(json);
		JsonNode node = tree.findValue("data");
		json = node.toString();		

		appoggio = mapper.readValue(json, new TypeReference<ArrayList<TwitterData>>() {});
		
		JsonNode place = tree.findValue("includes").findValue("places");
		json = place.toString();
		ArrayList<Place> placesArray = mapper.readValue(json, new TypeReference<ArrayList<Place>>() {});
		Map<String, Place> placesMap = placesArray.stream().collect(Collectors.toMap(Place::getId, Function.identity()));		
		
		for (TwitterData tweet : appoggio) {
			tweet.setPlace(placesMap.get(tweet.getPlace_id()).getFull_name());
			data.put(tweet.getId(), tweet);
		}
	}
	
	/**
	 * Metodo che carica i metadati in una Collection.
	 * @param metadata Collection in cui effettuare il caricamento dei metadati.
	 */
	public static void loadMetadata(Collection<TwitterMetadata> metadata) {
		metadata.add(new TwitterMetadata("id", "Numero identificativo del tweet", "String"));
		metadata.add(new TwitterMetadata("text", "Testo del tweet", "String"));
		metadata.add(new TwitterMetadata("place_id", "Identificativo della località da cui è stato inviato il tweet", "String"));
		metadata.add(new TwitterMetadata("place", "Località e regione da cui è stato inviato il tweet", "String"));
		metadata.add(new TwitterMetadata("longit", "Longitudine", "double"));
		metadata.add(new TwitterMetadata("latit", "Latitudine", "double"));
	}
	
	/**
	 * Metodo che legge la sequenza di Id da usare nella chiamata all'API di Twitter.
	 * 
	 * @throws IOException quando si verifica un errore nella lettura del file contenente gli Id.
	 * 
	 * @return String contenente gli Id separati dal carattere ','.
	 */
	private static String readIds() throws IOException{
		String line = "";
		BufferedReader fileReader = new BufferedReader(new FileReader(new File(idpath)));
		line = fileReader.readLine();
		return line;
	}	
}