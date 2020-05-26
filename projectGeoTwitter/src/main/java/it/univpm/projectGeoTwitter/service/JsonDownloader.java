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

class JsonDownloader {
	
	final static String idpath = new File("src/main/resources/id.txt").getAbsolutePath(); 				//Inserire path per il documento contenente gli id
	static String url = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/labs/2/tweets?ids="+readIds()+"&tweet.fields=geo&place.fields=name&user.fields=location";;
	
	public JsonDownloader() {}
	
	static String getJson() {
		String content = "";
		String line = "";
		
		try {
			URLConnection connection = new URL(url).openConnection();
			connection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			InputStream input = connection.getInputStream();
			
			try(BufferedReader reader = new BufferedReader(new InputStreamReader(input))){
				while((line = reader.readLine()) != null) {
					content += line;
				}
			} catch (Exception e) {
				//GESTIONE ECCEZIONI
			}
		} catch (Exception e) {
			//GESTIONE ECCEZIONI
		}
		return content;
	}
	
	private static String readIds() {
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
