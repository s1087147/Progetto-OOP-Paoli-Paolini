package it.univpm.projectGeoTwitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import it.univpm.projectGeoTwitter.model.CapoluoghiMarche;
import it.univpm.projectGeoTwitter.service.ArrayListToJsonStringConverter;
import it.univpm.projectGeoTwitter.service.DataService;
import it.univpm.projectGeoTwitter.service.FiltersImpl;
import it.univpm.projectGeoTwitter.service.StatsImpl;

@RestController
public class GeoTwitterController {

	@Autowired
	DataService dataService;
	
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public ResponseEntity<Object> getData(){
		
		return new ResponseEntity<>(dataService.getData(), HttpStatus.OK);
	}
	
	 @RequestMapping(value="/metadata", method = RequestMethod.GET)
	 public ResponseEntity<Object> getMetadata(){
		 return new ResponseEntity<>(dataService.getMetadata(), HttpStatus.OK);
	 }
	
	@RequestMapping(value = "/data/stats/coordinates/mean", method = RequestMethod.GET)
	public ResponseEntity<Object> getCoordinatesMean(){
		
		double[] coordinatesMean = new StatsImpl().getMean(DataService.getDataRepo());
		
		return new ResponseEntity<>("Longitudines mean: " + coordinatesMean[0] + "\n"
								  + "Latitudines mean: " + coordinatesMean[1], HttpStatus.OK);
	}
	
	@RequestMapping(value = "/data/stats/coordinates/variance", method = RequestMethod.GET)
	public ResponseEntity<Object> getCoordinatesVariance(){
		
		double[] coordinatesVariance = new StatsImpl().getVariance(DataService.getDataRepo());
		
		return new ResponseEntity<>("Longitudines variance: " + coordinatesVariance[0] + "\n"
								  + "Latitudines variance: " + coordinatesVariance[1], HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/data/filter/{capoluogo}/radius/{radius}", method = RequestMethod.GET)
	public ResponseEntity<Object> getTweetsWithinRadius(@PathVariable("capoluogo") String capoluogo,
														@PathVariable("radius") int radius) throws ResponseStatusException {
		
		if(capoluogo.equals("Ancona")) {
		
			return new ResponseEntity<>(ArrayListToJsonStringConverter.convert(new FiltersImpl().getTweetsWithinRadius(
					DataService.getDataRepo(), CapoluoghiMarche.getCoordinatesAncona(), radius)), HttpStatus.OK);
		}
		
		else if(capoluogo.equals("Ascoli Piceno")) {
			
			return new ResponseEntity<>(ArrayListToJsonStringConverter.convert(new FiltersImpl().getTweetsWithinRadius(
					DataService.getDataRepo(), CapoluoghiMarche.getCoordinatesAscoliPiceno(), radius)), HttpStatus.OK);
		}

		else if(capoluogo.equals("Fermo")) {
			
			return new ResponseEntity<>(ArrayListToJsonStringConverter.convert(new FiltersImpl().getTweetsWithinRadius(
					DataService.getDataRepo(), CapoluoghiMarche.getCoordinatesFermo(), radius)), HttpStatus.OK);
		}
		
		else if(capoluogo.equals("Macerata")) {
			
			return new ResponseEntity<>(ArrayListToJsonStringConverter.convert(new FiltersImpl().getTweetsWithinRadius(
					DataService.getDataRepo(), CapoluoghiMarche.getCoordinatesMacerata(), radius)), HttpStatus.OK);
		}
		
		else if(capoluogo.equals("Pesaro e Urbino")) {
			
			return new ResponseEntity<>(ArrayListToJsonStringConverter.convert(new FiltersImpl().getTweetsWithinRadius(
					DataService.getDataRepo(), CapoluoghiMarche.getCoordinatesPesaroEUrbino(), radius)), HttpStatus.OK);
		}
		
		else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Il capoluogo richiesto non esiste. Riprovare...");
	}
}