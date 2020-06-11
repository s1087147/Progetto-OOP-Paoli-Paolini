package it.univpm.projectGeoTwitter.utils.filter;

import java.util.ArrayList;
import java.util.Collection;

import it.univpm.projectGeoTwitter.exception.IllegalValueException;
import it.univpm.projectGeoTwitter.exception.OperatorNotFoundException;
import it.univpm.projectGeoTwitter.model.TwitterData;

/**
 * Classe che gestisce il filtro sul testo.
 * @author Davide Paolini
 * @author Francesco Paoli Leonardi
 */
public class TextFilter {

	/**
	 * Metodo che applica un filtro al testo.
	 * @param tweets Collection dei tweet su cui eseguire il filtro.
	 * @param operator stringa che indica l'operatore del filtro.
	 * @param filterValue stringa di testo da usare nel filtro.
	 * 
	 * @throws OperatorNotFoundException quando il nome dell'operatore fornito non è valido. 
	 * @throws IllegalValueException quando il valore fornito dall'utente non è una stringa di testo.
	 * 
	 * @return ArrayList contenente tutti gli elementi di tweets che rispettano la condizione imposta dal filtro.
	 */
	public static ArrayList<TwitterData> getTweetsWithText(Collection<TwitterData> tweets, String operator, Object filterValue)
		throws IllegalValueException, OperatorNotFoundException {
		
		ArrayList<TwitterData> tweetsWithThisText = new ArrayList<TwitterData>();
		if(filterValue.getClass() != String.class)
			throw new IllegalValueException("Il valore inserito non è una stringa.");
		String text = filterValue.toString();
		
		boolean choice;
		
		if(operator.equals("contains"))
			choice = true;
		else if(operator.equals("notcontains"))
			choice = false;
		else
			throw new OperatorNotFoundException("L'operatore richiesto non esiste.");
		
		for(TwitterData tweet : tweets) {
			
			if(tweet.getText().contains(text) == choice) {
					
				tweetsWithThisText.add(tweet);
			}
		}
		
		return tweetsWithThisText;
	}
}
