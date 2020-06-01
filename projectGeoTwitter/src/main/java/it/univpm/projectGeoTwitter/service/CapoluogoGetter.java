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
	    String getterCapoluogo = "get" + capoluogoName;
		Method method = capoluogoClass.getDeclaredMethod(getterCapoluogo, null);
		return (Geo) method.invoke(capoluogoMarche, null);
	}
}
