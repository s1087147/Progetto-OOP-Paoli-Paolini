package it.univpm.projectGeoTwitter.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import it.univpm.projectGeoTwitter.model.CapoluoghiMarche;
import it.univpm.projectGeoTwitter.model.Geo;

public class CapoluogoGetter {

	public static Geo getCapoluogo(String capoluogoName)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		CapoluoghiMarche capoluogoMarche = new CapoluoghiMarche();
	    Class<CapoluoghiMarche> capoluogoClass = CapoluoghiMarche.class;
	    String getterCapoluogoName = "get" + capoluogoName.substring(0, 1).toUpperCase() + capoluogoName.substring(1).toLowerCase();
		Method getterCapoluogo = capoluogoClass.getDeclaredMethod(getterCapoluogoName, null);
		return (Geo) getterCapoluogo.invoke(capoluogoMarche, null);
	}
}
