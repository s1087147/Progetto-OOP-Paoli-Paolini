package it.univpm.projectGeoTwitter.utils.stats;

import java.util.ArrayList;
import java.util.Collection;

import it.univpm.projectGeoTwitter.exception.GenericErrorException;
import it.univpm.projectGeoTwitter.exception.OperatorNotFoundException;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.utils.filter.TweetsMarche;

/**
 * Classe che gestisce la statistica sul numero di tweets inviati all'interno del territorio marchigiano.
 * @author Francesco Paoli Leonardi
 */
public class CountTweetsInsideMarche {

	/**
	 * Metodo che applica la statistica sul numero di tweets inviati da dentro le Marche.
	 * @param tweets Collection dei tweet su cui eseguire la statistica.
	 * 
	 * @throws OperatorNotFoundException quando il nome dell'operatore fornito non è valido.
	 * @throws GenericErrorException quando si verifica un errore interno.
	 * 
	 * @return int rappresentante il numero di tweets inviati da dentro la regione Marche.
	 */
	public static int insideMarche(Collection<TwitterData> tweets) throws OperatorNotFoundException, GenericErrorException {
		
		ArrayList<TwitterData> tweetsInsideMarche = TweetsMarche.getTweetsMarche(tweets, "inside");
		
		return tweetsInsideMarche.size();
	}
}
