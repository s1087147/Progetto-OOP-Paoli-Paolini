package it.univpm.projectGeoTwitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.projectGeoTwitter.service.DataService;

@RestController
public class GeoTwitterController {

	@Autowired
	DataService dataService;
	
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public ResponseEntity<Object> getData(){
		return new ResponseEntity<>(dataService.test(), HttpStatus.OK);
	}	
}
