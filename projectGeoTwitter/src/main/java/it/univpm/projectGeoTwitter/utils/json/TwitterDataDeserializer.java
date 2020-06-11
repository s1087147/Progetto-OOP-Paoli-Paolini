package it.univpm.projectGeoTwitter.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import it.univpm.projectGeoTwitter.model.TwitterData;

/**
 * Deserializzatore personalizzato per i TwitterData.
 * @see <a href="https://javadoc.io/static/com.fasterxml.jackson.core/jackson-databind/2.11.0/com/fasterxml/jackson/databind/JsonDeserializer.html"> JsonDeserializer</a>
 * @see <a href="https://javadoc.io/static/com.fasterxml.jackson.core/jackson-databind/2.11.0/com/fasterxml/jackson/databind/deser/std/StdDeserializer.html"> StdDeserializer</a>
 * @author Davide Paolini
 */
public class TwitterDataDeserializer extends StdDeserializer<TwitterData>{

	public TwitterDataDeserializer() {
		this(null);
	}
	
	public TwitterDataDeserializer(Class<?> c) {
		super(c);
	}
	
	/**
	 * Metodo usato per deserializzare i TwitterData.
	 */
	@Override
	public TwitterData deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		TwitterData data = new TwitterData();
		
		JsonNode node = p.getCodec().readTree(p);
		data.setId(node.get("id").asText());
		data.setText(node.get("text").asText());
		
		JsonNode geo = node.get("geo");
		data.setPlace_id(geo.get("place_id").asText());
		
		JsonNode coordnode = geo.get("coordinates");		
		data.setLongit(coordnode.get("coordinates").get(0).asDouble());
		data.setLatit(coordnode.get("coordinates").get(1).asDouble());
		
		return data;
	}
}