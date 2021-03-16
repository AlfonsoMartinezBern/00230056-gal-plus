package com.example.demo.actuator;

import java.io.IOException;
import java.util.Map;

import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonPropertySourceFactory implements PropertySourceFactory {
	//PropertySourceFactory personalizada con la capacidad de analizar datos JSON

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
		Map readValue = new ObjectMapper().readValue(resource.getInputStream(), Map.class);
		return new MapPropertySource("json-property", readValue);
	}
}
