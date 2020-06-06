package it.univpm.projectGeoTwitter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.univpm.projectGeoTwitter.service.DataService;
import it.univpm.projectGeoTwitter.utils.runner.StatsRunner;

public class TestGeoTwitter {

	//private String[] filters;
	//private String filter;
	//private String operator;
	//Optional<Object> body;
	private String bodyRequest;
	
	@BeforeEach
	void setUp() throws Exception {
		//filter = "marche";
		//operator = "inside";
		//filters = new String[] {filter, operator};
		//body = filters;
		bodyRequest = "{\n" + 
				"	\"filters\": [\n" + 
				"		{\n" + 
				"			\"filter\": \"marche\",\n" + 
				"			\"operator\": \"inside\"\n" + 
				"		}\n" + 
				"	]\n" + 
				"}";
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Test
	@DisplayName("Test count tweets inside Marche")
	void testInsideMarche() {
		/*
		with().
			body(bodyRequest).
		when().
			request("POST", "/stats").
		then().
			statusCode(200).assertThat().body();
		*/
		when().
			request("POST", "/stats").
		then().
			statusCode(200).assertThat().body("tweetsInsideMarche", equalTo(8));
		//assertEquals(8, StatsRunner.getStats(DataService.getData(), "", filters));
	}
}
