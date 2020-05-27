package it.univpm.projectGeoTwitter.service;

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

@Service
public class DataService {
		private static HashMap<Integer, TwitterData> dataRepo = new HashMap<>();	
		
		public DataService() {
			//Download JSON
			String json = JsonDownloader.getJson();
			System.out.println("JSON:" + json);
			//Caricamento dataSet
			ArrayList<TwitterData> appoggio = new ArrayList<>();
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);  //??
			try {			
				JsonNode node = mapper.readTree(json);
				System.out.println("Node: " + node.toString());
				JsonNode data = node.findValue("data");
				json = data.toString();
				
				appoggio = mapper.readValue(json, new TypeReference<ArrayList<TwitterData>>(){});
				for(TwitterData tweet : appoggio) {
					int key = tweet.getId().hashCode();
					dataRepo.put(key, tweet);
				}
			} catch (JsonProcessingException jsonException) {
				//GESTIONE ECCEZIONE
				jsonException.printStackTrace();
			}
		}
		
		public Collection<TwitterData> test(){
			System.out.println(dataRepo);
			return null;
		}
}
