package com.telefonica.gal.client.dynamicrouting.bu.facade;

import com.telefonica.gal.client.dynamicrouting.bu.msg.RoutingBUInfo;
import com.telefonica.gal.client.dynamicrouting.bu.msg.RoutingBUKey;


public interface DynamicRoutingBU{
	RoutingBUInfo search(RoutingBUKey tdkey);
}
