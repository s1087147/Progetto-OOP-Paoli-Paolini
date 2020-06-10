package it.univpm.projectGeoTwitter.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import it.univpm.projectGeoTwitter.exception.IllegalValueException;
import it.univpm.projectGeoTwitter.model.CapoluoghiMarche;
import it.univpm.projectGeoTwitter.model.Geo;

public class CapoluogoGetter {

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