package it.univpm.projectGeoTwitter.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.projectGeoTwitter.exception.BoundingBoxVertexException;
import it.univpm.projectGeoTwitter.exception.CapoluogoNotFoundException;
import it.univpm.projectGeoTwitter.exception.CoordinatesException;
import it.univpm.projectGeoTwitter.exception.FilterNotFoundException;
import it.univpm.projectGeoTwitter.exception.GenericErrorException;
import it.univpm.projectGeoTwitter.exception.IllegalValueException;
import it.univpm.projectGeoTwitter.exception.NegativeRadiusException;
import it.univpm.projectGeoTwitter.service.DataService;
import it.univpm.projectGeoTwitter.utils.runner.FilterRunner;
import it.univpm.projectGeoTwitter.utils.runner.StatsRunner;

@RestController
public class GeoTwitterController {

	@Autowired
	DataService dataService;
	
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public ResponseEntity<Object> getData() {
		
		return new ResponseEntity<>(dataService.getData(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/metadata", method = RequestMethod.GET)
	public ResponseEntity<Object> getMetadata() {
		
		return new ResponseEntity<>(dataService.getMetadata(), HttpStatus.OK);
	}
	 
	@RequestMapping(value="/stats", method = RequestMethod.POST) //HO SOSTITUITO "GET" CON "POST"
	public ResponseEntity<Object> getStats(
			@RequestParam(name = "capoluogo") Optional<String> capoluogo, @RequestBody Optional<Object> body) throws SecurityException,
				CapoluogoNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		try {
			return new ResponseEntity<>(StatsRunner.getStats(dataService.getData(), capoluogo, body), HttpStatus.OK);
			
		} catch(Exception e) {
			return new ResponseEntity<>("Exception throwed:\n" + e, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/filter", method = RequestMethod.POST)
	public ResponseEntity<Object> getFilteredTweets(@RequestBody Object body) throws BoundingBoxVertexException,
	NegativeRadiusException, IllegalValueException, CoordinatesException, GenericErrorException, InvocationTargetException,
	CapoluogoNotFoundException, FilterNotFoundException {
		
		return new ResponseEntity<>(FilterRunner.getFilters(dataService.getData(), body), HttpStatus.OK);
	}
	
	 /*
	  * {
	  * "filters":[
	  * 	{
	  * 	filter: String
	  * 	operator: String
	  * 	filterValue: Object		//Capoluogo e distanza unici dati in italiano
	  * 	},
	  * 	{...}
	  * ]
	  * }
	  * 
	 */
	
}