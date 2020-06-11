package it.univpm.projectGeoTwitter.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

import it.univpm.projectGeoTwitter.exception.GenericErrorException;
import it.univpm.projectGeoTwitter.exception.IllegalValueException;
import it.univpm.projectGeoTwitter.exception.OperatorNotFoundException;
import it.univpm.projectGeoTwitter.model.TwitterData;

/**
 *  Classe in cui vengono dichiarati i metodi utili alle operazioni di filtraggio su tweets. I metodi qui
 *  dichiarati vengono implementati all'interno della classe {@link it.univpm.projectGeoTwitter.service.FiltersImpl FiltersImpl}
 *  
 * @author Davide Paolini
 * @author Francesco Paoli Leonardi
 */
public interface Filters {

	/**
	 * Metodo che effettua il filtraggio tramite testo.
	 * @param tweets Collection dei tweet da filtrare.
	 * @param operator String rappresentante il criterio secondo cui eseguire il filtraggio.
	 * @param filterValue Object contenente il valore rispetto a cui eseguire il filtraggio.
	 * 
	 * @return ArrayList<TwitterData> contenente i tweets che rientrano nelle specifiche richieste dal filtro.
	 * 
	 * @see it.univpm.projectGeoTwitter.service.FiltersImpl#filterText(Collection, String, Object) filterText
	 */
	public abstract ArrayList<TwitterData> filterText(
			Collection<TwitterData> tweets, String operator, Object filterValue)
					throws IllegalValueException, OperatorNotFoundException;
	
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
	 * @see it.univpm.projectGeoTwitter.service.FiltersImpl#filterDistance(Collection, String, Object) filterDistance
	 */
	public abstract ArrayList<TwitterData> filterDistance (
			Collection<TwitterData> tweets, String operator,Object filterValue)
					throws IllegalAccessException, InvocationTargetException, IllegalValueException;
	
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
	 * @see it.univpm.projectGeoTwitter.service.FiltersImpl#filterBoundingbox(Collection, String, Object) filterBoundingbox
	 */
	public abstract ArrayList<TwitterData> filterBoundingbox(
			Collection<TwitterData> tweets, String operator, Object filterValue)
					throws IllegalValueException, OperatorNotFoundException;
	
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
	 * @see it.univpm.projectGeoTwitter.service.FiltersImpl#filterMarche(Collection, String) filterMarche
	 */
	public abstract ArrayList<TwitterData> filterMarche(
			Collection<TwitterData> tweets, String operator)
					throws GenericErrorException, OperatorNotFoundException;
}