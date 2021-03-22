package com.telefonica.gal.dinamicrouting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.telefonica.gal.dinamicrouting.dto.RoutingTDMapper;
import com.telefonica.gal.dinamicrouting.model.DynamicRoutingTDRepository;
import com.telefonica.gal.dinamicrouting.model.DynamicRoutingTDRepositoryMapper;

@Component
public class ConfigService {

	@Autowired
	RoutingTDMapper routingTDMapper;
	
	@Autowired
	DynamicRoutingTDRepositoryMapper repository;
	
	private String configFile;

	public ConfigService(@Value("${configFile.path}") String path,@Value("${configFile.name}") String name) throws IOException {
		super();
		this.configFile=path+name;
	}

	public boolean chargeConf() {
		DynamicRoutingTDRepository repository = getDynamicRoutingTDFromJson();
		if(repository==null) {
			return false;
		}
		return routingTDMapper.parseToRoutingTable(repository);
	}
	
	public boolean isValidChargeConf() {
		DynamicRoutingTDRepository repository = getDynamicRoutingTDFromJson();
		if(repository==null) {
			return false;
		}
		return repository.isValid();
	}
	
	private  DynamicRoutingTDRepository getDynamicRoutingTDFromJson() {
		try (BufferedReader reader = new BufferedReader(
				new FileReader(new File(configFile)))) {
			return repository.dynamicRoutingTDFromJson(reader.lines().collect(Collectors.joining()));
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
	}
	
	
	
//	private DynamicRoutingTD dynamicRoutingTDFromJson(String json) throws JsonMappingException, JsonProcessingException {
//		ObjectMapper objectMapper = new ObjectMapper();
//		DynamicRoutingTD dynamicRoutingTD = objectMapper.readValue(json, DynamicRoutingTD.class);
//		return dynamicRoutingTD;
//	}
}
