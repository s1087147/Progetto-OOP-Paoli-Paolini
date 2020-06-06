package it.univpm.projectGeoTwitter.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import it.univpm.projectGeoTwitter.exception.BoundingBoxVertexException;
import it.univpm.projectGeoTwitter.exception.CapoluogoNotFoundException;
import it.univpm.projectGeoTwitter.exception.CoordinatesException;
import it.univpm.projectGeoTwitter.exception.IllegalValueException;
import it.univpm.projectGeoTwitter.exception.NegativeRadiusException;
import it.univpm.projectGeoTwitter.exception.OperatorNotFoundException;
import it.univpm.projectGeoTwitter.model.TwitterData;

public interface Filters {

	public abstract ArrayList<TwitterData> filterText(
			Collection<TwitterData> tweets, String operator, Object filterValue) throws IllegalValueException,
				OperatorNotFoundException;
	
	public abstract ArrayList<TwitterData> filterDistance (
			Collection<TwitterData> tweets, String operator,Object filterValue) throws IllegalAccessException,
				InvocationTargetException, CapoluogoNotFoundException, IllegalValueException, NegativeRadiusException;
	
	public abstract ArrayList<TwitterData> filterBoundingbox(
			Collection<TwitterData> tweets, String operator, Object filterValue) throws BoundingBoxVertexException,
				CoordinatesException, IllegalValueException, OperatorNotFoundException;
	
	public abstract ArrayList<TwitterData> filterMarche(
			Collection<TwitterData> tweets, String operator, Object filterValue) throws CoordinatesException;
}
