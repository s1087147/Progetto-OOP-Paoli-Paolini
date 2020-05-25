package it.univpm.projectGeoTwitter.service;

import java.util.ArrayList;
import java.util.Map;

import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.utils.filter.IdFilter;
import it.univpm.projectGeoTwitter.utils.filter.TextFilter;

public class FiltersImpl implements Filters {

	@Override
	public ArrayList<TwitterData> textFilter(Map<Integer, TwitterData> tweetsMap, String text) {
		
		return TextFilter.getTweetsWithThisText(tweetsMap, text);
	}

	@Override
	public TwitterData idFilter(Map<Integer, TwitterData> tweetsMap, Integer id) {
		
		return IdFilter.getTweetWithThisId(tweetsMap, id);
	}
}
