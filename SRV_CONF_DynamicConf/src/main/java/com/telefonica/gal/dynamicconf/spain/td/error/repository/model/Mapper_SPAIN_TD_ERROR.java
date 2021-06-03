package com.telefonica.gal.dynamicconf.spain.td.error.repository.model;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.telefonica.gal.dynamicconf.repository.Repository;
import com.telefonica.gal.dynamicconf.repository.model.ConfigMapper;
import com.telefonica.gal.dynamicconf.spain.td.error.controller.MapTable_SPAIN_TD_ERROR;
import com.telefonica.gal.dynamicconf.spain.td.error.dto.ConfigInfo_SPAIN_TD_ERROR;
import com.telefonica.gal.dynamicconf.spain.td.error.dto.ConfigKey_SPAIN_TD_ERROR;

@Component
public class Mapper_SPAIN_TD_ERROR implements ConfigMapper {

	@Autowired
	MapTable_SPAIN_TD_ERROR routingTable;
	
	@Override
	public boolean parse2Dto(Repository repository) {
		if (!repository.isValid()) {
			return false;
		}

		for (Object object :  repository.getMaps()) {
			Error_SPAIN_TD_ERROR route = (Error_SPAIN_TD_ERROR) object;
			routingTable.add(parseToRoutingTDKey(route), parseToRoutingTDInfo(route));
		}
		routingTable.setConfigFileVersion(repository.getVersion());
		routingTable.setLastConfigurationTimeStamp(new DateTime());
		routingTable.setConfigFileInfo(repository.getInfo());
		return true;
	}
	
	private ConfigKey_SPAIN_TD_ERROR parseToRoutingTDKey(Error_SPAIN_TD_ERROR error) {
		return new ConfigKey_SPAIN_TD_ERROR(error.getOperationApi(),error.getServiceApi(),error.getErrorCode(),error.getErrorCodeInterface(),error.getErrorCodeOperation());
	}

	public ConfigInfo_SPAIN_TD_ERROR parseToRoutingTDInfo(Error_SPAIN_TD_ERROR error) {
		return new ConfigInfo_SPAIN_TD_ERROR(error.getErrorInfo());
	}

	
}
