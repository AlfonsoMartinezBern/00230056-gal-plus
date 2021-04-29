package com.telefonica.gal.dynamicconf.unica.td.repository.model;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.telefonica.gal.dynamicconf.repository.Repository;
import com.telefonica.gal.dynamicconf.repository.model.Flow;
import com.telefonica.gal.dynamicconf.repository.model.ConfigMapper;
import com.telefonica.gal.dynamicconf.unica.td.controller.RoutingTable_UNICA_TD;
import com.telefonica.gal.dynamicconf.unica.td.dto.RoutingInfo_UNICA_TD;
import com.telefonica.gal.dynamicconf.unica.td.dto.RoutingKey_UNICA_TD;

@Component
public class Mapper_UNICA_TD implements ConfigMapper {

	@Autowired
	RoutingTable_UNICA_TD routingTable;
	
	@Override
	public boolean parse2Dto(Repository repository) {
		if (!repository.isValid()) {
			return false;
		}

		for (Object object :  repository.getMaps()) {
			Route_UNICA_TD route = (Route_UNICA_TD) object;
			routingTable.add(parseToRoutingTDKey(route), parseToRoutingTDInfo(route));
		}
		routingTable.setConfigFileVersion(repository.getVersion());
		routingTable.setLastConfigurationTimeStamp(new DateTime());
		routingTable.setConfigFileInfo(repository.getInfo());
		return true;
	}
	
	private RoutingKey_UNICA_TD parseToRoutingTDKey(Route_UNICA_TD route) {
		return new RoutingKey_UNICA_TD(route.getServiceID(), route.getOperationTD(), route.getUri());
	}

	public RoutingInfo_UNICA_TD parseToRoutingTDInfo(Route_UNICA_TD route) {
		List<Flow> flows = setFlows(route.getFlows());
		List<Endpoint_UNICA_TD> enpoints = setEndpoints(flows, route);
		return new RoutingInfo_UNICA_TD(enpoints, flows);
	}

	private List<Endpoint_UNICA_TD> setEndpoints(List<Flow> flows, Route_UNICA_TD route) {
		List<Endpoint_UNICA_TD> newEndPoints = new ArrayList<Endpoint_UNICA_TD>();
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
