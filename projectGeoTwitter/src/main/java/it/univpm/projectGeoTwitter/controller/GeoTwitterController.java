package it.univpm.projectGeoTwitter.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.node.ArrayNode;

import it.univpm.projectGeoTwitter.exception.CapoluogoNotFoundException;
import it.univpm.projectGeoTwitter.model.CapoluoghiMarche;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.ObjectToJsonStringConverter;
import it.univpm.projectGeoTwitter.service.DataService;
import it.univpm.projectGeoTwitter.service.FiltersImpl;
import it.univpm.projectGeoTwitter.service.StatsImpl;
import it.univpm.projectGeoTwitter.service.StatsRunner;

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
	 
	@RequestMapping(value="/stats", method = RequestMethod.GET)
	public ResponseEntity<Object> getStats(
			@RequestParam(name = "capoluogo") Optional<String> capoluogo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		 
		return new ResponseEntity<>(StatsRunner.getStats(dataService.getDataRepo(), capoluogo), HttpStatus.OK);
	}
	
	 
	 
	 
	
	@RequestMapping(value = "/data/stats/coordinates/mean", method = RequestMethod.GET)
	public ResponseEntity<Object> getCoordinatesMean(){
		
		double[] coordinatesMean = new StatsImpl().getMean(dataService.getDataRepo());
		
		return new ResponseEntity<>("Longitudines mean: " + coordinatesMean[0] + "\n"
								  + "Latitudines mean: " + coordinatesMean[1], HttpStatus.OK);
	}
	
	@RequestMapping(value = "/data/stats/coordinates/variance", method = RequestMethod.GET)
	public ResponseEntity<Object> getCoordinatesVariance(){
		
		double[] coordinatesVariance = new StatsImpl().getVariance(dataService.getDataRepo());
		
		return new ResponseEntity<>("Longitudines variance: " + coordinatesVariance[0] + "\n"
								  + "Latitudines variance: " + coordinatesVariance[1], HttpStatus.OK);
	}
	
	@RequestMapping(value = "/data/stats/insideMarche", method = RequestMethod.GET)
	public ResponseEntity<Object> getTweetsInsideMarche() {
		
		return new ResponseEntity<>(ObjectToJsonStringConverter.convert(new StatsImpl().getTweetsInsideMarche(
				dataService.getDataRepo())), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/data/stats/insideMarche", method = RequestMethod.POST)				//POST CHE NON RICHIEDE BODY???
	public ResponseEntity<Object> tweetInsideMarche(@RequestParam(name="id") String id){
		
		if(new StatsImpl().tweetInsideMarche(dataService.getDataRepo(), id)) {
			
			return new ResponseEntity<>("Il tweet selezionato è stato inviato da dentro le Marche", HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<>("Il tweet selezionato NON è stato inviato da dentro le Marche", HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/data/filter/id/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> tweetWithThisId(@PathVariable("id") String id){
		
		if(new FiltersImpl().tweetWithThisId(dataService.getDataRepo(), id)) {
			
			return new ResponseEntity<>(/*STAMPARE IL TWEET TROVATO*/"Tweet trovato", HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<>("L'id inserito non fa riferimento ad alcun tweet", HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/data/filter/text", method = RequestMethod.POST)							//POST CHE NON RICHIEDE BODY???
	public ResponseEntity<Object> getTweetsWithThisText(@RequestParam(name="text") String text){
		
		return new ResponseEntity<>(ObjectToJsonStringConverter.convert(new FiltersImpl().
				getTweetsWithThisText(dataService.getDataRepo(), text)), HttpStatus.OK);
	}
	
	/*@RequestMapping(value = "/data/filter/insideBox", method = RequestMethod.POST)						//POST CHE NON RICHIEDE BODY???
	public ResponseEntity<Object> getTweetsWithinBoundingBox(@RequestBody ArrayNode boundingBox) {
			@RequestParam(name="longitBoundingBoxUpLeft") double longitUpLeft,
			@RequestParam(name="latitBoundingBoxUpLeft") double latitUpLeft,
			@RequestParam(name="longitBoundingBoxDownRight") double longitDownRight,
			@RequestParam(name="latitBoundingBoxDownRight") double latitDownRight){
		
		
		
		double[] boundingBoxUpLeft = {longitUpLeft, latitUpLeft};
		double[] boundingBoxDownRight = {longitDownRight, latitDownRight};
		
		return new ResponseEntity<>(ArrayListToJsonStringConverter.convert(
				new FiltersImpl().getTweetsWithinBoundingBox(
						dataService.getDataRepo(), boundingBoxUpLeft,boundingBoxDownRight)), HttpStatus.OK);
	}*/
	
	@RequestMapping(value = "/data/filter/{capoluogo}/radius/{radius}", method = RequestMethod.GET)
	public ResponseEntity<Object> getTweetsWithinRadius(@PathVariable("capoluogo") String capoluogo,
														@PathVariable("radius") int radius)
														throws CapoluogoNotFoundException {
		
		ResponseEntity<Object> response = null;
		
		try {
			
			response = new ResponseEntity<>(ObjectToJsonStringConverter.convert(new FiltersImpl().getTweetsWithinRadius(
					dataService.getDataRepo(), capoluogo, radius)), HttpStatus.OK);
		}
		catch(CapoluogoNotFoundException e) {
			
			System.out.println(e);
		}
		
		return response;
	}
	
}