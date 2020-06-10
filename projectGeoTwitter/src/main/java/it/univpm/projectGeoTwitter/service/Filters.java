package it.univpm.projectGeoTwitter.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

import it.univpm.projectGeoTwitter.exception.GenericErrorException;
import it.univpm.projectGeoTwitter.exception.IllegalValueException;
import it.univpm.projectGeoTwitter.exception.OperatorNotFoundException;
import it.univpm.projectGeoTwitter.model.TwitterData;

/**
 *  
 * @author Davide Paolini
 * @author Francesco Paoli Leonardi
 */
public interface Filters {

	public abstract ArrayList<TwitterData> filterText(
			Collection<TwitterData> tweets, String operator, Object filterValue)
					throws IllegalValueException, OperatorNotFoundException;
	
	public abstract ArrayList<TwitterData> filterDistance (
			Collection<TwitterData> tweets, String operator,Object filterValue)
					throws IllegalAccessException, InvocationTargetException, IllegalValueException;
	
	public abstract ArrayList<TwitterData> filterBoundingbox(
			Collection<TwitterData> tweets, String operator, Object filterValue)
					throws IllegalValueException, OperatorNotFoundException;
	
	public abstract ArrayList<TwitterData> filterMarche(
			Collection<TwitterData> tweets, String operator)
					throws GenericErrorException, OperatorNotFoundException;
}