package com.telefonica.gal.client.dynamicrouting.td.facade;

import com.telefonica.gal.client.dynamicrouting.td.msg.RoutingTDInfo;
import com.telefonica.gal.client.dynamicrouting.td.msg.RoutingTDKey;

public interface SpainDynamicRoutingTD {
    RoutingTDInfo search(RoutingTDKey tdkey);
}
