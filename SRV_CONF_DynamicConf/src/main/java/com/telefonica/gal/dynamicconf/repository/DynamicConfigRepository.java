package com.telefonica.gal.dynamicconf.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class DynamicConfigRepository<T,R> implements Repository<R> {

	protected T repository;
	
	public T getRepository() {
		return repository;
	}



	public DynamicConfigRepository(T repository) {
		super();
		this.repository = repository;
	}



	public void getConfFromJSON(String configFile) {
		ObjectMapper objectMapper = new ObjectMapper();
		try (BufferedReader reader = new BufferedReader(
				new FileReader(new File(configFile)))) {
			repository =  (T) objectMapper.readValue(reader.lines().collect(Collectors.joining()),repository.getClass());
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}

	@JsonIgnore
	@Override
	public abstract boolean isValid();

	@JsonIgnore
	@Override
	public abstract List<R> getMaps();
	
	@JsonIgnore
	@Override
	public abstract String getVersion();

	@JsonIgnore
	@Override
	public abstract String getInfo();
}
