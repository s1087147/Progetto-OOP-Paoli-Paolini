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
import it.univpm.projectGeoTwitter.utils.filter.BoundingBoxFilter;
import it.univpm.projectGeoTwitter.utils.filter.RadiusFilter;
import it.univpm.projectGeoTwitter.utils.filter.TextFilter;
import it.univpm.projectGeoTwitter.utils.filter.TweetsMarche;

public class FiltersImpl implements Filters {

	@Override
	public ArrayList<TwitterData> filterText(Collection<TwitterData> tweets, String operator, Object filterValue)
			throws IllegalValueException, OperatorNotFoundException {
		
		return TextFilter.getTweetsWithThisText(tweets, operator, filterValue);
	}

	@Override
	public ArrayList<TwitterData> filterDistance(
			Collection<TwitterData> tweets, String operator, Object filterValue) throws IllegalAccessException,
				InvocationTargetException, CapoluogoNotFoundException, IllegalValueException, NegativeRadiusException {
		
		
		return RadiusFilter.getTweetsWithinRadius(tweets, operator, filterValue);
		
	}
	
	@Override
	public ArrayList<TwitterData> filterBoundingbox(
			Collection<TwitterData> tweets, String operator, Object filterValue) throws BoundingBoxVertexException,
				CoordinatesException, IllegalValueException, OperatorNotFoundException {				
		
		return BoundingBoxFilter.getTweetsWithinBoundingBox(tweets, operator, filterValue);
	}
	
	@Override
	public ArrayList<TwitterData> filterMarche(
			Collection<TwitterData> tweets, String operator, Object filterValue) throws CoordinatesException, OperatorNotFoundException {				
		
		return TweetsMarche.getTweetsMarche(tweets, operator, filterValue);
	}
}
