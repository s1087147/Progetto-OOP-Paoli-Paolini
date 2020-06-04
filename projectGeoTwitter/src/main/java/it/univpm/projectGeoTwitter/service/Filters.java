package it.univpm.projectGeoTwitter.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

import it.univpm.projectGeoTwitter.exception.BoundingBoxVertexException;
import it.univpm.projectGeoTwitter.model.TwitterData;

public interface Filters {

	public abstract ArrayList<TwitterData> filterText(Collection<TwitterData> tweets, String operator, Object filterValue);
	
	public abstract ArrayList<TwitterData> filterDistance (
			Collection<TwitterData> tweets, String operator,Object filterValue)
					throws SecurityException, IllegalAccessException,
					IllegalArgumentException, InvocationTargetException;
	
	public abstract ArrayList<TwitterData> filterBoundingbox(
			Collection<TwitterData> tweets, String operator, Object filterValue);
}
