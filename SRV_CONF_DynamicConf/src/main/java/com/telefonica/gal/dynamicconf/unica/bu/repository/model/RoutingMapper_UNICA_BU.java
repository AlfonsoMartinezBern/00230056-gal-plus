package com.telefonica.gal.dynamicconf.unica.bu.repository.model;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.telefonica.gal.dynamicconf.repository.Repository;
import com.telefonica.gal.dynamicconf.repository.model.Flow;
import com.telefonica.gal.dynamicconf.repository.model.ConfigMapper;
import com.telefonica.gal.dynamicconf.unica.bu.controller.RoutingTable_UNICA_BU;
import com.telefonica.gal.dynamicconf.unica.bu.dto.RoutingInfo_UNICA_BU;
import com.telefonica.gal.dynamicconf.unica.bu.dto.RoutingKey_UNICA_BU;

@Component
public class RoutingMapper_UNICA_BU implements ConfigMapper {

	@Autowired
	RoutingTable_UNICA_BU routingTable;
	
	@Override
	public boolean parse2Dto(Repository repository) {
		if (!repository.isValid()) {
			return false;
		}

		for (Object object :  repository.getMaps()) {
			Route_UNICA_BU route = (Route_UNICA_BU) object;
			routingTable.add(parseToRoutingTDKey(route), parseToRoutingTDInfo(route));
		}
		routingTable.setConfigFileVersion(repository.getVersion());
		routingTable.setLastConfigurationTimeStamp(new DateTime());
		routingTable.setConfigFileInfo(repository.getInfo());
		return true;
	}
	
	private RoutingKey_UNICA_BU parseToRoutingTDKey(Route_UNICA_BU route) {
		return new RoutingKey_UNICA_BU(route.getInstanceID(), route.getPlatformID(), route.getOperationType());
	}

	public RoutingInfo_UNICA_BU parseToRoutingTDInfo(Route_UNICA_BU route) {
		List<Flow> flows = setFlows(route.getFlows());
		List<Endpoint_UNICA_BU> enpoints = setEndpoints(flows, route);
		return new RoutingInfo_UNICA_BU(enpoints, flows);
	}

	private List<Endpoint_UNICA_BU> setEndpoints(List<Flow> flows, Route_UNICA_BU route) {
		List<Endpoint_UNICA_BU> newEndPoints = new ArrayList<Endpoint_UNICA_BU>();
		if ((route.getFlows() == null && route.getEndpoints().size() == 1)
				|| ((flows.isEmpty() || flows == null) && route.getEndpoints().size() == 1)) {
			return route.getEndpoints();
		}

		for (Flow flow : flows) {
			newEndPoints.add(route.getEndpointsById(flow.getEndpointID()));
		}

		return newEndPoints;
	}

	private List<Flow> setFlows(List<Flow> flows) {
		List<Flow> newFlows = new ArrayList<Flow>();
		for (Flow flow : flows) {
			if (flow.isActive()) {
				newFlows.add(flow);
			}
		}
		return newFlows;
	}

}
