package cz.jkoudelka.tictactoe.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtils {

	private static ObjectMapper mapper = new ObjectMapper();

	public static String objectToString(Object object) throws JsonProcessingException {
		return mapper.writeValueAsString(object);
	}

	public static String objectToString(Object object, String defaultString) {
		try {
			return mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			return defaultString;
		}
	}

	public static <T> T stringToObject(String s, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(s, clazz);
	}

}
