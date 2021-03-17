package com.example.demo.actuator;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonPropertyContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
	//Carga los datos del archivo JSON y completa el entorno Spring con MapPropertySources

	private static String CUSTOM_PREFIX = "custom.";

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
		try {
			Resource resource = configurableApplicationContext.getResource("classpath:C:/Develop/STSWorkspace/demo/directoryconfigpropscustom.json");
			Map readValue = new ObjectMapper().readValue(resource.getInputStream(), Map.class);
			Set<Map.Entry> set = readValue.entrySet();
			List<MapPropertySource> propertySources = convertEntrySet(set, Optional.empty());
			for (PropertySource propertySource : propertySources) {
				configurableApplicationContext.getEnvironment().getPropertySources().addFirst(propertySource);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("rawtypes")
	private static List<MapPropertySource> convertEntrySet(Set<Map.Entry> entrySet, Optional<String> parentKey) {
		return entrySet.stream().map((Map.Entry e) -> convertToPropertySourceList(e, parentKey))
				.flatMap(Collection::stream).collect(Collectors.toList());
	}

	@SuppressWarnings("rawtypes")
	private static List<MapPropertySource> convertToPropertySourceList(Map.Entry e, Optional<String> parentKey) {
		String key = parentKey.map(s -> s + ".").orElse("") + (String) e.getKey();
		Object value = e.getValue();
		return covertToPropertySourceList(key, value);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static List<MapPropertySource> covertToPropertySourceList(String key, Object value) {
		if (value instanceof LinkedHashMap) {
			LinkedHashMap map = (LinkedHashMap) value;
			Set<Map.Entry> entrySet = map.entrySet();
			return convertEntrySet(entrySet, Optional.ofNullable(key));
		}
		String finalKey = CUSTOM_PREFIX + key;
		return Collections.singletonList(new MapPropertySource(finalKey, Collections.singletonMap(finalKey, value)));
	}
}