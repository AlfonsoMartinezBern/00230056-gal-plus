package com.telefonica.gal.dinamicrouting.dto;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.telefonica.gal.dinamicrouting.model.DynamicRoutingTDRepository;
import com.telefonica.gal.dinamicrouting.model.Endpoint;
import com.telefonica.gal.dinamicrouting.model.Flow;
import com.telefonica.gal.dinamicrouting.model.Route;

@Component
public class RoutingTDMapper {

	@Autowired
	RoutingTableTD routingTable;
	
	public RoutingTDMapper() {
		super();
		// TODO Auto-generated constructor stub
	}


	public boolean parseToRoutingTable(DynamicRoutingTDRepository dynamicRouting) {
		if(!dynamicRouting.isValid()) {
			return false;
		}
		
		for (Route route : dynamicRouting.getRoutes()) {
			routingTable.add(parseToRoutingTDKey(route).toString(), parseToRoutingTDInfo(route));
		}
		routingTable.setConfigFileVersion(dynamicRouting.getVersion());
		routingTable.setLastConfigurationTimeStamp(new DateTime());
		routingTable.setConfigFileInfo(dynamicRouting.getInfo());
		return true;
	}

	private RoutingTDKey parseToRoutingTDKey(Route route) {
		return new RoutingTDKey(route.getServiceID(), route.getOperationTD(), route.getUri());
	}

	private RoutingTDInfo parseToRoutingTDInfo(Route route) {
		List<Flow> flows = setFlows(route.getFlows());
		List<Endpoint> enpoints = setEndpoints(flows, route);
		return new RoutingTDInfo(enpoints, flows);
	}
	
	private List<Endpoint> setEndpoints(List<Flow> flows,Route route) {
		List<Endpoint> newEndPoints = new ArrayList<Endpoint>();
		if(route.getFlows()==null && route.getEndpoints().size()==1 ) {
			return route.getEndpoints();
		}
		
		
		for(Flow flow:flows) {
			newEndPoints.add(route.getEndpointsById(flow.getEndpointID()));
		}
		
		return newEndPoints;
	}


	private List<Flow> setFlows(List<Flow> flows){
		List<Flow> newFlows = new ArrayList<Flow>();
		for(Flow flow:flows) {
			if(flow.isActive()) {
				newFlows.add(flow);
			}
		}
		return newFlows;
	}
}
