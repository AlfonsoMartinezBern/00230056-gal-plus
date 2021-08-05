package com.telefonica.gal.dynamicconf.unica.error.td.repository.model;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.telefonica.gal.dynamicconf.repository.Repository;
import com.telefonica.gal.dynamicconf.repository.model.ConfigMapper;
import com.telefonica.gal.dynamicconf.unica.error.td.controller.MapTable_UNICA_ERROR_TD;
import com.telefonica.gal.dynamicconf.unica.error.td.dto.ConfigInfo_UNICA_ERROR_TD;
import com.telefonica.gal.dynamicconf.unica.error.td.dto.ConfigKey_UNICA_ERROR_TD;

@Component
public class Mapper_UNICA_ERROR_TD implements ConfigMapper {

	@Autowired
	MapTable_UNICA_ERROR_TD routingTable;
	
	@Override
	public boolean parse2Dto(Repository repository) {
		if (!repository.isValid()) {
			return false;
		}

		for (Object object :  repository.getMaps()) {
			Route_UNICA_ERROR_TD route = (Route_UNICA_ERROR_TD) object;
			routingTable.add(parseToRoutingTDKey(route), parseToRoutingTDInfo(route));
		}
		routingTable.setConfigFileVersion(repository.getVersion());
		routingTable.setLastConfigurationTimeStamp(new DateTime());
		routingTable.setConfigFileInfo(repository.getInfo());
		return true;
	}
	
	private ConfigKey_UNICA_ERROR_TD parseToRoutingTDKey(Route_UNICA_ERROR_TD route) {
		return new ConfigKey_UNICA_ERROR_TD(route.getShort_description(),route.getInterfaceType());
	}

	public ConfigInfo_UNICA_ERROR_TD parseToRoutingTDInfo(Route_UNICA_ERROR_TD route) {
		return new ConfigInfo_UNICA_ERROR_TD(route.getErrorInfo());
	}

	
}
