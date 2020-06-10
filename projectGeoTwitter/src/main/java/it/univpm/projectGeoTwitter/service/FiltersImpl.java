package it.univpm.projectGeoTwitter.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

import it.univpm.projectGeoTwitter.exception.GenericErrorException;
import it.univpm.projectGeoTwitter.exception.IllegalValueException;
import it.univpm.projectGeoTwitter.exception.OperatorNotFoundException;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.utils.filter.BoundingBoxFilter;
import it.univpm.projectGeoTwitter.utils.filter.RadiusFilter;
import it.univpm.projectGeoTwitter.utils.filter.TextFilter;
import it.univpm.projectGeoTwitter.utils.filter.TweetsMarche;

/**
 * 
 * @author Davide Paolini
 * @author Francesco Paoli Leonardi
 */
public class FiltersImpl implements Filters {

	@Override
	public ArrayList<TwitterData> filterText(Collection<TwitterData> tweets, String operator, Object filterValue)
			throws IllegalValueException, OperatorNotFoundException {
		
		return TextFilter.getTweetsWithText(tweets, operator, filterValue);
	}

	@Override
	public ArrayList<TwitterData> filterDistance(
			Collection<TwitterData> tweets, String operator, Object filterValue)
					throws IllegalAccessException, InvocationTargetException, IllegalValueException, OperatorNotFoundException {
		
		
		return RadiusFilter.getTweetsWithRadius(tweets, operator, filterValue);
		
	}
	
	@Override
	public ArrayList<TwitterData> filterBoundingbox(
			Collection<TwitterData> tweets, String operator, Object filterValue)
					throws IllegalValueException, OperatorNotFoundException {				
		
		return BoundingBoxFilter.getTweetsWithBoundingBox(tweets, operator, filterValue);
	}
	
	@Override
	public ArrayList<TwitterData> filterMarche(
			Collection<TwitterData> tweets, String operator)
					throws GenericErrorException, OperatorNotFoundException {				
		
		return TweetsMarche.getTweetsMarche(tweets, operator);
	}
}
