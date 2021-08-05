package com.telefonica.gal.dynamicconf.facade;

import com.telefonica.gal.dynamicconf.generic.dto.MessageResponse;

public interface DynamicConf {

	 MessageResponse chargeConf();
	 MessageResponse isValidConfigFile();
	 MessageResponse getConfigInfo();
	 
}
