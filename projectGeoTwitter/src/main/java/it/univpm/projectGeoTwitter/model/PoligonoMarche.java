package it.univpm.projectGeoTwitter.model;

import java.awt.geom.Path2D;

import it.univpm.projectGeoTwitter.exception.GenericErrorException;
import it.univpm.projectGeoTwitter.exception.IllegalValueException;
import it.univpm.projectGeoTwitter.service.Calculator;

/**
 * Modello per la rappresentazione del poligono delimitante il perimetro della regione Marche.
 * @author Francesco Paoli Leonardi
 */
public class PoligonoMarche {

	/**
	 * Path2D rappresentante il poligono che delimita il perimetro della regione Marche.
	 */
	private Path2D poligonoMarche;
	
	/**
	 * double[] contenente le longitudini dei punti con i quali viene generato il poligono delle Marche.
	 */
	private final double[] longitMarche = {13.51318359375, 12.76611328125, 12.73590087890625, 12.6287841796875, 12.57659912109375,
						12.450256347656248, 12.3101806640625, 12.37884521484375, 12.21954345703125, 12.30194091796875, 12.3651123046875,
						12.3870849609375, 12.5299072265625, 12.62054443359375, 12.755126953125, 12.7935791015625, 12.782592773437498,
						12.8924560546875, 12.930908203125, 13.172607421875, 13.252258300781248, 13.271484375, 13.3978271484375, 13.53515625,
						13.68072509765625, 13.75762939453125, 13.9306640625, 13.656005859375, 13.5406494140625};
	
	/**
	 * double[] contenente le latitudini dei punti con i quali viene generato il poligono delle Marche.
	 */
	private final double[] latitMarche = {43.644025847699496, 43.98491011404692, 43.846412964702395, 43.810747313446996, 43.86423779837694,
						43.880077621969036, 43.777043519302175, 43.70759350405294, 43.632099415557754, 43.602272978692746, 43.62215891380659,
						43.538593801442374, 43.520671902437606, 43.442948806351396, 43.47086090917325, 43.442948806351396, 43.37311218382002,
						43.15710884095329, 42.96044267380142, 42.84173746978783, 42.849792501926466, 42.75709622397268, 42.70060440808085,
						42.807491865911544, 42.8215952943695, 42.87596410238256, 42.91419494510531, 43.54854811091286, 43.64005063334696};
	
	/**
	 * Costruttore che genera il poligono delimitante il perimetro delle Marche.
	 * @throws GenericErrorException quando si verifica un errore interno.
	 */
	public PoligonoMarche() throws GenericErrorException {
		try {
			poligonoMarche = Calculator.polygonGenerator(longitMarche, latitMarche);
			
		} catch(IllegalValueException e) {
			throw new GenericErrorException("Errore durante la creazione del poligono delimitante le Marche");
		}
	}
	
	public Path2D getPoligonoMarche() {
		return poligonoMarche;
	}
}
