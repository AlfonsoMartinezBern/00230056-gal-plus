package com.telefonica.gal.dinamicrouting.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class DynamicRoutingTDRepositoryMapper {
	
	public DynamicRoutingTDRepository dynamicRoutingTDFromJson(String json) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		DynamicRoutingTDRepository dynamicRoutingTD = objectMapper.readValue(json, DynamicRoutingTDRepository.class);
		return dynamicRoutingTD;
	}
}
