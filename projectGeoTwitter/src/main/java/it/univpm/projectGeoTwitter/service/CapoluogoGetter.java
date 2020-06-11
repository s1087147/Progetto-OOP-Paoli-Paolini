package it.univpm.projectGeoTwitter.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import it.univpm.projectGeoTwitter.exception.IllegalValueException;
import it.univpm.projectGeoTwitter.model.CapoluoghiMarche;
import it.univpm.projectGeoTwitter.model.Geo;

/**
 * Classe che gestisce i metodi getter della classe {@link it.univpm.projectGeoTwitter.model.CapoluoghiMarche CapoluoghiMarche}
 * 
 * @author Davide Paolini
 * @author Francesco Paoli Leonardi
 */
public class CapoluogoGetter {

	/**
	 * Metodo che restituisce l'istanza Geo relativa al capoluogo desiderato.
	 * @param capoluogoName nome del capoluogo desiderato.
	 * 
	 * @return Geo rappresentante il capoluogo relativo al nome del capoluogo desiderato.
	 * 
	 * @throws IllegalValueException quando viene inserito un valore non valido per il capoluogo.
	 */
	public static Geo getCapoluogo(String capoluogoName) throws IllegalValueException {
		
		CapoluoghiMarche capoluogoMarche = new CapoluoghiMarche();
	    Class<CapoluoghiMarche> capoluogoClass = CapoluoghiMarche.class;
	    
		try {
			String getterCapoluogoName = "get" + capoluogoName.toLowerCase();
			Method getterCapoluogo = capoluogoClass.getDeclaredMethod(getterCapoluogoName, null);
			return (Geo) getterCapoluogo.invoke(capoluogoMarche, null);
			
		} catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException e) {
			throw new IllegalValueException("Il parametro inserito non fa riferimento ad alcun capoluogo.");
		}
	}
}