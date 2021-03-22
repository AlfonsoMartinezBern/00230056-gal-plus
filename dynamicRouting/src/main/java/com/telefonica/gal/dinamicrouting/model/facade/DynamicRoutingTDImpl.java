package com.telefonica.gal.dinamicrouting.model.facade;

import org.springframework.beans.factory.annotation.Autowired;

import com.telefonica.gal.dinamicrouting.dto.RoutingTDInfo;
import com.telefonica.gal.dinamicrouting.dto.RoutingTDKey;

public class DynamicRoutingTDImpl implements DynamicRoutingTD {

	@Autowired
	DynamicRoutingTD dynamicRoutingTD;
	
	public RoutingTDInfo getRouting(RoutingTDKey key) {
		// TODO Auto-generated method stub
		return null;
	}

}
