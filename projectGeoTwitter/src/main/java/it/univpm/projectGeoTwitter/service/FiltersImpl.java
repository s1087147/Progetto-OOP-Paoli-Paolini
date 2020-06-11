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
 * Classe che implementa i metodi astratti dichiarati nell'interfaccia {@link it.univpm.projectGeoTwitter.service.Filters Filters}
 * 
 * @author Davide Paolini
 * @author Francesco Paoli Leonardi
 */
public class FiltersImpl implements Filters {

	/**
	 * Metodo che effettua il filtraggio tramite testo.
	 * @param tweets Collection dei tweet da filtrare.
	 * @param operator String rappresentante il criterio secondo cui eseguire il filtraggio.
	 * @param filterValue Object contenente il valore rispetto a cui eseguire il filtraggio.
	 * 
	 * @return ArrayList<TwitterData> contenente i tweets che rientrano nelle specifiche richieste dal filtro.
	 * 
	 * @see it.univpm.projectGeoTwitter.utils.filter.TextFilter#getTweetsWithText(Collection, String, Object) getTweetsWithText
	 */
	@Override
	public ArrayList<TwitterData> filterText(Collection<TwitterData> tweets, String operator, Object filterValue)
			throws IllegalValueException, OperatorNotFoundException {
		
		return TextFilter.getTweetsWithText(tweets, operator, filterValue);
	}

	/**
	 * Metodo che effettua il filtraggio tramite distanza.
	 * @param tweets Collection dei tweet da filtrare.
	 * @param operator String rappresentante il criterio secondo cui eseguire il filtraggio.
	 * @param filterValue Object contenente il valore rispetto a cui eseguire il filtraggio.
	 * 
	 * @return ArrayList<TwitterData> contenente i tweets che rientrano nelle specifiche richieste dal filtro.
	 * 
	 * @throws IllegalAccessException quando si verifica un problema di accesso.
	 * @throws InvocationTargetException quando non è stato trovato il metodo relativo al filtro richiesto.
	 * @throws IllegalValueException quando vengono forniti valori non validi per eseguire il filtro.
	 * @throws OperatorNotFoundException quando il nome dell'operatore fornito non è valido.
	 * 
	 * @see it.univpm.projectGeoTwitter.utils.filter.RadiusFilter#getTweetsWithRadius(Collection, String, Object) getTweetsWithRadius
	 */
	@Override
	public ArrayList<TwitterData> filterDistance(
			Collection<TwitterData> tweets, String operator, Object filterValue)
					throws IllegalAccessException, InvocationTargetException, IllegalValueException, OperatorNotFoundException {
		
		
		return RadiusFilter.getTweetsWithRadius(tweets, operator, filterValue);
		
	}
	
	/**
	 * Metodo che effettua il filtraggio tramite bounding box.
	 * @param tweets Collection dei tweet da filtrare.
	 * @param operator String rappresentante il criterio secondo cui eseguire il filtraggio.
	 * @param filterValue Object contenente il valore rispetto a cui eseguire il filtraggio.
	 * 
	 * @return ArrayList<TwitterData> contenente i tweets che rientrano nelle specifiche richieste dal filtro.
	 * 
	 * @throws IllegalValueException quando vengono forniti valori non validi per eseguire il filtro.
	 * @throws OperatorNotFoundException quando il nome dell'operatore fornito non è valido.
	 * 
	 * @see it.univpm.projectGeoTwitter.utils.filter.BoundingBoxFilter#getTweetsWithBoundingBox(Collection, String, Object) getTweetsWithBoundingBox
	 */
	@Override
	public ArrayList<TwitterData> filterBoundingbox(
			Collection<TwitterData> tweets, String operator, Object filterValue)
					throws IllegalValueException, OperatorNotFoundException {				
		
		return BoundingBoxFilter.getTweetsWithBoundingBox(tweets, operator, filterValue);
	}
	
	/**
	 * Metodo che effettua il filtraggio tramite bounding box.
	 * @param tweets Collection dei tweet da filtrare.
	 * @param operator String rappresentante il criterio secondo cui eseguire il filtraggio.
	 * 
	 * @return ArrayList<TwitterData> contenente i tweets che rientrano nelle specifiche richieste dal filtro.
	 * 
	 * @throws GenericErrorException quando si verifica un errore interno durante l'esecuzione.
	 * @throws OperatorNotFoundException quando il nome dell'operatore fornito non è valido.
	 * 
	 * @see it.univpm.projectGeoTwitter.utils.filter.TweetsMarche#getTweetsMarche(Collection, String) getTweetsMarche
	 */
	@Override
	public ArrayList<TwitterData> filterMarche(
			Collection<TwitterData> tweets, String operator)
					throws GenericErrorException, OperatorNotFoundException {				
		
		return TweetsMarche.getTweetsMarche(tweets, operator);
	}
}
