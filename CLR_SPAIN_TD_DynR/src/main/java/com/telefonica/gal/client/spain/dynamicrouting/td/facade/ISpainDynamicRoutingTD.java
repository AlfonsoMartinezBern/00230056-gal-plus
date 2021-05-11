package com.telefonica.gal.client.spain.dynamicrouting.td.facade;

import com.telefonica.gal.client.spain.dynamicrouting.td.msg.RoutingTDInfo;
import com.telefonica.gal.client.spain.dynamicrouting.td.msg.RoutingTDKey;

public interface ISpainDynamicRoutingTD {
    RoutingTDInfo search(RoutingTDKey tdkey);
}
