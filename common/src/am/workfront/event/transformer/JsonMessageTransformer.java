package am.workfront.event.transformer;

import org.codehaus.jackson.map.*;
import org.springframework.integration.annotation.*;

import java.io.*;

public class JsonMessageTransformer {

	private Class<?> objectClass;

	private ObjectMapper mapper = new ObjectMapper();

	public String serialize(Object message) {
		try {
			System.out.println("Serialized : " + message);
			return mapper.writeValueAsString(message);
		} catch (IOException e) {
			throw new RuntimeException("unable to serialize message", e);
		}
	}

	public <T> T deserialize(Class<T> clazz, String serializedMessage) {
		try {
			return mapper.readValue(serializedMessage, clazz);
		} catch (IOException e) {
			throw new RuntimeException("unable to deserialize message", e);
		}
	}


	@Transformer
	public Object transform(String serializedMessage) {
		try {
			System.out.println("Transformed : " + serializedMessage);
			return mapper.readValue(serializedMessage, objectClass);
		} catch (IOException e) {
			throw new RuntimeException("unable to deserialize message", e);
		}
	}

	public void setObjectClass(Class<?> objectClass) {
		this.objectClass = objectClass;
	}
}
