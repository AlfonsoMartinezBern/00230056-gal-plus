package com.telefonica.gal.dinamicrouting.model.facade;

import com.telefonica.gal.dinamicrouting.dto.RoutingTDInfo;
import com.telefonica.gal.dinamicrouting.dto.RoutingTDKey;

public interface DynamicRoutingTD {

	public RoutingTDInfo getRouting(RoutingTDKey key);
}
