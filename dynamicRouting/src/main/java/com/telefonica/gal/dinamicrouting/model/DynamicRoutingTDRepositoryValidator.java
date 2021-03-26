package com.telefonica.gal.dinamicrouting.model;

import java.util.ArrayList;

public class DynamicRoutingTDRepositoryValidator {

	public boolean isValid(ArrayList<Route> routes) {
		return isValidFlowsForRoutes(routes) && !isMultipleEndpointsWith_No_Flow(routes);
	}

	private boolean isMultipleEndpointsWith_No_Flow(ArrayList<Route> routes) {
		for (Route route : routes) {
			if (route.isMultipleEndpointsWith_No_Flow()) {
				return true;
			}
		}
		return false;
	}

	private boolean isValidFlowsForRoutes(ArrayList<Route> routes) {
		for (Route route : routes) {
			if (!route.isFlowForRoute()) {
				return false;
			}
		}
		return true;
	}

}
