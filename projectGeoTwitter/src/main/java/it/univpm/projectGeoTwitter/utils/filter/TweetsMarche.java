package it.univpm.projectGeoTwitter.utils.filter;

import java.util.ArrayList;
import java.util.Collection;

import it.univpm.projectGeoTwitter.exception.GenericErrorException;
import it.univpm.projectGeoTwitter.exception.OperatorNotFoundException;
import it.univpm.projectGeoTwitter.model.PoligonoMarche;
import it.univpm.projectGeoTwitter.model.TwitterData;

/**
 * Classe che gestisce il filtro sull'appartenenza alla regione Marche.
 * @author Davide Paolini
 * @author Francesco Paoli Leonardi
 */
public class TweetsMarche {
																		
	/**
	 * Metodo che applica un filtro sull'appartenenza alla regione Marche.
	 * @param tweets Collection dei tweet su cui eseguire il filtro.
	 * @param operator stringa che indica l'operatore del filtro.
	 * 
	 * @throws OperatorNotFoundException quando il nome dell'operatore fornito non è valido. 
	 * @throws GenericErrorException quando si verifica un errore interno.
	 * 
	 * @return {@literal ArrayList<TwitterData>} contenente tutti gli elementi di tweets che rispettano la condizione imposta dal filtro.
	 */
	public static ArrayList<TwitterData> getTweetsMarche(Collection<TwitterData> tweets, String operator)
			throws OperatorNotFoundException, GenericErrorException {
		
		ArrayList<TwitterData> tweetsInsideMarche = new ArrayList<>();
		
		PoligonoMarche regioneMarche = new PoligonoMarche();
		
		boolean choice;
		
		if(operator.equals("inside"))
			choice = true;
		else if(operator.equals("outside"))
			choice = false;
		else
			throw new OperatorNotFoundException("L'operatore richiesto non esiste");
		
		for(TwitterData tweet : tweets) {
			
			if(regioneMarche.getPoligonoMarche()
						    .contains(tweet.getLongit(), tweet.getLatit()) == choice) {

				tweetsInsideMarche.add(tweet);
			}
		}
		
		return tweetsInsideMarche;
	}
}