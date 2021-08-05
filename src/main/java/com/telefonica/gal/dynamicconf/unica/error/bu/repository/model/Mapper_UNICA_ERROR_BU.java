package com.telefonica.gal.dynamicconf.unica.error.bu.repository.model;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.telefonica.gal.dynamicconf.repository.Repository;
import com.telefonica.gal.dynamicconf.repository.model.ConfigMapper;
import com.telefonica.gal.dynamicconf.unica.error.bu.controller.MapTable_UNICA_ERROR_BU;
import com.telefonica.gal.dynamicconf.unica.error.bu.dto.ConfigInfo_UNICA_ERROR_BU;
import com.telefonica.gal.dynamicconf.unica.error.bu.dto.ConfigKey_UNICA_ERROR_BU;

@Component
public class Mapper_UNICA_ERROR_BU implements ConfigMapper {

	@Autowired
	MapTable_UNICA_ERROR_BU routingTable;
	
	@Override
	public boolean parse2Dto(Repository repository) {
		if (!repository.isValid()) {
			return false;
		}

		for (Object object :  repository.getMaps()) {
			Route_UNICA_ERROR_BU route = (Route_UNICA_ERROR_BU) object;
			routingTable.add(parseToRoutingTDKey(route), parseToRoutingTDInfo(route));
		}
		routingTable.setConfigFileVersion(repository.getVersion());
		routingTable.setLastConfigurationTimeStamp(new DateTime());
		routingTable.setConfigFileInfo(repository.getInfo());
		return true;
	}
	
	private ConfigKey_UNICA_ERROR_BU parseToRoutingTDKey(Route_UNICA_ERROR_BU route) {
		return new ConfigKey_UNICA_ERROR_BU(route.getShort_description(),route.getInterfaceType());
	}

	public ConfigInfo_UNICA_ERROR_BU parseToRoutingTDInfo(Route_UNICA_ERROR_BU route) {

		return new ConfigInfo_UNICA_ERROR_BU(route.getErrorInfo());
	}

}
