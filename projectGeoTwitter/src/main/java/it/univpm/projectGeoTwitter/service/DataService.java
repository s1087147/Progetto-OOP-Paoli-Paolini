package it.univpm.projectGeoTwitter.service;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import it.univpm.projectGeoTwitter.model.TwitterData;

@Service
public class DataService {
		private static HashMap<Integer, TwitterData> dataRepo = new HashMap<>();
		public DataService() {
			//Download JSON
			String json = JsonDownloader.getJson();
			System.out.println("JSON:" + json);
			//Caricamento dataSet			
		}
		
		public Collection<TwitterData> test(){
			return null;
		}
}
