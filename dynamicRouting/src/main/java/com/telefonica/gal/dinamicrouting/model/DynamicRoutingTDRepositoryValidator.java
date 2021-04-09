package com.telefonica.gal.dinamicrouting.model;

import java.util.ArrayList;
import java.util.List;

public class DynamicRoutingTDRepositoryValidator {

	public boolean isValid(ArrayList<Route> routes) {
		return isValidFlowsForRoutes(routes) && !isMultipleEndpointsWith_No_Flow(routes) && isAllRequiredParameters(routes);
	}

	private boolean isMultipleEndpointsWith_No_Flow(ArrayList<Route> routes) {
		for (Route route : routes) {
			if (route.isMultipleEndpointsWith_No_Flow()) {
				return true;
			}
		}
		return false; //
	}

	private boolean isValidFlowsForRoutes(ArrayList<Route> routes) {
		for (Route route : routes) {
			if (!route.isFlowForRoute()) {
				return false;
			}
		}
		return true; //
	}

	public boolean isAllRequiredParameters(ArrayList<Route> routes) {
		for (Route route : routes){
			if (!this.isAllEndpointsParameters(route.getEndpoints()) || !this.isAllFlowsParameters(route.getFlows()))
			return false;
		}
		return true;
	}

	private boolean isAllEndpointsParameters(List<Endpoint> endpoints) {
		if (endpoints == null)
			return false;
		for (Endpoint ep : endpoints) {
			if (ep.getEndpointType() == null || ((Integer) ep.getInstanceID()) == null
					|| ((Integer) ep.getInstanceID()) == 0 || ((Integer) ep.getPlatformID()) == null
					|| ((Integer) ep.getPlatformID()) == 0 || ep.getTargetEndpoint() == null)
				return false;
		}
		return true;  //
	}

	private boolean isAllFlowsParameters(List<Flow> flows) {
		if (flows == null)
			return true;
		for (Flow fl : flows) {
			if (fl.getEndpointID() == null || ((Integer) fl.getStep()) == null || ((Integer) fl.getStep()) == 0
					|| fl.getType() == null)
				return false;
		}
		return true; //
	}

}
