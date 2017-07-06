package cz.jkoudelka.tictactoe.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Metody pro prevod objektu na JSON String a obracene.
 * 
 * @author jlochman
 *
 */
public class JSONUtils {

	private static ObjectMapper mapper = new ObjectMapper();

	/**
	 * Prevod objektu na String
	 * 
	 * @param object
	 * @return
	 * @throws JsonProcessingException
	 */
	public static String objectToString(Object object) throws JsonProcessingException {
		return mapper.writeValueAsString(object);
	}

	/**
	 * Prevod Objektu na String s defaultni return hodnotou, ktera je vracena,
	 * pokud nastane vyjimka
	 * 
	 * @param object
	 * @param defaultString
	 * @return
	 */
	public static String objectToString(Object object, String defaultString) {
		try {
			return mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			return defaultString;
		}
	}

	/**
	 * Prevod Stringu na objekt, definovany predanou tridou
	 * 
	 * @param s
	 * @param clazz
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> T stringToObject(String s, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(s, clazz);
	}

}
