package com.telefonica.gal.dinamicrouting;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.telefonica.gal.dinamicrouting.dto.RoutingTDMapper;
import com.telefonica.gal.dinamicrouting.model.DynamicRoutingTDRepository;
import com.telefonica.gal.dinamicrouting.model.DynamicRoutingTDRepositoryMapper;
import com.telefonica.gal.dinamicrouting.model.Endpoint;
import com.telefonica.gal.dinamicrouting.model.Flow;

@Component
public class ConfigService {

	@Autowired
	RoutingTDMapper routingTDMapper;

	@Autowired
	DynamicRoutingTDRepositoryMapper repository;

	private String configFile;

	public String getConfigFile() {
		return configFile;
	}

	public void setConfigFile(String configFile) {
		this.configFile = configFile;
		this.chargeConf();
	}

	public ConfigService(@Value("${configFile.path}") String path, @Value("${configFile.name}") String name)
			throws IOException {
		super();
		this.configFile = path + name;
	}

	public boolean chargeConf() {
		DynamicRoutingTDRepository repository = getDynamicRoutingTDFromJson();
		if (repository == null) {
			return false;
		}
		return routingTDMapper.parseToRoutingTable(repository);
	}

	public boolean isValidChargeConf() {
		DynamicRoutingTDRepository repository = getDynamicRoutingTDFromJson();
		if (repository == null) {
			return false;
		}
		return repository.isValid(repository.getRoutes());
	}

	public DynamicRoutingTDRepository getDynamicRoutingTDFromJson() {
		try (BufferedReader reader = new BufferedReader(
				new FileReader(ResourceLoader.class.getResource(configFile).getFile()))) {
			return repository.dynamicRoutingTDFromJson(reader.lines().collect(Collectors.joining()));
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
	}

	public boolean isAllRequiredParameters(List<Endpoint> endpoints, List<Flow> flows) {
		return (this.isAllEndpointsParameters(endpoints)) && (this.isAllFlowsParameters(flows));
	}

	private boolean isAllEndpointsParameters(List<Endpoint> endpoints) {
		if (endpoints == null)
			return false;
		for (Endpoint ep : endpoints) {
			if (ep.getId() == null || ep.getEndpointType() == null || ((Integer) ep.getInstanceID()) == null
					|| ((Integer) ep.getInstanceID()) == 0 || ((Integer) ep.getPlatformID()) == null
					|| ((Integer) ep.getPlatformID()) == 0 || ep.getTargetEndpoint() == null)
				return false;
		}
		return true;
	}

	private boolean isAllFlowsParameters(List<Flow> flows) {
		if (flows == null)
			return true;
		for (Flow fl : flows) {
			if (fl.getEndpointID() == null || ((Integer) fl.getStep()) == null || ((Integer) fl.getStep()) == 0
					|| fl.getType() == null)
				return false;
		}
		return true;
	}

//	private DynamicRoutingTD dynamicRoutingTDFromJson(String json) throws JsonMappingException, JsonProcessingException {
//		ObjectMapper objectMapper = new ObjectMapper();
//		DynamicRoutingTD dynamicRoutingTD = objectMapper.readValue(json, DynamicRoutingTD.class);
//		return dynamicRoutingTD;
//	}
}
