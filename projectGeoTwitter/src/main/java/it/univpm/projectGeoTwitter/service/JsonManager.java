package it.univpm.projectGeoTwitter.service;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.univpm.projectGeoTwitter.exception.URLException;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.model.TwitterMetadata;

class JsonManager {
	
	final static String idpath = new File("src/main/resources/id.txt").getAbsolutePath(); 				//Inserire path per il documento contenente gli id
	static String url = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/labs/2/tweets"
						+ "?ids=" + readIds()				//Id dei tweet
						+ "&tweet.fields=geo"				//Ottieni dati geo
						+ "&expansions=geo.place_id"		//Includi informazioni sulla località 	
						+ "&place.fields=full_name";		//Mostra nome completo della località
	
	public JsonManager() {}
	
	static String getJson() throws IOException, URLException{
		String content = "";
		String line = "";
		URLConnection connection = new URL(url).openConnection();
		connection.addRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
		InputStream input = connection.getInputStream();

		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		while ((line = reader.readLine()) != null) {
			content += line;
		}
		return content;
	}
	
	static void loadData(String json, Map<String, TwitterData> data) throws JsonProcessingException{
		ArrayList<TwitterData> appoggio = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // VERIFICARE SE NECESSARIO
		JsonNode node = mapper.readTree(json).findValue("data");
		json = node.toString();

		appoggio = mapper.readValue(json, new TypeReference<ArrayList<TwitterData>>() {});
		for (TwitterData tweet : appoggio) {
			data.put(tweet.getId(), tweet);
		}
	}
	
	static void loadMetadata(Collection<TwitterMetadata> metadata) {
		metadata.add(new TwitterMetadata("id", "Numero identificativo del tweet", "String"));
		metadata.add(new TwitterMetadata("text", "Testo del tweet", "String"));
		metadata.add(new TwitterMetadata("place_id", "Identificativo della località da cui è stato inviato il tweet", "String"));
		metadata.add(new TwitterMetadata("longit", "Longitudine", "double"));
		metadata.add(new TwitterMetadata("latit", "Latitudine", "double"));
	}
	
	private static String readIds(){
		String line = "";
		try (BufferedReader fileReader = new BufferedReader(new FileReader(new File(idpath)))) {
			line = fileReader.readLine();
		} catch (FileNotFoundException fileNotFoundException) {
			// GESTIONE ECCEZIONE FILE
		} catch (IOException ioException) {
			// GESTIONE ECCEZIONE IO
		}
		return line;
	}	
}