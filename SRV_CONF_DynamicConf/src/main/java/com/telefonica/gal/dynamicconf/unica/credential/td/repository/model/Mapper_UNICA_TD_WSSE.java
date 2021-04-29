package com.telefonica.gal.dynamicconf.unica.credential.td.repository.model;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.telefonica.gal.dynamicconf.repository.Repository;
import com.telefonica.gal.dynamicconf.repository.model.ConfigMapper;
import com.telefonica.gal.dynamicconf.unica.credential.td.controller.MapTable_UNICA_TD_WSSE;
import com.telefonica.gal.dynamicconf.unica.credential.td.dto.ConfigInfo_UNICA_TD_WSSE;
import com.telefonica.gal.dynamicconf.unica.credential.td.dto.ConfigKey_UNICA_TD_WSSE;

@Component
public class Mapper_UNICA_TD_WSSE implements ConfigMapper {

	@Autowired
	MapTable_UNICA_TD_WSSE mapTable;
	
	@Override
	public boolean parse2Dto(Repository repository) {
		if (!repository.isValid()) {
			return false;
		}

		for (Object object :  repository.getMaps()) {
			Credentials_UNICA_TD_WSSE credential = (Credentials_UNICA_TD_WSSE) object;
			mapTable.add(parseToRoutingTDKey(credential), parseToRoutingTDInfo(credential));
		}
		mapTable.setConfigFileVersion(repository.getVersion());
		mapTable.setLastConfigurationTimeStamp(new DateTime());
		mapTable.setConfigFileInfo(repository.getInfo());
		return true;
	}

	private ConfigKey_UNICA_TD_WSSE parseToRoutingTDKey(Credentials_UNICA_TD_WSSE credential) {
		// TODO Auto-generated method stub
		return new ConfigKey_UNICA_TD_WSSE(credential.getInstanceID(),credential.getPlatformID(),credential.getUri());
	}

	private ConfigInfo_UNICA_TD_WSSE parseToRoutingTDInfo(Credentials_UNICA_TD_WSSE credential) {
		// TODO Auto-generated method stub
		return new ConfigInfo_UNICA_TD_WSSE(credential.getCredentials());
	}
	
	

}
