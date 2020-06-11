package it.univpm.projectGeoTwitter;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.univpm.projectGeoTwitter.exception.IllegalValueException;
import it.univpm.projectGeoTwitter.exception.OperatorNotFoundException;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.DataService;
import it.univpm.projectGeoTwitter.utils.filter.RadiusFilter;

class TestGeoTwitter {
	
	DataService dataService = new DataService();
	ArrayList<TwitterData> tweets = new ArrayList<>();

	@BeforeEach
	void setUp() throws Exception {
		tweets.addAll(DataService.getData());		
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Test
	void filterTest() {
		LinkedHashMap<String, Object> filter = new LinkedHashMap<>();		
		filter.put("capoluogo", "Ancona");
		filter.put("distanza", 10);
		
		ArrayList<Number> radius = new ArrayList<Number>();
		radius.add(15);
		radius.add(100);
		filter.put("distanza", radius);
		

		HashMap<String, TwitterData> tweetsMap = DataService.getDataMap();
		ArrayList<TwitterData> result = new ArrayList<>();
		result.add(tweetsMap.get("1264940365003571200"));
		result.add(tweetsMap.get("1265031755867643905"));
		result.add(tweetsMap.get("1264988123957788674"));
				
		try {
			assertEquals(result, RadiusFilter.getTweetsWithRadius(tweets, "between", filter));
		} catch (IllegalValueException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void illegalValueExceptionTest1() {
		LinkedHashMap<String, Object> filter = new LinkedHashMap<>();		
		filter.put("capoluogo", "Milano");								//Capoluogo non corrispondente a nessuna delle 5 province marchigiane
		filter.put("distanza", 10);
		
		IllegalValueException e = assertThrows(IllegalValueException.class, () -> {
			RadiusFilter.getTweetsWithRadius(tweets, "outside", filter);
			});
		assertEquals("Il parametro inserito non fa riferimento ad alcun capoluogo.", e.getMessage());
	}
	
	@Test
	void illegalValueExceptionTest2() {
		LinkedHashMap<String, Object> filter = new LinkedHashMap<>();		
		filter.put("capoluogo", "Ancona");
		filter.put("distanza", "100");									//Valore della distanza non corrispondente ad un numero
		
		IllegalValueException e = assertThrows(IllegalValueException.class, () -> {
			RadiusFilter.getTweetsWithRadius(tweets, "inside", filter);
			});
		assertEquals("Valori della distanza non validi.", e.getMessage());
	}
	
	@Test
	void illegalValueExceptionTest3() {
		LinkedHashMap<String, Object> filter = new LinkedHashMap<>();		
		filter.put("capoluogo", "Ancona");
		filter.put("distanza", -50);									//Valore della distanza negativo
		
		IllegalValueException e = assertThrows(IllegalValueException.class, () -> {
			RadiusFilter.getTweetsWithRadius(tweets, "outside", filter);
			});
		assertEquals("Non sono ammessi valori negativi per la distanza.", e.getMessage());
	}
	
	@Test
	void illegalValueExceptionTest4() {
		LinkedHashMap<String, Object> filter = new LinkedHashMap<>();		
		filter.put("capoluogo", "Ancona");
		filter.put("distanza", 10);										//Non viene fornito un array di distanza con l'operatore between
		
		IllegalValueException e = assertThrows(IllegalValueException.class, () -> {
			RadiusFilter.getTweetsWithRadius(tweets, "between", filter);
			});
		assertEquals("Valori della distanza non validi.", e.getMessage());
	}

	@Test
	void illegalValueExceptionTest5() {
		LinkedHashMap<String, Object> filter = new LinkedHashMap<>();
		filter.put("capoluogo", "Ancona");
		
		ArrayList<Number> radius = new ArrayList<Number>();
		radius.add(1.3);
		radius.add(120);
		radius.add(200);												//Viene fornito un array di dimensione diversa da 2 con l'operatore between
		filter.put("distanza", radius);

		IllegalValueException e = assertThrows(IllegalValueException.class, () -> {
			RadiusFilter.getTweetsWithRadius(tweets, "between", filter);
		});
		assertEquals("Sono solamente ammessi 2 valori per la distanza.", e.getMessage());
	}
	
	@Test
	void operatorNotFoundExceptionTest() {
		LinkedHashMap<String, Object> filter = new LinkedHashMap<>();		
		filter.put("capoluogo", "Ancona");
		filter.put("distanza", 10);										
		
		OperatorNotFoundException e = assertThrows(OperatorNotFoundException.class, () -> {
			RadiusFilter.getTweetsWithRadius(tweets, "maggiore", filter);			//Operatore non esistente
			});
		assertEquals("L'operatore richiesto non esiste.", e.getMessage());
	}	
}