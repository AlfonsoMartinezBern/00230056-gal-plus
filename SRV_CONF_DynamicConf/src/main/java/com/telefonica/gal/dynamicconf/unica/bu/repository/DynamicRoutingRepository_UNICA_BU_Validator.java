package com.telefonica.gal.dynamicconf.unica.bu.repository;

import java.util.ArrayList;
import java.util.List;

import com.telefonica.gal.dynamicconf.repository.model.Flow;
import com.telefonica.gal.dynamicconf.unica.bu.repository.model.Endpoint_UNICA_BU;
import com.telefonica.gal.dynamicconf.unica.bu.repository.model.Route_UNICA_BU;

public class DynamicRoutingRepository_UNICA_BU_Validator {

	public static boolean isValid(ArrayList<Route_UNICA_BU> routes) {
		return isValidFlowsForRoutes(routes) && !isMultipleEndpointsWith_No_Flow(routes) && isAllRequiredParameters(routes) && isMultipleRoutesWithSourceAndReplicas(routes);
	}

	private static boolean isMultipleEndpointsWith_No_Flow(ArrayList<Route_UNICA_BU> routes) {
		for (Route_UNICA_BU route : routes) {
			if (route.isMultipleEndpointsWith_No_Flow()) {
				return true;
			}
		}
		return false; //
	}

	private static boolean isValidFlowsForRoutes(ArrayList<Route_UNICA_BU> routes) {
		for (Route_UNICA_BU route : routes) {
			if (!route.isFlowForRoute()) {
				return false;
			}
		}
		return true; //
	}
	
	private static boolean isMultipleRoutesWithSourceAndReplicas(ArrayList<Route_UNICA_BU> routes) {
		for(Route_UNICA_BU route : routes) {
			if ( !isMultipleFlowWihtSourceAndReplicas(route.getFlows())) {
				return false;
			}
		}
		return true; 
	}
	
	private static boolean isMultipleFlowWihtSourceAndReplicas(List<Flow> list) {
		boolean existSource = false;
		for(Flow flow: list) {
			if(flow.getType().contains("source")) {
				if(!existSource) {
					existSource = true;
				}else {
					return false;
				}
			}else if(!flow.getType().contains("replica")) {
				return false;
			}
		}
		return existSource;
		
	}

	public static boolean isAllRequiredParameters(ArrayList<Route_UNICA_BU> routes) {
		for (Route_UNICA_BU route : routes){
			if (!isAllEndpointsParameters(route.getEndpoints()) || !isAllFlowsParameters(route.getFlows()))
			return false;
		}
		return true;
	}

	private static boolean isAllEndpointsParameters(List<Endpoint_UNICA_BU> endpoints) {
		if (endpoints == null)
			return false;
		for (Endpoint_UNICA_BU ep : endpoints) {
			if ( ep.getUri() == null || ep.getTargetEndpoint() == null
					|| ep.getWssUser() == null || ep.getWssPassword() == null
					|| ep.getEndpointType() == null)
				return false;
		}
		return true;  //
	}

	private static boolean isAllFlowsParameters(List<Flow> flows) {
		if (flows == null ) {
			return true;
		}
		if (flows.size()<1 ) {
			return true;
		}
			
		for (Flow fl : flows) {
			if (fl.getEndpointID() == null || ((Integer) fl.getStep()) == null || ((Integer) fl.getStep()) == 0
					|| fl.getType() == null)
				return false;
		}
		return true; 
	}

}
